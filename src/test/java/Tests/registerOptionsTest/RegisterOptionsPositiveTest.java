package Tests.registerOptionsTest;

import Pages.user.RegisterPage;
import Pages.user.account.UserAccountPage;
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
public class RegisterOptionsPositiveTest {

    @Parameter()
    public String firstName;
    @Parameter(1)
    public String lastName;
    @Parameter(2)
    public String phone;
    @Parameter(3)
    public String password;
    @Parameter(4)
    public String confirmPassword;
    private WebDriver driver;
    private RegisterPage registerPage;
    private WebDriverWait wait;
    private UserAccountPage userAccountPage;

    @Parameters(name = "Test {index}: First name: {0}, Last name: {1}, Phone: {2}, Password: {3}, confirm: {4}")

    public static Collection<Object[]> dataForRegisterOption() {

        return Arrays.asList(new Object[][]{
                {"Gerwazy", "Moczymord", "788990333", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymord", "788990333", "M4ki3t", "M4ki3t"},
                {"Gerwazy", "Moczymord", "", "M4ki3t9!", "M4ki3t9!"},
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
        wait = new WebDriverWait(driver, 5);
        registerPage = new RegisterPage(driver);
        userAccountPage = new UserAccountPage(driver);
        registerPage.goToRegisterPage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    @Test
    public void whenNecessaryFieldAreFilledThenShouldRegister() {
        registerPage.fillFirstName(firstName)
                .fillLastName(lastName)
                .fillMobileNumber(phone)
                .typeRandomEmail()
                .fillPassword(password)
                .fillConfirmPassword(confirmPassword)
                .clickSubmit();
        wait.until(ExpectedConditions.visibilityOf(userAccountPage.getGreetingHeader()));
        assertThat(registerPage.getCurrentUrl())
                .as("Site URL")
                .isEqualTo(userAccountPage.getUrl());

    }

}
