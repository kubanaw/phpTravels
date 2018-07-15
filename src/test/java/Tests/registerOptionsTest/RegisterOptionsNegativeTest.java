package Tests.registerOptionsTest;

import Pages.RegisterPage;
import Pages.UserAccount;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RegisterOptionsNegativeTest {
    private WebDriver driver;
    private RegisterPage registerPage;
    private WebDriverWait wait;
    private UserAccount userAccount;

    @Parameter()
    public String firstName;
    @Parameter(1)
    public String lastName;
    @Parameter(2)
    public String phone;
    @Parameter(3)
    public String email;
    @Parameter(4)
    public String password;
    @Parameter(5)
    public String confirmPassword;

    @Parameters(name = "Test {index}: First name: {0}, Last name: {1}, Phone: {2}, " +
            "E-mail: {3}, Password: {4}, confirm: {5}")

    public static Collection<Object[]> dataForRegisterOption() {
        return Arrays.asList(new Object[][]{
                {"", "Moczymorda","788990333", "j37756@nwytg.com", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "","788990333", "j3776666@nwytg.com", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymorda","788990333", "", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymorda","788990333", "j355776@nwytg.com", "", ""},
                {"Gerwazy", "Moczymorda","788990333", "j3776nwytg.com", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymorda","788990333", " j3776@nwytg.com", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymorda","788990333", "j3776@nwytg.com  ", "M4ki3t9!", "M4ki3t9!"},
                {"Gerwazy", "Moczymorda","788990333", "j3776@nwytg.com", "M4ki3", "M4ki3"},

        });
    }


}
