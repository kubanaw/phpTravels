package Pages.navbarTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class RegisterPage {


    private final String url = "https://www.phptravels.net/register";
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger LOGGER =Logger.getLogger(RegisterPage.class.getName());

    @FindBy(name = "firstname")
    private WebElement firstName;
    @FindBy(name = "lastname")
    private WebElement lastName;
    @FindBy(name = "phone")
    private WebElement mobileNumber;
    @FindBy(name = "email")
    private WebElement emailAdress;
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

    public void fillFirstName(String typeName) {
        firstName.clear();
        firstName.sendKeys(typeName);
    }

    public void fillLastName(String typeLastName) {
        lastName.clear();
        lastName.sendKeys(typeLastName);
    }

    public void fillMobileNumber(String typeMobileNumber) {
        mobileNumber.clear();
        mobileNumber.sendKeys(typeMobileNumber);
    }

    public void fillEmailAdress(String typeEmail) {
        emailAdress.clear();
        emailAdress.sendKeys(typeEmail);
    }

    public void fillPassword(String typePassword) {
        password.clear();
        password.sendKeys(typePassword);
    }

    public void fillConfirmPassword(String typeConfirmPassword) {
        confirmPassword.clear();
        confirmPassword.sendKeys(typeConfirmPassword);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
    }

    public void goToRegisterPage() {
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
        LOGGER.info("Current alert: "+alertMessage);
        return alertMessage;
    }

    public String showCurrentUrl (){
        String currentURL = driver.getCurrentUrl();
        LOGGER.info("Current URL of Register Page: "+currentURL);
        return currentURL;
    }



}
