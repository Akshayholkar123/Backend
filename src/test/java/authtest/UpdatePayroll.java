 package authtest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import io.restassured.response.Response;

public class UpdatePayroll {
    @Test
    public void payrollTest() throws Exception {
        A ed = new A();
       // String jBody = "{ \"employee\": { \"empId\": \"NH_PROJ_1444\", \"designation\": \"Software Engineer\", \"dob\": \"01/01/1895\", \"email\": \"employee@example.com\", \"empName\": \"John_Doe\", \"experience\": 5.5, \"mobileNo\": \"1234567890\", \"project\": \"ProjectX\", \"role\": \"Developer\", \"username\": \"johndoe\" }, \"basicPlusVda\": 50000, \"hra\": 20000, \"insurance\": 5000, \"lta\": 10000, \"lwf\": 200, \"netPay\": 72000, \"payroll_id\": 101, \"pf\": 6000, \"pt\": 200, \"stat_bonus\": 3000, \"status\": \"Active\" }";
      //  String jBody = "{ \"employee\": { \"empId\": \"NH_PROJ_00133\", \"designation\": \"Software Engineer\", \"dob\": \"01/01/1895\", \"email\": \"employee@example.com\", \"empName\": \"John_Doe\", \"experience\": 5.5, \"mobileNo\": \"1234567890\", \"project\": \"ProjectX\", \"role\": \"Developer\", \"username\": \"johndoe\" }, \"basicPlusVda\": 50000, \"hra\": 20000, \"insurance\": 5000, \"lta\": 10000, \"lwf\": 200, \"netPay\": 72000, \"payroll_id\": 101, \"pf\": 6000, \"pt\": 200, \"stat_bonus\": 3000, \"status\": \"Active\" }";
        String jBody = "{ \"employee\": { \"empId\": \"NH_00127\", \"designation\": \"Manager\", \"dob\": \"02/02/1997\", \"email\": \"ah@gmail.com\", \"empName\": \"Akshay\", \"experience\": 5.0, \"mobileNo\": \"9876543210\", \"project\": \"XYZ12950\", \"role\": \"user\", \"username\": \"Sp_2950\", \"password\": \"$2a$10$66hsGrAkDeYyu0qxTzmPrONgzihMaHuAgjpaO9NBDq5WiThO/Milq\" }, \"basicPlusVda\": 40000, \"hra\": 0.0, \"insurance\": 2000, \"lta\": 1000, \"lwf\": 1000, \"netPay\": 70000, \"payroll_id\": 96, \"pf\": 1800, \"pt\": 400, \"stat_bonus\": 100000, \"status\": \"Disabled\" }";

        // Encrypt the request body
        String encryptionKey = "Ac03tEam@j!tu_#1";
        String reBody = ed.encrypt(jBody, encryptionKey);
        System.out.println("Encrypted Request Body: " + reBody);

        // Make the PUT request
        Response resp = given()
                .header("Content-Type", "application/json")
                .body(reBody)
                .when()
                .put("http://49.249.28.218:8091/payroll");
        
      resp.then().log().all();
   // System.out.println("====done====");

       
//        // Encrypt the response body
        String resBody = ed.decrypt(resp.getBody().asString(), encryptionKey);
        System.out.println("Encrypted Response Body: " + resBody);
        System.out.println("====done====");
        
        /*
        
        
        { "employee": { "empId":"NH_PROJ_1444", "designation": "Engineer", "dob": "06/06/1895", "email": "a@gmail.com", "empName": "Akki", "experience": 7, "mobileNo": "9876543210", "project": "Appolo24", "role": "jr.Engineer", "username": “Akshay” }, "basicPlusVda": 30000, "hra": 5000, "insurance": 1000, "lta": 1000, "lwf": 1000, "netPay": 60000, "payroll_id": 101, "pf": 3600, "pt": 500, "stat_bonus": 50000, "status": “Activ” }


        
        
        
        
        
        
        
        
        
        
        
        
        */
    }
}
