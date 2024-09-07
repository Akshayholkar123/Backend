package parameters;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSender;

public class QueryParam 
{
	@Test
	public void sampleTest()
	{
	given()
	.queryParam("teamSize",10)
	//.log().all()

	.when()
	//.get("http://49.249.28.218:8091/project?projectId=NH_PROJ_038")

	.get("http://49.249.28.218:8091/project")
	.then()
	.log().all();
		//RequestSender.po
	
	}


}
