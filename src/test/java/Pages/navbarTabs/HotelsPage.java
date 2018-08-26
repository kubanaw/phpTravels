package Pages.navbarTabs;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelsPage extends BasePage {

   private final String hotelsSubPageUrl = "https://www.phptravels.net/hotels";

   @FindBy (css="h4>a")
   private List<WebElement> listOfHeaderLinkHotels;

    public HotelsPage (WebDriver driver){

        super(driver);
    }

    public HotelsPage openHotelsSubpage() {
        driver.get(hotelsSubPageUrl);
        return this;
    }

    public String getUrl (){
        return hotelsSubPageUrl;
    }



}
