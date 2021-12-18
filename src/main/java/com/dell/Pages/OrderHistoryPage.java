package com.dell.Pages;

import com.dell.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderHistoryPage extends BasePage {

    public OrderHistoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody")
    private WebElement ordersTableBody;

    @FindBy(xpath = "//*[@title= 'Women']")
    private WebElement womenCategory;

    @FindBy(xpath = "//*[@title= 'Blouses']")
    private WebElement womenBlouses;

    public BlousesPage goToBlousesPage(){
        Actions action = new Actions(driver);
        action.moveToElement(womenCategory).perform();
        womenBlouses.click();
        return new BlousesPage(driver);
    }

    public int countOrders(){
        List<WebElement> orders = ordersTableBody.findElements(By.xpath("./tr"));
        return orders.size();
    }
}
