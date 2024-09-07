package authtest;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginAccesstoken 
{
	@Test
	public void getTokenAndLogin()
	{
		Login l=new Login("rmgy@9999","rmgyantra");
		Response resp= given()
				
				.contentType(ContentType.JSON)
				
				.body(l)
				.when()
				.post("http://49.249.28.218:8091/login");
		resp.then()
		.log().all();
		//capture token from the response {keyClock[oauth 2.0]}
		String token=resp.jsonPath().get("access_token");
		given()
		.auth().oauth2(token)
		.log().all()
		.when()
		.get("http://49.249.28.218:8091/admin/payrolls")
		.then()
		.log().all();
	}

}
