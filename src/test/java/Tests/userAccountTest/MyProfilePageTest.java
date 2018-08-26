package Tests.userAccountTest;

import Pages.commons.NavbarHeader;
import Pages.user.LoginPage;
import Pages.user.account.MyProfilePage;
import Pages.user.account.UserAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(this.driver, 5);
        myProfilePage = new MyProfilePage(driver);
        loginPage = new LoginPage(driver);
        userAccountPage = new UserAccountPage(driver);
        navbarHeader = new NavbarHeader(driver);
        jse = (JavascriptExecutor) driver;
        loginPage.loginPageOpen();

        try {
            loginPage.loginDemoUser();
            userAccountPage.goToMyProfileTab();
//            Thread.sleep(5000);
        }
        catch (Exception e){}

        wait.until(ExpectedConditions.elementToBeClickable(myProfilePage.getSubmitUpdateProfileButton()));

//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }


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
    public void userCanUpdateAddressForm() {

        myProfilePage.selectCountry("Poland");
        List<String> random = myProfilePage.typeRandomDataAddressForProfileUpdate();
        assertThat(myProfilePage
                .submitMyProfileUpdate()
                .getAlertMessage())
                .as("A message confirms profile update.")
                .isEqualTo("Profile Updated Successfully.");

        assertThat(loginPage
                .logOut()
                .getCurrentUrl())
                .as("URL of Login Page")
                .isEqualTo(loginPage.getUrl());

        loginPage.loginDemoUser();

        userAccountPage.goToMyProfileTab();
        assertThat(myProfilePage.getTextFromInputList())
                .as("List of user's personal data in form")
                .containsAll(random);
    }

    @Test
    public void userShouldNotBeAllowedToUpdateWithTooShortPassword() {

        assertThat(
                myProfilePage
                        .changePassword("abcd1", "abcd1")
                        .getAlertMessage())
                .as("Change password with length less than 6 characters.")
                .contains("The Password field must be at least 6 characters in length.");

    }

    @Test
    public void userShouldNotBeAllowedToUpdateWithWrongPasswordConfirmation() {

        assertThat(
                myProfilePage
                        .changePassword("abcdef1", "abcdef12")
                        .getAlertMessage())
                .as("Change password with mismatch password confirmation.")
                .contains("Passwords not matching.");
    }

    @Test
    public void userShouldNotBeAllowedToUpdateWithEmptyPasswordConfirmation() {
        assertThat(
                myProfilePage
                        .changePassword("abcdef1", "")
                        .getAlertMessage())
                .as("Change password without fill a confirmation field.")
                .contains("The Password field is required.");

    }

    //A bug on page:

    @Test
    public void userShouldNotBeAllowedToUpdateWhenOnlyConfirmPasswordIsTyping() {
        assertThat(
                myProfilePage
                        .changePassword("", "abcdef123")
                        .getAlertMessage())
                .as("Change password with empty password field and typing password confirmation only.")
                .contains("The Password field is required.");

    }

    @Test
    public void userShouldNotBeAllowedToUpdateWhenInvalidEmailIsTyping() {

        assertThat(
                myProfilePage.emailUpdate("phptravels.com")
                        .getAlertMessage())
                .as("Type invalid email form without @")
                .contains("The Email field must contain a valid email address.");
    }


}
