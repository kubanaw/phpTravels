package Tests;

import Pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ChromeDrvPathHelper;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayMainNavbarTest  {

    private WebDriver driver;
    private NavbarHeader navbarHeader;
    private HotelsPage hotelspage;
    private HomePage homePage;
    private FlightsPage flightsPage;
    private ToursPage toursPage;
    private VisaPage visaPage;
    private CarsPage carsPage;
    private OffersPage offersPage;
    private BlogPage blogPage;

    @BeforeClass
    public static void ustawSciezke() {
        //PATH WILL CHANGE BASED ON OS through: util/ChromeDrvPathHelper
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        // this.driver.get("https://www.phptravels.net/");
        navbarHeader = new NavbarHeader(driver);
        navbarHeader.openMainPage();
       //TODO find solution for loggers in abstractclass
        // navbarHeader.testLogLevels();
        hotelspage = new HotelsPage(driver);
        homePage = new HomePage(driver);
        flightsPage = new FlightsPage(driver);
        toursPage = new ToursPage(driver);
        visaPage = new VisaPage(driver);
        carsPage = new CarsPage(driver);
        offersPage = new OffersPage(driver);
        blogPage = new BlogPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }


//Assert Logo exist
//    WebElement result1 = this.driver.findElement(By.className("navbar-"));
//    Assert.assertEquals(result1, "navbar-");

    //Assert Home on navbar exist. This assertion checks test, and tries to click object if working, it continues
    //Fixed removed leading dot "." before xpath pointer - worked.

    public void givenThatHomePageLinkExist() {
        navbarHeader.pickHomeElement();
        assertThat(homePage.getCurrentUrl()).isEqualTo("https://www.phptravels.net/");
    }

//Assert HOTELS link on navbar exist. This assertion checks test, and tries to click object if working, it continues

    @Test
    public void givenThatHotelsLinkExist() {
        navbarHeader.pickHotelsElement();
        assertThat(hotelspage.getCurrentUrl()).isEqualTo("https://www.phptravels.net/hotels");
    }

    //Assert FLIGHTS link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatFlightsLinkExist() {
        navbarHeader.pickFlightsElement();
        assertThat(flightsPage.getCurrentUrl()).isEqualTo("https://www.phptravels.net/flights");
    }

    //Assert TOURS link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatToursLinkExist() {
        navbarHeader.pickToursElement();
        assertThat(toursPage.getCurrentUrl()).isEqualTo("https://www.phptravels.net/tours");
        }

    //Assert CARS link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatCarsLinkExist() {
        navbarHeader.pickCarsElement();
        assertThat(carsPage.getCurrentUrl()).isEqualTo("https://www.phptravels.net/cars");
    }

    //Assert VISA link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatVisaLinkExist() {
        navbarHeader.pickVisaElement();
        assertThat(visaPage.getCurrentUrl()).isEqualTo("https://www.phptravels.net/ivisa");
    }

    //Assert Offers link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatOffersPageExist() {
        navbarHeader.pickHOffersElement();
        assertThat(offersPage.getCurrentUrl()).isEqualTo("https://www.phptravels.net/offers");
    }

    //Assert BLOG link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatBlogPageExist() {
        navbarHeader.pickBlogElement();
        assertThat(blogPage.getCurrentUrl()).isEqualTo("https://www.phptravels.net/blog");
    }
  }

