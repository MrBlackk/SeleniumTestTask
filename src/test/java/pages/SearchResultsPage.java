package pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Log4Test;

import java.util.List;

/**
 * Created by qa on 1/15/2015.
 */
public class SearchResultsPage extends GeneralPage {

    public String firstResult;
    public String secondResult;
    public String thirdResult;

    @Override
    public boolean isOpened(String URL) {
        return webDriver.getCurrentUrl().contains(URL); // changed "equals" to "contains"
    }

    public void sortByPrice(){
        elementIsLocated(getLocator("sortByPrice")).click();
        Log4Test.info("Click sort by price");
    }

    public void openAdvancedSearch(){
        elementIsLocated(getLocator("advancedSearch")).click();
        Log4Test.info("Click Advanced search");
    }

    public int getNumberOfResults(){
        List<WebElement> listOfResults = elementsAreLocated(getLocator("allResults"));
        return listOfResults.size();
    }

    public void selectThreeSearchResults(int first, int second, int third){
        int numberOfResults = getNumberOfResults();
        List<WebElement> listOfCheckboxes = elementsAreLocated(getLocator("allCheckboxes"));
        if (first <= numberOfResults && second <= numberOfResults && third <= numberOfResults){
            listOfCheckboxes.get(first).click();
            listOfCheckboxes.get(second).click();
            listOfCheckboxes.get(third).click();

            firstResult = listOfCheckboxes.get(first).getAttribute("id");
            secondResult = listOfCheckboxes.get(second).getAttribute("id");
            thirdResult = listOfCheckboxes.get(third).getAttribute("id");
            Log4Test.info("Select " + first + ", " + second + ", " + third + " results in list");
        }
        else {
            Log4Test.error("There are only " + numberOfResults + " results.");
            Assert.fail();
        }
    }

    public void clickShowSelected(){
        elementIsLocated(getLocator("showSelectedResults")).click();
        Log4Test.info("Click Show Selected results");
    }

}
