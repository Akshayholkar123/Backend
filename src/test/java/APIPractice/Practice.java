package APIPractice;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/*
 * @author - akshay
 */


public class Practice extends BaseClass {

	@Test
	public void getprojects()
	{
Response resp=given()
		.spec(requestSpec)		
		//.log().all()
		.when()
		.get("http://49.249.28.218:8091/projects");
		resp.then()
		.statusCode(200);
	//resp.then().log().all();	
//String id=resp.jsonPath().getString("[0].projectId");
//resp.then().body("[*].[?(@.projectId=='NH_PROJ_383']",equalTo("NH_PROJ_383"));
//String val=JsonPath.read(resp.asString(),"[*].[?(@.projectName=='Project Cipher')].projectId,status").toString();

//Example to fetch a single field where condition matches
String jsonPathExpr = "$[?(@.projectName=='Project Cipher')]";
List<Map<String, Object>> projects = JsonPath.read(resp.asString(), jsonPathExpr);

for (Map<String, Object> project : projects) {
 String projectId = (String) project.get("projectId");
 String status = (String) project.get("status");
 
 System.out.println(projectId+" "+status);
}





//System.out.println("Project name ==="+val);
//resp.then().body("content.projectId", hasItem("NH_PROJ_383"));

//resp.then().body("[0].projectId", equalTo("NH_PROJ_383"));

//System.out.println(" my project Id -"+id);
	}
}
//for(String v : val)
//{
//	System.out.println(v);
//}
