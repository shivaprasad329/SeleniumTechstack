package Session3;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckValideResponseUsingValidatableResponse {

	@Test
	public void test()
	{
		RestAssured.baseURI="https://reqres.in/api/users/2";

		RequestSpecification reqs=RestAssured.given();
		Response response=reqs.get();
		
		
		ValidatableResponse validateres=response.then();
		
		//Validate Statuscode
		validateres.statusCode(200);
		validateres.statusLine("HTTP/1.1 200 OK");
		
		

		
		
		
		

	}

}
