package backendautomation;


	import static io.restassured.RestAssured.given;

	import java.util.Random;

	import org.hamcrest.Matchers;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.mysql.cj.jdbc.Driver;
import com.ninza.hrm.api.genericutility.DataBaseUtility;
import com.ninza.hrm.api.genericutility.ProFileUtility;

import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import jacksonSerialization.Project;

	import pOJO.EmpPojo;
	public class AddEmpWithoutEmail //with email for FW
	{
ProFileUtility fu=new ProFileUtility();
DataBaseUtility dBU=new DataBaseUtility();
		String expMsg="Successfully Added";
		Project pObj;
		Random ran=new Random();
		int num=ran.nextInt(100);

		@Test
		public void dBTest() throws Throwable  {
			String baseUrl=fu.getDataFromPropertiesFile("base_url");
			String	projName ="appolo"+num;
			String userName="Akshay"+num;
			pObj = new Project(projName,"OnGoing","Akshay",100); 
			Response resp = given()
					.contentType(ContentType.JSON)
					.body(pObj)
					.when()
					.post(baseUrl+"/addProject");
		//	.assertThat().contentType(ContentType.JSON)
			resp.then().log().all();

		
	//add employee to same project--------------------------------------
		
		EmpPojo empP=new EmpPojo("Astronot","06/06/1995","",userName,7,"9874563210",projName,"ROLE_EMPLOYEE","Akshay"+num);
		given()
		.contentType(ContentType.JSON)
		.body(empP)
		.when()
		.post(baseUrl+"/employees")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(500)
		.and()
		.time(Matchers.lessThan(6000L))
		.log().all();
		//.then().assertThat().contentType(ContentType.JSON).assertThat().statusCode(201).and().time(Matchers.lessThan(3000L)).log().all();
		//verify project inDB layer
		}
	}


