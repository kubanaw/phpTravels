package Tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.Select;
import util.ChromeDrvPathHelper;

import static org.junit.Assert.assertEquals;

public class DisplayMainNavbarTest {

    private WebDriver driver;

    @BeforeClass
    public static void ustawSciezke() {
        //PATH WILL CHANGE BASED ON OS through: util/ChromeDrvPathHelper
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.get("https://www.phptravels.net/");
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    @Test
    public void givenThatPageOpens() {
        this.driver.get("https://www.phptravels.net/");

//Assert Logo exist
//    WebElement result1 = this.driver.findElement(By.className("navbar-"));
//    Assert.assertEquals(result1, "navbar-");

//Assert Home on navbar exist. This assertion checks test, and tries to click object if working, it continues
        String resultHome = this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[1]/a")).getText();
        Assert.assertEquals(resultHome, "HOME");
        this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[1]/a")).click();
        this.driver.get("https://www.phptravels.net/");


//Assert HOTELS link on navbar exist. This assertion checks test, and tries to click object if working, it continues
        String resultHotels = this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[2]/a")).getText();
        Assert.assertEquals(resultHotels, "HOTELS");
        this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[2]/a")).click();
        this.driver.get("https://www.phptravels.net/");

//Assert FLIGHTS link on navbar exist. This assertion checks test, and tries to click object if working, it continues
        String resultFlights = this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[3]/a")).getText();
        Assert.assertEquals(resultFlights, "FLIGHTS");
        this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[3]/a")).click();
        this.driver.get("https://www.phptravels.net/");

//Assert TOURS link on navbar exist. This assertion checks test, and tries to click object if working, it continues
        String resultTours = this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[4]/a")).getText();
        Assert.assertEquals(resultTours, "TOURS");
        this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[4]/a")).click();
        this.driver.get("https://www.phptravels.net/");

//Assert CARS link on navbar exist. This assertion checks test, and tries to click object if working, it continues
        String resultCars = this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[5]/a")).getText();
        Assert.assertEquals(resultCars, "CARS");
        this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[5]/a")).click();
        this.driver.get("https://www.phptravels.net/");

    }
//Assert VISA link on navbar exist. This assertion checks test, and tries to click object if working, it continues
   @Test
        public void givenThatVisaLinkExist(){
        this.driver.get("https://www.phptravels.net/");
        String resultVisa = this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[6]/a")).getText();
        Assert.assertEquals(resultVisa, "VISA");
        this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[6]/a")).click();
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/ivisa");
       this.driver.get("https://www.phptravels.net/");
   }
//Assert Offers link on navbar exist. This assertion checks test, and tries to click object if working, it continues
     @Test
     public void givenThatOffersPageExist() {
         this.driver.get("https://www.phptravels.net/");
         String resultOffers = this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[7]/a")).getText();
         Assert.assertEquals(resultOffers, "OFFERS");
         this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[7]/a")).click();
         try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/offers");
         this.driver.get("https://www.phptravels.net/");
     }
//Assert BLOG link on navbar exist. This assertion checks test, and tries to click object if working, it continues
      @Test
        public void givenThatBlogPageExist(){
            this.driver.get("https://www.phptravels.net/");

        String resultBlog = this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[8]/a")).getText();
        Assert.assertEquals(resultBlog, "BLOG");
        this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[8]/a")).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/blog");
            this.driver.get("https://www.phptravels.net/");
            //DELAY Until closing
            try {
                Thread.sleep(2700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
    @Test
    public void givenThahtHotelsPageExist() {
        this.driver.get("https://www.phptravels.net/");
        String assertHotels = this.driver.findElement(By.cssSelector("li.main-lnk:nth-child(2) > a:nth-child(1)")).getText();
        Assert.assertEquals(assertHotels, "HOTELS");
        this.driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[1]/li[2]/a")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/hotels");
        this.driver.get("https://www.phptravels.net/");
        //DELAY Until closing
        try {
            Thread.sleep(2700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //DELAY-END

    }
}
