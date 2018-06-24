package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver=driver;
    }
    //ELEMENTS:
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
        submit.submit();
    }

}
