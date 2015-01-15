package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by qa on 1/15/2015.
 */
public class WebDriverFactory {

    static {
        try {
            System.setProperty("webdriver.chrome.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/chromedriver.exe").getPath());
        }
        catch (Exception ex){
            System.out.println("Cannot launch Chrome driver \n" + ex.getMessage());
        }
    }

    public static WebDriver getWebDriver(BrowserTypes browserType){
        switch (browserType){
            case CHROME:
                return new ChromeDriver();
            case FIRE_FOX:
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Browser is not supported " + browserType);
        }
    }

}
