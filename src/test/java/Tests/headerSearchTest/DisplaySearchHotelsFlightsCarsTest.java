package Tests.headerSearchTest;

import Pages.commonPages.Footer;
import Pages.homePage.HomePage;
import Pages.BasePage;
import Pages.commonPages.NavbarHeader;
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

public class DisplaySearchHotelsFlightsCarsTest {
//TODO - WARNING! - CLASS search_head - IS only available on three pages: Hotels, Flights and Cars. On the other pages
//search is done via different component.
    private WebDriver driver;
    private Footer footer;
    private HomePage homePage;


}
