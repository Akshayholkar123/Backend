package validateResponse;

import org.hamcrest.Matchers;


import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.List;


import  io.restassured.response.Response;

public class JsonPath1
{
	@Test
	public void sampleTest()
	{
	Response resp= given()

			        .get("http://49.249.28.218:8091/projects-paginated");
			//.get("http://localhost:3000/user");
	                  resp.then().log().all();
	                 // List<String> list=JsonPath.read(resp.asString(),".content[*].projectName");
	                 List<String> list = JsonPath.read(resp.asString(),"JsonPath");
	                  resp.then().assertThat().body("numberOfElements",Matchers.equalTo(20));
	                  resp.then().assertThat().body("pagebale.sort.unsorted",Matchers.equalTo(true));
	                  
	                  resp.then().assertThat().body("content[0].projectId",Matchers.equalTo("NH_PROJ_024"));
	                  
//	                  int  data=resp.jsonPath().get("numberOfElements");
//	                  System.out.println(data);
//	                  //Assert.assert testNg assertion
//	                  boolean data1 = resp.jsonPath().get("pagebale.sort.unsorted");
//	                  
//	                  System.out.println(data1);
//	                  String data3=resp.jsonPath().get("content[0].projectId");
//	                  System.out.println(data3);
	}



}
