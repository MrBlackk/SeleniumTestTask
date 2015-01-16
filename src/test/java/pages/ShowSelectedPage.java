package pages;

import org.openqa.selenium.WebElement;
import utilities.Log4Test;

import java.util.List;

/**
 * Created by qa on 1/15/2015.
 */
public class ShowSelectedPage extends GeneralPage {

    @Override
    public boolean isOpened(String URL) {
        return webDriver.getCurrentUrl().contains(URL); // changed "equals" to "contains"
    }

    public boolean isPageContainsCorrectSearchResults(String firstResult, String secondResult, String thirdResult){
            List<WebElement> listOfElements = elementsAreLocated(getLocator("allCheckboxes"));
            for (WebElement webEl: listOfElements){
                String actual = webEl.getAttribute("id");
                if (actual.equals(firstResult) || actual.equals(secondResult) || actual.equals(thirdResult)){
                    Log4Test.info("Correct result id: " + actual);
                }
                else {
                    Log4Test.error("Incorrect result id: " + actual);
                    return false;
                }
            }
        return true;
    }
}
