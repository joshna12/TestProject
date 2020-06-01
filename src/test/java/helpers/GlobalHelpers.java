package helpers;

import com.selenium.test.BasePage;
import org.openqa.selenium.WebDriver;

public class GlobalHelpers extends BasePage {
    private static WebDriver driver;
    public GlobalHelpers(WebDriver driver) {
        super(driver);
    }

    public void waitForSecs(int secs) {
        try {
            Thread.sleep(secs*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
