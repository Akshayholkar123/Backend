package validateResponse;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VeriftHeader
{
	@Test
	public void verfyWithHeadertest()
	{
		 Response resp = given() 
				 .when()
				.get("http://49.249.28.218:8091/projects");
		 resp.then().log().all();
		 
		 resp.then().assertThat().statusCode(200);
		 
		 resp.then().assertThat().contentType("application/json");
		 
		 resp.then().assertThat().statusLine("HTTP/1.1 200 ");
		 
		 resp.then().assertThat().header("Transfer-Encoding","chunked");

		 
		 
		 resp.then().assertThat().time(Matchers.lessThan(900l));
		 resp.then().assertThat().time(Matchers.greaterThan(300l));

		 resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900l)).and(Matchers.greaterThan(300l)));

		
	}

}
