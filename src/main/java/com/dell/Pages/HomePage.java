package com.dell.Pages;

import com.dell.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class = 'login']")
    private WebElement signInBtn;

    @FindBy(xpath = "//*[@title= 'Women']")
    private WebElement womenCategory;

    @FindBy(xpath = "//*[@title= 'Blouses']")
    private WebElement womenBlouses;

    public AuthenticationPage clickSignInBtn(){
        signInBtn.click();
        return new AuthenticationPage(driver);

    }

    public BlousesPage goToBlousesPage(){
        Actions action = new Actions(driver);
        action.moveToElement(womenCategory).perform();
        womenBlouses.click();
        return new BlousesPage(driver);

    }
}
