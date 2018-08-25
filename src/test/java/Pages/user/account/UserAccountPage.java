package Pages.user.account;

import Pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;


public class UserAccountPage extends BasePage {

    private final String url = "https://www.phptravels.net/account/";

    private JavascriptExecutor jse;

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

    @FindBy(css = "input.newsletter")
    private WebElement newsletterButton;

    //elements from bookings tab:
    @FindBy(css = "div.col-md-3>span")
    private List<WebElement> bookingDetails;

    //elements from wishlist tab:
    @FindBy(css = "div[id='wishlist']")
    private List<WebElement> wishlistFavoritesList;


    public UserAccountPage(WebDriver driver) {

        super(driver);
        jse = (JavascriptExecutor) driver;
    }


    public UserAccountPage goToBookingTab() {

        bookings.click();
        return this;
    }

    public UserAccountPage goToMyProfileTab() {

        myProfile.click();
        return this;
    }

    public UserAccountPage goToWishlistTab() {

        wishlist.click();
        return this;
    }

    public UserAccountPage goToNewsletterTab() {

        newsletter.click();
        return this;
    }

    public WebElement getProfileImage() {
        return profileImage;
    }

    public WebElement getGreetingHeader() {
        return greetingHeader;
    }

    public String getNewsletterSubscribeHeader() {

        String subscribe = newsletterSubscribeHeader.getText();
        LOGGER.trace("Subscribe header: " + subscribe);
        return subscribe;
    }


    public String getUrl() {
        return url;
    }



    public String getMyProfileTabCSSStyle(String style) {

        String value = myProfile.getCssValue(style);
        LOGGER.trace("Current value of " + style + " is: " + value);
        return value;
    }


    public String getNewsletterTabCSSStyle(String style) {

        String value = newsletter.getCssValue(style);
        LOGGER.trace("Current value of " + style + " is: " + value);
        return value;
    }

    public String getWishlistTabCSSStyle(String style) {

        String value = wishlist.getCssValue(style);
        LOGGER.trace("Current value of " + style + " is: " + value);
        return value;
    }

    public String getBookingsTabCSSStyle(String style) {

        String value = bookings.getCssValue(style);
        LOGGER.trace("Current value of " + style + " is: " + value);
        return value;
    }

    public List<String> getBookingDetails() {

        List<String> details = new ArrayList<>();

        for (WebElement webElement : bookingDetails) {
            details.add(webElement.getText());
        }
        if (details.isEmpty()) {
            LOGGER.warn("Booking List is empty!");
        }
        return details;
    }

    public List<String> getWishListFavorites() {

        List<String> details = new ArrayList<>();
        for (WebElement webElement : wishlistFavoritesList) {
            details.add(webElement.getText());
        }
        if (details.isEmpty()) {
            LOGGER.warn("Wish List is empty!");
        }
        return details;
    }

    public String getCurrentActiveTabHref() {

        String currentTab = activeTab.getAttribute("href");
        LOGGER.trace("Active tab is: " + currentTab);
        return currentTab;
    }

    public String getActiveTabCSSStyle(String style) {

        String value = activeTab.getCssValue(style);
        LOGGER.debug("Current value of " + style + " is: " + value);
        return value;
    }

    public boolean isSubscribeActive() {

        String activeNews = newsletterButton.getAttribute("checked");
        LOGGER.debug("Is subscribe active: " + activeNews);
        if (activeNews != null) {
            return true;
        }
        return false;
    }

    public boolean switchOffSubscribe() {

        if (isSubscribeActive()) {
            jse.executeScript("arguments[0].click();", newsletterButton);
        }
        return true;
    }

    public UserAccountPage goToMainPage() {

        driver.get(BASE_URL);
        return this;
    }

}
