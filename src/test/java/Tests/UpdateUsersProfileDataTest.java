package Tests;

import Pages.LoginPage;
import Pages.MyProfile;
import Pages.UserAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ChromeDrvPathHelper;

import java.util.concurrent.TimeUnit;

public class UpdateUsersProfileDataTest {

    private WebDriver driver;
    private MyProfile myProfile;
    private LoginPage loginPage;
    private UserAccount userAccount;
    private WebDriverWait waitTime;


    @BeforeClass
    public static void ustawSciezke() {
        //PATH WILL CHANGE BASED ON OS through: util/ChromeDrvPathHelper
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.waitTime = new WebDriverWait(this.driver, 2);
        this.driver.get("https://www.phptravels.net/login");
        this.myProfile = PageFactory.initElements(this.driver, MyProfile.class);
        this.loginPage = PageFactory.initElements(this.driver, LoginPage.class);
        this.userAccount = PageFactory.initElements(this.driver, UserAccount.class);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage.loginDemoUser();
        userAccount.goToMyProfile();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

//    @After
//    public void CloseBrowser() {
//        this.driver.quit();
//    }

    @Test
    public void allProfilesFormFieldsShouldBeDisplayed() {
        //TODO catch NoSuchElementException to logger
            Assert.assertTrue(myProfile.getFirstNameInput().isDisplayed());
            Assert.assertTrue(myProfile.getLastNameInput().isDisplayed());
            Assert.assertTrue(myProfile.getPhoneNumberInput().isDisplayed());
            Assert.assertTrue(myProfile.getEmailInput().isDisplayed());
            Assert.assertTrue(myProfile.getPasswordInput().isDisplayed());
            Assert.assertTrue(myProfile.getConfirmPasswordInput().isDisplayed());
            Assert.assertTrue(myProfile.getFirstAddressInput().isDisplayed());
            Assert.assertTrue(myProfile.getSecondAddressInput().isDisplayed());
            Assert.assertTrue(myProfile.getCityInput().isDisplayed());
            Assert.assertTrue(myProfile.getStateInput().isDisplayed());
            Assert.assertTrue(myProfile.getZipCodeInput().isDisplayed());
            Assert.assertTrue(myProfile.getCountryListInput().isDisplayed());
            Assert.assertTrue(myProfile.getSubmitUpdateProfileButton().isDisplayed());
    }

    @Test
    public void userShouldNotBeAllowedToChangeFirstNameField() {
        String firstName = myProfile.getFirstNameInput().getAttribute("value");
        myProfile.getFirstNameInput().sendKeys("Natalia");
        String changeName = myProfile.getFirstNameInput().getAttribute("value");
        Assert.assertEquals(firstName, "Johny");
        Assert.assertNotEquals(firstName, "Natalia");
        Assert.assertEquals(firstName, changeName);
    }

    @Test
    public void userShouldNotBeAllowedToChangeLastNameField() {
        //TODO ask is that good solution
        String lastName = myProfile.getLastNameInput().getAttribute("value");
        myProfile.getLastNameInput().sendKeys("Kowalska");
        String changeName = myProfile.getLastNameInput().getAttribute("value");
        Assert.assertEquals(lastName, "Smith");
        Assert.assertNotEquals(lastName, "Kowalska");
        Assert.assertEquals(lastName, changeName);
    }

    @Test
    public void userShouldChangeCountry() {
        //TODO create assertions -confirm country name and get correct string message
        myProfile.selectCountry("Brazil");
        myProfile.submitMyProfileUpdate();
    }


}
