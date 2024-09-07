package backendautomation;


import java.util.Random;

import org.eclipse.jetty.util.ajax.JSON;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.api.genericutility.DataBaseUtility;
import com.ninza.hrm.api.genericutility.ProFileUtility;

import io.restassured.http.ContentType;
import jacksonSerialization.Project;
import static io.restassured.RestAssured.*;


public class VerifyDBAndApiCreatingProj {
	String expMsg="Successfully Added";
	public Project pObj;
	public String projName;
	static ProFileUtility fu=new ProFileUtility();

	@Test
	public void dBTest() throws Throwable {
		String BaseUrl=fu.getDataFromPropertiesFile("Base_url");
		Random ran=new Random();
		int num=ran.nextInt();
	    projName ="appolo"+num;
		  pObj = new Project(projName,"OnGoing","Akshay",100); 
		  given()
			  .contentType(ContentType.JSON)
			  .body(pObj)
			  .when()
			  .post(BaseUrl+"/addProject") 
		 .then().assertThat().statusCode(201).assertThat().time(Matchers.lessThan(7000L))
		 .assertThat().contentType(ContentType.JSON)
		 
		 .log().all();
 //Assert.assertEquals(expMsg,resp.jsonPath().get("msg"));
 
 //verify project name indata base--------------------------
 DataBaseUtility dBU=new DataBaseUtility();
 dBU.connectToDB();
 boolean flag=dBU.verifyDbData("select * from project",4, projName);
Assert.assertTrue(flag,"Projectb in DB not verified");
//second string execute if assertion failed
 
 dBU.closeDB();
}
	
	
	
	
	@Test(dependsOnMethods = "dBTest")
	public void createDuplicateProjTest() throws Throwable
	{
		ProFileUtility fu=new ProFileUtility();
		String BaseUrl=fu.getDataFromPropertiesFile("Base_url");

		given()
		.contentType(ContentType.JSON)
        .body(pObj)
        .when()
		  .post(BaseUrl+"/addProject")
		  .then()
		  .assertThat().statusCode(409)
		  .log().all();

        
	
	
	}
	
	
	
	
	
	
	
	
}