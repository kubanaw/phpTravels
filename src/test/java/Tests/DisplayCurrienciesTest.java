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

public class DisplayCurrienciesTest {

    //dolaczam webdriver
    private WebDriver driver;

    //realnie laduje sterownik chromedriver
    @BeforeClass
    public static void pathSetup() {
        //CHANGE PATH TO THE CHROMEDRIVER AS NEEDED - AND RE-RUN TESTS
        System.setProperty("webdriver.chrome.driver", "./src/test/java/resources/chromedriver");
    }

    //nowy obiekt chromedriver'a
    @Before
    public void setup() {
        this.driver = new ChromeDriver();
    }

//    @After
//    public void CloseBrowser() {
//        this.driver.quit();
//    }

    //test
    @Test
    public void givenThatPageOpens() {
        //1. wchodze na strone phptravels
        this.driver.get("https://www.phptravels.net/");
        //2. sprawdzam domyslna walute
        String resultUSD = this.driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[2]/ul/li[2]/a/strong")).getText();
        Assert.assertEquals("USD", resultUSD);
        //3. klikam na liste w celu rozwiniecia
        this.driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[2]/ul/li[2]/a")).click();
        //4. zmieniam na walute GBP
        String resultGBP = this.driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[3]/a")).getText();
        Assert.assertEquals("GBP",resultGBP);
        this.driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[2]/a")).click();
        //4. zmieniam na walute SAR
        String resultSAR = this.driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[3]/a")).getText();
        Assert.assertEquals("SAR", resultSAR);
        this.driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[3]/a")).click();





        //DELAY Until closing
        try {
            Thread.sleep(2700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
