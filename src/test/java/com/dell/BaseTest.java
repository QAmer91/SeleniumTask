package com.dell;

import static org.junit.Assert.assertTrue;

import com.dell.Pages.HomePage;
import com.dell.Utilities.DriverHandler;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class BaseTest
{
    public DriverHandler driverHandler ;
    public WebDriver driver ;

    @BeforeMethod
    public void setup() throws IOException {
        driverHandler = new DriverHandler();
        driver = driverHandler.createDriver();
        driver.get("http://automationpractice.com/index.php");
    }


    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
