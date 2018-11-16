	package basic;
	import org.testng.annotations.*;
	import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.hasItem; 
import static io.restassured.RestAssured.given;

	
	public class getrequestdemo {
		
	@BeforeClass
	public void setup() 
	{
		RestAssured.baseURI ="https://maps.googleapis.com";
		RestAssured.basePath="/maps/api"; 
	}
	
	@Test
	public void statuscodeVerification() {
	Response resp =	 given()
		.param("units", "imperial")
		.param("origins", "Washington,DC")
		.param("destinations", "New+York+City")
		.param("key", "AIzaSyC_pjSzj8izetFmOUT_NsA8BVCjPpGg8EE")
		.when()
		.get("/distancematrix/json");resp
		.then()
		.statusCode(200);
	//	.and()
		//.body("rows[0].elements[0].distance.text",hasItem("225 mi"))
		//.contentType(ContentType.JSON);
	}
	
	@Test
	
	public void responseVerification() {
		Response res= given()
		.param("units", "imperial")
		.param("origins", "Washington,DC")
		.param("destinations", "New+York+City")
		.param("key", "AIzaSyC_pjSzj8izetFmOUT_NsA8BVCjPpGg8EE")
		.when()
		.get("/distancematrix/json");
		System.out.println(res.body().prettyPrint()+" this is op");
	}
	}
