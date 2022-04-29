package JustAPackage;

import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.openqa.selenium.By.*;

public class MainPage extends BasePage {


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//div[@role='main']"))).isDisplayed();
    }

    public void checkTheMoreButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector("div[role='button'] div[class='ow4ym5g4 auili1gw rq0escxv j83agx80 buofh1pr g5gj957u i1fnvgqd oygrvhab cxmmr5t8 hcukyx3x kvgmc6g5 hpfvmrgz qt6c0cv9 jb3vyjys l9j0dhe7 du4w35lb bp9cbjyn btwxx1t3 dflh9lhu scb9dxdr nnctdnn4']"))).click();
    }

    public void checkLeftList() {
        //Storing the links in a list and traversing through the links
        List<WebElement> links = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath("(//ul)[3]/li/div/a")));
        // This line will print the number of links and the count of links.
        System.out.println("No of links are "+ links.size());

        //checking the links fetched.
        for(int i=0;i<links.size();i++)
        {
            WebElement E1= links.get(i);
            String url= E1.getAttribute("href");
            verifyLinks(url);
            System.out.println(url);

        }
    }


    public void isSearchBarWorks() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector("div[class='rq0escxv byvelhso q10oee1b poy2od1o j9ispegn kr520xx4 ooia0uwo kavbgo14 mhnrfdw6'] div label[class='lzcic4wl gs1a9yip br7hx15l h2jyy9rg n3ddgdk9 owxd89k7 rq0escxv j83agx80 a5nuqjux l9j0dhe7 k4urcfbm kbf60n1y b3i9ofy5']"))).sendKeys("Something that i want");
    }

    public void linksOnTheTopWork() {
        List<WebElement> links = driver.findElements(xpath("(//ul[@class='thodolrn ojvp67qx taijpn5t buofh1pr j83agx80 aovydwv3 bqdfd6uv'])/li/span/div/a"));
        // This line will print the number of links and the count of links.
        System.out.println("No of links are "+ links.size());

        //checking the links fetched.
        for(int i=0;i<links.size();i++)
        {
            WebElement E1= links.get(i);
            String url= E1.getAttribute("href");
            verifyLinks(url);
            System.out.println(url);
        }

    }

    public void hubButtonsWork() {
        driver.findElement(xpath("(//div[@class='bp9cbjyn j83agx80 datstx6m taijpn5t oi9244e8'])[1]")).click();
        driver.findElement(xpath("(//div[@class='bp9cbjyn j83agx80 datstx6m taijpn5t oi9244e8'])[2]")).click();
        driver.findElement(xpath("(//div[@class='bp9cbjyn j83agx80 datstx6m taijpn5t oi9244e8'])[3]")).click();
        driver.findElement(xpath("(//span[@class='tojvnm2t a6sixzi8 abs2jz4q a8s20v7p t1p8iaqh k5wvi7nf q3lfd5jv pk4s997a bipmatt0 cebpdrjk qowsmv63 owwhemhu dp1hu0rb dhp61c6y iyyx5f41'])[7]")).click();
    }
    public static void verifyLinks(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
            }

            //Fetching and Printing the response code obtained
            else{
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
        }
    }
}
