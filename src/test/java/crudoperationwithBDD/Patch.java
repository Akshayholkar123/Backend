package crudoperationwithBDD;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Patch {
	@Test
	public void postDataToServer()
	{
		JSONObject jObj=new JSONObject();
		//jObj.put("createdBy","Akshay");
		//jObj.put("status","Created");
		//jObj.put("teamSize",10);
		jObj.put("projectName","Orange_055");
		
		
		given()
		.contentType(ContentType.JSON)
		.body(jObj.toJSONString())
		.when()
		.patch("http://49.249.28.218:8091/project/NH_PROJ_294")
		
		.then()
		.assertThat().statusCode(200)

		
		.log().all();
	}

}
