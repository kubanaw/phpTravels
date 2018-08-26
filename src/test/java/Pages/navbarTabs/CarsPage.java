package Pages.navbarTabs;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CarsPage extends BasePage {

    private final String url = "https://www.phptravels.net/cars";


    public CarsPage (WebDriver driver){

        super(driver);
    }

    public String getUrl() {
        return url;
    }
}

