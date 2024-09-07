package validateResponse;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;


//import static io.restassured.RestAssured.*;

import java.util.List;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import  io.restassured.response.Response;


public class ConditionBasedValidate
{
	@Test
	public void sampleTest2()
	{


		Response resp = given()
				.get("http://49.249.28.218:8091/projects-paginated");
		//.get("http://localhost:3000/user");

		//    resp.then().log().all();
		List<String> list=JsonPath.read(resp.asString(),".content[*].projectName"); //any column name
		for(String data : list)
		{
			System.out.println(data);
		}

		//         System.out.println(list);
		//        List<String> list=JsonPath.read(resp.asString(),".content[*].[?(@.projectName=='Airtel_801')].projectId");
		//        String actProjId=list.get(0);
		//        System.out.println(actProjId);
		//        Assert.assertEquals(actProjId,"NH_PROJ_994");
	}

}
