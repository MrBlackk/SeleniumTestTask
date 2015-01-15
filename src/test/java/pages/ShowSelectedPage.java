package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by qa on 1/15/2015.
 */
public class ShowSelectedPage extends GeneralPage {

    public static final String SHOW_RESULT_CHECKBOX = ".//*[@id='filter_frm']/table/tbody/tr/td[1]/input";
    public static final String TO_FIND_ELEMENTS = ".//*[@id='filter_frm']/table[%s]/tbody/tr/td[1]/input";


    @Override
    public boolean isOpened(String URL) {
        return webDriver.getCurrentUrl().contains(URL); // changed "equals" to "contains"
    }



    public boolean isPageContainsCorrectSearchResults(String firstResult, String secondResult, String thirdResult){

        getNumberOfTables();
        getNumberOfElementsInTable(1);

        for (int i = 1; i <=getNumberOfTables() ; i++) {
            List<WebElement> listOfElements = elementsAreLocated(By.xpath(String.format(TO_FIND_ELEMENTS, i)));
            for (WebElement webEl: listOfElements){
                String actual = webEl.getAttribute("id");
                System.out.println(webEl.getAttribute("id"));
                if (actual.equals(firstResult) || actual.equals(secondResult) || actual.equals(thirdResult)){
                    System.out.println("bingo");
                }
                else {
                    System.out.println("fail");
                    Assert.fail();
                }
            }

        }


        return true;
    }


    public int getNumberOfTables(){
        List<WebElement> listOfTables = elementsAreLocated(getLocator("allTables"));
        System.out.println("tab:" + listOfTables.size());
        return listOfTables.size();
    }

    public int getNumberOfElementsInTable(int tableNumber){
        List<WebElement> listOfElements = elementsAreLocated(By.xpath(String.format(TO_FIND_ELEMENTS, tableNumber)));
        System.out.println("el: " + listOfElements.size());
        return listOfElements.size();
    }
}
