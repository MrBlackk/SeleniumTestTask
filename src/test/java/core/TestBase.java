package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.TestData;

import java.util.concurrent.TimeUnit;

/**
 * Created by qa on 1/15/2015.
 */
public class TestBase {
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;


    @BeforeSuite
    public static void setUp(){
        webDriver = WebDriverFactory.getWebDriver(TestData.BROWSER_NAME);
        wait = new WebDriverWait(webDriver, 30);

        webDriver.manage().window().maximize();

        //default timeouts
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
        //webDriver.quit();
    }

}
