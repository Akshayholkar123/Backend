package crudoperationwithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.response.ValidatableResponse;

public class GetWithBDD 
{
    @Test
    public void getTest() {        
        ValidatableResponse resp = given()
        //.contentType(ContentType.JSON.toString()) // Uncomment if you need to set the content type
        .when()
        //.get("http://49.249.28.218:8091/project/NH_PROJ_294") // Uncomment if you need to test with this URL
        .get("http://localhost:3000/user")
        .then()
        .statusCode(200)
        .assertThat()
 .time(lessThan(2000L))  // Validate that the response time is less than 2000 milliseconds

        .log().all();
        
        long time = resp.extract().time(); // Use 'extract().time()' to get the response time
        System.out.println("Response time: " + time + " ms");
    }
}
