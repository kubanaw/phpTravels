package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfile {
    WebDriver driver;

    public MyProfile (WebDriver driver){
        this.driver =driver;
    }

    @FindBy (name = "firstname")
    private WebElement firstNameInput;

    @FindBy(name = "lastname")
    private WebElement lastNameInput;

    @FindBy (name="phone")
    private WebElement phoneNumberInput;

    @FindBy (name ="email")
    private WebElement emailInput;

    @FindBy (name ="password")
    private WebElement passwordInput;

    @FindBy (name ="confirmpassword")
    private WebElement confirmPasswordInput;

    @FindBy (name ="address1")
    private WebElement firstAddressInput;

    @FindBy (name = "address2")
    private WebElement secondAddressInput;

    @FindBy (name = "city")
    private WebElement cityInput;

    @FindBy (name = "state")
    private WebElement stateInput;

    @FindBy (name = "zip")
    private WebElement zipCodeInput;

    @FindBy (name = "country")
    private WebElement countryListInput;

    @FindBy (name = "updateprofile")
    private WebElement submitUpdateProfileButton;

    //methods

    public void clearFirstName (){
        firstNameInput.clear();
    }
    public void clearLastName (){
        lastNameInput.clear();
    }
    public void fillPhonenumber (String phone){
        phoneNumberInput.sendKeys(phone);
    }
    public void fillEmail (String email){
        emailInput.sendKeys(email);
    }
    public void fillPassword (String password) {
        passwordInput.sendKeys();
    }

    public void fillConfirmPassword (String confirmPassword){
        confirmPasswordInput.sendKeys(confirmPassword);
    }
    public void fillFirstAddress (String address1){
        firstAddressInput.sendKeys(address1);
    }

    public void fillSecondAddress (String address2) {
        secondAddressInput.sendKeys(address2);
    }
    public void fillCity (String city){
        cityInput.sendKeys(city);
    }
    public void fillState (String state){
        stateInput.sendKeys(state);
    }
    public void fillZipCode (String zip){
        zipCodeInput.sendKeys(zip);
    }
    public void submitMyProfileUpdate (){
        submitUpdateProfileButton.submit();
    }
    public void selectCountry (String country) {
        countryListInput.click();

    }





}
