package tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.*;
import sun.security.timestamp.TSRequest;

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
        page.changeLanguage();
        page.isRussianPageLoaded(TestData.SS_LV_RU_URL);
    }

    @Test(dependsOnMethods = "changeLanguage")
    public void openElectronicsPage(){
        page.openElectronicsPage();
        electrPage.isOpened(TestData.ELECTRONICS_RU_URL);
    }

    @Test(dependsOnMethods = "openElectronicsPage")
    public void openSearchPageAndSelectParameters() throws InterruptedException {
        electrPage.openSearchPage();
        searchPage.isOpened(TestData.ELECTRONICS_SEARCH_RU_URL);
        searchPage.inputSearchPhrase("Персональные компьютеры");
        searchPage.selectCityOrRegion("Рига");
        searchPage.changeSearchPeriod("За последний месяц");
        searchPage.clickSearchButton();
    }

    @Test(dependsOnMethods = "openSearchPageAndSelectParameters")
    public void sortResultsAndOpenAdvancedSearch(){
        searchResultsPage.isOpened(TestData.SEARCH_RESULTS_RU_URL);
        searchResultsPage.sortByPrice();
        searchResultsPage.clickSaleButton();
        searchResultsPage.openAdvancedSearch();
    }

    @Test(dependsOnMethods = "sortResultsAndOpenAdvancedSearch")
    public void setMinAndMaxPrice(){
        searchPage.isOpened(TestData.ELECTRONICS_SEARCH_RU_URL);
        searchPage.inputMinAndMaxPrice(0,300);
        searchPage.changeSearchPeriod("За последний месяц");
        searchPage.clickSearchButton();
    }

    @Test(dependsOnMethods = "setMinAndMaxPrice")
    public void selectSearchResults(){
        searchResultsPage.isOpened(TestData.SEARCH_RESULTS_RU_URL);
        System.out.println(searchResultsPage.firstText);
        searchResultsPage.selectThreeSearchResults(3, 1, 2);
        System.out.println(searchResultsPage.firstText);
        System.out.println(searchResultsPage.secondText);
        System.out.println(searchResultsPage.thirdText);
        searchResultsPage.clickShowSelected();
    }

    @Test(dependsOnMethods = "selectSearchResults")
    public void verifySelectedSearchResults(){
        showSelectedPage.isOpened(TestData.SHOW_SELECTED_RESULTS_RU_URL);
        showSelectedPage.isPageContainsCorrectSearchResults(searchResultsPage.firstText, searchResultsPage.secondText, searchResultsPage.thirdText);
    }


}
