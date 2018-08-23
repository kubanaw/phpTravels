package Tests.userAccountTest;

import Pages.commonPages.NavbarHeader;
import Pages.user.LoginPage;
import Pages.user.account.MyProfilePage;
import Pages.user.account.UserAccountPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ChromeDrvPathHelper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class MyProfilePageTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private MyProfilePage myProfilePage;
    private LoginPage loginPage;
    private UserAccountPage userAccountPage;
    private NavbarHeader navbarHeader;
    private JavascriptExecutor jse;



    @BeforeClass
    public static void ustawSciezke() {
        //PATH WILL CHANGE BASED ON OS through: util/ChromeDrvPathHelper
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(this.driver, 5);
        myProfilePage = new MyProfilePage(driver);
        loginPage = new LoginPage(driver);
        userAccountPage = new UserAccountPage(driver);
        navbarHeader = new NavbarHeader(driver);
        jse = (JavascriptExecutor) driver;
        loginPage.loginPageOpen();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        loginPage.loginDemoUser();
        userAccountPage.goToMyProfileTab();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

//    @After
//    public void CloseBrowser() {
//        this.driver.quit();
//    }


    @Test
    public void userShouldNotBeAllowedToChangeFirstNameField() {
        assertThat(myProfilePage.isFirstNameReadOnly())
                .as("First name field is read-only")
                .isTrue();
    }

    @Test
    public void userShouldNotBeAllowedToChangeLastNameField() {
        assertThat(myProfilePage.isLastNameReadOnly())
                .as("Last name field is read-only")
                .isTrue();
    }

    @Test
    public void userCouldUpdateAddressForm(){

       List<String> random = myProfilePage.typeRandomDataForProfileUpdate();
        assertThat(myProfilePage.submitMyProfileUpdate().getAlertMessage())
                .as("A message confirms profile update.")
        .isEqualTo("Profile Updated Successfully.");

        loginPage.logOut();
        assertThat(myProfilePage.getCurrentUrl())
                .as("URL of Login Page")
                .isEqualTo(loginPage.getUrl());
        loginPage.loginDemoUser();

        userAccountPage.goToMyProfileTab();
        assertThat(myProfilePage.getTextFromInputList())
                .as("List of user's personal data in form")
        .containsAll(random);
    }


}
