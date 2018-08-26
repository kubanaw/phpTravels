package Pages.navbarTabs;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BlogPage extends BasePage {

    private final String url = "https://www.phptravels.net/blog";

    public BlogPage (WebDriver driver){

        super(driver);
    }

    public String getUrl() {
        return url;
    }
}

