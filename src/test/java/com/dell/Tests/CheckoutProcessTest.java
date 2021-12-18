package com.dell.Tests;

import com.dell.BaseTest;
import com.dell.Pages.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class CheckoutProcessTest extends BaseTest {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;
    BlousesPage blousesPage;
    CheckoutPage checkoutPage;
    OrderHistoryPage orderHistoryPage;
    SoftAssert softAssert;

    @Test
    public void checkOutBlouseHappyScenario(){
        int initialOrdersNum = 0 ;
        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
        authenticationPage = homePage.clickSignInBtn();
        authenticationPage.setRegisteredUserCredentials("AhmedAmer@dell.com",
                "dell123");
        myAccountPage = authenticationPage.clickLoginWithValidCredentials();
        orderHistoryPage = myAccountPage.goToOrdersHistory();

        //Get initial count of orders before placing new order
        initialOrdersNum = orderHistoryPage.countOrders();
        blousesPage = orderHistoryPage.goToBlousesPage();
        blousesPage.addProductToCart();
        checkoutPage = blousesPage.goToCheckout();
        checkoutPage.summaryProceedToCheckout();
        checkoutPage.addressProceedToCheckout();
        checkoutPage.shippingProceedToCheckout();
        checkoutPage.selectPayByBankWire();
        checkoutPage.confirmOrder();
        orderHistoryPage = checkoutPage.goToOrderHistoryPage();

        //Asserting that order is added correctly will be better if done with order reference
        //However, order reference is provided within a text not as a field
        softAssert.assertEquals(initialOrdersNum + 1  ,orderHistoryPage.countOrders() ,
                "Orders history isn't updated correctly");
        softAssert.assertAll();
    }


}
