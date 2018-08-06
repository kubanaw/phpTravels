package Pages.commonPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Footer {
    WebDriver driver;
    public Footer(WebDriver driver) {
        this.driver = driver;
    }
//Newsletter:
    @FindBy(id="exampleInputEmail1")
    WebElement emailField;
    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[1]/div/div[2]/button")
    WebElement submitNewsletterButton;
    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[2]/h2")
    WebElement doDna;
    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[2]/ul/li[1]/a")
    WebElement contactLink;
    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[2]/ul/li[2]/a")
    WebElement aboutUS;
    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[2]/ul/li[3]/a")
    WebElement howToBook;
    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[2]/ul/li[4]/a")
    WebElement bookingTips;
    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[3]/ul/li[1]/a")
    WebElement ourPartners;

    //METHODS:
//napisac metode do wpisania maila i submita

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getSubmitNewsletterButton() {
        return submitNewsletterButton;
    }

    public WebElement getContactLink() {
        return contactLink;
    }

    public WebElement getAboutUS() {
        return aboutUS;
    }

    public WebElement getHowToBook() {
        return howToBook;
    }

    public WebElement getBookingTips() {
        return bookingTips;
    }

    public WebElement getOurPartners() {
        return ourPartners;
    }

    public WebElement getDoDna() {
        return doDna;
    }


}
