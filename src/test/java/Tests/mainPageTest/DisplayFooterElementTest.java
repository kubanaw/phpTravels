package Tests.mainPageTest;


import Pages.commons.Footer;
import Pages.commons.NavbarHeader;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ChromeDrvPathHelper;

import static org.assertj.core.api.Assertions.assertThat;


public class DisplayFooterElementTest {

    private WebDriverWait wait;
    private WebDriver driver;
    private Footer footer;
    private NavbarHeader navbarHeader;

    @BeforeClass
    public static void ustawSciezke() {

        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {

        this.driver = new ChromeDriver();
        this.footer = new Footer(driver);
        this.navbarHeader = new NavbarHeader(driver);
        this.wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        navbarHeader.openMainPage();

        //scrollowanie na dół strony za pomocą skryptu js, żeby uwidocznić element footera:
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void addEmailToNewsletterList() {

        footer.typeEmailToNewsletter();
        assertThat(footer.alreadySubscribedMessage())
                .isEqualToIgnoringCase("Subscribed Successfully");
    }


    @Test
    public void whenClickOnContactUsSubpageOpens() {

        this.footer.getContactLink().click();
        assertThat(footer.getCurrentUrl())
                .isEqualTo("https://www.phptravels.net/contact-us");
        assertThat(footer.getTitle())
                .isEqualTo("Contact");
    }

    @Test
    public void whenClickOnAbouttUsSubpageOpens() {

        this.footer.getAboutUS().click();
        assertThat(footer.getCurrentUrl())
                .isEqualTo("https://www.phptravels.net/About-Us");
        assertThat(footer.getTitle())
                .isEqualTo("About Us");
    }

    @Test
    public void whenClickOnHowToBookSubpageOpens() {

        this.footer.getHowToBook().click();
        assertThat(footer.getCurrentUrl())
                .isEqualTo("https://www.phptravels.net/How-to-Book");
        assertThat(footer.getTitle())
                .isEqualTo("How to Book");
    }

    @Test
    public void whenClickOnBookingTipsSubpageOpens() {

        this.footer.getBookingTips().click();
        assertThat(footer.getCurrentUrl())
                .isEqualTo("https://www.phptravels.net/Booking-Tips");
        assertThat(footer.getTitle())
                .isEqualTo("Booking Tips");
    }

//windows handle - przekierowanie otwiera sie w nowym oknie:
    @Test
    public void twitterIconRedirectsToTwitLoginPage() {

        this.footer.getTwitterIcon().click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        assertThat(driver.getCurrentUrl())
                .isEqualTo("https://twitter.com/phptravels");
    }

    @Test
    public void faceBookIconRedirectsToFBloginPage() {

        this.footer.getFaceBookIcon().click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        assertThat(driver.getCurrentUrl())
                .isEqualTo("https://www.facebook.com/travelbusiness");
    }


}
