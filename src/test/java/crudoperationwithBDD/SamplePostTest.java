package crudoperationwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SamplePostTest {
	@Test
	public void postDataToServer()
	{
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy","Akshay");
		jObj.put("status","Created");
		jObj.put("teamSize",0);
		jObj.put("projectName","Orange_004");
		
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj.toJSONString())
		.when()
		.post("http://49.249.28.218:8091/addProject")
		
		.then()
		.assertThat().statusCode(201)

		
		.log().all();
		
	}

}
