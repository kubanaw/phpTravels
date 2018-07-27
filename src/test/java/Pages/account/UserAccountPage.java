package Pages.account;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class UserAccountPage {
    //TODO create useraccount tests

    private static final Logger LOGGER = Logger.getLogger(UserAccountPage.class.getName());
    private final String url = "https://www.phptravels.net/account/";
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = "a[href='#bookings']")
    private WebElement bookings;
    @FindBy(css = "a[href='#profile']")
    private WebElement myProfile;
    @FindBy(css = "a[href='#wishlist']")
    private WebElement wishlist;
    @FindBy(css = "a[href='#newsletter']")
    private WebElement newsletter;
    @FindBy(css = "img.img-thumbnail")
    private WebElement profileImage;
    @FindBy(css = "h3.RTL")
    private WebElement greetingHeader;
    @FindBy (css ="div.pull-left>h4")
    private WebElement newsletterSubscribeHeader;

    public UserAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }


    public void goToBookingTab() {

        bookings.click();
    }

    public void goToMyProfileTab() {

        myProfile.click();
    }

    public void goToWishlistTab() {
        wishlist.click();
    }

    public void goToNewsletterTab() {
        newsletter.click();
    }

    public WebElement getProfileImage() {
        return profileImage;
    }

    public WebElement getGreetingHeader() {
        return greetingHeader;
    }

    public WebElement getNewsletterSubscribeHeader(){
        return newsletterSubscribeHeader;
    }


    public String getUrl() {

        return url;
    }

    public String getCurrentUrl() {

        String currentURL = driver.getCurrentUrl();
        LOGGER.info("Current URL of User Account Page: " + currentURL);
        return currentURL;

    }
}
