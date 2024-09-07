package API;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class WireMock {

    @Test
    public void postM() {
        // Create a JSON object with the required fields
        JSONObject jobj = new JSONObject();
        jobj.put("creditcard_number", "12345678910");
        jobj.put("cardname", "Akshay");
        jobj.put("cvv_num", "123");

         Response resp=given()
             //   .header("Content-Type", "application/json")
                .body(jobj.toJSONString()) 
                .when()
                .post("http://localhost:7777/payment1");

        resp.then().statusCode(201)

        .body("message", equalTo("card payment success."))
        .log().all();
            String var=resp.jsonPath().getString("status");
            System.out.println(" my print "+var);
       resp.then().body("status", equalTo("success"));


    }

}
