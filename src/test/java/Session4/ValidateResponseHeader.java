package Session4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {

	@Test
	public void getsingleUSer()
	{
		RequestSpecification reqs=RestAssured.given();
		reqs.baseUri("https://reqres.in");
		reqs.basePath("/api/users/2");

		//Capture the Response
		Response response=reqs.get();
		
		//Read the Response single single Header and Print value
		String Headervalue1=response.getHeader("Content-Type");
		String Headervalue2=response.getHeader("Date");
		String Headervalue3=response.getHeader("Transfer-Encoding");
		String Headervalue4=response.getHeader("Connection");

		System.out.println("Response Header Value1 ----:"+Headervalue1);
		System.out.println("Response Header Value2 ----:"+Headervalue2);
		System.out.println("Response Header Value3 ----:"+Headervalue3);
		System.out.println("Response Header Value4 ----:"+Headervalue4);

	}


	//Read All the Reponse Header Attributes/keys and print their Values
	@Test
	public void getsingleUser1()
	{
		RequestSpecification reqs=RestAssured.given();
		reqs.baseUri("https://reqres.in");
		reqs.basePath("/api/users/2");

		Response response=reqs.get();

		Headers headers=response.headers();
		
		for (Header header : headers) {
			System.out.println(header.getName()  +"&&"+ header.getValue());
		}
		
		
		//Validate header Content
		String ActualContentTyepe=response.getHeader("Content-Type");
		String ExpectedContentType="application/json; charset=utf-8";
		
		Assert.assertEquals(ActualContentTyepe, ExpectedContentType);
		
		
		
		
		
	}







}
