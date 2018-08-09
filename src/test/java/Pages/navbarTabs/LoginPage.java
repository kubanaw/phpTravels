package Pages.navbarTabs;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;


public class LoginPage {
    //TODO create login options tests

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class.getName());
    private final String url = "https://www.phptravels.net/login";
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='wow fadeIn animated']")
    private WebElement loginPanel;
    @FindBy(name = "username")
    private WebElement userName;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "remember")
    private WebElement rememberMeCheckBox;
    @FindBy(className = "loginbtn")
    private WebElement loginButton;
    @FindBy(linkText = "Sign Up")
    private WebElement signUpButton;
    @FindBy(linkText = "Forget Password")
    private WebElement forgetPasswordButton;
    @FindBy(id = "resetemail")
    private WebElement resetPasswordField;
    @FindBy(css = "button.btn.btn-primary.resetbtn")
    private WebElement resetButton;
    @FindBy(css = " div.alert.alert-danger")
    private WebElement resetAlertText;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
        driver.get(url);
    }

    public String getCurrentUrl() {
        String currentURL = driver.getCurrentUrl();
        LOGGER.info("Current URL of Login Page: " + currentURL);
        return currentURL;
    }

    public WebElement getLoginPanel() {
        return loginPanel;
    }

    public void fillUserEmailField(String userEmail) {
        userName.clear();
        userName.sendKeys(userEmail);
    }

    public void fillUsersPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void checkRememberMe() {
        if (!rememberMeCheckBox.isSelected())
            rememberMeCheckBox.click();
    }

    public void clickSignUp() {
        signUpButton.click();
    }

    public void clickForgetPassword() {
        forgetPasswordButton.click();
    }

    public void fillEmailToPasswordReset(String email) {
        resetPasswordField.clear();
        resetPasswordField.sendKeys(email);

    }

    public void resetPassword() {
        forgetPasswordButton.click();
    }

    public String getResetAlertMessage() {
        String alertMessage = resetAlertText.getText();
        LOGGER.info("Current reset alert: " + alertMessage);
        return alertMessage;
    }


    public void loginDemoUser() {
        LOGGER.info("Login DemoUser start.");
        fillUserEmailField("user@phptravels.com");
        fillUsersPassword("demouser");
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
            LOGGER.info("Login DemoUser success!");
        } catch (TimeoutException toe) {
            LOGGER.info("Login button is not clickable " + toe);

        }
    }


}
