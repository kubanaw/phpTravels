package Tests;

import Pages.RegisterPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ChromeDrvPathHelper;

import java.util.concurrent.TimeUnit;

public class RegisterOptionsTest {
    //TODO refactor (create DDT)
    //TODO change assertions to AssertJ
    private WebDriver driver;
    private RegisterPage registerPage;
    private WebDriverWait wait;

    @BeforeClass
    public static void ustawSciezke() {
        //PATH WILL CHANGE BASED ON OS through: util/ChromeDrvPathHelper
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 3);
        this.registerPage = new RegisterPage(driver);
        registerPage.goToRegisterPage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    //positive cases:

    @Test
    public void whenAllNecessaryFieldsAreFilledThenUserShouldRegister() {

        registerPage.fillFirstName("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3776@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        registerPage.clickSubmit();
        //is any way to make it better?
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO add String url in Account Page class
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.phptravels.net/account/");

    }

    @Test
    public void whenAllFieldsAreFilledThenUserShouldRegister() {

        registerPage.fillFirstName("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillMobileNumber("440086544");
        registerPage.fillEmailAdress("j368687577116@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.phptravels.net/account/");

    }

    //negative cases:

    @Test
    public void whenAllFieldsAreNotFilledThenUserShouldNotRegister() {

        registerPage.clickSubmit();
        Assert.assertEquals(registerPage.getAlertMessage(), "The Email field is required.\nThe Password field is required.\nThe Password field is required." +
                "\nThe First name field is required.\nThe Last Name field is required.");
        Assert.assertEquals(driver.getCurrentUrl(), registerPage.getUrl());

    }

    @Test
    public void whenUserFirstNameFieldIsNotFillThenUserShouldNotRegister() {

        registerPage.fillLastName("Moczymorda");
        registerPage.fillMobileNumber("440086544");
        registerPage.fillEmailAdress("j368687577116@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(registerPage.getAlertMessage(), "The First name field is required.");
        Assert.assertEquals(driver.getCurrentUrl(), registerPage.getUrl());

    }

    @Test
    public void whenUserLastNameFieldIsNotFillThenUserShouldNotRegister() {

        registerPage.fillFirstName("Gerwazy");
        registerPage.fillMobileNumber("440086544");
        registerPage.fillEmailAdress("j368687577116@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(registerPage.getAlertMessage(), "The Last Name field is required.");
        Assert.assertEquals(driver.getCurrentUrl(), registerPage.getUrl());

    }

    @Test
    public void whenUserEmailFieldIsNotFillThenUserShouldNotRegister() {

        registerPage.fillFirstName("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillMobileNumber("440086544");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(registerPage.getAlertMessage(), "The Email field is required.");
        Assert.assertEquals(driver.getCurrentUrl(), registerPage.getUrl());

    }

    @Test
    public void whenUserPasswordFieldNotFillThenUserShouldNotRegister() {

        registerPage.fillFirstName("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillMobileNumber("440086544");
        registerPage.fillEmailAdress("j368687577116@nwytg.com");
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(registerPage.getAlertMessage(), "The Password field is required.\nThe Password field is required.");
        Assert.assertEquals(driver.getCurrentUrl(), registerPage.getUrl());

    }

    //e-mail field validation

    @Test
    public void whenEmailFieldHasInvalidValueThenUserShouldNotRegister() {

        registerPage.fillFirstName("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3686875776nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        //TODO catch TimeoutException to logger
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(registerPage.getAlertMessage(), "The Email field must contain a valid email address.");
        Assert.assertEquals(driver.getCurrentUrl(), registerPage.getUrl());

    }

    @Test
    public void whenEmailFieldHasWhiteSpaceBeforeThenUserShouldNotRegister() {

        registerPage.fillFirstName("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress(" j3686875776@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(registerPage.getAlertMessage(), "The Email field must contain a valid email address.");
        Assert.assertEquals(driver.getCurrentUrl(), registerPage.getUrl());

    }

    @Test
    public void whenEmailFieldHasWhiteSpaceAfterThenUserShouldNotRegister() {

        registerPage.fillFirstName("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3686875776@nwytg.com ");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3t9!");
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(registerPage.getAlertMessage(), "The Email field must contain a valid email address.");
        Assert.assertEquals(driver.getCurrentUrl(), registerPage.getUrl());

    }

    //password field validation:

    @Test
    public void whenPasswordHasLessThanSixCharThenUserShouldNotRegister() {

        registerPage.fillFirstName("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3686875776@nwytg.com");
        registerPage.fillPassword("M4ki3");
        registerPage.fillConfirmPassword("M4ki3");
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(registerPage.getAlertMessage(), "The Password field must be at least 6 characters in length.");
        Assert.assertEquals(driver.getCurrentUrl(), registerPage.getUrl());

    }

    @Test
    public void whenPasswordHasSixCharThenUserShouldRegister() {

        registerPage.fillFirstName("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3675776@nwytg.com");
        registerPage.fillPassword("M4ki3t");
        registerPage.fillConfirmPassword("M4ki3t");
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.getCurrentUrl(), registerPage.getUrl());

    }

    @Test
    public void whenConfirmPasswordIsInaccurateThenUserShouldNotRegister() {

        registerPage.fillFirstName("Gerwazy");
        registerPage.fillLastName("Moczymorda");
        registerPage.fillEmailAdress("j3686875776@nwytg.com");
        registerPage.fillPassword("M4ki3t9!");
        registerPage.fillConfirmPassword("M4ki3");
        registerPage.clickSubmit();
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(registerPage.getAlertMessage(), "Password not matching with confirm password.");
        Assert.assertEquals(this.driver.getCurrentUrl(), registerPage.getUrl());

    }


}