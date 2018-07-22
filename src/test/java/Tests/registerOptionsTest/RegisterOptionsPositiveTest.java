package Tests.registerOptionsTest;
import Pages.RegisterPage;
import Pages.UserAccount;
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
    private WebDriver driver;
    private RegisterPage registerPage;
    private WebDriverWait wait;
    private UserAccount userAccount;

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

    @Parameters(name = "Test {index}: First name: {0}, Last name: {1}, Phone: {2}, " +
            "E-mail: {3}, Password: {4}, confirm: {5}")

    public static Collection<Object[]> dataForRegisterOption() {
        return Arrays.asList(new Object[][]{
                {"Gerwazy", "Moczymord", "788990333", "j36@nwytgfg.com", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymord", "788990333", "j36rty@nwytgfg.com", "M4ki3t", "M4ki3t"},
                {"Gerwazy", "Moczymord", "", "j3779@nwytgfffg.com", "M4ki3t9!", "M4ki3t9!"},
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
        userAccount = new UserAccount(driver);
        registerPage.goToRegisterPage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    @Test
    public void whenNecessaryFieldAreFilledThenShouldRegister (){
        registerPage.fillFirstName(firstName);
        registerPage.fillLastName(lastName);
        registerPage.fillMobileNumber(phone);
        registerPage.fillEmailAdress(email);
        registerPage.fillPassword(password);
        registerPage.fillConfirmPassword(confirmPassword);
        registerPage.clickSubmit();
        wait.until(ExpectedConditions.visibilityOf(userAccount.getGreetingHeader()));
        assertThat(registerPage.showCurrentUrl())
                .isEqualTo(userAccount.getUrl());





    }

}
