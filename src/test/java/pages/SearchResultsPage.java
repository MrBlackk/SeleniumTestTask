package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Log4Test;

import java.util.List;

/**
 * Created by qa on 1/15/2015.
 */
public class SearchResultsPage extends GeneralPage {

    public static final String RESULT_CHECKBOX = ".//*[@id='maindv2']/tbody/tr/td/table[4]/tbody/tr[%s]/td[1]/input";
    public static final String resultInfo = ".//*[@id='maindv2']/tbody/tr/td/table[4]/tbody/tr[%s]/td[3]/div[2]";

    public String firstText = "";
    public String secondText = "";
    public String thirdText = "";


    @Override
    public boolean isOpened(String URL) {
        return webDriver.getCurrentUrl().contains(URL); // changed "equals" to "contains"
    }

    public void sortByPrice(){
        elementIsLocated(getLocator("sortByPrice")).click();
    }

    public void clickSaleButton(){
        elementIsLocated(getLocator("saleButton")).click();
    }

    public void openAdvancedSearch(){
        elementIsLocated(getLocator("advancedSearch")).click();
    }

    public int getNumberOfResults(){
        List<WebElement> listOfResults = elementsAreLocated(getLocator("allResults"));
        System.out.println(listOfResults.size() - 1);
        return listOfResults.size() - 1; // -1 to remove header

    }

    public void selectThreeSearchResults(int first, int second, int third){
        //ToDO field getNumberOfResults()
        //ToDO f s l should be different
        if (first <= getNumberOfResults() && second <= getNumberOfResults() && third <= getNumberOfResults()){
            System.out.println("first, second and third good");
            elementIsLocated(By.xpath(String.format(RESULT_CHECKBOX, first + 1))).click(); // + 1
            elementIsLocated(By.xpath(String.format(RESULT_CHECKBOX, second + 1))).click(); // + 1
            elementIsLocated(By.xpath(String.format(RESULT_CHECKBOX, third + 1))).click(); // + 1

            firstText = elementIsLocated(By.xpath(String.format(RESULT_CHECKBOX, first + 1))).getAttribute("id");
            secondText = elementIsLocated(By.xpath(String.format(RESULT_CHECKBOX, second + 1))).getAttribute("id");
            thirdText = elementIsLocated(By.xpath(String.format(RESULT_CHECKBOX, third + 1))).getAttribute("id");
        }
        else {
            Log4Test.error("There are only " + getNumberOfResults() + " results.");
        }
    }

    public void clickShowSelected(){
        elementIsLocated(getLocator("showSelectedResults")).click();
    }

}
