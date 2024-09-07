package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class FormParameter {
	
	@Test
	public void sampleTest()
	{
	given()
	.log().all()

	.formParam("projectId","NH_PROJ_038")
	.when()
	.post("http://49.249.28.218:8091/project")
	.then()
	.statusCode(200)
	.log().all();
	
	}


}
