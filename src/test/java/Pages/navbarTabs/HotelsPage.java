package Pages.navbarTabs;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage extends BasePage {

   private String hotelsSubPageUrl = "https://www.phptravels.net/hotels";

    public HotelsPage (WebDriver driver){

        super(driver);
    }
    public void openHotelsSubpage() {
        driver.get(hotelsSubPageUrl);
    }



}
