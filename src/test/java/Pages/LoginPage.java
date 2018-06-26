package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

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

    public void fillUserEmailField (String userEmail){
        userName.sendKeys(userEmail);
    }
    public void fillUsersPassword (String pass) {
        password.sendKeys(pass);
    }
    public void checkRememberMe (){
        rememberMeCheckBox.click();
    }


    public void loginDemoUser(){
        fillUserEmailField("user@phptravels.com");
        fillUsersPassword("demouser");
        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        loginButton.click();
    }




}
