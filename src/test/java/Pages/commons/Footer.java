package Pages.commons;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Footer extends BasePage{

    public Footer(WebDriver driver) {
       super(driver);
        PageFactory.initElements(driver, this);

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
    @FindBy (xpath = "//*[@id=\"footer\"]/div/div[1]/div/ul/li/a/div")
    WebElement subscribeMessage;

    @FindBy (xpath = "/html/body/div[7]/div[1]/div[1]/a[1]/img")
    WebElement faceBookicon;
    @FindBy (xpath = "/html/body/div[7]/div[1]/div[1]/a[2]/img")
    WebElement twitterIcon;


    //METHODS:
//napisac metode do wpisania maila i submita

    public String alreadySubscribedMessage(){
        wait.until(ExpectedConditions.visibilityOf(subscribeMessage));
        LOGGER.debug("tekst z guzika " +subscribeMessage.getText());
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

    public WebElement getDoDna() {
        return doDna;
    }


    public Footer typeEmailToNewsletter(String email){
        emailField.clear();
        emailField.sendKeys(email);
        LOGGER.info("Current email: "+email);
        submitNewsletterButton.click();
        return this;
    }
    //method overloading to type random emails
    public Footer typeEmailToNewsletter(){
        emailField.clear();
        emailField.sendKeys(randomEmail);
        LOGGER.trace("Current email: "+randomEmail);
        submitNewsletterButton.click();
        return this;
    }



    public WebElement getFaceBookicon()
    {return faceBookicon;}
    public WebElement getTwitterIcon()
    {return twitterIcon;}
    public String getCurrentUrl() {
        String currentURL = driver.getCurrentUrl();
        LOGGER.debug("Current URL: " + currentURL);
        return currentURL;
    }
    public String getTitle() {
        String currentTitle = driver.getTitle();
        LOGGER.info("current title: "+ currentTitle);
        return currentTitle;
    }


}
