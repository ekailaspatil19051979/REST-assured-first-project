package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetAndPostExamples {
	
	//@Test
	public void testGet() {
		baseURI= "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].email",equalTo("george.edwards@reqres.in")).
			//body("data.first_name",hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"));
			body("data.first_name",hasItems("Michael", "Lindsay", "Tobias"));
		
	}
	
	@Test
	public void testPost() {
		
		Map<String,Object> map = new HashMap <String,Object>();
		
		//map.put("name", "Raghav");
		//map.put("job", "Teacher");
		//System.out.println("map => " + map);
		
		
		JSONObject request = new JSONObject(map);
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println("JSONObject request  => " + request);
		System.out.println("request.toJSONString()=> "+ request.toJSONString());
	
		baseURI= "https://reqres.in/api";
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).      // telling server that sending content type is json
		accept(ContentType.JSON).			// telling server that accepting response as json
		body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201)
			.log().all();
			
	}

}
