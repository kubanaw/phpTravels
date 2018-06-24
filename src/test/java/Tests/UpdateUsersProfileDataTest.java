package Tests;

import Pages.MyProfile;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import util.ChromeDrvPathHelper;

public class UpdateUsersProfileDataTest {

    private WebDriver driver;
    private MyProfile myProfile;


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
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    @Test
    public void userShouldChangeCountry (){
        myProfile.selectCountry("Brazil");
        myProfile.submitMyProfileUpdate();

    }

}
