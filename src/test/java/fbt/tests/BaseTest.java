package fbt.tests;

import JustAPackage.LoginPageFeature;
import JustAPackage.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;

import static org.junit.Assert.assertTrue;

public class BaseTest {
    WebDriver driver;
    public static LoginPageFeature loginPage;
    public static MainPage mainPage;
    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }
    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        return new ChromeDriver();
    }
    @Before
    public void setup(){
        driver =getDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPageFeature(driver);
        loginPage.open();
        mainPage = new MainPage(driver);
        assertTrue(loginPage.isLoaded());
    }
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
    //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
    //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    //Move image file to new destination
        File DestFile=new File(fileWithPath);
    //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }


    @After
    public void cleanUp(){ driver.quit();
    }

}
