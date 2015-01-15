package pages;

/**
 * Created by qa on 1/15/2015.
 */
public class SsLvWelcomePage extends GeneralPage{

//    public void changeLanguage(){
//
//    }

    public boolean isRussianPageLoaded(String URL){
        return webDriver.getCurrentUrl().equals(URL);

    }

    public void openElectronicsPage(){
        elementIsLocated(getLocator("electronicsCategory")).click();
    }

}
