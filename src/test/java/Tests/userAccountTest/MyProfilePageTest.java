package Tests.userAccountTest;

import Pages.navbarTabs.LoginPage;
import Pages.account.MyProfilePage;
import Pages.account.UserAccountPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ChromeDrvPathHelper;

import java.util.concurrent.TimeUnit;

public class MyProfilePageTest {
    //TODO change assertions to AssertJ and loggers

    private WebDriver driver;
    private MyProfilePage myProfilePage;
    private LoginPage loginPage;
    private UserAccountPage userAccountPage;
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
        this.wait = new WebDriverWait(this.driver, 2);
        this.myProfilePage = new MyProfilePage(driver);
        this.loginPage = new LoginPage(driver);
        this.userAccountPage = new UserAccountPage(driver);
        loginPage.goToLoginPage();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        loginPage.loginDemoUser();
        userAccountPage.goToMyProfileTab();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

//    @After
//    public void CloseBrowser() {
//        this.driver.quit();
//    }

//    @Test
//    public void allProfilesFormFieldsShouldBeDisplayed() {
//        //TODO catch NoSuchElementException to logger or remove this test
//            Assert.assertTrue(myProfilePage.getFirstNameInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getLastNameInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getPhoneNumberInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getEmailInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getPasswordInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getConfirmPasswordInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getFirstAddressInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getSecondAddressInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getCityInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getStateInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getZipCodeInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getCountryListInput().isDisplayed());
//            Assert.assertTrue(myProfilePage.getSubmitUpdateProfileButton().isDisplayed());
//    }
//
//    @Test
//    public void userShouldNotBeAllowedToChangeFirstNameField() {
//        String firstName = myProfilePage.getFirstNameInput().getAttribute("value");
//        myProfilePage.fillFirstName("Natalia");
//        String changeName = myProfilePage.getFirstNameInput().getAttribute("value");
//        Assert.assertEquals(firstName, "Johny");
//        Assert.assertNotEquals(firstName, "Natalia");
//        Assert.assertEquals(firstName, changeName);
//    }
//
//    @Test
//    public void userShouldNotBeAllowedToChangeLastNameField() {
//        //TODO ask is that good solution
//        String lastName = myProfilePage.getLastNameInput().getAttribute("value");
//        myProfilePage.fillLastName("Kowalska");
//        String changeName = myProfilePage.getLastNameInput().getAttribute("value");
//        Assert.assertEquals(lastName, "Smith");
//        Assert.assertNotEquals(lastName, "Kowalska");
//        Assert.assertEquals(lastName, changeName);
//    }
//
//    @Test
//    public void userShouldChangeCountry() {
//        //TODO create assertions -confirm country name and get correct string message
//        myProfilePage.selectCountry("Brazil");
//        myProfilePage.submitMyProfileUpdate();
//    }

    //TODO create more options tests


}
