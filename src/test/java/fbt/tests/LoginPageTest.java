package fbt.tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginPageTest extends BaseTest{
    @Test
    public void visibilityOfPassword() throws Exception {
        assertTrue(loginPage.isPasswordButtonVisible());
        assertTrue(loginPage.isPasswordVisible());
        takeSnapShot(driver,".//screenshot/screenshot.png");
    }
    @Test
    public void isCreateAnUserButtonVisible(){
        assertTrue(loginPage.iSCreateButtonVisible());
    }
    @Test
    public void forgotThePasswordButtonIsVisible(){
        assertTrue(loginPage.forgotButtonIsVisible());
    }
    @Test
    public void isRecoverPageWorking(){
        loginPage.checkingTheRecoverPage();
    }
    @Test
    public void checkTheListOfURLs()  {
        loginPage.checkTheURLs();
    }
    @Test
    public void shouldLogin(){
        loginPage.login("n.ganrey@mail.ru", "Secret_sauce1");
    }

}


