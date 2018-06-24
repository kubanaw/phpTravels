package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavbarHeader {
    WebDriver driver;
    public NavbarHeader(WebDriver driver) {
      this.driver = driver;
    }

//ELEMENTS:
    @FindBy(className ="navbar-brand")
    WebElement logoButton;
    @FindBy(xpath = "*[@id=\"collapse\"]/ul[1]/li[1]/a")
    WebElement home;
    @FindBy(xpath = "*[@id=\"collapse\"]/ul[1]/li[2]/a")
    WebElement hotels;
    @FindBy(xpath = "*[@id=\"collapse\"]/ul[1]/li[3]/a")
    WebElement flights;
    @FindBy(xpath = "*[@id=\"collapse\"]/ul[1]/li[4]/a")
    WebElement tours;
    @FindBy(xpath ="*[@id=\"collapse\"]/ul[1]/li[5]/a")
    WebElement cars;
}


