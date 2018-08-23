package Tests.mainPageTest;

import Pages.BasePage;
import Pages.commons.Footer;
import Pages.commons.NavbarHeader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ChromeDrvPathHelper;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class DisplayFooterElementTest {
    //ilona tutaj pisze
    private WebDriver driver;
    private Footer footer;
    private NavbarHeader navbarHeader;
    WebDriverWait wait;



    @BeforeClass
    public static void ustawSciezke() {
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before

    public void setup() {
        this.driver = new ChromeDriver();
        this.footer = PageFactory.initElements(this.driver, Footer.class);
        this.navbarHeader = new NavbarHeader(driver);
        this.wait = new WebDriverWait(driver, 5);


        navbarHeader.openMainPage();
        driver.manage().window().maximize();
        //scrollowanie na dół strony za pomocą skryptu js, żeby uwidocznić element footera:

     JavascriptExecutor jse = (JavascriptExecutor)driver;
       jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Actions action = new Actions(driver);
//        WebElement hook = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div/div[2]/button"));
//        action.moveToElement(hook);
    }

//    public void setup() {
//        this.driver = new ChromeDriver();
//        this.footer = PageFactory.initElements(this.driver, Footer.class);
//        this.navbarHeader = new NavbarHeader(driver);
//        navbarHeader.openMainPage();
//        driver.manage().window().maximize();
//        //scrollowanie na dół strony za pomocą skryptu js, żeby uwidocznić element footera:
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document" +
//                ".body.scrollHeight,document.documentElement.clientHeight));");
//
//    }

//    @After
//    public void tearDown() {
//        driver.manage().timeouts().implicitlyWait(14,TimeUnit.SECONDS);
//        driver.quit();
//
//    }

    //zapis na newsletter
    @Test
    public void addEmailToNewsletterList() {

        this.footer.typeRandomEmail();
        this.footer.getSubmitNewsletterButton().click();

        //footer.alreadySuscribedMessage();
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div/ul/li/a/div")).getText();
        //System.out.println(subscribedSuccessfullyAlert);

        assertThat(footer.alreadySuscribedMessage()).isEqualToIgnoringCase("Subscribed Successfully");

//      Below is negative assertion, when email is known to the page, alert then is: ALREADY SUBSCRIBED
//        String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[1]/div/ul/li/a/div")).getText();
//        System.out.println(subscribedSuccessfullyAlert);
//        assertEquals("ALREADY SUBSCRIBED", subscribedSuccessfullyAlert);
    }
    //TODO refactor test with wait to emement show before assertion
        @Test
        public void givenThatContactLinkExist() {
            this.footer.getContactLink().click();
            String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[2]/ul/li[1]/a")).getText();
            System.out.println(subscribedSuccessfullyAlert);
            assertEquals("CONTACT", subscribedSuccessfullyAlert);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        @Test
        public void givenThatAboutUsLinkExist() {
            String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[2]/ul/li[2]/a")).getText();

            System.out.println(subscribedSuccessfullyAlert);
            assertEquals("ABOUT US", subscribedSuccessfullyAlert);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }

        @Test
        public void givenThatHowToBookLinkExist() {
            this.footer.getHowToBook().click();
            String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[2]/ul/li[3]/a")).getText();
            System.out.println(subscribedSuccessfullyAlert);
            assertEquals("HOW TO BOOK", subscribedSuccessfullyAlert);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
        @Test
        public void givenThatBookingTipsLinkExist() {
            this.footer.getBookingTips().click();
            String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[2]/ul/li[4]/a")).getText();
            System.out.println(subscribedSuccessfullyAlert);
            assertEquals("BOOKING TIPS", subscribedSuccessfullyAlert);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
        @Test
        public void givenThatOurPartnersLinkExist() {
            this.footer.getOurPartners().click();
            String subscribedSuccessfullyAlert = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[3]/ul/li[1]/a")).getText();
            System.out.println(subscribedSuccessfullyAlert);
            assertEquals("OUR PARTNERS", subscribedSuccessfullyAlert);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

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
    public void faceBookIconRedirectsToFBloginPage() {
        this.footer.getFaceBookicon().click();
        for (String handle : driver.getWindowHandles()) {
        driver.switchTo().window(handle);
        }
        assertThat(driver.getCurrentUrl()).isEqualTo("https://www.facebook.com/travelbusiness");
    }
    @Test
    public void twitterIconRedirectsToFBloginPage() {
        this.footer.getTwitterIcon().click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        assertThat(driver.getCurrentUrl()).isEqualTo("https://twitter.com/phptravels");
    }



}
