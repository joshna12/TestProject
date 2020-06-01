package com.selenium.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    public static Properties prop;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public static WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        prop.load(fis);
        String browser = prop.getProperty("browser");

        if (browser.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "/Users/vikaspatra/CarGiant/src/chromedriver");
            driver = new ChromeDriver();


        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.firefox.driver", "/Users/vikaspatra/CarGiant/geckodriver.exe");
            driver = new FirefoxDriver();


        } else if (browser.equals("IE")) {

            File file = new File("/Users/vikaspatra/CarGiant/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            driver = new InternetExplorerDriver();

        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        return driver;


    }

    public void getScreenShot(String result1) throws IOException {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("FailedTests/ScreenShots" + result1 + "screenshot.png"));

    }
    public static String getUrl() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        prop.load(fis);
        return prop.getProperty("url");
    }
    protected static String getUserName() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        prop.load(fis);
        return prop.getProperty("userName");
    }
    protected static String getPassword() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        prop.load(fis);
        return prop.getProperty("passWord");
    }



}