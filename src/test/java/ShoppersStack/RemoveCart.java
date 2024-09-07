package ShoppersStack;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class RemoveCart extends BSClass{
    @Test
    public void addToCart() {
        // Specify the base URL

        // Setting up the request specification
                given()
                .spec(requestSpec)

            .pathParam("shopperId", "6585")
            .pathParam("productId", "22")
        .when()
            .delete("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/wishlist/{productId}") 
            .then()
            .log().all()
            .statusCode(204);
    }
}
