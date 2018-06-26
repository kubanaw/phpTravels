package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.XMLFormatter;

public class NavbarHeader {
    WebDriver driver;
    public NavbarHeader(WebDriver driver) {
      this.driver = driver;
    }

//ELEMENTS:
    @FindBy(className ="navbar-brand")
    WebElement logoButton;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[1]/a")
    WebElement home;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[2]/a")
    WebElement hotels;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[3]/a")
    WebElement flights;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[4]/a")
    WebElement tours;
    @FindBy(xpath ="//*[@id=\"collapse\"]/ul[1]/li[5]/a")
    WebElement cars;
    @FindBy(xpath ="//*[@id=\"collapse\"]/ul[1]/li[6]/a")
    WebElement visa;
    @FindBy(xpath ="//*[@id=\"collapse\"]/ul[1]/li[7]/a")
    WebElement offers;
    @FindBy(xpath ="//*[@id=\"collapse\"]/ul[1]/li[8]/a")
    WebElement blog;

    //MY ACCOUNT
    @FindBy(xpath = "//*[@id=\"li_myaccount\"]/a")
    WebElement myAccountDropdown;
    @FindBy(xpath = "//*[@id=\"li_myaccount\"]/ul/li[1]/a")
    WebElement loginFromMyAccountDropdown;
    @FindBy(xpath = "//*[@id=\"li_myaccount\"]/ul/li[2]/a")
    WebElement signFromMyAccountDropdown;

    //CURRENCY
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[1]/a")
    WebElement currencyUSD;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[2]/a")
    WebElement currencyGBP;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[3]/a")
    WebElement currencySAR;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[4]/a")
    WebElement currencyEUR;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[5]/a")
    WebElement currencyPKR;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[6]/a")
    WebElement currencyKWD;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[7]/a")
    WebElement currencyJPY;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[8]/a")
    WebElement currencyINR;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[9]/a")
    WebElement currencyCNY;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[10]/a")
    WebElement currencyTRY;

    //LANGUAGE OPTIONS
    @FindBy(xpath = "//*[@id=\"ar\"]")
    WebElement ArabicLanguage;
    @FindBy(xpath = "//*[@id=\"tr\"]")
    WebElement TurkishLanguage;
    @FindBy(xpath = "//*[@id=\"fr\"]")
    WebElement FrenchLanguage;
    @FindBy(xpath = "//*[@id=\"es\"]")
    WebElement SpanishLanguage;
    @FindBy(xpath = "//*[@id=\"ru\"]")
    WebElement RussianLanguage;
    @FindBy(xpath = "//*[@id=\"en\"]")
    WebElement EnglishLanguage;

//METHODS for elements:
    public void pickHomeElement() {
        home.click();
    }
    public void pickHotelsElement() {
        hotels.click();
    }
    public void pickFlightsElement() {
        flights.click();
    }
    public void pickToursElement(){
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

   // METHODS for accountDropdown
   public void loginToMyAccount() {
        myAccountDropdown.click();
        loginFromMyAccountDropdown.click();
   }
    public void SignInMyAccount() {
        myAccountDropdown.click();
        signFromMyAccountDropdown.click();
    }
    //METHODS for currency
//przerwalam tworzenie, metody rozwijania z listy beda dodane


}


