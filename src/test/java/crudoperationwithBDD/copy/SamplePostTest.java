package crudoperationwithBDD.copy;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
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
		jObj.put("teamSize",10);
		jObj.put("projectName","NASA_2040");
		
		
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj.toJSONString());//toJsonString not required now
		
		Response resp = req.post("http://49.249.28.218:8091/addProject");
		resp.then().log().all();
		resp.then().assertThat().statusCode(201);
		
	}

}
