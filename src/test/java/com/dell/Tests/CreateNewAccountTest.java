package com.dell.Tests;

import com.dell.BaseTest;
import com.dell.Pages.AuthenticationPage;
import com.dell.Pages.HomePage;
import com.dell.Pages.MyAccountPage;
import com.dell.Pages.NewAccountPage;
import com.dell.Utilities.DataProviderSource;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;


public class CreateNewAccountTest extends BaseTest {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    NewAccountPage newAccountPage;
    MyAccountPage myAccountPage;
    Random rand ;
    SoftAssert softAssert;

    @Test(alwaysRun = true)
    public void checkErrorMessageForInvalidCreateUserEmail() {

        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
        authenticationPage = homePage.clickSignInBtn();
        authenticationPage.setNewUserEmailAndSubmit("");
        softAssert.assertEquals("Invalid email address." , authenticationPage.getCreateAccountErrorMsg() ,
                "Wrong error message displayed for Create Account");
        softAssert.assertAll();

    }

    @Test(alwaysRun = true , dataProvider = "NewValidUserAccount" , dataProviderClass = DataProviderSource.class)
    public void createNewUserWithValidDetails(String fName, String lName, String day, String month,
                                              String year, String address, String companyName, String city,
                                              String state, String zipCode, String mobilePhone) {

        rand = new Random();
        homePage = new HomePage(driver);
        authenticationPage = homePage.clickSignInBtn();
        newAccountPage = authenticationPage.setNewUserEmailAndSubmit(rand.nextInt() + "@dell.com");
        newAccountPage.fillPersonalInformation(fName,lName,day,month,year);
        newAccountPage.fillAddressInfo(fName,lName,companyName,address,city,state,zipCode,mobilePhone);
        myAccountPage = newAccountPage.submitNewValidAccount();

    }

    @Test(alwaysRun = true , dataProvider = "NewInvalidUserAccount" , dataProviderClass = DataProviderSource.class)
    public void createNewUserWithInValidDetails(String fName, String lName, String day, String month,
                                              String year, String address, String companyName, String city,
                                              String state, String zipCode, String mobilePhone) {

        rand = new Random();
        softAssert = new SoftAssert();

        homePage = new HomePage(driver);
        authenticationPage = homePage.clickSignInBtn();
        newAccountPage = authenticationPage.setNewUserEmailAndSubmit(rand.nextInt() + "@dell.com");
        newAccountPage.fillPersonalInformation(fName,lName,day,month,year);
        newAccountPage.fillAddressInfo(fName,lName,companyName,address,city,state,zipCode,mobilePhone);
        newAccountPage.submitNewInvalidAccount();
        softAssert.assertTrue(newAccountPage.checkErrorIsDisplayed(), "No Error Message Displayed");
        softAssert.assertAll();

    }

}
