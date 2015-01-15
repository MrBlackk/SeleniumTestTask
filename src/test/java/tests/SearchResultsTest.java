package tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.ElectronicsPage;
import pages.SsLvWelcomePage;

import static org.testng.Assert.*;

/**
 * Created by qa on 1/15/2015.
 */
public class SearchResultsTest extends TestBase{

    SsLvWelcomePage page = new SsLvWelcomePage();
    ElectronicsPage electrPage = new ElectronicsPage();

    @Test
    public void setUpPreconditions(){
        page.open(TestData.SS_LV_URL);
        assertTrue(page.isOpened(TestData.SS_LV_URL));
    }

    @Test
    public void changeLanguage(){
        page.changeLanguage();
        page.isRussianPageLoaded(TestData.SS_LV_RU_URL);
    }

    @Test
    public void openElectronicsPage(){
        page.openElectronicsPage();
        electrPage.isOpened(TestData.ELECTRONICS_RU_URL);
    }

    //@Test


}
