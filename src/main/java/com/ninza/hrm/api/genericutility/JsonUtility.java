package com.ninza.hrm.api.genericutility;

import java.util.List;

import com.jayway.jsonpath.JsonPath;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class JsonUtility
{
	ProFileUtility fu=new ProFileUtility();

	public boolean verifyJsonData(Response resp,String jsonXpath,String expectedData)
	{
		List<String> list=JsonPath.read(resp.asString(),jsonXpath);
		boolean flag=false;
		for(String str:list)
		{
			if(str.equals(expectedData)) {
				flag=true;
			}
		}
		if(flag==true)
		{
			System.out.println(expectedData+ " is available ==pass");
		}
		else
		{
			System.out.println(expectedData+ " is not available ==fail");

		}
		return flag;
		
	}
	
	
	
	
	
	public String getAcccessToken() throws Throwable
	{
		Response resp=given()
				.formParam("client_id",fu.getDataFromPropertiesFile("ninza-client"))
				.formParam("client_secret",fu.getDataFromPropertiesFile("ClientSecret"))
				.formParam("grant_type","client_credentials")
				.when()
			.post("http://49.249.28.218:8180/auth/reals/ninza/protocol/openid-connect/token");
		resp.then().log().all();
		String token=resp.jsonPath().get("access_token");
		return token;
		
	
}
	
	
	public String getDataOnXmlpath(Response resp,String xmlXPath)
	{
		
		return resp.xmlPath().get(xmlXPath);
		
	}
	
		
	
}
