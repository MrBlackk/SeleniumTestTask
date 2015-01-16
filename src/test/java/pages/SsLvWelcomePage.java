package pages;

import utilities.Log4Test;

/**
 * Created by qa on 1/15/2015.
 */
public class SsLvWelcomePage extends GeneralPage{

    public boolean isRussianPageLoaded(String URL){
        return webDriver.getCurrentUrl().equals(URL);
    }

    public void openElectronicsPage(){
        elementIsLocated(getLocator("electronicsCategory")).click();
        Log4Test.info("Open Electronics page");
    }

}
