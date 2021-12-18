package com.dell;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriverWait wait;
    public WebDriver driver ;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public void checkCorrectPage(String pageIdentifier , String errorMsg){

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageIdentifier)));
        }
        catch (TimeoutException e)
        {
            throw new IllegalStateException(errorMsg);
        }
    }
}