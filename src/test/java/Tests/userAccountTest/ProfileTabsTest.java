package Tests.userAccountTest;

import Pages.commons.Footer;
import Pages.user.account.MyProfilePage;
import Pages.user.account.UserAccountPage;
import Pages.user.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;


public class ProfileTabsTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private UserAccountPage userAccountPage;
    private LoginPage loginPage;
    private MyProfilePage myProfilePage;
    private Footer footer;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {

        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(this.driver, 10);
        this.loginPage = new LoginPage(driver);
        this.userAccountPage = new UserAccountPage(driver);
        this.myProfilePage = new MyProfilePage(driver);
        this.footer = new Footer(driver);
        loginPage
                .loginPageOpen()
                .loginDemoUser();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    @Test
    public void userShouldGoToMyProfileTab() {

        assertThat(
                userAccountPage
                        .goToMyProfileTab()
                        .getCurrentActiveTabHref())
                .as("Active tab fragment identifier is #profile")
                .isEqualTo("https://www.phptravels.net/account/#profile");

        String valueAsHexActive = Color.fromString(userAccountPage.getMyProfileTabCSSStyle("color")).asHex();
        String valueAsHex = Color.fromString(userAccountPage.getBookingsTabCSSStyle("color")).asHex();
        assertThat(valueAsHexActive)
                .as("Active tab has different color than any other")
                .isNotEqualTo(valueAsHex);

        assertThat(
                myProfilePage
                        .getMyProfileForm()
                        .isDisplayed())
                .as("Personal details form is displayed on the page.")
                .isTrue();

        assertThat(myProfilePage.getPersonalDetailHeaderText())
                .as("My Profile Tab has a header 'Personal Details'")
                .isEqualToIgnoringCase("personal details");
    }

    @Test
    public void userShouldGoToNewsletterTab() {

        assertThat(
                userAccountPage
                        .goToNewsletterTab()
                        .getCurrentActiveTabHref())
                .as("Active tab fragment identifier is #newsletter")
                .isEqualTo("https://www.phptravels.net/account/#newsletter");

        String valueAsHexActive = Color.fromString(userAccountPage.getNewsletterTabCSSStyle("color")).asHex();
        String valueAsHex = Color.fromString(userAccountPage.getBookingsTabCSSStyle("color")).asHex();
        assertThat(valueAsHexActive)
                .as("Active tab has different color than any other")
                .isNotEqualTo(valueAsHex);

        assertThat(userAccountPage.getNewsletterSubscribeHeader())
                .as("Newsletter Tab has a header 'Subscribe'")
                .isEqualToIgnoringCase("subscribe");
    }

    @Test
    public void userShouldGoToBookingsTab() {

        assertThat(
                userAccountPage
                        .goToBookingTab()
                        .getCurrentActiveTabHref())
                .as("Active tab fragment identifier is #bookings")
                .isEqualTo("https://www.phptravels.net/account/#bookings");

        String valueAsHexActive = Color.fromString(userAccountPage.getBookingsTabCSSStyle("color")).asHex();
        String valueAsHex = Color.fromString(userAccountPage.getWishlistTabCSSStyle("color")).asHex();
        assertThat(valueAsHexActive)
                .as("Active tab has different color than any other")
                .isNotEqualTo(valueAsHex);

        for (String booking : userAccountPage.getBookingDetails()) {

            assertThat(booking)
                    .as("All user's booking from Booking List have 'Booking ID' headers")
                    .contains("Booking ID");
        }

    }

    @Test
    public void userShouldGoToWishlistTab() {

        assertThat(
                userAccountPage
                        .goToWishlistTab()
                        .getCurrentActiveTabHref())
                .as("Active tab fragment identifier is #wishlist")
                .isEqualTo("https://www.phptravels.net/account/#wishlist");

        String valueAsHexActive = Color.fromString(userAccountPage.getWishlistTabCSSStyle("color")).asHex();
        String valueAsHex = Color.fromString(userAccountPage.getNewsletterTabCSSStyle("color")).asHex();

        assertThat(valueAsHexActive)
                .as("Active tab has different color than any other")
                .isNotEqualTo(valueAsHex);


    }

    @Test
    public void whenUserAddEmailToNewsletterThenSubscribeIsActive() {

        assertThat(
                userAccountPage
                        .goToNewsletterTab()
                        .switchOffSubscribe())
                .as("Checked is subscribe switch off")
                .isTrue();

        userAccountPage.goToMainPage();
        footer.typeEmailToNewsletter("user@phptravels.com");

        assertThat(
                loginPage
                        .backToUserAccount()
                        .goToNewsletterTab()
                        .isSubscribeActive())
                .as("Subscribe is active.")
                .isTrue();


    }


}
