package Pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Logger;

public class MyProfilePage {

    private WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(MyProfilePage.class.getName());

    @FindBy (css = "div.form-horizontal")
    private WebElement myProfileForm;
    @FindBy (css = "div.panel-default:nth-child(1) div.panel-heading > h3.panel-title.go-text-right")
    private WebElement personalDetailsHeader;
    @FindBy(name = "firstname")
    private WebElement firstNameInput;
    @FindBy(name = "lastname")
    private WebElement lastNameInput;
    @FindBy(name = "phone")
    private WebElement phoneNumberInput;
    @FindBy(css = "input.form-control[name='email']")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "confirmpassword")
    private WebElement confirmPasswordInput;
    @FindBy(name = "address1")
    private WebElement firstAddressInput;
    @FindBy(name = "address2")
    private WebElement secondAddressInput;
    @FindBy(name = "city")
    private WebElement cityInput;
    @FindBy(name = "state")
    private WebElement stateInput;
    @FindBy(name = "zip")
    private WebElement zipCodeInput;
    @FindBy(name = "country")
    private WebElement countryListInput;
    @FindBy(className = "updateprofile")
    private WebElement submitUpdateProfileButton;

    public MyProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //methods

    public void fillFirstName(String firstname) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstname);
    }

    public void fillLastName(String lastname) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastname);
    }

    public void fillPhonenumber(String phone) {
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phone);
    }

    public void fillEmail(String email) {
       emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void fillPassword(String password) {
       passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void fillConfirmPassword(String confirmPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void fillFirstAddress(String address1) {
        firstAddressInput.clear();
        firstAddressInput.sendKeys(address1);
    }

    public void fillSecondAddress(String address2) {
        secondAddressInput.clear();
        secondAddressInput.sendKeys(address2);
    }

    public void fillCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void fillState(String state) {

        stateInput.clear();
        stateInput.sendKeys(state);
    }

    public void fillZipCode(String zip) {
        zipCodeInput.clear();
        zipCodeInput.sendKeys(zip);
    }

    public void submitMyProfileUpdate() {
        if (submitUpdateProfileButton.isEnabled())
            submitUpdateProfileButton.click();
    }

    public void selectCountry(String country) {
        Select selectCountry = new Select(countryListInput);
        selectCountry.selectByVisibleText(country);
    }


    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getPhoneNumberInput() {
        return phoneNumberInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getFirstAddressInput() {
        return firstAddressInput;
    }

    public WebElement getSecondAddressInput() {
        return secondAddressInput;
    }

    public WebElement getCityInput() {
        return cityInput;
    }

    public WebElement getStateInput() {
        return stateInput;
    }

    public WebElement getZipCodeInput() {
        return zipCodeInput;
    }

    public WebElement getCountryListInput() {
        return countryListInput;
    }

    public WebElement getMyProfileForm() {
        return myProfileForm;
    }

    public String getPersonalDetailHeaderText (){
        String header = personalDetailsHeader.getText();
        LOGGER.info("Current personal details header is: "+header);
        return header;
    }
}
