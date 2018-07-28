package Tests.registerOptionsTest;

import Pages.navbarTabs.RegisterPage;
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

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

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
    private WebDriver driver;
    private RegisterPage registerPage;
    private WebDriverWait wait;

    @Parameters(name = "Test {index}: First name: {0}, Last name: {1}, Phone: {2}, " +
            "E-mail: {3}, Password: {4}, confirm: {5}")

    public static Collection<Object[]> dataForRegisterOption() {
        return Arrays.asList(new Object[][]{
                {"", "Moczymorda", "788990333", "j37756@nwytg.com", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "", "788990333", "j3776666@nwytg.com", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymorda", "788990333", "", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymorda", "788990333", "j355776@nwytg.com", "", ""},
                {"Gerwazy", "Moczymorda", "788990333", "j3776nwytg.com", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymorda", "788990333", " j3776@nwytg.com", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymorda", "788990333", "j3776@nwytg.com  ", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymorda", "788990333", "j3776@nwytg.com", "M4ki3", "M4ki3"},
                {"Gerwazy", "Moczymord", "788990333", "j44436@nwytgfg.com", "M4ki3t9!", "M4ki3t"},

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
        registerPage.goToRegisterPage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

        @After
    public void CloseBrowser() {
        this.driver.quit();
    }
    @Test
    public void whenNecessaryFieldAreFilledIncorrectlyThenShouldNotRegister() {
        registerPage.fillFirstName(firstName);
        registerPage.fillLastName(lastName);
        registerPage.fillMobileNumber(phone);
        registerPage.fillEmailAddress(email);
        registerPage.fillPassword(password);
        registerPage.fillConfirmPassword(confirmPassword);
        registerPage.clickSubmit();
        assertThat(registerPage.getCurrentUrl())
                .isEqualTo(registerPage.getUrl());
        wait.until(ExpectedConditions.visibilityOf(registerPage.getAlert()));
        assertThat(registerPage.getAlertMessage())
                .isNotBlank();

        if (firstName.isEmpty())
            assertThat(registerPage.getAlertMessage())
                    .isEqualTo("The First name field is required.");
        if (lastName.isEmpty())
            assertThat(registerPage.getAlertMessage())
                    .isEqualTo("The Last Name field is required.");
        if (email.isEmpty())
            assertThat(registerPage.getAlertMessage())
                    .isEqualTo("The Email field is required.");
        if (password.isEmpty() || confirmPassword.isEmpty())
            assertThat(registerPage.getAlertMessage())
                    .contains("The Password field is required.");
        if (!email.contains("@")) {
            if (!email.isEmpty())
                assertThat(registerPage.getAlertMessage())
                        .isEqualTo("The Email field must contain a valid email address.");
        }
        if (email.startsWith(" ") || email.endsWith(" "))
            assertThat(registerPage.getAlertMessage())
                    .isEqualTo("The Email field must contain a valid email address.");
        if (!password.isEmpty()) {
            if (password.length() < 6) {
                assertThat(registerPage.getAlertMessage())
                        .isEqualTo("The Password field must be at least 6 characters in length.");

            } else if (!password.equals(confirmPassword))
                assertThat(registerPage.getAlertMessage())
                        .isEqualTo("Password not matching with confirm password.");
        }


    }


}
