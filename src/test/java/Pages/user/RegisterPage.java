package Pages.user;

import Pages.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class RegisterPage extends BasePage {

    private final String url = "https://www.phptravels.net/register";

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstname")
    private WebElement firstName;
    @FindBy(name = "lastname")
    private WebElement lastName;
    @FindBy(name = "phone")
    private WebElement mobileNumber;
    @FindBy(name = "email")
    private WebElement emailAddress;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "confirmpassword")
    private WebElement confirmPassword;
    @FindBy(className = "signupbtn")
    private WebElement submit;
    @FindBy(className = "alert-danger")
    private WebElement alert;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    //change void to class name and return this -> create fluent fill register forms:

    public RegisterPage fillFirstName(String typeName) {
        firstName.clear();
        firstName.sendKeys(typeName);
        return this;
    }

    public RegisterPage fillLastName(String typeLastName) {
        lastName.clear();
        lastName.sendKeys(typeLastName);
        return this;
    }

    public RegisterPage fillMobileNumber(String typeMobileNumber) {
        mobileNumber.clear();
        mobileNumber.sendKeys(typeMobileNumber);
        return this;
    }

    public RegisterPage fillEmailAddress(String typeEmail) {
        emailAddress.clear();
        emailAddress.sendKeys(typeEmail);
        return this;
    }

    public RegisterPage fillPassword(String typePassword) {
        password.clear();
        password.sendKeys(typePassword);
        return this;
    }

    public RegisterPage fillConfirmPassword(String typeConfirmPassword) {
        confirmPassword.clear();
        confirmPassword.sendKeys(typeConfirmPassword);
        return this;
    }

    public RegisterPage clickSubmit() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(submit));
            submit.click();
        } catch (TimeoutException toe) {
            LOGGER.info("Submit button is not clickable " + toe);
        }
        return this;
    }

    public void registerPageOpen() {
        driver.get(url);
    }

    public String getUrl() {
        return url;
    }

    public WebElement getAlert() {
        return alert;
    }

    public String getAlertMessage() {
        String alertMessage = alert.getText();
        LOGGER.info("Current alert: " + alertMessage);
        return alertMessage;
    }

    public String getCurrentUrl() {
        String currentURL = driver.getCurrentUrl();
        LOGGER.info("Current URL of Register Page: " + currentURL);
        return currentURL;
    }

    //method to set random email:

    public RegisterPage typeRandomEmail() {
        emailAddress.clear();
        emailAddress.sendKeys(randomEmail);
        return this;
    }


}
