package crudoperationwithBDD.copy;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Delete {
	@Test
	public void getDataFromServer()
	{
		Response resp=RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_443");
		//System.out.println(resp.prettyPrint());
		resp.then().assertThat().statusCode(204);
		resp.then().log().all();
	}

}
