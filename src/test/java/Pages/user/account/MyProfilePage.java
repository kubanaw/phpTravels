package Pages.user.account;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class MyProfilePage extends BasePage {

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

    @FindBy(css="input.form-control")
    private List<WebElement> inputFormList;

    @FindBy(className = "updateprofile")
    private WebElement submitUpdateProfileButton;

    @FindBy(css = ".accountresult>.alert")
    private WebElement alert;

    public MyProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public MyProfilePage fillPhonenumber(String phone) {
        phoneNumber.clear();
        phoneNumber.sendKeys(phone);
        return this;
    }


    public String fillPhonenumber(int numberOfRandomDigits) {
        phoneNumber.clear();
        phoneNumber.sendKeys(getRandomNumber(numberOfRandomDigits));
        return phoneNumber.getAttribute("value");
    }

    public MyProfilePage fillEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
        return this;
    }

    public String fillEmail() {
        this.email.clear();
        this.email.sendKeys(randomEmail);
        return email.getAttribute("value");
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


    public String fillFirstAddress() {
        firstAddress.clear();
        firstAddress.sendKeys(randomString);
        return firstAddress.getAttribute("value");
    }


    public String fillSecondAddress() {
        secondAddress.clear();
        secondAddress.sendKeys(randomString);
        return secondAddress.getAttribute("value");
    }


    public String fillCity() {
        this.city.clear();
        this.city.sendKeys(randomString);
        return city.getAttribute("value");
    }


    public String fillState() {
        this.state.clear();
        this.state.sendKeys(randomString);
        return state.getAttribute("value");
    }


    public String fillZipCode(int numberOfRandomDigits) {
        zipCode.clear();
        zipCode.sendKeys(getRandomNumber(numberOfRandomDigits));
        return zipCode.getAttribute("value");
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

    public String getTextFromInput(WebElement element) {
        String textFromElement = element.getAttribute("value");
        LOGGER.debug("Current text from " + element.getAttribute("placeholder") + " is:" + textFromElement);
        return textFromElement;
    }

    public List<String> getTextFromInputList (){
        List <String> details = new ArrayList<>();

        for(WebElement element: inputFormList){
            details.add(element.getAttribute("value"));
        }
        LOGGER.debug("List of values input form: "+details);
        return details;
    }

    public List<String> typeRandomDataForProfileUpdate(){

        List<String> random = new ArrayList<>();
        random.add(fillPhonenumber(8));
        random.add(fillFirstAddress());
        random.add(fillSecondAddress());
        random.add(fillCity());
        random.add(fillState());
        random.add(fillZipCode(5));
        LOGGER.debug("Random data list from profile's update form contains: "+random);
        return random;
    }


    public WebElement getMyProfileForm() {
        return myProfileForm;
    }

    public String getPersonalDetailHeaderText() {
        String header = personalDetailsHeader.getText();
        LOGGER.debug("Current personal details header is: " + header);
        return header;
    }

    public boolean isFirstNameReadOnly() {
        String state = firstName.getAttribute("readonly");
        if (state == null) {
            LOGGER.debug("First name doesn't have attribute read-only!");
        } else if (state.contains("true")) {
            return true;
        }
        return false;
    }

    public boolean isLastNameReadOnly() {
        String state = lastName.getAttribute("readonly");
        if (state == null) {
            LOGGER.debug("Last name doesn't have attribute read-only!");
        } else if (state.contains("true")) {
            return true;
        }
        return false;
    }

    public String getAlertMessage() {
        String alertMessage = alert.getText();
        LOGGER.debug("Actual alert message is " + alertMessage);
        return alertMessage;
    }

    public String getCurrentUrl() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }


}
