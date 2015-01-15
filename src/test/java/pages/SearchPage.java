package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by qa on 1/15/2015.
 */
public class SearchPage extends GeneralPage {

    public void inputSearchPhrase(String phrase) throws InterruptedException {
        elementIsLocated(getLocator("searchPhrase")).clear();
        elementIsLocated(getLocator("searchPhrase")).sendKeys(phrase);
        //ToDo
        Thread.sleep(1000);

        if (elementIsLocated(getLocator("firstElementInList")).getText().contains(phrase)){
            elementIsLocated(getLocator("firstElementInList")).click();
        }
    }

    public void clickSearchButton(){
        elementIsLocated(getLocator("searchButton")).click();
    }

    public void inputMinAndMaxPrice(int min, int max){
        //ToDo
        elementIsLocated(getLocator("minField")).clear();
        elementIsLocated(getLocator("minField")).sendKeys(min + "");

        elementIsLocated(getLocator("maxField")).clear();
        elementIsLocated(getLocator("maxField")).sendKeys(max + "");
    }

    public void selectCityOrRegion(String city){
        Select cityDropDown = new Select(elementIsLocated(getLocator("cityDropDown")));
        cityDropDown.selectByVisibleText(city);
    }

    public void changeSearchPeriod(String period){
        Select periodDropDown = new Select(elementIsLocated(getLocator("periodDropDown")));
        periodDropDown.selectByVisibleText(period);
    }
}
