package ShoppersStack;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ShopperLogin extends BSClass {

    @Test
    public void login() {
        try {

           // BSClass baseClass = new BSClass();
Response response = given()
                    .spec(requestSpec)  // Use the requestSpec from BSClass instance
                    .when()
                    .post("https://www.shoppersstack.com/shopping/users/login")
                    .then()
                    .spec(responseSpec)
                    .log().all()
                    .extract().response();

            // Handle the response (e.g., check status code)
            int statusCode = response.getStatusCode();
            if (statusCode == 200) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed with status code: " + statusCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
