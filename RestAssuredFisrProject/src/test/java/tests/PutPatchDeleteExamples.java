package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {

	//@Test
	public void testPut() {
	JSONObject request = new JSONObject();
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
		put("/users/2").
	then().
		statusCode(200)
		.log().all();
}
	
	//@Test
	public void testPatch() {
	JSONObject request = new JSONObject();
	request.put("name", "Raghav");
	request.put("job", "Teacher");
	
	System.out.println("JSONObject request  => " + request);
	System.out.println("request.toJSONString()=> "+ request.toJSONString());

	baseURI= "https://reqres.in";
	given().
	header("Content-Type","application/json").
	contentType(ContentType.JSON).      // telling server that sending content type is json
	accept(ContentType.JSON).			// telling server that accepting response as json
	body(request.toJSONString()).
	when().
		put("/api/users/2").
	then().
		statusCode(200)
		.log().all();
		
}
	
	@Test
	public void testDelete() {
	

	baseURI= "https://reqres.in";
	
	when().
		delete("/api/users/2").
	then().
		statusCode(204)
		.log().all();
		
}
	
}
