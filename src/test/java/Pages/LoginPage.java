package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginPage {
    //TODO refactor ()

    private WebDriver driver;
    //declare WebDriverWait variable to create explicit waits:
    private WebDriverWait waitTime;
    private final String url = "https://www.phptravels.net/login";
    @FindBy (name = "username")
    private WebElement userName;
    @FindBy (name = "password")
    private WebElement password;
    @FindBy (name = "remember")
    private WebElement rememberMeCheckBox;
    @FindBy (className = "loginbtn")
    private WebElement loginButton;
    @FindBy (linkText = "Sign Up")
    private WebElement signUpButton;
    @FindBy (linkText = "Forget Password")
    private WebElement forgetPasswordButton;

    public LoginPage (WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }
    public void goToLoginPage (){
        driver.get(url);
    }
    public void fillUserEmailField (String userEmail){
        userName.sendKeys(userEmail);
    }
    public void fillUsersPassword (String pass) {
        password.sendKeys(pass);
    }
    //TODO remember to create a method for checkbox with loop and boolean isSelected()
    public void checkRememberMe (){
        rememberMeCheckBox.click();
    }


    public void loginDemoUser(){
        fillUserEmailField("user@phptravels.com");
        fillUsersPassword("demouser");
        this.waitTime = new WebDriverWait(driver, 2);
        //ExpectedConditions class is necessary for WebDriverWait.until() method
        try {
            waitTime.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
        } catch (TimeoutException toe) {
//            System.out.println(toe);
        }
    }




}
