package panCardMock;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class CreditCardPaymentTest {
	 
@Test
public void patmentTest()
{
//	String body="{\r\n"
//			+ "\"creditcard\":\"1234567891234\",\r\n"
//			+ "\"cvv\":\"123\",\r\n"
//			+ "\"cardName\":\"Akshay\"\r\n"
//			+ "}";
	JSONObject obj=new JSONObject();
	obj.put("creditcard","1234567891234");
	obj.put("cvv","123");
	obj.put("cardName","Akshay");	
	
	given()
	.contentType(ContentType.JSON)
	.body(obj)
	.when()
	.post("http://localhost:8889/credit-card")
	.then().log().all();
}
}
