package Tests;

import Pages.LoginPage;
import Pages.MyProfile;
import Pages.UserAccount;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import util.ChromeDrvPathHelper;

import java.util.concurrent.TimeUnit;

public class UpdateUsersProfileDataTest {

    private WebDriver driver;
    private MyProfile myProfile;
    private LoginPage loginPage;
    private UserAccount userAccount;


    @BeforeClass
    public static void ustawSciezke() {
        //PATH WILL CHANGE BASED ON OS through: util/ChromeDrvPathHelper
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.get("https://www.phptravels.net/login");
        this.myProfile =PageFactory.initElements(this.driver, MyProfile.class);
        this.loginPage =PageFactory.initElements(this.driver, LoginPage.class);
        this.userAccount=PageFactory.initElements(this.driver, UserAccount.class);
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage.loginDemo();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        userAccount.goToMyProfile();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

    }

//    @After
//    public void CloseBrowser() {
//        this.driver.quit();
//    }

    @Test
    public void userShouldChangeCountry (){
        myProfile.selectCountry("Brazil");
        myProfile.submitMyProfileUpdate();

    }

}
