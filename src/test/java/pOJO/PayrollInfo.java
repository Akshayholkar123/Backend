package pOJO;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PayrollInfo {

	@Test
	public void getPayInfo()
	{
		//Api req 1 get access token
		Response resp=given()
				.formParam("client_id","ninza-client")
				.formParam("client_secret","gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
				.formParam("grant_type","client_credentials")
				.when()
				.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		//because this is post req but we not going to create resources we get token by posting this info

		resp.then()
		.log().all();
		
		//capture the token from response
		String token=resp.jsonPath().get("access_token");
		//Api req 2 get payroll info 
		given()
		.auth().oauth2(token)
		//.get("http://49.249.28.218:8091/admin/payrolls")
		.get("http://49.249.28.218:8091/admin/payrolls")

		.then()
		.statusCode(200)
		.log().all();
				
	}
}
