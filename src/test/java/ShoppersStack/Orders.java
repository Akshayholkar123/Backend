package ShoppersStack;

import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Orders extends BSClass
{
	@Test
	public void getOders()
	{
	Response resp=	given()
		.spec(requestSpec)
		.pathParam("shopperId",6585)
		.when()
		.get("/shoppers/{shopperId}/orders");
	resp.then()
		.assertThat()
		.contentType("application/json")
		.statusCode(200)
		
		.log().all();
        String conn= resp.getHeader("Connection");
        
       // List<String> orderStatus = resp.jsonPath().getList("data.orderStatus");
        
        List<String> orderStatus1 = resp.jsonPath().getList("data.orderStatus", String.class);
        
        System.out.println("Extracted statuses: " + orderStatus1);

        // Expected list of statuses
        List<String> expectedStatuses = Arrays.asList("CANCELLED", "PLACED", "DELIVERED", "PLACED", "PLACED");

        Assert.assertEquals(orderStatus1, expectedStatuses, "The statuses did not match the expected values.");

        
        Assert.assertEquals(conn, "keep-alive", "The Connection header value did not match the expected value.");
    

	}

}
