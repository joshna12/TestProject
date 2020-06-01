package pageObjects;

import com.selenium.test.BasePage;
import helpers.GlobalHelpers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        globalHelpers = new GlobalHelpers(driver);
    }

    private GlobalHelpers globalHelpers;

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Log in')]")
    private static WebElement logInButton;
    @FindBy(how = How.XPATH, using = "//a[@role='button']")
    private static WebElement closeButton;
    @FindBy(how = How.ID, using = "PartialLogin_Username")
    private static WebElement username;
    @FindBy(how = How.ID, using = "PartialLogin_Password")
    private static WebElement password;
    @FindBy(how = How.XPATH, using = "//input[@value='Sign in']")
    private static WebElement signInButton;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Home')]")
    private static WebElement homePageLink;

    public void userGetsTheUrl() throws IOException {
        driver.get(BasePage.getUrl());
    }

    public void userClicksOnLoginButtonOnHomePage() throws InterruptedException {
        globalHelpers.waitForSecs(3);
        closeButton.click();
        globalHelpers.waitForSecs(2);
        logInButton.click();
    }
    public void userEntersTheLoginCredentials() throws IOException {
        username.sendKeys(getUserName());
        password.sendKeys(getPassword());
        globalHelpers.waitForSecs(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,240 )");
        signInButton.click();
    }
    public void navigatesToHomePage(){
        globalHelpers.waitForSecs(2);
        homePageLink.click();
    }
}
