package dataDrivenTesting;

import org.testng.annotations.Test;

//import com.comcast.crm.generic.fileutility.ExcelUtility;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class DataProvider 
{
	@Test(dataProvider="getData")
	public void sampleTest(String projectName,String status)
	{
	String reqBody="{\r\n"
			+ "  \"createdBy\": \"John_Doe\",\r\n"
			+ "  \"projectName\": \"Project_Alpha\",\r\n"
			+ "  \"status\": \"Created\",\r\n"
			+ "  \"teamSize\": 5\r\n"
			+ "}";	
	given()
	.contentType(ContentType.JSON)
	.body(reqBody)
	.when()
	.post("http://49.249.28.218:8091/addProject")
	.then()
	.log().all();
	}
	
	
	
    @org.testng.annotations.DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility eu=new ExcelUtility();
		int count=eu.getLastRowNum("project");
		Object[][] data=new Object[count][2];
		for(int i=0;i<count;i++)//	for(int i=;i<=count;i++)
		{
			data[i][0]=eu.getDataFromExcel("project",i+1,0);//i
			data[i][1]=eu.getDataFromExcel("project",i+1,1);//i

		}
		return data;
	}
	
	
	}

