package Tests.userAccountTest;

import Pages.account.MyProfilePage;
import Pages.account.UserAccountPage;
import Pages.navbarTabs.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
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
    private MyProfilePage myProfilePage;

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
        this.myProfilePage = new MyProfilePage(driver);
        loginPage.goToLoginPage();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginPanel()));
        loginPage.loginDemoUser();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    @Test
    public void userShouldGoToMyProfileTab() {
        userAccountPage.goToMyProfileTab();
        assertThat(userAccountPage.getCurrentActiveTabHref())
                .isEqualTo("https://www.phptravels.net/account/#profile");
        //This assertion was created before I found active tab properties
        String valueAsHexActive = Color.fromString(userAccountPage.getMyProfileTabCSSStyle("color")).asHex();
        String valueAsHex = Color.fromString(userAccountPage.getBookingsTabCSSStyle("color")).asHex();
        assertThat(valueAsHexActive)
                .isNotEqualTo(valueAsHex);
        assertThat(myProfilePage.getMyProfileForm().isDisplayed())
                .isTrue();
        assertThat(myProfilePage.getPersonalDetailHeaderText())
                .isEqualToIgnoringCase("personal details");

    }

    @Test
    public void userShouldGoToNewsletterTab() {
        userAccountPage.goToNewsletterTab();
        assertThat(userAccountPage.getCurrentActiveTabHref())
                .isEqualTo("https://www.phptravels.net/account/#newsletter");
        String valueAsHexActive = Color.fromString(userAccountPage.getNewsletterTabCSSStyle("color")).asHex();
        String valueAsHex = Color.fromString(userAccountPage.getBookingsTabCSSStyle("color")).asHex();
        assertThat(valueAsHexActive)
                .isNotEqualTo(valueAsHex);
        assertThat(userAccountPage.getNewsletterSubscribeHeader())
                .isEqualToIgnoringCase("subscribe");

    }

    @Test
    public void userShouldGoToBookingsTab (){
        userAccountPage.goToBookingTab();
        assertThat(userAccountPage.getCurrentActiveTabHref())
                .isEqualTo("https://www.phptravels.net/account/#bookings");
        String valueAsHexActive = Color.fromString(userAccountPage.getBookingsTabCSSStyle("color")).asHex();
        String valueAsHex = Color.fromString(userAccountPage.getWishlistTabCSSStyle("color")).asHex();
        assertThat(valueAsHexActive)
                .isNotEqualTo(valueAsHex);
        assertThat(userAccountPage.getBookingDetails().toString())
                .containsSequence("Booking"); //"Booking ID" doesn't work - why?

    }

    @Test
    public void userShouldGoToWishlistTab (){
        userAccountPage.goToWishlistTab();
        assertThat(userAccountPage.getCurrentActiveTabHref())
                .isEqualTo("https://www.phptravels.net/account/#wishlist");
        String valueAsHexActive = Color.fromString(userAccountPage.getWishlistTabCSSStyle("color")).asHex();
        String valueAsHex = Color.fromString(userAccountPage.getNewsletterTabCSSStyle("color")).asHex();
        assertThat(valueAsHexActive)
                .isNotEqualTo(valueAsHex);
    }


}
