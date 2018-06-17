package Tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterOptionsTest {

    private WebDriver driver;

    @BeforeClass
    public static void pathSetup() {
        //CHANGE PATH TO THE CHROMEDRIVER AS NEEDED - AND RE-RUN TESTS
        System.setProperty("webdriver.chrome.driver", "./src/test/java/resources/chromedriver");
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.get("https://www.phptravels.net/register");
    }

//    @After
//    public void CloseBrowser() {
//        this.driver.quit();
//    }

    @Test
    public void whenUserFirstNameFieldIsNotFillThenUserShouldNotRegister() {

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

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String message = this.driver.findElement(By.className("alert-danger")).getText();
        Assert.assertEquals(message, "The First name field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");


    }

    @Test
    public void whenUserLastNameFieldIsNotFillThenUserShouldNotRegister() {
        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");

        this.driver.findElement(By.name("phone")).sendKeys("0048664111332");
        this.driver.findElement(By.name("email")).sendKeys("j3686875@nwytg.com");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t9!");
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = this.driver.findElement(By.className("alert-danger")).getText();
        Assert.assertEquals(message, "The Last Name field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");


    }

    @Test
    public void whenUserEmailFieldIsNotFillThenUserShouldNotRegister() {
        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("phone")).sendKeys("0048664111332");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t9!");
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = this.driver.findElement(By.className("alert-danger")).getText();
        Assert.assertEquals(message, "The Email field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(),"https://www.phptravels.net/register");


    }

    @Test
    public void whenUserPasswordFieldNotFillThenUserShouldNotRegister(){

    }
}