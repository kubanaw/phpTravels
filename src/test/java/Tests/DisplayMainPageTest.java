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
       System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
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


}
