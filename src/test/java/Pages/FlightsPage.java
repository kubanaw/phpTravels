package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage {
    WebDriver driver;

    public FlightsPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
