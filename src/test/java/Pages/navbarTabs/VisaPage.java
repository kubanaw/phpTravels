package Pages.navbarTabs;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class VisaPage extends BasePage {

    private final String url = "https://www.phptravels.net/ivisa";

    public VisaPage(WebDriver driver) {

        super(driver);
    }

    public String getUrl() {
        return url;
    }
}

