package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAccount {

    //fields

    private WebDriver driver;
    private WebDriverWait waitTime;

    //constructor

    public UserAccount (WebDriver driver) {

        this.driver = driver;
    }

    //elements

    @FindBy (xpath = "//*[@id=\"body-section\"]/div/div[3]/div/div[1]/ul/li[1]/a")
    private WebElement bookings;

    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement myProfile;

    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[3]/a[1]")
    private WebElement wishlist;

    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[4]/a[1]")

    private WebElement newsletter;

    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]")

    private WebElement profileImage;

    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/h3[1]")
    private WebElement greetingHeader;

    @FindBy (xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[1]/a")
    private WebElement nameHeader;

//    @FindBy (xpath = "//*[@id=\"bookings\"]/div[2]/div[4]/a")
//    private WebElement invoiceButton;

    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/strong[1]/div[1]")
    private WebElement timeBar;

    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]")
    private WebElement dateBar;

    //methods

    public void goToBooking  (){

        bookings.click();
    }

    public void goToMyProfile (){

        waitTime = new WebDriverWait(driver, 2);
        try {
            waitTime.until(ExpectedConditions.elementToBeClickable(myProfile));
            myProfile.click();
        } catch (TimeoutException toe) {
//            System.out.println(toe);
        }
    }

    public void goToWishlist (){
        wishlist.click();
    }

    public void goToNewsletter (){
        newsletter.click();
    }

//    public void goToInvoice (){
//        invoiceButton.click();
//    }

    //getters


    public WebElement getProfileImage() {
        return profileImage;
    }

    public WebElement getGreetingHeader() {
        return greetingHeader;
    }

    public WebElement getNameHeader() {
        return nameHeader;
    }

    public WebElement getTimeBar() {
        return timeBar;
    }

    public WebElement getDateBar() {
        return dateBar;
    }
}
