package Pages.user.account;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

public class MyProfilePage extends BasePage {

//    private static final Logger LOGGER = Logger.getLogger(MyProfilePage.class.getName());
    private WebDriver driver;

    @FindBy(css = "div.form-horizontal")
    private WebElement myProfileForm;

    @FindBy(css = "div.panel-default:nth-child(1) div.panel-heading > h3.panel-title.go-text-right")
    private WebElement personalDetailsHeader;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "phone")
    private WebElement phoneNumber;

    @FindBy(css = "input.form-control[name='email']")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmpassword")
    private WebElement confirmPassword;

    @FindBy(name = "address1")
    private WebElement firstAddress;

    @FindBy(name = "address2")
    private WebElement secondAddress;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "state")
    private WebElement state;

    @FindBy(name = "zip")
    private WebElement zipCode;

    @FindBy(name = "country")
    private WebElement countryList;

    @FindBy(className = "updateprofile")
    private WebElement submitUpdateProfileButton;

    @FindBy (css = ".accountresult>.alert")
    private WebElement alert;

    public MyProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //methods


    public MyProfilePage fillPhonenumber(String phone) {
        phoneNumber.clear();
        phoneNumber.sendKeys(phone);
        return this;
    }

    public MyProfilePage fillEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
        return this;
    }

    public MyProfilePage fillPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }

    public MyProfilePage fillConfirmPassword(String confirmPassword) {
        this.confirmPassword.clear();
        this.confirmPassword.sendKeys(confirmPassword);
        return this;
    }

    public MyProfilePage fillFirstAddress(String address1) {
        firstAddress.clear();
        firstAddress.sendKeys(address1);
        return this;
    }

    public MyProfilePage fillSecondAddress(String address2) {
        secondAddress.clear();
        secondAddress.sendKeys(address2);
        return this;
    }

    public MyProfilePage fillCity(String city) {
        this.city.clear();
        this.city.sendKeys(city);
        return this;
    }

    public MyProfilePage fillState(String state) {

        this.state.clear();
        this.state.sendKeys(state);
        return this;
    }

    public MyProfilePage fillZipCode(String zip) {
        zipCode.clear();
        zipCode.sendKeys(zip);
        return this;
    }

    public MyProfilePage submitMyProfileUpdate() {
        if (submitUpdateProfileButton.isEnabled())
            submitUpdateProfileButton.click();
        return this;
    }


    public MyProfilePage selectCountry(String country) {
        Select selectCountry = new Select(countryList);
        selectCountry.selectByVisibleText(country);
        return this;
    }


//    public WebElement getFirstNameInput() {
//        return firstName;
//    }
//
//    public WebElement getLastNameInput() {
//        return lastName;
//    }
//
//    public WebElement getPhoneNumberInput() {
//        return phoneNumber;
//    }
//
//    public WebElement getEmailInput() {
//        return email;
//    }
//
//    public WebElement getFirstAddressInput() {
//        return firstAddress;
//    }
//
//    public WebElement getSecondAddressInput() {
//        return secondAddress;
//    }
//
//    public WebElement getCityInput() {
//        return city;
//    }
//
//    public WebElement getStateInput() {
//        return state;
//    }
//
//    public WebElement getZipCodeInput() {
//        return zipCode;
//    }
//
//    public WebElement getCountryListInput() {
//        return countryList;
//    }

    public WebElement getMyProfileForm() {
        return myProfileForm;
    }

    public String getPersonalDetailHeaderText() {
        String header = personalDetailsHeader.getText();
        LOGGER.finer("Current personal details header is: " + header);
        return header;
    }

    public boolean isFirstNameReadOnly() {
        String state = firstName.getAttribute("readonly");
        if (state == null) {
            LOGGER.finer("First name doesn't have attribute readonly!");
        } else if (state.contains("true")) {
            return true;
        }
        return false;
    }

    public boolean isLastNameReadOnly() {
        String state = lastName.getAttribute("readonly");
        if (state == null) {
            LOGGER.finer("Last name doesn't have attribute readonly!");
        } else if (state.contains("true")) {
            return true;
        }
        return false;
    }

    public String getAlertMessage (){
       String alertMessage = alert.getText();
       LOGGER.finer("Actual alert message is "+alertMessage);
       return alertMessage;
    }

    public String getCurrentUrl() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }


}
