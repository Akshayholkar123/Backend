 package ShoppersStack;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.matcher.*;
import io.restassured.response.Response;

public class CartEndToEnd extends BSClass {
    String itemid ;

    @Test(priority = 0)
    public void addToCart() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("productId", 22);
        jsonObject.put("quantity", 1);

        String jsonString = jsonObject.toString();

        Response response = given()
                .spec(requestSpec)
                .body(jsonString)
                .pathParam("shopperId", 6585)
                .when()
                .post("/shoppers/{shopperId}/carts");
        response .then()
                .log().all()
                .statusCode(201)
                .extract()
                .response();


        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        String msg = response.jsonPath().getString("message");
        itemid = response.jsonPath().getString("data.itemId");

        Assert.assertEquals(msg, "Created");


        System.out.println("Item ID: " + itemid);
    }
    @Test
    public void get()
    {
    given()
    .pathParam("shopperId", 6585)

    .queryParam("message","Success")
    .spec(requestSpec)
    .when()
    .get("/shoppers/{shopperId}/carts")
    .then()
    .log().all()
    .statusCode(200);
    
    }

    @Test(priority = 1)
    public void updateCart() {
        // Ensure itemid is not null or empty
//        Assert.assertNotNull(itemid, "Item ID should not be null");
//        Assert.assertFalse(itemid.isEmpty(), "Item ID should not be empty");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("productId", 22);
        jsonObject.put("quantity", 3);  // Ensure quantity is an integer

        String jsonString = jsonObject.toString();

        Response response = given()
                .spec(requestSpec)
                .body(jsonString)
                .pathParam("shopperId", "6585")
                .pathParam("itemId", itemid)
                .when()
                .put("/shoppers/{shopperId}/carts/{itemId}");

        response.then()
                .log().all()
                .statusCode(200);
        String quant=response.jsonPath().getString("data.quantity");
System.out.println("cart item qauntity is :- "+quant);
        
    }

    
    
    @Test(priority = 2)
    public void removeFromCart() {
        given()
                .spec(requestSpec)
                .pathParam("shopperId", "6585")
                .pathParam("productId", "22")
                .when()
                .delete("/shoppers/{shopperId}/carts/{productId}")
                .then()
             //   .body("status",equalTo("Created"))
                .log().all()
                .statusCode(200);
        
        System.out.println("======passed======");
    }

}