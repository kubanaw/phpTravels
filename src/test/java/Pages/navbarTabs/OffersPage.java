package Pages.navbarTabs;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OffersPage extends BasePage {


    public OffersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

