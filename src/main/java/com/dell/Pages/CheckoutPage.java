package com.dell.Pages;

import com.dell.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@class = 'cart_navigation clearfix']//*[@title = 'Proceed to checkout']")
    private WebElement summaryProceedToCheckoutBtn;

    @FindBy(xpath = "//*[@name= 'processAddress']")
    private WebElement addressProceedToCheckoutBtn;

    @FindBy(id = "uniform-cgv")
    private WebElement termsAndConditions;

    @FindBy(xpath = "//*[@name= 'processCarrier']")
    private WebElement shippingProceedToCheckoutBtn;

    @FindBy(xpath = "//*[@class= 'bankwire']")
    private WebElement selectPayByBankWire;

    @FindBy(xpath = "//*[@id= 'cart_navigation']//*[@type= 'submit']")
    private WebElement confirmOrderBtn;

    @FindBy(xpath = "//*[@class= 'cart_navigation exclusive']//*[@title='Back to orders']")
    private WebElement backToOrdersHistoryBtn;

    public void summaryProceedToCheckout(){
        wait.until(ExpectedConditions.visibilityOf(summaryProceedToCheckoutBtn));
        summaryProceedToCheckoutBtn.click();
    }

    public void addressProceedToCheckout(){
        wait.until(ExpectedConditions.visibilityOf(addressProceedToCheckoutBtn));
        addressProceedToCheckoutBtn.click();
    }

    public void shippingProceedToCheckout(){
        wait.until(ExpectedConditions.visibilityOf(termsAndConditions));
        termsAndConditions.click();
        shippingProceedToCheckoutBtn.click();

    }

    public void selectPayByBankWire(){
        selectPayByBankWire.click();
    }

    public void confirmOrder(){
        confirmOrderBtn.click();
    }

    public OrderHistoryPage goToOrderHistoryPage(){
        backToOrdersHistoryBtn.click();
        return new OrderHistoryPage(driver);
    }
}
