package Tests.mainPageTest;

import Pages.mainPage.Footer;
import Pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import util.ChromeDrvPathHelper;

public class DisplayFooterElementTest {
    //ilona tutaj pisze
    private WebDriver driver;
    private Footer footer;
    private HomePage homePage;

    @BeforeClass
    public static void ustawSciezke() {
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.footer = PageFactory.initElements(this.driver, Footer.class);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //zapis na newsletter
    @Test
    public void addEmailToNewsletterList() {
        this.driver.get("https://www.phptravels.net/");
//footer.

    }

}
