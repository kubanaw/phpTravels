package Tests.userAccountTest;

import Pages.account.MyProfilePage;
import Pages.account.UserAccountPage;
import Pages.navbarTabs.LoginPage;
import Pages.navbarTabs.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ChromeDrvPathHelper;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;


public class ProfileTabsTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private UserAccountPage userAccountPage;
    private LoginPage loginPage;

    @BeforeClass
    public static void ustawSciezke() {
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(this.driver, 10);
        this.loginPage = new LoginPage(driver);
        this.userAccountPage = new UserAccountPage(driver);
        loginPage.goToLoginPage();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginPanel()));
        loginPage.loginDemoUser();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }




}
