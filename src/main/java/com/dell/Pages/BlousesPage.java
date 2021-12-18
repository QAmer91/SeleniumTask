package com.dell.Pages;

import com.dell.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlousesPage extends BasePage {

    public BlousesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@alt='Blouse']")
    private WebElement blouseImage;

    @FindBy(xpath = "//*[@title='Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//*[@title='Proceed to checkout']")
    private WebElement checkoutBtn;

    public void addProductToCart(){
        Actions actions = new Actions(driver);
        actions.moveToElement(blouseImage).perform();
        addToCartBtn.click();
    }

    public CheckoutPage goToCheckout(){
        wait.until(ExpectedConditions.visibilityOf(checkoutBtn));
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }

}
