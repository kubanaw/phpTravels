package Tests.navbarTest;

import Pages.commons.NavbarHeader;
import Pages.navbarTabs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ChromeDrvPathHelper;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayMainNavbarTest {

    private WebDriver driver;
    private NavbarHeader navbarHeader;
    private HotelsPage hotelspage;
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
        driver.manage().window().maximize();
        navbarHeader = new NavbarHeader(driver);
        navbarHeader.openMainPage();
        hotelspage = new HotelsPage(driver);
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


//Assert HOTELS link on navbar exist. This assertion checks test, and tries to click object if working, it continues

    @Test
    public void givenThatHotelsLinkExist() {
        navbarHeader.pickHotelsElement();
        assertThat(hotelspage.getCurrentUrl()).isEqualTo(hotelspage.getUrl());
    }

    //Assert FLIGHTS link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatFlightsLinkExist() {
        navbarHeader.pickFlightsElement();
        assertThat(flightsPage.getCurrentUrl()).isEqualTo(flightsPage.getUrl());
    }

    //Assert TOURS link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatToursLinkExist() {
        navbarHeader.pickToursElement();
        assertThat(toursPage.getCurrentUrl()).isEqualTo(toursPage.getUrl());
    }

    //Assert CARS link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatCarsLinkExist() {
        navbarHeader.pickCarsElement();
        assertThat(carsPage.getCurrentUrl()).isEqualTo(carsPage.getUrl());
    }

    //Assert VISA link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatVisaLinkExist() {
        navbarHeader.pickVisaElement();
        assertThat(visaPage.getCurrentUrl()).isEqualTo(visaPage.getUrl());
    }

    //Assert Offers link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatOffersPageExist() {
        navbarHeader.pickHOffersElement();
        assertThat(offersPage.getCurrentUrl()).isEqualTo(offersPage.getUrl());
    }

    //Assert BLOG link on navbar exist. This assertion checks test, and tries to click object if working, it continues
    @Test
    public void givenThatBlogPageExist() {
        navbarHeader.pickBlogElement();
        assertThat(blogPage.getCurrentUrl()).isEqualTo(blogPage.getUrl());
    }
}

