package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyProfile {

    private WebDriver driver;
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

    public MyProfile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //methods

    public void fillFirstName(String firstname) {
        firstNameInput.sendKeys(firstname);
    }

    public void fillLastName(String lastname) {
        lastNameInput.sendKeys(lastname);
    }

    public void fillPhonenumber(String phone) {
        clearPhonenumberField();
        phoneNumberInput.sendKeys(phone);
    }

    public void fillEmail(String email) {
        clearEmailField();
        emailInput.sendKeys(email);
    }

    public void fillPassword(String password) {
        clearPasswordField();
        passwordInput.sendKeys(password);
    }

    public void fillConfirmPassword(String confirmPassword) {
        clearConfirmPasswordField();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void fillFirstAddress(String address1) {
        clearFirstAddressField();
        firstAddressInput.sendKeys(address1);
    }

    public void fillSecondAddress(String address2) {
        clearSecondAddressField();
        secondAddressInput.sendKeys(address2);
    }

    public void fillCity(String city) {
        clearCityField();
        cityInput.sendKeys(city);
    }

    public void fillState(String state) {

        clearStateField();
        stateInput.sendKeys(state);
    }

    public void fillZipCode(String zip) {
        clearZipCodeField();
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

    public void clearPhonenumberField() {
        phoneNumberInput.clear();
    }

    public void clearEmailField() {
        emailInput.clear();
    }

    public void clearFirstAddressField() {
        firstAddressInput.clear();
    }

    public void clearSecondAddressField() {
        secondAddressInput.clear();
    }

    public void clearCityField() {
        cityInput.clear();
    }

    public void clearStateField() {
        stateInput.clear();
    }

    public void clearZipCodeField() {
        zipCodeInput.clear();
    }

    public void clearPasswordField() {
        passwordInput.clear();
    }

    public void clearConfirmPasswordField() {
        confirmPasswordInput.clear();
    }


    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getConfirmPasswordInput() {
        return confirmPasswordInput;
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

    public WebElement getSubmitUpdateProfileButton() {
        return submitUpdateProfileButton;
    }
}
