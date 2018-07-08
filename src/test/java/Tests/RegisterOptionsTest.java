package Tests;

import Pages.RegisterPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ChromeDrvPathHelper;

import java.util.concurrent.TimeUnit;

public class RegisterOptionsTest {
    //TODO refactor (create DDT)


    private WebDriver driver;
    private RegisterPage registerPage;
    private WebDriverWait waitTime;

    @BeforeClass
    public static void ustawSciezke() {
        //PATH WILL CHANGE BASED ON OS through: util/ChromeDrvPathHelper
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.waitTime = new WebDriverWait(driver, 2);
        this.registerPage = new RegisterPage(driver);
        registerPage.goToRegisterPage();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    //positive cases:

    @Test
    public void whenAllNecessaryFieldsAreFilledThenUserShouldRegister() {

        registerPage.fillFirstname("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3776@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        //is any way to make it better?
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/account/");

    }

    @Test
    public void whenAllFieldsAreFilledThenUserShouldRegister() {

        registerPage.fillFirstname("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillMobileNumber("440086544");
        registerPage.fillEmailAdress("j368687577116@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/account/");

    }

    //negative cases:

    @Test
    public void whenAllFieldsAreNotFilledThenUserShouldNotRegister() {

        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        String message = registerPage.getAlert().getText();
        Assert.assertEquals(message, "The Email field is required.\nThe Password field is required.\nThe Password field is required." +
                "\nThe First name field is required.\nThe Last Name field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    @Test
    public void whenUserFirstNameFieldIsNotFillThenUserShouldNotRegister() {

        registerPage.fillLastName("Moczymorda");
        registerPage.fillMobileNumber("440086544");
        registerPage.fillEmailAdress("j368687577116@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = registerPage.getAlert().getText();
        Assert.assertEquals(message, "The First name field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    @Test
    public void whenUserLastNameFieldIsNotFillThenUserShouldNotRegister() {

        registerPage.fillFirstname("Gerwazy");
        registerPage.fillMobileNumber("440086544");
        registerPage.fillEmailAdress("j368687577116@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = registerPage.getAlert().getText();
        Assert.assertEquals(message, "The Last Name field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    @Test
    public void whenUserEmailFieldIsNotFillThenUserShouldNotRegister() {

        registerPage.fillFirstname("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillMobileNumber("440086544");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = registerPage.getAlert().getText();
        Assert.assertEquals(message, "The Email field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    @Test
    public void whenUserPasswordFieldNotFillThenUserShouldNotRegister() {

        registerPage.fillFirstname("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillMobileNumber("440086544");
        registerPage.fillEmailAdress("j368687577116@nwytg.com");
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = registerPage.getAlert().getText();
        Assert.assertEquals(message, "The Password field is required.\nThe Password field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    //e-mail field validation

    @Test
    public void whenEmailFieldHasInvalidValueThenUserShouldNotRegister() {

        registerPage.fillFirstname("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3686875776nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        //TODO catch TimeoutException to logger
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = registerPage.getAlert().getText();
        Assert.assertEquals(message, "The Email field must contain a valid email address.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    @Test
    public void whenEmailFieldHasWhiteSpaceBeforeThenUserShouldNotRegister() {

        registerPage.fillFirstname("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress(" j3686875776@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = registerPage.getAlert().getText();
        Assert.assertEquals(message, "The Email field must contain a valid email address.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    @Test
    public void whenEmailFieldHasWhiteSpaceAfterThenUserShouldNotRegister() {

        registerPage.fillFirstname("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3686875776@nwytg.com ");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = registerPage.getAlert().getText();
        Assert.assertEquals(message, "The Email field must contain a valid email address.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    //password field validation:

    @Test
    public void whenPasswordHasLessThanSixCharThenUserShouldNotRegister() {

        registerPage.fillFirstname("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3686875776@nwytg.com");
        registerPage.fillPassword("M4ki3");
        registerPage.fillConfirmPassword("M4ki3");
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = registerPage.getAlert().getText();
        Assert.assertEquals(message, "The Password field must be at least 6 characters in length.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    @Test
    public void whenPasswordHasSixCharThenUserShouldRegister() {

        registerPage.fillFirstname("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3675776@nwytg.com");
        registerPage.fillPassword("M4ki3t");
        registerPage.fillConfirmPassword("M4ki3t");
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/account/");

    }

    @Test
    public void whenConfirmPasswordIsInaccurateThenUserShouldNotRegister() {

        registerPage.fillFirstname("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3686875776@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3");
        Assert.assertTrue(registerPage.getSubmit().isEnabled());
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = registerPage.getAlert().getText();
        Assert.assertEquals(message, "Password not matching with confirm password.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }


}