package pageObjects;

import com.selenium.test.BasePage;
import helpers.GlobalHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;


public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
        globalHelpers = new GlobalHelpers(driver);
    }

    private GlobalHelpers globalHelpers;
    public String getSubHeadingOfTheItem;

    public void userVerifiesTheTitle() {
        String searchPageTitle = driver.getTitle();
        Assert.assertTrue(searchPageTitle.contains("Your Search Results - Cargiant"));
    }
    public void userAddsItemIntoWishList(String carName) {

        String beforeXpath = "//*[@id=\"vehicle-results-panel\"]/ul/li[";
        String afterXpath = "]//h3/a";
        for(int i=1; i<=27; i++){
            String carModel = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
            System.out.println("value of i: " + i);
            System.out.println(carModel);
            if(carModel.contains(carName)){
                globalHelpers.waitForSecs(5);
                WebElement watchlist = driver.findElement(By.xpath("//*[@id=\"vehicle-results-panel\"]/ul/li[" + i + "]//div[1]/div/a[1][@data-action='Add to Watchlist']"));
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].scrollIntoView()", watchlist);
                JavascriptExecutor js1 = (JavascriptExecutor)driver;
                js1.executeScript("window.scrollBy(0,240)");
                js1.executeScript("arguments[0].click();", watchlist);
                break;
            }

        }

    }
}
