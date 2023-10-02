package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class TestExamples {

	@Test
	public void test_a() {

		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("========================================================================================");
		System.out.println(response.getStatusCode());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("========================================================================================");
		System.out.println(response.getTime());
		System.out.println("========================================================================================");
		//System.out.println(response.getBody().asString());
		System.out.println("========================================================================================");
		System.out.println(response.getStatusLine());
		System.out.println("========================================================================================");
		System.out.println(response.getHeader("content-type"));
		System.out.println("========================================================================================");

	}
	
	@Test
	public void test_b() {
		
		baseURI= "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].id",equalTo(11)).log().all();
	}

}
