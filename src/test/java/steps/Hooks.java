package steps;

import com.selenium.test.BasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Hooks {
    public static WebDriver driver;

    protected static Logger logger = Logger.getLogger(Hooks.class);

    // In case of running the test on mac, please comment out the windows maximise and cookies line
    @Before
    public void openBrowser() throws IOException {
        driver = BasePage.initializeDriver();
        //driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

// Once test gets failed it will take screenshot and quit the driver.
 // To view the  screenshot navigate to target folder >> cucumber-html-report >> right click on index.html >> select the browser name
    @After
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                logger.info(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
        driver.quit();
        driver = null;
    }

}