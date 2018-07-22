package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavbarHeader {
    WebDriver driver;

    public NavbarHeader(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "navbar-brand")
    WebElement logoButton;
    @FindBy(xpath = "//a[text()='Home']")
    WebElement home;
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[1]/li[2]/a")
    WebElement hotels;
    @FindBy(css = ".loader title=Flights")
    WebElement flights;
    @FindBy(css = ".loader title=Tours")
    WebElement tours;
    @FindBy(css = ".loader title=Cars")
    WebElement cars;
    @FindBy(css = ".loader title=Ivisa")
    WebElement visa;
    @FindBy(xpath = ".loader title=Offers")
    WebElement offers;
    @FindBy(xpath = ".loader title=Blog")
    WebElement blog;

    //MY ACCOUNT
    @FindBy(id = "li_myaccount")
    WebElement myAccountDropdown;
    @FindBy(xpath = "//*[@id=\"li_myaccount\"]/ul/li[1]/a")
    WebElement loginFromMyAccountDropdown;
    @FindBy(linkText = "Sign Up")
    WebElement signFromMyAccountDropdown;

    //CURRENCY
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul")
    WebElement currency;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[2]/a")
//    WebElement currencyGBP;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[3]/a")
//    WebElement currencySAR;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[4]/a")
//    WebElement currencyEUR;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[5]/a")
//    WebElement currencyPKR;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[6]/a")
//    WebElement currencyKWD;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[7]/a")
//    WebElement currencyJPY;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[8]/a")
//    WebElement currencyINR;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[9]/a")
//    WebElement currencyCNY;
//    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/li[2]/ul/li[10]/a")
//    WebElement currencyTRY;

    //LANGUAGE OPTIONS
    @FindBy(xpath = "//*[@id=\"collapse\"]/ul[2]/ul/ul/li/ul")
    WebElement language;
//    @FindBy(xpath = "//*[@id=\"ar\"]")
//    WebElement ArabicLanguage;
//    @FindBy(xpath = "//*[@id=\"tr\"]")
//    WebElement TurkishLanguage;
//    @FindBy(xpath = "//*[@id=\"fr\"]")
//    WebElement FrenchLanguage;
//    @FindBy(xpath = "//*[@id=\"es\"]")
//    WebElement SpanishLanguage;
//    @FindBy(xpath = "//*[@id=\"ru\"]")
//    WebElement RussianLanguage;
//    @FindBy(xpath = "//*[@id=\"en\"]")
//    WebElement EnglishLanguage;

//METHODS for elements:
    public void openMainPage() {
        driver.get("https://www.phptravels.net/");
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

    // METHODS for accountDropdown
    public void loginToMyAccount() {
        myAccountDropdown.click();
        loginFromMyAccountDropdown.click();

    }

    public void SignInMyAccount() {
        myAccountDropdown.click();
        signFromMyAccountDropdown.click();
    }
//    //METHODS for currency, not sure it works
//    public String pickCurrency(String text) {
//        Select currencyList = new Select(currency);
//        currencyList.selectByValue(text);
//
//        LOGGER.info("Currency chosen" + text);
//        LOGGER.log(Level.INFO, "Currency selected: " + currency.getAttribute("value"));
//        return currency.getAttribute("value");
   // }


    //METHODS for currency
//    public String pickCurrency(String text) {
//        Select currencyList = new Select(currency());
//        currencyList.selectByValue(text);

//        LOGGER.info("Currency chosen" + text);
//        LOGGER.log(Level.INFO, "Currency selected: " + currency.getAttribute("value"));
//        return currency.getAttribute("value");
//    }

//przerwalam tworzenie, metody rozwijania z listy beda dodane
}





