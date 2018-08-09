package Tests.mainPageTest;

import Pages.commonPages.Footer;
import Pages.homePage.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ChromeDrvPathHelper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

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
        driver.manage().timeouts().implicitlyWait(14,TimeUnit.SECONDS);
        driver.quit();

    }

    //zapis na newsletter
    @Test
    public void addEmailToNewsletterList() {
        this.driver.get("https://www.phptravels.net/");
        this.footer.getEmailField().sendKeys("testqwerty3210@gmail.com");
        this.footer.getSubmitNewsletterButton().click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div/ul/li/a/div")).getText();
        System.out.println(subscribedSuccessfullyAlert);
        assertEquals("SUBSCRIBED SUCCESSFULLY", subscribedSuccessfullyAlert);

//      Below is negative assertion, when email is known to the page, alert then is: ALREADY SUBSCRIBED
//        String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div/ul/li/a/div")).getText();
//        System.out.println(subscribedSuccessfullyAlert);
//        assertEquals("ALREADY SUBSCRIBED", subscribedSuccessfullyAlert);
    }
        @Test
        public void givenThatContactLinkExist() {
            this.driver.get("https://www.phptravels.net/");
        //Trick to show footer - go to email field
            this.footer.getEmailField().click();
        //WARNING FOOTER IS NOT LOADED WHEN PAGE IS SQUEEZED TO TABLET MODE
            driver.manage().window().maximize();
        //Now links are visible
            this.footer.getContactLink().click();
            String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[2]/ul/li[1]/a")).getText();
            System.out.println(subscribedSuccessfullyAlert);
            assertEquals("CONTACT", subscribedSuccessfullyAlert);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        @Test
        public void givenThatAboutUsLinkExist() {
            this.driver.get("https://www.phptravels.net/");
        //Trick to show footer - go to email field
            this.footer.getEmailField().click();
        //WARNING FOOTER IS NOT LOADED WHEN PAGE IS SQUEEZED TO TABLET MODE
            driver.manage().window().maximize();
        //Now links are visible
            this.footer.getAboutUS().click();
            String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[2]/ul/li[2]/a")).getText();
            System.out.println(subscribedSuccessfullyAlert);
            assertEquals("ABOUT US", subscribedSuccessfullyAlert);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        @Test
        public void givenThatHowToBookLinkExist() {
            this.driver.get("https://www.phptravels.net/");
            this.footer.getEmailField().click();
            driver.manage().window().maximize();
            this.footer.getHowToBook().click();
            String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[2]/ul/li[3]/a")).getText();
            System.out.println(subscribedSuccessfullyAlert);
            assertEquals("HOW TO BOOK", subscribedSuccessfullyAlert);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
        @Test
        public void givenThatBookingTipsLinkExist() {
            this.driver.get("https://www.phptravels.net/");
            this.footer.getEmailField().click();
            driver.manage().window().maximize();
            this.footer.getBookingTips().click();
            String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[2]/ul/li[4]/a")).getText();
            System.out.println(subscribedSuccessfullyAlert);
            assertEquals("BOOKING TIPS", subscribedSuccessfullyAlert);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        @Test
        public void givenThatOurPartnersLinkExist() {
            this.driver.get("https://www.phptravels.net/");
            this.footer.getEmailField().click();
            driver.manage().window().maximize();
            this.footer.getOurPartners().click();
            String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[3]/ul/li[1]/a")).getText();
            System.out.println(subscribedSuccessfullyAlert);
            assertEquals("OUR PARTNERS", subscribedSuccessfullyAlert);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }

        //TODO - in analogy to Tests above it is needed to create test for other links and also create metods and Getters in commonPages/Footer.java

}
