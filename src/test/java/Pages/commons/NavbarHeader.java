package Pages.commons;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class NavbarHeader extends BasePage {


    @FindBy(className = "navbar-brand")
    private WebElement logoButton;
    @FindBy(xpath = "//a[text()='Home']")
    private WebElement home;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[2]/a")
    private WebElement hotels;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[3]/a")
    private WebElement flights;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[4]/a")
    private WebElement tours;
    @FindBy(xpath = ".//*[@id=\"collapse\"]/ul[1]/li[5]/a")
    private WebElement cars;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[6]/a")
    private WebElement visa;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[7]/a")
    private WebElement offers;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[8]/a")
    private WebElement blog;
    //CURRENCY
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul")
    private WebElement currency;
    //LANGUAGE OPTIONS
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/ul/li/ul")
    private WebElement language;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/a/strong")
    private WebElement currentCurrency;

    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[2]/a")
    private WebElement GBPCurrency;

    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/a")
    private WebElement currencyList;

    public NavbarHeader(WebDriver driver) {

        super(driver);
    }

    //METHODS for elements:
    public void openMainPage() {
        driver.get(BASE_URL);
    }


    public void pickHomeElement() {
        home.click();
    }

    public void pickHotelsElement() {
        hotels.click();
    }

    public void pickFlightsElement() {
        flights.click();
    }

    public void pickToursElement() {
        tours.click();
    }

    public void pickCarsElement() {
        cars.click();
    }

    public void pickVisaElement() {
        visa.click();
    }

    public void pickHOffersElement() {
        offers.click();
    }

    public void pickBlogElement() {
        blog.click();
    }


    public void setCurrency(String currency) {
        currencyList.click();
        driver.findElement(By.linkText(currency)).click();
    }

    public WebElement getCurrentCurrency() {
        return currentCurrency;
    }


}





