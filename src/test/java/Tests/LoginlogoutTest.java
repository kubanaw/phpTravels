package Tests;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.Select;

public class LoginlogoutTest {

    private WebDriver driver;

    @BeforeClass
    public static void usawSciezke() {
    //CHANGE PATH TO THE CHROMEDRIVER AS NEEDED - AND RE-RUN TESTS
    System.setProperty("webdriver.chrome.driver", "./src/test/java/resources/chromedriver");
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
    }

    @After
//    public void CloseBrowser() {
//        this.driver.quit();
    //}

    @Test
    public void GivenThatIWantTologinLogOut() {
        this.driver.get("http://phptravels.net/");
        //Testing logging in
        String resultLogin = this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")).getText();
        Assert.assertEquals(resultLogin, "MY ACCOUNT");
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")).click();
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Strona logowania
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[1]/a")).click();
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Enter E-mail address:
        this.driver.findElement(By.name("username")).sendKeys("GerwazyMaciej@protonmail.com");
        //enter Password
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t4!");
        //SUMBIT
        this.driver.findElement(new By.ByCssSelector("button.btn:nth-child(2)")).click();


//        //LOGOUT
//        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")).click();
//        try {
//            Thread.sleep(1800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //DELAY Until closing
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //DELAY-END


    }





}
