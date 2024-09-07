package Pleas;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TestScript {

	
	@Test
	public void Test() {
		Pojjo p=new Pojjo();
		p.setName("noushad");
		p.setJob("Qa");
		
		RestAssured.given().body(p).when().post("https://reqres.in/api/users")
		
		  .then().log().all();
		
	}
}
