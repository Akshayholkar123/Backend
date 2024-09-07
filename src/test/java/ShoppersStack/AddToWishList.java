package ShoppersStack;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
public class AddToWishList extends BSClass {

	@Test
	public void addToCart() {        
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("productId", 22);
		jsonObject.put("quantity", 1);

		//String jsonString = jsonObject.toString();

		Response response=  given()
				.spec(requestSpec)		

				.body(jsonObject.toJSONString())
				.pathParam("shopperId", 6585)   //

				.when()
				//.post("/shoppers/6585/wishlist")
				.post("/shoppers/{shopperId}/wishlist");

		response.then()
		.body("message",equalTo("Created"))
        //.body("fruits", hasItems("banana","Apple"))

				.log().all()
			.header("Connection","keep-alive")
				.statusCode(201);
//				.extract()
//				.response();
		
		String msg = response.jsonPath().getString("message");
//ValidatableResponse v=response.then().body("message",equalTo("Created"));

	Assert.assertEquals(msg,"Created");

		System.out.println(msg);


	}

	@Test(priority = 1)
	public void RemoveFromCart() {
		// Specify the base URL

		given()
		.spec(requestSpec)

		.pathParam("shopperId", "6585")
		.pathParam("productId", "22")
		.when()
		.delete("/shoppers/{shopperId}/wishlist/{productId}") 
		.then()
		.log().all()
		.statusCode(204);
	}

}
