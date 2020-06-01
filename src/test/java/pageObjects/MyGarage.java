package pageObjects;

import com.selenium.test.BasePage;
import helpers.GlobalHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class MyGarage extends BasePage {
    public MyGarage(WebDriver driver){
        super(driver);
        globalHelpers = new GlobalHelpers(driver);
        homePage = new HomePage(driver);
    }
    private static GlobalHelpers globalHelpers;
    private static HomePage homePage;

    @FindBy(how = How.XPATH, using = "//*[@id='slick-slide00']//span[text()='Remove from watchlist']")
    private static WebElement firstRemoveButton;

    @FindBy(how = How.XPATH, using = "//*[@id='whatchlist_slider']//div[1]//a/span")
    private static WebElement secondRemoveButton;



    public void verifyCarIsAddedToTheWatchList(String carName){
        String beforeXpath = "//*[@id='slick-slide0";
        String afterXpath = "']/div[2]/h3";
        for(int i=0 ;i<=1;i++){
            String carTitle = driver.findElement(By.xpath(beforeXpath+ i + afterXpath)).getText();
            if(carTitle.contains(carName)){
                Assert.assertTrue(carTitle.contains(carName));
            }else{
                WebElement nextButton = driver.findElement(By.xpath("//span[@class='watch-next slick-arrow']"));
                JavascriptExecutor js = (JavascriptExecutor)driver;
                JavascriptExecutor js1 = (JavascriptExecutor)driver;
                js1.executeScript("window.scrollBy(0,280)");
                js.executeScript("arguments[0].click();", nextButton);
            }
        }

    }
    public void remove1stCarFromWatchLit(){
        homePage.navigateToMyGarage();
        firstRemoveButton.click();
    }
    public void remove2ndCarFromWatchLit(){
        homePage.navigateToMyGarage();
        secondRemoveButton.click();
    }
    public boolean verifyCarIsRemovedFromTheWatchList(){
        try {
            driver.findElement(By.xpath("//*[@id='slick-slide00']//span[text()='Remove from watchlist']"));
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


}
