package Tests.navbarTest;

import Pages.commons.NavbarHeader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        this.wait = new WebDriverWait(driver, 10);
        this.navbarHeader = new NavbarHeader(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        navbarHeader.openMainPage();
    }

    @After
    public void closeBrowser() {
        this.driver.quit();
    }

    @Test
    public void changeToRussianLanguage() {
        this.navbarHeader.getRussianLanguage().click();
        assertThat(navbarHeader.getCurrentUrl())
                .isEqualTo("https://www.phptravels.net/ru");
        assertThat(navbarHeader.getTitle())
                .isEqualTo("Russian");
    }
}
