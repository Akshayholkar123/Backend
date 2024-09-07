package crudoperationwithBDD.copy;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutClass {
	@Test
	public void postDataToServer()
	{
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy","Akshay");
		jObj.put("status","Created");
		jObj.put("teamSize",10);
		jObj.put("projectName","Orange_003");
		
		
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj.toJSONString());
		
		Response resp = req.put("http://49.249.28.218:8091/project/NH_PROJ_443");
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
		
	}

}