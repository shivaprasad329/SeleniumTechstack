package Session2;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_05_DeleteUser {
	
	//NON BDD Style
	@Test
	public void test01()
	{
		RequestSpecification reqs=RestAssured.given();
		reqs.baseUri("https://reqres.in/");
		reqs.basePath("api/users/424");
	    
		
		Response response=reqs.delete();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		
		//Validate Delete Status Code
		int ActualStatusCode=response.getStatusCode();
		int ExpectedStatusCode=204;
		Assert.assertEquals(ActualStatusCode, ExpectedStatusCode);
	}
	
	//BDD Style
	@Test
	public void test02()
	{
		RestAssured.baseURI="https://reqres.in/api/users/424";
		RestAssured.given()
		.when().delete()
		.then().statusCode(204)
		.log().all();
	}

}
