package Pages.user.account;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class UserAccountPage extends BasePage {

    private final String url = "https://www.phptravels.net/account/";
    private WebDriver driver;
    private WebDriverWait wait;
    //tabs icons
    @FindBy(css = "a[href='#bookings']")
    private WebElement bookings;
    @FindBy(css = "a[href='#profile']")
    private WebElement myProfile;
    @FindBy(css = "a[href='#wishlist']")
    private WebElement wishlist;
    @FindBy(css = "a[href='#newsletter']")
    private WebElement newsletter;
    //active tab icon:
    @FindBy(css = "ul.profile-tabs>li.active>a")
    private WebElement activeTab;
    //user greeting panel:
    @FindBy(css = "img.img-thumbnail")
    private WebElement profileImage;
    @FindBy(css = "h3.RTL")
    private WebElement greetingHeader;
    //elements from newsletter tab:
    @FindBy(css = "div.pull-left>h4")
    private WebElement newsletterSubscribeHeader;
    //elements from bookings tab:
    @FindBy(css = "div.col-md-3>span")
    private List<WebElement> bookingDetails;
    //elements from wishlist tab:
    @FindBy(css = "div[id='wishlist']")
    private List<WebElement> wishlistFavoritesList;


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

    public String getNewsletterSubscribeHeader() {
        String subscribe = newsletterSubscribeHeader.getText();
        LOGGER.debug("Subscribe header: " + subscribe);
        return subscribe;
    }


    public String getUrl() {
        return url;
    }

    public String getCurrentUrl() {
        String currentURL = driver.getCurrentUrl();
        LOGGER.debug("Current URL of User Account Page: " + currentURL);
        return currentURL;
    }

    public String getMyProfileTabCSSStyle(String style) {
        String value = myProfile.getCssValue(style);
        LOGGER.debug("Current value of " + style + " is: " + value);
        return value;
    }


    public String getNewsletterTabCSSStyle(String style) {
        String value = newsletter.getCssValue(style);
        LOGGER.debug("Current value of " + style + " is: " + value);
        return value;
    }

    public String getWishlistTabCSSStyle(String style) {
        String value = wishlist.getCssValue(style);
        LOGGER.debug("Current value of " + style + " is: " + value);
        return value;
    }

    public String getBookingsTabCSSStyle(String style) {
        String value = bookings.getCssValue(style);
        LOGGER.debug("Current value of " + style + " is: " + value);
        return value;
    }

    public List<String> getBookingDetails() {
        List<String> details = new ArrayList<>();

        for (WebElement webElement : bookingDetails) {
            details.add(webElement.getText());
        }
        LOGGER.debug("booking: "+details);
        return details;
    }

    public List<String> getWishlistFavorites() {
        List<String> details = new ArrayList<>();
        for (WebElement webElement : wishlistFavoritesList) {
            details.add(webElement.getText());
        }
        LOGGER.debug("wishlist favorites" +details);
        return details;
    }

    public String getCurrentActiveTabHref() {
        String currentTab = activeTab.getAttribute("href");
        LOGGER.debug("Active tab is: " + currentTab);
        return currentTab;
    }

    public String getActiveTabCSSStyle(String style) {
        String value = activeTab.getCssValue(style);
        LOGGER.debug("Current value of " + style + " is: " + value);
        return value;
    }


}
