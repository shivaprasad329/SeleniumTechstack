package Session2;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TC_04_PatchMethod {
	
	@Test
	public void test01()
	{
		JSONObject jsonob=new JSONObject();
		jsonob.put("name", "shivatesting");
		jsonob.put("job", "leader1");
		
		RequestSpecification reqs=RestAssured.given();
		
		reqs.header("Content-Type","application/json; charset=utf-8");
		reqs.baseUri("https://reqres.in/");
		reqs.basePath("/api/users/424");
		
		reqs.contentType(ContentType.JSON).body(jsonob.toJSONString())
			.when().patch()
			.then().statusCode(200)
			.log().all();
		
		
	}

}
