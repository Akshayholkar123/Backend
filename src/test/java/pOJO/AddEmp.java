package pOJO;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jacksonSerialization.Project;

public class AddEmp 
{
	@Test
	public void addEmployee()
	{
		Random ran=new Random();
		int num=ran.nextInt(100);
		Project pojo=new Project("NASA"+num,"Created","Akshay",100);
		Response resp = given()
				.contentType(ContentType.JSON)
				.body(pojo)
				.when()
				.post("http://49.249.28.218:8091/addProject");
		        resp.then()
		        .assertThat().body("msg",Matchers.equalTo("Successfully Added"))
		       .assertThat().body("status",Matchers.equalTo("Created"))

		        .log().all();
		        
		        String projName=resp.jsonPath().getString("projectName");
		        System.out.println(projName);
		//Api Req 2 add employee to same project
//<constructor for ref -public EmpPojo(String designation, String dob, String email, String empName, double experience, String mobileNo,
	//String project, String role, String username) {

		EmpPojo empP=new EmpPojo("Astronot","06/06/1995","akshay@gmail.com","Akshay"+num,7,"9874563210",projName,"ROLE_EMPLOYEE","Akshay"+num);
		given()
		.contentType(ContentType.JSON)
		.body(empP)
		.when()
		.post("http://49.249.28.218:8091/employees");
		
		
		
		

	}

}
