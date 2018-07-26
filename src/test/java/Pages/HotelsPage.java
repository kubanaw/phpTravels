package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage {
    WebDriver driver;
   private String hotelsSubPageUrl = "https://www.phptravels.net/hotels";

    public HotelsPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void openHotelsSubpage() {
        driver.get(hotelsSubPageUrl);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
