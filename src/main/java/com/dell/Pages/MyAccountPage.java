package com.dell.Pages;

import com.dell.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver){
        super(driver);
        checkCorrectPage("//*[@title = 'Credit slips']" , "Didn't Navigate to My Account Page");
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@title= 'Women']")
    private WebElement womenCategory;

    @FindBy(xpath = "//*[@title= 'Blouses']")
    private WebElement womenBlouses;

    @FindBy(xpath = "//*[@title = 'Orders']")
    private WebElement orderHistory;

    public BlousesPage goToBlousesPage(){
        Actions action = new Actions(driver);
        action.moveToElement(womenCategory).perform();
        womenBlouses.click();
        return new BlousesPage(driver);
    }

    public OrderHistoryPage goToOrdersHistory(){
        orderHistory.click();
        return new OrderHistoryPage(driver);
    }


}
