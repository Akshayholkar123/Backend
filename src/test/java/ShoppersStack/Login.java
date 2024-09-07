package ShoppersStack;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Login {
	@Test
	public void loginToGenToken() {
    JSONObject jObj = new JSONObject();
    jObj.put("email", "aholkar01@gmail.com");
    jObj.put("password", "Akshay@6695");
    jObj.put("role", "SHOPPER");
Response resp=given()
	.contentType(ContentType.JSON)
	.body(jObj)
	.when()
	.post("https://www.shoppersstack.com/shopping/users/login");
resp.then().log().all();
resp.then().statusCode(200);
 String token=resp.jsonPath().getString("data.jwtToken");
	System.out.println("my token -"+token);
	
	

}
}
