package Session2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_01_GetMethod {

	@Test
	public void test01()
	{
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Response Code : " + response.getStatusCode());
		System.out.println("Response Body : " + response.getBody().asPrettyString());
		System.out.println("Response Time : " + response.getTime());
		System.out.println("Response Header :" + response.getHeader("Content-Type"));
		
		//Validate status Code
		
		int ActualStatudCode=response.getStatusCode();
		int ExpectedStatusCode=200;
		
		Assert.assertEquals(ExpectedStatusCode,ActualStatudCode);
	}

	@Test
	public void test02()
	{
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		RestAssured.given().queryParam("page","2").when().get().then().statusCode(200);
	}
}
