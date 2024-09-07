package ShoppersStack;



import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BSClass {
    protected ResponseSpecification responseSpec;
    protected static RequestSpecification requestSpec;
    protected String token; 

    @BeforeMethod
    public void loginToGenToken() {
        JSONObject jObj = new JSONObject();
        jObj.put("email", "aholkar01@gmail.com");
        jObj.put("password", "Akshay@6695");
        jObj.put("role", "SHOPPER");

        Response resp = given()
                .contentType(ContentType.JSON)
                .body(jObj)
                .when()
                .post("https://www.shoppersstack.com/shopping/users/login");

      //  resp.then().log().all();
        resp.then().statusCode(200);

        token = resp.jsonPath().getString("data.jwtToken");
        
        
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://www.shoppersstack.com/shopping");
        builder.setContentType("ContentType.JSON");
        builder.addHeader("Authorization", "Bearer " + token);
     
       // builder.setAuth(oauth2(token));

        requestSpec = builder.build();

        ResponseSpecBuilder rB = new ResponseSpecBuilder();
        rB.expectContentType("application/json");
        responseSpec = rB.build();

    }


}
