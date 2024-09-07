package API;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class CreatePetRequest {
    public static void main(String[] args) {
        JSONObject tag = new JSONObject();
        tag.put("id", 1);
        tag.put("name", "friendly");

        JSONArray tags = new JSONArray();
        tags.add(tag);  

        JSONObject category = new JSONObject();
        category.put("id", 1);
        category.put("name", "Dog");

        JSONArray photoUrls = new JSONArray();
        photoUrls.add("https://example.com/doggie-photo.jpg");  

        JSONObject pet = new JSONObject();
        pet.put("id", 12345);
        pet.put("category", category);
        pet.put("name", "doggie");
        pet.put("photoUrls", photoUrls);
        pet.put("tags", tags);
        pet.put("status", "available");

        System.out.println(pet.toJSONString());
        
        RestAssured.given()
        .contentType(ContentType.JSON)  
        .body(pet.toJSONString())
        .when()
        .post("https://petstore.swagger.io/v2/pet")  
        .then()
        .statusCode(200)  
        .log().all();  

    }
}
