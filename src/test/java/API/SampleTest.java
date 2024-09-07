package API;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleTest {


	@Test
	public void sampleGetReqTest()
	{

		//to perform this method chaining static import is mandatory
		//Response resp=	RestAssured.get("https://reqres.in/api/users?page=2");
		get("https://reqres.in/api/users?page=2")
		.then()
		.log()
		.all();
		//System.out.println(resp.prettyPrint());
	}

}
