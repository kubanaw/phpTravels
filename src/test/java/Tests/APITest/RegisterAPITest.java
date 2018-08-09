package Tests.APITest;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RegisterAPITest {

    @BeforeClass
    public static void setUp() {

        RestAssured.baseURI = "https://www.phptravels.net";
        RestAssured.port = 443;


    }

    @Test
    public void givenProperDataThenShouldRegister() {

        given()
                .param("firstname", "Ewa")
                .param("lastname", "Kot")
                .param("email", "user@op.pl")
                .param("phone", "88768377372")
                .param("password", "alamakota12")
                .param("confirmpassword", "alamakota12")

        .when()
                .post("/account/signup")
        .then()
                .assertThat()
                .statusCode(200);

    }

}
