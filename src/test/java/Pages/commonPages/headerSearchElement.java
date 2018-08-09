package Pages.commonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderSearchElement {
//TODO - verify if headerSearch is same method on all 3 pages: hotels, cars and flights.
        WebDriver driver;
        public Footer(WebDriver driver) {this.driver = driver;}

//headerSearch
    //first field - Hotels
    @FindBy(className = "select2-chosen")
    WebElement firstSearchField;


    public WebElement getFirstSearchField() {
        return firstSearchField;
    }
}
