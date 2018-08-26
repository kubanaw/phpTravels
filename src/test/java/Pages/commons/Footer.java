package Pages.commons;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Footer extends BasePage {

    //Newsletter:
    @FindBy(id = "exampleInputEmail1")
    private WebElement emailField;
    //    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[1]/div/div[2]/button")
    @FindBy(css = "button.sub_newsletter")
    private WebElement submitNewsletterButton;

    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[2]/ul/li[1]/a")
    private WebElement contactLink;

    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[2]/ul/li[2]/a")
    private WebElement aboutUS;

    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[2]/ul/li[3]/a")
    private WebElement howToBook;

    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[2]/ul/li[4]/a")
    private WebElement bookingTips;

    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[3]/ul/li[1]/a")
    private WebElement ourPartners;

    @FindBy(xpath = "//*[@id=\"footer\"]/div/div[1]/div/ul/li/a/div")
    private WebElement subscribeMessage;

    @FindBy(xpath = "/html/body/div[7]/div[1]/div[1]/a[1]/img")
    private WebElement faceBookIcon;

    @FindBy(xpath = "/html/body/div[7]/div[1]/div[1]/a[2]/img")
    private WebElement twitterIcon;

    public Footer(WebDriver driver) {
        super(driver);

    }

    //METHODS:

    public String alreadySubscribedMessage() {
        wait.until(ExpectedConditions.visibilityOf(subscribeMessage));
        LOGGER.debug("tekst z guzika " + subscribeMessage.getText());
        return subscribeMessage.getText();
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


    public Footer typeEmailToNewsletter(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        LOGGER.info("Current email: " + email);
        submitNewsletterButton.click();
        return this;
    }

    //method overloading to type random emails
    public Footer typeEmailToNewsletter() {
        emailField.clear();
        emailField.sendKeys(randomEmail);
        LOGGER.trace("Current email: " + randomEmail);
        submitNewsletterButton.click();
        return this;
    }


    public WebElement getFaceBookIcon() {
        return faceBookIcon;
    }

    public WebElement getTwitterIcon() {
        return twitterIcon;
    }


    public String getTitle() {
        String currentTitle = driver.getTitle();
        LOGGER.info("current title: " + currentTitle);
        return currentTitle;
    }


}
