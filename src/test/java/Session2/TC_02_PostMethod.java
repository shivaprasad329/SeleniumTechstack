package Session2;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_02_PostMethod {

	@Test
	public void testcase01()
	{
		
		JSONObject jsonob=new JSONObject();
		jsonob.put("name", "selenium");
		jsonob.put("job", "leader");
		
		RequestSpecification req=RestAssured.given();
		req.given().
			header("Content-Type","application/json; charset=utf-8");
			req.baseUri("https://reqres.in");
			req.basePath("/api/users").contentType(ContentType.JSON).body(jsonob.toJSONString())
		.when().post()
		.then().statusCode(201).log().all();

		

		
	}

}
