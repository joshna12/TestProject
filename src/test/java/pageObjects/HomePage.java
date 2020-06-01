package pageObjects;

import com.selenium.test.BasePage;
import helpers.GlobalHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
        globalHelpers = new GlobalHelpers(driver);
    }
    private static GlobalHelpers globalHelpers;

    @FindBy(how = How.XPATH,using = "//button[contains(text(), 'SEARCH')]")
    public WebElement searchButton;

    @FindBy(how = How.XPATH,using = "//a[@title='Price (low to high)']")
    public WebElement defaultSortByOption;

    @FindBy(how = How.XPATH,using = "//section[1]/header//a[text()='My Garage']")
    public WebElement myGarage;

    @FindBy(how = How.XPATH,using = "//button[@class='logout-button']")
    public WebElement logoutButton;

    public void userVerifiesTheTitleOfHomepage(String expectedTitle){
        globalHelpers.waitForSecs(2);
        String actualTitle =driver.getTitle();
        System.out.println("ActualTitle is>>>>>>>>>>"+ actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    public void userClicksOnSearchButton(){
        searchButton.click();
    }

    public void verifyDefaultSortBy(){
        Assert.assertTrue(defaultSortByOption.isDisplayed());
    }

    public void sortBy(String option){
        defaultSortByOption.click();
        WebElement sortBy = driver.findElement(By.xpath("//a[contains(text(), 'Price (" + option + ")')]"));
        sortBy.click();
        globalHelpers.waitForSecs(5);
        driver.findElement(By.xpath("//a[@class='list-view open']")).click();
        globalHelpers.waitForSecs(5);
        Assert.assertTrue(driver.findElement(By.xpath("//section[@class='search-results__header']//a[@class='value'][contains(text(),'Price (" + option + ")')]")).isDisplayed());

    }

    public void navigateToMyGarage(){
        globalHelpers.waitForSecs(5);
        myGarage.click();
    }
    public void userLogout(){
        globalHelpers.waitForSecs(2);
        logoutButton.click();
    }
}
