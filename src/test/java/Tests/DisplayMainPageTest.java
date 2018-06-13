package Tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.Select;


import static org.junit.Assert.assertEquals;

public class DisplayMainPageTest {

    private  WebDriver driver;

    @BeforeClass
    public static void pathSetup() {
        //CHANGE PATH TO THE CHROMEDRIVER AS NEEDED - AND RE-RUN TESTS
        System.setProperty("webdriver.chrome.driver", "C:\\Github\\jdqzl1-materialy\\jdqzl1-selenium\\src\\test\\java\\resources\\chromedriver.exe");
    }

   @Before
    public void setup(){
       this.driver = new ChromeDriver();
    }
   @After
    public void CloseBrowser(){
        this.driver.quit();
    }
@Test
    public void givenThatPageOpens() {
        this.driver.get("https://www.phptravels.net/");

//Assert Logo exist
    WebElement result1 = this.driver.findElement(By.className("navbar-brand"));
    Assert.assertEquals(result1, "navbar-brand");




//    this.driver.get("http://demoqa.com/registration/");
//    driver.findElement(By.id("name_3_firstname")).sendKeys("Johny");
//    driver.findElement(By.id("name_3_lastname")).sendKeys("Rock");
//    driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[2]/div/div/input[1]")).click();
//    driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/main/article/div/div/div[3]/form/ul/li[3]/div/div/input[2]")).click();
//    //DROP DOWN LIST OBSŁUGA:
//    //KRAJ-DROP
//    Select SelectCountry = new Select(driver.findElement(By.id("dropdown_7")));
//    SelectCountry.selectByValue("Poland");
//    //MONTH-DROP
//    Select SelectMonth = new Select(driver.findElement(By.id("mm_date_8")));
//    SelectMonth.selectByValue("6");
//    //DAY-DROP
//    Select SelectDay = new Select(driver.findElement(By.id("dd_date_8")));
//    SelectDay.selectByValue("21");
//    //YEAR-DROP
//    Select SelectYear = new Select(driver.findElement(By.id("yy_date_8")));
//    SelectYear.selectByValue("1982");
//
//    //Enter Phone number
//    this.driver.findElement(By.id("phone_9")).sendKeys("0048888123456");
//    //Enter Username
//    this.driver.findElement(By.id("username")).sendKeys("JohnnyMnemonic1234");
//    //Enter e-mail address
//    this.driver.findElement(By.id("email_1")).sendKeys("KillmeifYoucan@wp.pl");
//    //UPLOAD PHOTO
//    this.driver.findElement(By.id("profile_pic_10")).sendKeys("C:\\Users\\kpodlaski\\Pictures\\kpodlaski.png");
//    //Description - wprowadzenie opisu
//    this.driver.findElement(By.id("description")).sendKeys("Bzdury na temat opisu dla uzytkownika, takie tam nic nie istotne informacje");
//
//    //Password_1
//    this.driver.findElement(By.id("password_2")).sendKeys("Ma7itam4w2^@");
//    //confirm_password_password_2
//    this.driver.findElement(By.id("confirm_password_password_2")).sendKeys("Ma7itam4w2^@");
//
//
//    //GET Attribut
//    String result = this.driver.findElement(By.id("piereg_passwordStrength")).getText();
//    Assert.assertEquals(result,"Very weak");
//    //GET Attrib
//    String color = this.driver.findElement(By.id("piereg_passwordStrength")).getCssValue("Background");
//    //AssertIfPasswordIsVeryWeak
//    Assert.assertEquals(color,"#FFA0A0");
//
//    String result2 = this.driver.findElement(By.id("piereg_passwordStrength")).getText();
//    //AssertIfPasswordIsStrong
//    Assert.assertEquals(color, "#C3FF88");
//    Assert.assertEquals(result2,"Strong");
//    //SUBMIT FORM
//
//    this.driver.findElement(By.name("pie_submit")).submit();





    //DELAY Until closing
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    //DELAY-END
















        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
