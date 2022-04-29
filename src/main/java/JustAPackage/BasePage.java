package JustAPackage;


import io.restassured.response.Response;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class BasePage {

    public final WebDriver driver;
    protected WebDriverWait wait;
    public Response response;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }
    public boolean waitMethodByXpath(String xpathFeature){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathFeature))).isDisplayed();
    }

}
