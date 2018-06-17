package Tests;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.Select;

public class MainPageAccountLoginTest {
    private WebDriver driver;

    @BeforeClass
    public static void pathSetup() {
        //CHANGE PATH TO THE CHROMEDRIVER AS NEEDED - AND RE-RUN TESTS
        System.setProperty("webdriver.chrome.driver", "./src/test/java/resources/chromedriver");
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    @Test
    public void GivenThatIWantToLogIntoMyAccount() {
        this.driver.get("https://www.phptravels.net/");
        // This page has registered user:j2187262@nwytg.com Password: M4ki3t4!
        //Testing logging in
        String resultLogin = this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")).getText();
        Assert.assertEquals(resultLogin, "MY ACCOUNT");
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")).click();
        //Strona logowania
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[1]/a")).click();

//        //Enter E-mail address:
//        this.driver.findElement(By.name("username")).sendKeys("j2187262@nwytg.com");
//        //enter Password
//        this.driver.findElement(By.name("password")).sendKeys("Qwert32!");
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Sign up
        this.driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/form/div[2]/div[1]/a")).click();

        //REGISTER USER
        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy3455");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("phone")).sendKeys("0048664111332");
        this.driver.findElement(By.name("email")).sendKeys("j3686875@nwytg.com");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t9!");
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Submit Registration
        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();


//j3686875@nwytg.com
//Mail: "GerwazyMaciej@protonmail.com" M4ki3t4!


        //DELAY Until closing
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //DELAY-END

    }
}
