package parameters;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ParamPara {
	
	@Test
	public void sampleTest()
	{
	given()
	.log().all()

	.param("projectId","NH_PROJ_038")//if it is get request it act like query parameter
	.when()
	.get("http://49.249.28.218:8091/project")
	//.post("http://49.249.28.218:8091/project")

	.then()
	.log().all();
	
	}


}
