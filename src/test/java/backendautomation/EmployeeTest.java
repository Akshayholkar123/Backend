package backendautomation;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.mysql.cj.jdbc.Driver;
import com.ninza.hrm.api.genericutility.JavaUtility;
import com.ninza.hrm.api.genericutility.ProFileUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jacksonSerialization.Project;
import pOJO.EmpPojo;

public class EmployeeTest {
    String expMsg = "Successfully Added";
    Project pObj;
    ProFileUtility fu = new ProFileUtility();
    JavaUtility ju = new JavaUtility();
    int num = ju.getRnadomNumber();

    @Test
    public void dBTest() throws Throwable {
        String BaseUrl = fu.getDataFromPropertiesFile("Base_url");
        String projName = "appolo" + num;
        String userName = "Akshay" + num;

        pObj = new Project(projName, "OnGoing","Akshay", 0);

        Response resp = given()
                .contentType(ContentType.JSON)
                .body(pObj)
                .when()
                .post(BaseUrl + "/addProject");

        resp.then().log().all();
        String conn=resp.header("Connection");
        System.out.println(conn);

        EmpPojo empP = new EmpPojo("Astronot", "06/06/1995", "akshay@gmail.com", userName, 7, "9874563210", projName, "ROLE_EMPLOYEE", "Akshay" + num);

        given()
                .contentType(ContentType.JSON)
                .body(empP)
                .when()
                .post(BaseUrl + "/employees")
                .then()
                .assertThat().contentType(ContentType.JSON)
                .assertThat().statusCode(201)
                .and()
                .time(Matchers.lessThan(6000L))
                .assertThat().header("Connection","keep-alive")
                
                .log().all();

        boolean flag = false;
        Driver driverRef = new Driver();
        DriverManager.registerDriver(driverRef);

        try (Connection con = DriverManager.getConnection(fu.getDataFromPropertiesFile("DBURL"), fu.getDataFromPropertiesFile("DBUSN"), fu.getDataFromPropertiesFile("DBpass"))) {
            ResultSet result = con.createStatement().executeQuery("SELECT * FROM employee");

            while (result.next()) {
                if (result.getString(5).equals(userName)) {
                    flag = true;
                    Assert.assertTrue(flag, "Employee in DB is verified");

                    System.out.println("Passed: Employee found in the database");
                    break;
                }
            }

            if (!flag) {
                System.out.println("Failed: Employee not found in the database");
                Assert.assertTrue(flag, "Employee in DB not verified");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
