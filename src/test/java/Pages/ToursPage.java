package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ToursPage {
    WebDriver driver;

    public ToursPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
