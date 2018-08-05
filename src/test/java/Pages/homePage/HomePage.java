package Pages.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    //TODO refactor (input homepage) THIS CLASS! Is the same as NavbarHeader -Kuba You must refactor your DisplayCurrenciesTest

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/a/strong")
    private WebElement currentCurrency;

    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[2]/a")
    private WebElement GBPCurrency;

    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/a")
    private WebElement currencyList;

    public void setCurrency(String currency){
        currencyList.click();
        driver.findElement(By.linkText(currency)).click();
    }

    public WebElement getCurrentCurrency() {
        return currentCurrency;
    }

    public WebElement getGBPCurrency() {
        return GBPCurrency;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
