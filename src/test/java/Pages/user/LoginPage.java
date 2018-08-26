package Pages.user;

import Pages.BasePage;
import Pages.user.account.UserAccountPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    //TODO create login options tests

    private final String url = "https://www.phptravels.net/login";
    private JavascriptExecutor jse;


    @FindBy(xpath = "//div[@id='collapse']/ul/ul/li[1]/a[1]")
    private WebElement myAccountDropdown;

    @FindBy(linkText = "Logout")
    private WebElement logOut;

    @FindBy(linkText = "Account")
    private WebElement account;

    @FindBy(css = "div.panel> div.wow")
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

        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    public String getUrl() {
        return url;
    }

    public LoginPage loginPageOpen() {

        driver.get(url);

        try {
            wait.until(ExpectedConditions.visibilityOf(loginPanel));
            LOGGER.debug("Login Panel is displayed");
        } catch (TimeoutException toe) {
            LOGGER.info("Login Panel is not visible " + toe);
        }
        return this;
    }

    public LoginPage loginUser(String userEmail, String pass) {

        wait.until(ExpectedConditions.visibilityOf(password));

        LOGGER.info("Login User start.");
        userName.clear();
        userName.sendKeys(userEmail);
        password.clear();
        password.sendKeys(pass);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
            LOGGER.info("Login User success!");

        } catch (TimeoutException toe) {
            LOGGER.info("Login button is not clickable " + toe);
        }

        return this;

    }


    public void checkRememberMe() {

        if (!rememberMeCheckBox.isSelected())
            rememberMeCheckBox.click();
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
        LOGGER.debug("Current reset alert: " + alertMessage);
        return alertMessage;
    }


    public LoginPage loginDemoUser() {

        loginUser("user@phptravels.com", "demouser");

        return this;
    }

    public LoginPage logOut() {

        jse.executeScript("arguments[0].click();", myAccountDropdown);
        jse.executeScript("arguments[0].click();", logOut);
        LOGGER.info("Logout successful!");
        return this;
    }

    public UserAccountPage backToUserAccount() {

        jse.executeScript("arguments[0].click();", myAccountDropdown);
        jse.executeScript("arguments[0].click();", account);
        LOGGER.info("Back to User's Account");
        return new UserAccountPage(driver);
    }


}
