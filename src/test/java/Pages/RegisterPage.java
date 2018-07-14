package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {


    private final String url = "https://www.phptravels.net/register";
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(name = "firstname")
    private WebElement firstName;
    @FindBy(name = "lastname")
    private WebElement lastName;
    @FindBy(name = "phone")
    private WebElement mobileNumber;
    @FindBy(name="email")
    private WebElement emailAdress;
    @FindBy(name="password")
    private WebElement password;
    @FindBy(name = "confirmpassword")
    private WebElement confirmPassword;
    @FindBy(className = "signupbtn")
    private WebElement submit;
    @FindBy(className = "alert-danger")
    private WebElement alert;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 3);
        PageFactory.initElements(driver, this);
    }


    public void fillFirstName(String typeName) {
        firstName.sendKeys(typeName);
    }

    public void fillLastName(String typeLastName) {
        lastName.sendKeys(typeLastName);
    }

    public void fillMobileNumber(String typeMobileNumber) {
        mobileNumber.sendKeys(typeMobileNumber);
    }

    public void fillEmailAdress(String typeEmail) {
        emailAdress.sendKeys(typeEmail);
    }

    public void fillPassword(String typePassword) {
        password.sendKeys(typePassword);
    }

    public void fillConfirmPassword(String typeConfirmPassword) {
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

    public String getAlertMessage() {
        return alert.getText();
    }


}
