package pages;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.Log4Test;

/**
 * Created by qa on 1/15/2015.
 */
public class SearchPage extends GeneralPage {

    public void inputSearchPhrase(String phrase) throws InterruptedException {
        elementIsLocated(getLocator("searchPhrase")).clear();
        elementIsLocated(getLocator("searchPhrase")).sendKeys(phrase);
        Thread.sleep(1000); // waiting for results

        if (elementIsLocated(getLocator("firstElementInList")).getText().contains(phrase)){
            elementIsLocated(getLocator("firstElementInList")).click();
            Log4Test.info("Search phrase: " + phrase);
        }
        else {
            Log4Test.error("Incorrect search phrase: " + phrase);
            Assert.fail();
        }

    }

    public void clickSearchButton(){
        elementIsLocated(getLocator("searchButton")).click();
        Log4Test.info("Click Search Button");
    }

    public void inputMinAndMaxPrice(int min, int max){
        elementIsLocated(getLocator("minField")).clear();
        elementIsLocated(getLocator("minField")).sendKeys(Integer.toString(min));

        elementIsLocated(getLocator("maxField")).clear();
        elementIsLocated(getLocator("maxField")).sendKeys(Integer.toString(max));
        Log4Test.info("Input min: " + min + "  and max: " + max + " price");
    }

    public void selectCityOrRegion(String city){
        Select cityDropDown = new Select(elementIsLocated(getLocator("cityDropDown")));
        cityDropDown.selectByVisibleText(city);
        Log4Test.info("Select city/region: " + city);
    }

    public void changeSearchPeriod(String period){
        Select periodDropDown = new Select(elementIsLocated(getLocator("periodDropDown")));
        periodDropDown.selectByVisibleText(period);
        Log4Test.info("Change search period to: " + period);
    }
}
