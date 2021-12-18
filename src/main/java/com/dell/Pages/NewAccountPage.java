package com.dell.Pages;

import com.dell.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage extends BasePage {

    Select selectField;

    public NewAccountPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "id_gender1")
    private WebElement titleBtn;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "days")
    private WebElement datePickerDays;

    @FindBy(id = "months")
    private WebElement datePickerMonths;

    @FindBy(id = "years")
    private WebElement datePickerYears;

    @FindBy(id = "firstname")
    private WebElement addressFirstNameField;

    @FindBy(id = "lastname")
    private WebElement addressLastNameField;

    @FindBy(id = "company")
    private WebElement addressCompanyField;

    @FindBy(id = "address1")
    private WebElement firstAddressField;

    @FindBy(id = "address2")
    private WebElement secondAddressField;

    @FindBy(id = "city")
    private WebElement addressCityField;

    @FindBy(id = "id_state")
    private WebElement addressStateSelectField;

    @FindBy(id = "postcode")
    private WebElement addressPostalCodeField;

    @FindBy(id = "id_country")
    private WebElement addressCountrySelectField;

    @FindBy(id = "other")
    private WebElement addressAdditionalInfoField;

    @FindBy(id = "phone")
    private WebElement addressHomePhoneField;

    @FindBy(id = "phone_mobile")
    private WebElement addressMobilePhoneField;

    @FindBy(id = "alias")
    private WebElement addressAliasField;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountBtn;

    @FindBy(xpath = "//*[@class = 'alert alert-danger']")
    private WebElement errorMessage;

    public void fillPersonalInformation(String firstName, String lastName, String day, String month, String year){
        wait.until(ExpectedConditions.visibilityOf(firstAddressField));
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        passwordField.sendKeys("dell123");

        selectField = new Select(datePickerDays);
        selectField.selectByValue(day);

        selectField = new Select(datePickerMonths);
        selectField.selectByValue(month);

        selectField = new Select(datePickerYears);
        selectField.selectByValue(year);

    }

    public void fillAddressInfo(String firstName, String lastName, String companyName, String address,
                                String city, String state, String postalCode, String mobilePhone){

        firstAddressField.sendKeys(firstName);
        addressLastNameField.sendKeys(lastName);
        addressCompanyField.sendKeys(companyName);
        firstAddressField.sendKeys(address);
        addressCityField.sendKeys(city);

        selectField = new Select(addressStateSelectField);
        selectField.selectByVisibleText(state);

        addressPostalCodeField.sendKeys(postalCode);

        selectField = new Select(addressCountrySelectField);
        selectField.selectByValue("21");

        addressMobilePhoneField.sendKeys(mobilePhone);

    }

    public MyAccountPage submitNewValidAccount(){
        submitAccountBtn.click();
        return new MyAccountPage(driver);
    }

    public void submitNewInvalidAccount(){
        submitAccountBtn.click();
    }

    public boolean checkErrorIsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
