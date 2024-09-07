package crudoperationwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class Delete {
	@Test
	public void delete()
	{
		given()

		.when()
		.delete("http://49.249.28.218:8091/project/NH_PROJ_473")
		.then()
		.statusCode(204)

		.log().all();
	}

}
