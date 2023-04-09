package Session3;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckValideResponse {

	
	@Test
	public void NONBDD_Style()
	{
		RestAssured.baseURI="https://reqres.in/api/users/2";

		RequestSpecification reqs=RestAssured.given();
		Response response=reqs.get();

		//Get Responsecode
		int statusode=response.getStatusCode();
		System.out.println("Statuscode is --- :"+statusode);
		
		//Validate Status code
		Assert.assertEquals(statusode,200);
		
		String statusLine=response.getStatusLine();
		System.out.println("Statuscode is --- :"+statusLine);
		
		//Validate StatusLine
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
		
		

	}
	
	
	@Test
	public void BDD_Style()
	{
		
		
		
		
		RestAssured.baseURI="https://reqres.in/api/users/2";

		RestAssured
			.given()
			.when().get()
			.then().statusCode(200).statusLine("HTTP/1.1 200 OK");
		

		
		
		

	}

}
