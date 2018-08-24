package Tests.registerOptionsTest;

import Pages.user.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ChromeDrvPathHelper;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)

public class RegisterOptionsNegativeTest {

    @Parameter()
    public String firstName;

    @Parameter(1)
    public String lastName;

    @Parameter(2)
    public String phone;

    @Parameter(3)
    public String email;

    @Parameter(4)
    public String password;

    @Parameter(5)
    public String confirmPassword;

    @Parameter(6)
    public String message;

    private WebDriver driver;
    private RegisterPage registerPage;
    private WebDriverWait wait;


    @Parameters
            (name = "Test {index}: First name: {0}, Last name: {1}, Phone: {2}, " +
            "E-mail: {3}, Password: {4}, confirm: {5}, alert: {6}")

    public static Collection<Object[]> dataForRegisterOption() {

        return Arrays.asList(new Object[][]{

                {"", "Moczymorda", "788990333", "j37756@nwytg.com", "M4ki3t9!", "M4ki3t9!",
                        "The First name field is required."},
                {"Gerwazy", "", "788990333", "j3776666@nwytg.com", "M4ki3t9!", "M4ki3t9!",
                        "The Last Name field is required."},
                {"Gerwazy", "Moczymorda", "788990333", "", "M4ki3t9!", "M4ki3t9!",
                        "The Email field is required."},
                {"Gerwazy", "Moczymorda", "788990333", "j355776@nwytg.com", "", "",
                        "The Password field is required."},
                {"Gerwazy", "Moczymorda", "788990333", "j3776nwytg.com", "M4ki3t9!", "M4ki3t9!",
                        "The Email field must contain a valid email address."},
                {"Gerwazy", "Moczymorda", "788990333", " j3776@nwytg.com", "M4ki3t9!", "M4ki3t9!",
                        "The Email field must contain a valid email address."},
                {"Gerwazy", "Moczymorda", "788990333", "j3776@nwytg.com  ", "M4ki3t9!", "M4ki3t9!",
                        "The Email field must contain a valid email address."},
                {"Gerwazy", "Moczymorda", "788990333", "j3776@nwytg.com", "M4ki3", "M4ki3",
                        "The Password field must be at least 6 characters in length."},
                {"Gerwazy", "Moczymord", "788990333", "j44436@nwytgfg.com", "M4ki3t9!", "M4ki3t",
                        "Password not matching with confirm password."},

        });
    }

    @BeforeClass
    public static void ustawSciezke() {
        //PATH WILL CHANGE BASED ON OS through: util/ChromeDrvPathHelper
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        registerPage = new RegisterPage(driver);
        registerPage.registerPageOpen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    @Test
    public void whenNecessaryFieldAreFilledIncorrectlyThenShouldNotRegister() {

        registerPage.fillFirstName(firstName)
                .fillLastName(lastName)
                .fillMobileNumber(phone)
                .fillEmailAddress(email)
                .fillPassword(password)
                .fillConfirmPassword(confirmPassword)
                .clickSubmit();

        assertThat(registerPage.getCurrentUrl())
                .as("URL of registration page")
                .isEqualTo(registerPage.getUrl());

        wait.until(ExpectedConditions.visibilityOf(registerPage.getAlert()));
        assertThat(registerPage.getAlertMessage())
                .as("Registration alert message")
                .isNotBlank()
                .contains(message);
    }


}
