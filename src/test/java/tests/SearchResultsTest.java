package tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.*;

/**
 * Created by qa on 1/15/2015.
 */
public class SearchResultsTest extends TestBase{

    SsLvWelcomePage page = new SsLvWelcomePage();
    ElectronicsPage electrPage = new ElectronicsPage();
    SearchPage searchPage = new SearchPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    ShowSelectedPage showSelectedPage = new ShowSelectedPage();

    @Test
    public void setUpPreconditions(){
        page.open(TestData.SS_LV_URL);
        assertTrue(page.isOpened(TestData.SS_LV_URL));
    }

    @Test(dependsOnMethods = "setUpPreconditions")
    public void changeLanguage(){
        page.changeLanguageToRussian();
        assertTrue(page.isRussianPageLoaded(TestData.SS_LV_RU_URL));
    }

    @Test(dependsOnMethods = "changeLanguage")
    public void openElectronicsPage(){
        page.openElectronicsPage();
        assertTrue(electrPage.isOpened(TestData.ELECTRONICS_RU_URL));
    }

    @Test(dependsOnMethods = "openElectronicsPage")
    public void openSearchPageAndSelectParameters() throws InterruptedException {
        electrPage.openSearchPage();
        assertTrue(searchPage.isOpened(TestData.ELECTRONICS_SEARCH_RU_URL));
        searchPage.inputSearchPhrase(TestData.SEARCH_PHRASE);
        searchPage.selectCityOrRegion(TestData.CITY_REGION);
        searchPage.changeSearchPeriod(TestData.SEARCH_PERIOD);
        searchPage.clickSearchButton();
    }

    @Test(dependsOnMethods = "openSearchPageAndSelectParameters")
    public void sortResultsAndOpenAdvancedSearch(){
        assertTrue(searchResultsPage.isOpened(TestData.SEARCH_RESULTS_RU_URL));
        searchResultsPage.sortByPrice();
        searchResultsPage.openAdvancedSearch();
    }

    @Test(dependsOnMethods = "sortResultsAndOpenAdvancedSearch")
    public void setMinAndMaxPrice(){
        assertTrue(searchPage.isOpened(TestData.ELECTRONICS_SEARCH_RU_URL));
        searchPage.inputMinAndMaxPrice(TestData.MIN_PRICE,TestData.MAX_PRICE);
        searchPage.changeSearchPeriod("За последний месяц");
        searchPage.clickSearchButton();
    }

    @Test(dependsOnMethods = "setMinAndMaxPrice")
    public void selectSearchResults(){
        assertTrue(searchResultsPage.isOpened(TestData.SEARCH_RESULTS_RU_URL));
        searchResultsPage.selectThreeSearchResults(2, 0, 1);
        searchResultsPage.clickShowSelected();
    }

    @Test(dependsOnMethods = "selectSearchResults")
    public void verifySelectedSearchResults(){
        assertTrue(showSelectedPage.isOpened(TestData.SHOW_SELECTED_RESULTS_RU_URL));
        assertTrue(showSelectedPage.isPageContainsCorrectSearchResults(searchResultsPage.firstResult, searchResultsPage.secondResult, searchResultsPage.thirdResult));
    }
}
