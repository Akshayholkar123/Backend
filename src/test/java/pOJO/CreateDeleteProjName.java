 package pOJO;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jacksonSerialization.Project;

public class CreateDeleteProjName 
{
	@Test
	public void postData() {

	Random ran=new Random();
	int num=ran.nextInt(100);
	Project pojo=new Project("ISRO"+num,"Created","Akshay",10);
	
	Response resp = given()
			.contentType(ContentType.JSON)
			.body(pojo)
			.when()
		//.get("http://49.249.28.218:8091/projects");

			.post("http://49.249.28.218:8091/addProject");
	        resp.then()
	        .assertThat().statusCode(201)
	        .log().all();
	        	        
	        String projectId=resp.jsonPath().get("projectId").toString();
	        String message=resp.jsonPath().get("msg").toString();
	        Assert.assertEquals("Successfully Added",message);
	        System.out.println(message);
	System.out.println(projectId);
	        
	        //Api request 2 Delete project
	        given()
	        .when()
	        .delete("http://49.249.28.218:8091/project/"+"NH_PROJ_2026")
	        .then().assertThat().statusCode(204)
	        .log().all();
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	
			
	
	
}
}