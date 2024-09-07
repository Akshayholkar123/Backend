package ShoppersStack;

import org.json.simple.JSONObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

public class BaseClass {
    protected ResponseSpecification responseSpec;
    protected static RequestSpecification requestSpec;

    public BaseClass() {
        // Initialize Request and Response specifications
        initializeSpecifications();
    }

    // Method to initialize request and response specifications
    private void initializeSpecifications() {
        // Generate the Bearer token dynamically
        String token = generateBearerToken();

        // Initialize RequestSpecBuilder and set the base URL, content type, and authorization
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://www.shoppersstack.com/shopping");  // Replace with your actual base URL
        builder.setContentType(ContentType.JSON);
        builder.addHeader("Authorization", "Bearer " + token);  // Set the Authorization header

        // Build the request specification
        requestSpec = builder.build();
        
        // Initialize ResponseSpecBuilder
        ResponseSpecBuilder rB = new ResponseSpecBuilder();
        rB.expectContentType(ContentType.JSON);
        responseSpec = rB.build();
    }

    // Method to generate Bearer token dynamically
    private String generateBearerToken() {
        // Create the JSON object for the login payload
        JSONObject jObj = new JSONObject();
        jObj.put("email", "aholkar01@gmail.com");
        jObj.put("password", "Akshay@6695");
        jObj.put("role", "SHOPPER");

        // Make a POST request to the authentication endpoint to get the token
        String token = given()
            .baseUri("https://www.shoppersstack.com/shopping")  // Replace with your actual base URI for authentication
            .contentType(ContentType.JSON)
            .body(jObj.toString())
            .post("/users/login")  // Replace with your actual authentication endpoint
            .then()
            .extract()
            .path("jwtToken");  // Replace "token" with the actual JSON path to the token in the response
System.out.println(token);
        return token;
    }
}
