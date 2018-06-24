package Tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ChromeDrvPathHelper;

public class RegisterOptionsTest {

    private WebDriver driver;

    @BeforeClass
    public static void ustawSciezke() {
        //PATH WILL CHANGE BASED ON OS through: util/ChromeDrvPathHelper
        ChromeDrvPathHelper.setChromeDrvPath();
    }

    @Before
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.get("https://www.phptravels.net/register");
    }

    @After
    public void CloseBrowser() {
        this.driver.quit();
    }

    //positive cases:

    @Test
    public void whenAllNecessaryFieldsAreFilledThenUserShouldRegister() {

        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("email")).sendKeys("j3686875@nwytg.com");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t9!");

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/account/");

    }

    @Test
    public void whenAllFieldsAreFilledThenUserShouldRegister() {

        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("phone")).sendKeys("0048664111332");
        this.driver.findElement(By.name("email")).sendKeys("j3686875@nwytg.com");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t9!");

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/account/");

    }


    //negative cases:

    @Test
    public void whenAllFieldsAreNotFilledThenUserShouldNotRegister() {

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String message = this.driver.findElement(By.className("alert-danger")).getText();
//        System.out.println(message);
        Assert.assertEquals(message, "The Email field is required.\nThe Password field is required.\nThe Password field is required." +
                "\nThe First name field is required.\nThe Last Name field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");


    }

    @Test
    public void whenUserFirstNameFieldIsNotFillThenUserShouldNotRegister() {

        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("phone")).sendKeys("0048664111332");
        this.driver.findElement(By.name("email")).sendKeys("j3686875@nwytg.com");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t9!");
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String message = this.driver.findElement(By.className("alert-danger")).getText();
        Assert.assertEquals(message, "The First name field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");


    }

    @Test
    public void whenUserLastNameFieldIsNotFillThenUserShouldNotRegister() {

        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("phone")).sendKeys("0048664111332");
        this.driver.findElement(By.name("email")).sendKeys("j3686875@nwytg.com");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t9!");

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = this.driver.findElement(By.className("alert-danger")).getText();
        Assert.assertEquals(message, "The Last Name field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");


    }

    @Test
    public void whenUserEmailFieldIsNotFillThenUserShouldNotRegister() {

        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("phone")).sendKeys("0048664111332");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t9!");

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = this.driver.findElement(By.className("alert-danger")).getText();
        Assert.assertEquals(message, "The Email field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");


    }

    @Test
    public void whenUserPasswordFieldNotFillThenUserShouldNotRegister() {

        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("phone")).sendKeys("0048664111332");
        this.driver.findElement(By.name("email")).sendKeys("j3686875@nwytg.com");

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String message = this.driver.findElement(By.className("alert-danger")).getText();
//        System.out.println(message);
        Assert.assertEquals(message, "The Password field is required.\nThe Password field is required.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");


    }

    //e-mail field validation

    @Test

    public void whenEmailFieldHasInvalidValueThenUserShouldNotRegister() {

        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("email")).sendKeys("j3686875nwytg.com");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t9!");

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = this.driver.findElement(By.className("alert-danger")).getText();
//        System.out.println(message);
        Assert.assertEquals(message, "The Email field must contain a valid email address.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");


    }

    @Test

    public void whenEmailFieldHasWhiteSpaceBeforeThenUserShouldNotRegister() {

        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("email")).sendKeys(" j3686875@nwytg.com");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t9!");

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = this.driver.findElement(By.className("alert-danger")).getText();
//        System.out.println(message);
        Assert.assertEquals(message, "The Email field must contain a valid email address.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    @Test

    public void whenEmailFieldHasWhiteSpaceAfterThenUserShouldNotRegister() {

        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("email")).sendKeys("j3686875@nwytg.com ");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t9!");

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = this.driver.findElement(By.className("alert-danger")).getText();
//        System.out.println(message);
        Assert.assertEquals(message, "The Email field must contain a valid email address.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    //password field validation:

    @Test

    public void whenPasswordHasLessThanSixCharThenUserShouldNotRegister() {

        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("email")).sendKeys("j3686875@nwytg.com");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3");

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = this.driver.findElement(By.className("alert-danger")).getText();
//        System.out.println(message);
        Assert.assertEquals(message, "The Password field must be at least 6 characters in length.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }

    @Test

    public void whenPasswordHasSixCharThenUserShouldRegister() {

        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("email")).sendKeys("j3686875@nwytg.com");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t");

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/account/");

    }
    @Test

    public void whenConfirmPasswordIsInaccurateThenUserShouldNotRegister() {

        this.driver.findElement(By.name("firstname")).sendKeys("Gerwazy");
        this.driver.findElement(By.name("lastname")).sendKeys("Moczymorda");
        this.driver.findElement(By.name("email")).sendKeys("j3686875@nwytg.com");
        this.driver.findElement(By.name("password")).sendKeys("M4ki3t9!");
        this.driver.findElement(By.name("confirmpassword")).sendKeys("M4ki3t");

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.driver.findElement(By.xpath("/html/body/div[4]/section/div/div/div/div/div[2]/div/form/div[9]/button")).click();

        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message = this.driver.findElement(By.className("alert-danger")).getText();
//        System.out.println(message);
        Assert.assertEquals(message, "Password not matching with confirm password.");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://www.phptravels.net/register");

    }




}