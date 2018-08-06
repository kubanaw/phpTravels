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

    public WebElement getDoDna() {
        return doDna;
    }


}
