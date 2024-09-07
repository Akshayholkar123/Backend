package APIPractice;


	import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


	public class BaseClass {
		protected static RequestSpecification requestSpec;
	    protected ResponseSpecification responseSpec;

		@BeforeTest
		public void beforeClass()
		{
			Response resp= given()
					.formParam("client_id","ninza-client")
					.formParam("client_secret","gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
					.formParam("grant_type","client_credentials")
					.when()
					.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");

			String token=resp.jsonPath().get("access_token");

			
			
			//capture token from the response {keyClock[oauth 2.0]}
			
			
			RequestSpecBuilder rB=new RequestSpecBuilder();
			rB.setBaseUri("");
			rB.setContentType("ContentType.JSON");
			rB.setAuth(oauth2(token));
			requestSpec=rB.build();
		}
		
		@AfterClass
		public void afterClass()
		{
			ResponseSpecBuilder res=new  ResponseSpecBuilder();
			res.expectContentType("application-Json");
		}
		
		
		
	}


