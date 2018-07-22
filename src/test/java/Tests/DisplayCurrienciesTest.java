package Tests;

import Pages.HomePage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class DisplayCurrienciesTest {

    //dolaczam webdriver
    private WebDriver driver;
    private HomePage homePage;
    private WebDriverWait wait;

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
        this.wait = new WebDriverWait(driver, 7);
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    @Test
    public void givenThatPageOpens() {
        //1. wchodze na strone phptravels
        this.driver.get("https://www.phptravels.net/");

       // 2. sprawdzam domyslna walute

          Assert.assertEquals("USD",homePage.getCurrentCurrency().getText());

        //3. klikam na liste w celu rozwiniecia
        this.driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[2]/ul/li[2]/a")).click();

        //4. zmieniam na walute GBP STARA METODA
//        Assert.assertEquals("GBP", homePage.getGBPCurrency().getText());

        //4. zmieniam na walute GBP
        homePage.setCurrency("GBP");
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getCurrentCurrency(), "GBP"));
        Assert.assertEquals("GBP",homePage.getCurrentCurrency().getText());

        //5. zmieniam na walute SAR
        homePage.setCurrency("SAR");
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getCurrentCurrency(), "ريال"));
        Assert.assertEquals("ريال",homePage.getCurrentCurrency().getText());

        //6. zmieniam na walute EUR
        homePage.setCurrency("EUR");
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getCurrentCurrency(), "EUR"));
        Assert.assertEquals("EUR",homePage.getCurrentCurrency().getText());

        //7. zmieniam na walute PKR
        homePage.setCurrency("PKR");
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getCurrentCurrency(), "RS"));
        Assert.assertEquals("RS",homePage.getCurrentCurrency().getText());

        //8. zmieniam na walute KWD
        homePage.setCurrency("KWD");
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getCurrentCurrency(), "KWD"));
        Assert.assertEquals("KWD",homePage.getCurrentCurrency().getText());

        //9. zmieniam na walute JPY
        homePage.setCurrency("JPY");
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getCurrentCurrency(), "JPY"));
        Assert.assertEquals("JPY",homePage.getCurrentCurrency().getText());

        //9. zmieniam na walute INR
        homePage.setCurrency("INR");
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getCurrentCurrency(), "INR"));
        Assert.assertEquals("INR",homePage.getCurrentCurrency().getText());

        //10. zmieniam na walute CNY
        homePage.setCurrency("CNY");
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getCurrentCurrency(), "CNY"));
        Assert.assertEquals("CNY",homePage.getCurrentCurrency().getText());

        //11. zmieniam na walute TRY
        homePage.setCurrency("TRY");
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getCurrentCurrency(), "TURKISH"));
        Assert.assertEquals("TURKISH",homePage.getCurrentCurrency().getText());

        //DELAY Until closing
        try {
            Thread.sleep(2700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
