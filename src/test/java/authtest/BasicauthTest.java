package authtest;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
public class BasicauthTest {
	@Test
	public void sampletTest()
	{
	Response resp = given()
		//.auth().basic("rmgyantra","rmgy@9999")
	.auth().digest("rmgyantra","rmgy@9999")

	//.auth().preemptive().basic("rmgyantra","rmgy@9999")
	//.auth().basic("rmgyantra","rmgy@9999")

		.log().all()
		.when()
		.get("http://49.249.29.5:8091/login");
		resp.then()
.statusCode(202)
		
		.log().all();
	String token=resp.jsonPath().get("jwtToken");
System.out.println("bearer -"+token);
		
	}

}
