package com.dell.Pages;

import com.dell.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthenticationPage extends BasePage {

    public AuthenticationPage(WebDriver driver){
        super(driver);
        checkCorrectPage("//*[@id='SubmitCreate']" , "Didn't Navigate to Authentication Page");
        PageFactory.initElements(driver,this);
    }

    // Create Account Section
    @FindBy(id = "email_create")
    private WebElement newAccountEmailField;

    @FindBy(id = "SubmitCreate")
    private WebElement createNewAccountBtn;

    @FindBy(id = "create_account_error")
    private WebElement createAccountErrorMsg;

    //Registered User Login Section
    @FindBy(id = "email")
    private WebElement registeredUserEmailField;

    @FindBy(id = "passwd")
    private WebElement registeredUserPasswordField;

    @FindBy(id = "SubmitLogin")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@class= 'alert alert-danger']")
    private WebElement loginErrorMsg;

    public void setRegisteredUserCredentials(String userName, String password){
        wait.until(ExpectedConditions.visibilityOf(registeredUserEmailField));
        registeredUserEmailField.sendKeys(userName);
        registeredUserPasswordField.sendKeys(password);

    }

    public MyAccountPage clickLoginWithValidCredentials(){

        loginBtn.click();
        return new MyAccountPage(driver);
    }

    public void loginWithInvalidCredentials(){
        loginBtn.click();
    }

    public NewAccountPage setNewUserEmailAndSubmit(String newUserMail){
        wait.until(ExpectedConditions.visibilityOf(newAccountEmailField));
        newAccountEmailField.sendKeys(newUserMail);
        createNewAccountBtn.click();
        return new NewAccountPage(driver);
    }

    public String getCreateAccountErrorMsg(){
        wait.until(ExpectedConditions.visibilityOf(createAccountErrorMsg));
        return createAccountErrorMsg.getText();
    }

    public boolean checkErrorIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginErrorMsg));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
