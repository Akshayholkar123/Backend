package ShoppersStack;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import com.ninza.hrm.api.genericutility.ProFileUtility;

import static org.hamcrest.Matchers.*;

import java.util.List;

import io.restassured.response.Response;

public class APITest extends BSClass {
	ProFileUtility fu=new ProFileUtility();

	@Test
	public void get() throws Throwable
	{        
		Response res = given()
				.spec(requestSpec)
				.pathParam("shopperId","6585")
				.when()
				.get("/shoppers/{shopperId}/carts")
				.then().body("message",equalTo("Success"))
				.log().all()
				.statusCode(200)
				.spec(responseSpec)
				.time(lessThan(6000L))
				
			.extract().response();	
	String s=	res.jsonPath().getString("message");
		System.out.println(s+" my msg");

//		List<String> list = res.jsonPath().getList("user.roles");

		long responseTime = res.time();
		System.out.println("Response time: " + responseTime + " ms");
	}
}
