package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;
    @FindBy (name = "username")
    WebElement userName;
    @FindBy (name = "password")
    WebElement password;
    @FindBy (name = "remember")
    WebElement rememberMeCheckBox;
    @FindBy (className = "loginbtn")
    WebElement loginButton;
    @FindBy (linkText = "Sign Up")
    WebElement signUpButton;
    @FindBy (linkText = "Forget Password")
    WebElement forgetPasswordButton;

    public LoginPage (WebDriver driver){
        this.driver =driver;
    }




}
