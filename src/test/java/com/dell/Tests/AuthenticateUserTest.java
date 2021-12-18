package com.dell.Tests;

import com.dell.BaseTest;
import com.dell.Pages.AuthenticationPage;
import com.dell.Pages.HomePage;
import com.dell.Pages.MyAccountPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AuthenticateUserTest extends BaseTest {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;
    SoftAssert softAssert;

    @Test
    public void authenticateUserWithValidCredentials(){
        homePage = new HomePage(driver);
        authenticationPage = homePage.clickSignInBtn();
        authenticationPage.setRegisteredUserCredentials("AhmedAmer@dell.com",
                "dell123");
        myAccountPage = authenticationPage.clickLoginWithValidCredentials();
    }

    @Test
    public void authenticateUserWithEmptyEmail(){

        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
        authenticationPage = homePage.clickSignInBtn();
        authenticationPage.setRegisteredUserCredentials("",
                "dell123");
       authenticationPage.loginWithInvalidCredentials();
       softAssert.assertTrue(authenticationPage.checkErrorIsDisplayed());
       softAssert.assertAll();

    }

    @Test
    public void authenticateUserWithEmptyPassword(){

        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
        authenticationPage = homePage.clickSignInBtn();
        authenticationPage.setRegisteredUserCredentials("AhmedAmer@dell.com",
                "");
        authenticationPage.loginWithInvalidCredentials();
        softAssert.assertTrue(authenticationPage.checkErrorIsDisplayed());
        softAssert.assertAll();

    }
}
