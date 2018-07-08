package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    //TODO refactor (change xpath to another type)

    private WebDriver driver;
    private WebDriverWait waitTime;
    private final String url = "https://www.phptravels.net/register";
    //ELEMENTS:
    @FindBy(name = "firstname")
    private WebElement firstName;
    @FindBy(name = "lastname")
    private WebElement lastName;
    @FindBy(xpath = "//*[@id=\"headersignupform\"]/div[5]/input")
    private WebElement mobileNumber;
    @FindBy(xpath = "//*[@id=\"headersignupform\"]/div[6]/input")
    private WebElement emailAdress;
    @FindBy(xpath = "//*[@id=\"headersignupform\"]/div[7]/input")
    private WebElement password;
    @FindBy(name = "confirmpassword")
    private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"headersignupform\"]/div[9]/button")
    private WebElement submit;
    @FindBy(className = "alert-danger")
    private WebElement alert;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //METHODS:

    public void fillFirstname(String typeName) {
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

    public void fillPassword(String typePasword) {
        password.sendKeys(typePasword);
    }

    public void fillConfirmPassword(String typeConfirmPassword) {
        confirmPassword.sendKeys(typeConfirmPassword);
    }

    public void clickSubmit() {
        this.waitTime = new WebDriverWait(driver, 2);
        try {
            waitTime.until(ExpectedConditions.elementToBeClickable(submit));
            submit.click();
        } catch (TimeoutException toe) {
            //System.out.println(toe);
        }
    }

    public void goToRegisterPage (){
        driver.get(url);
    }
    //GETTERS

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getMobileNumber() {
        return mobileNumber;
    }

    public WebElement getEmailAdress() {
        return emailAdress;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getAlert() {
        return alert;
    }
}
