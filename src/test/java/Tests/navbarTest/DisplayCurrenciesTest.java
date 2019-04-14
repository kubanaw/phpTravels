package Tests.navbarTest;

import Pages.commons.NavbarHeader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;


public class DisplayCurrenciesTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private NavbarHeader navbarHeader;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().version("73");
        //WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 15);
        this.navbarHeader = PageFactory.initElements(driver, NavbarHeader.class);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        navbarHeader.openMainPage();
        navbarHeader.setCurrency("USD");
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    @Test
    public void givenThatSelectCurrencyIsDisplayed() {
        navbarHeader.setCurrency("GBP");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "GBP"));
        assertThat(navbarHeader.getCurrentCurrency().getText())
                .as("change currency to GBP")
                .isEqualTo("GBP");

        navbarHeader.setCurrency("SAR");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "ريال"));
        assertThat(navbarHeader.getCurrentCurrency().getText())
                .as("change currency to SAR")
                .isEqualTo("ريال");

        navbarHeader.setCurrency("EUR");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "EUR"));
        assertThat(navbarHeader.getCurrentCurrency().getText())
                .as("change currency to EUR")
                .isEqualTo("EUR");

        navbarHeader.setCurrency("PKR");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "RS"));
        assertThat(navbarHeader.getCurrentCurrency().getText())
                .as("change currency to PKR")
                .isEqualTo("RS");


        navbarHeader.setCurrency("KWD");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "KWD"));
        assertThat(navbarHeader.getCurrentCurrency().getText())
                .as("change currency to KWD")
                .isEqualTo("KWD");


        navbarHeader.setCurrency("JPY");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "JPY"));
        assertThat(navbarHeader.getCurrentCurrency().getText())
                .as("change currency to JPY")
                .isEqualTo("JPY");


        navbarHeader.setCurrency("INR");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "INR"));
        assertThat(navbarHeader.getCurrentCurrency().getText())
                .as("change currency to INR")
                .isEqualTo("INR");


        navbarHeader.setCurrency("CNY");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "CNY"));
        assertThat(navbarHeader.getCurrentCurrency().getText())
                .as("change currency to CNY")
                .isEqualTo("CNY");


        navbarHeader.setCurrency("TRY");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentCurrency(), "TURKISH"));
        assertThat(navbarHeader.getCurrentCurrency().getText())
                .as("change currency to TRY")
                .isEqualTo("TURKISH");

    }
}
