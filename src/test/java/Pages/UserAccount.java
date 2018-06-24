package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccount {

    //fields

    WebDriver driver;

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

    @FindBy (xpath = "//*[@id=\"bookings\"]/div[2]/div[4]/a")
    private WebElement invoiceButton;

    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/strong[1]/div[1]")
    private WebElement timeBar;




}
