package Pages.navbarTabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {
    WebDriver driver;

    public OffersPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

