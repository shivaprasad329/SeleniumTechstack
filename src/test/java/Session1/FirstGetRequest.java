package Session1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest {

	@Test
	public void testcase01()
	{
		Response response= RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(response.body().asPrettyString());
		System.out.println("Status code is :" +response.getStatusCode());
		System.out.println("Status Line is :" +response.getStatusLine());
	}

}
