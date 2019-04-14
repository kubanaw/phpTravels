package Tests.navbarTest;

import Pages.commons.NavbarHeader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

public class DisplayLanguagesTest {


    private WebDriver driver;
    private WebDriverWait wait;
    private NavbarHeader navbarHeader;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().version("73");
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 20);
        this.navbarHeader = new NavbarHeader(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        navbarHeader.openMainPage();
        navbarHeader.setLanguage("English");
    }

    @After
    public void closeBrowser() {
        this.driver.quit();
    }

    @Test
    public void changeToRussianLanguage() {
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/ul/li/a"));
        actions.moveToElement(menu);

//        WebElement submenu = driver.findElement(By.xpath("//*[@id=\"ru\"]"));
//        actions.moveToElement(submenu);
//        actions.click().build().perform();

        navbarHeader.setLanguage("Russian");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentLanguage(), "Russian"));
        assertThat(navbarHeader.getCurrentLanguage().getText())
                .as("change language to Russian")
                .isEqualTo("Russian");

        actions.moveToElement(menu);

        navbarHeader.setLanguage("Farsi");
        wait.until(ExpectedConditions.textToBePresentInElement(navbarHeader.getCurrentLanguage(), "Farsi"));
        assertThat(navbarHeader.getCurrentLanguage().getText())
                .as("change language to Farsi")
                .isEqualTo("Farsi");



    }
}
