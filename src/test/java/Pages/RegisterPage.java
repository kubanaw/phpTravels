package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
    @FindBy(name = "firstname")
    WebElement firstName;
    @FindBy(name = "lastname")
    WebElement lastName;
    @FindBy(xpath = "//*[@id=\"headersignupform\"]/div[5]/input")
    WebElement mobileNumber;
    @FindBy(xpath = "//*[@id=\"headersignupform\"]/div[6]/input")
    WebElement emailAdress;
    @FindBy(xpath = "//*[@id=\"headersignupform\"]/div[7]/input")
    WebElement password;
    @FindBy(name ="confirmpassword")
    WebElement confirmPassword;
    @FindBy(xpath ="//*[@id=\"headersignupform\"]/div[9]/button")
    WebElement submit;







}
