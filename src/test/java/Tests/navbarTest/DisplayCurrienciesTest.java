package Tests.navbarTest;

import Pages.commonPages.NavbarHeader;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class DisplayCurrienciesTest {

    //dolaczam webdriver
    private WebDriver driver;
    private WebDriverWait wait;
    private NavbarHeader navbarHeader;

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
        this.navbarHeader = PageFactory.initElements(driver, NavbarHeader.class);
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

          Assert.assertEquals("USD",navbarHeader.getCurrentCurrency().getText());

        //3. klikam na liste w celu rozwiniecia
        this.driver.findElement(By.xpath("//*[@id=\"collapse\"]/ul[2]/ul/li[2]/a")).click();

        //4. zmieniam na walute GBP STARA METODA
//        Assert.assertEquals("GBP", commonPages.getGBPCurrency().getText());

        //4. zmieniam na walute GBP
        navbarHeader.setCurrency("GBP");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "GBP"));
        Assert.assertEquals("GBP",navbarHeader.getCurrentCurrency().getText());

        //5. zmieniam na walute SAR
        navbarHeader.setCurrency("SAR");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "ريال"));
        Assert.assertEquals("ريال",navbarHeader.getCurrentCurrency().getText());

        //6. zmieniam na walute EUR
        navbarHeader.setCurrency("EUR");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "EUR"));
        Assert.assertEquals("EUR",navbarHeader.getCurrentCurrency().getText());

        //7. zmieniam na walute PKR
        navbarHeader.setCurrency("PKR");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "RS"));
        Assert.assertEquals("RS",navbarHeader.getCurrentCurrency().getText());

        //8. zmieniam na walute KWD
        navbarHeader.setCurrency("KWD");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "KWD"));
        Assert.assertEquals("KWD",navbarHeader.getCurrentCurrency().getText());

        //9. zmieniam na walute JPY
        navbarHeader.setCurrency("JPY");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "JPY"));
        Assert.assertEquals("JPY",navbarHeader.getCurrentCurrency().getText());

        //9. zmieniam na walute INR
        navbarHeader.setCurrency("INR");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "INR"));
        Assert.assertEquals("INR",navbarHeader.getCurrentCurrency().getText());

        //10. zmieniam na walute CNY
        navbarHeader.setCurrency("CNY");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "CNY"));
        Assert.assertEquals("CNY",navbarHeader.getCurrentCurrency().getText());

        //11. zmieniam na walute TRY
        navbarHeader.setCurrency("TRY");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "TURKISH"));
        Assert.assertEquals("TURKISH",navbarHeader.getCurrentCurrency().getText());

        //DELAY Until closing
        try {
            Thread.sleep(2700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
