package fbt.tests;

import org.junit.Test;

public class MainPageTest extends BaseTest{
    @Test
    public void isMainPageLoaded(){
        loginPage.login("vip.saparbaev@bk.ru", "Saparbaev02");
        mainPage.isLoaded();
    }
    @Test
    public void checkMoreButtonAndLinksInTheLeftOfThePage() throws Exception {
        loginPage.login("vip.saparbaev@bk.ru", "Saparbaev02");
        mainPage.isLoaded();
        Thread.sleep(500);
        mainPage.checkTheMoreButton();
        takeSnapShot(driver,".//screenshot/showingtheleftpanel.png");
        mainPage.checkLeftList();
    }
    @Test
    public void IsSearchBarWorking() throws Exception {
        loginPage.login("vip.saparbaev@bk.ru", "Saparbaev02");
        mainPage.isLoaded();
        mainPage.isSearchBarWorks();
        takeSnapShot(driver,".//screenshot/searchbar.png");
    }
    @Test
    public void AreLinksOnTheTopWorking(){
        loginPage.login("vip.saparbaev@bk.ru", "Saparbaev02");
        mainPage.isLoaded();
        mainPage.linksOnTheTopWork();
    }
    @Test
    public void AreHudButtonsWorking() throws Exception {
        loginPage.login("vip.saparbaev@bk.ru", "Saparbaev02");
        mainPage.isLoaded();
        mainPage.hubButtonsWork();
        takeSnapShot(driver,".//screenshot/hudbuttons.png");
    }
}
