	package basic;
	import org.testng.annotations.*;
	import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

	
	public class postrequest {
	
	//	RequestSpecBuilder reqBld;
	//static  RequestSpecification reqSpe;
		
		String consumerKey="rhuQGkuHtN8TPX5FU8DQy79Ck";
		String consumerSecret="iSpMAejAvm1B5oADicCrbzuBZvhIxMnPfzE5keBsxJgdvKZ1J1";
		String accessToken="965663515326345216-DjN3Xkot9jT1mNR9XaPGN1HhGEtO85U";
		String accessSecret="wnFRgszEZOMJyXWabxisZbGwmOsCVTXZsnb0Fq8YOCw4N";
		
		
		String oauth_consumer_key="rhuQGkuHtN8TPX5FU8DQy79Ck";
		String oauth_token="965663515326345216-DjN3Xkot9jT1mNR9XaPGN1HhGEtO85U";
		String oauth_signature_method="HMAC-SHA1",oauth_timestamp="1535318973";
		String oauth_nonce="yumvlIzL2lr";
		String oauth_signature="ociYop8QGM3hfSZuY2KlsmvfAEs%3D";
		ArrayList<String> token=new ArrayList<String>();
		
	@BeforeClass
	public void setup() 
	{
		token.add(oauth_consumer_key);
		token.add(oauth_token);
		token.add(oauth_signature_method);
		token.add(oauth_nonce);
		token.add(oauth_signature);
		
		RestAssured.baseURI ="https://api.twitter.com";
		RestAssured.basePath="/1.1/statuses"; 
	}
	
	@Test
	public void statuscodeVerification() {
		/* given()
		//.headers("Authorization ","Bearer " + "oauth_consumer_key=\"rhuQGkuHtN8TPX5FU8DQy79Ck\",oauth_token=\"965663515326345216-DjN3Xkot9jT1mNR9XaPGN1HhGEtO85U\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1535323152\",oauth_nonce=\"yEN0id5fml5\",oauth_signature=\"AQ6iwfXGwQAbOAFzHJM9qNkL5Tk%3D\"")
		 .auth()
		.oauth(consumerKey,consumerSecret,accessToken,accessSecret)
		.contentType(ContentType.JSON)
		 .log().all()
		 .queryParam("status", "irritated")
		.when()
		.post("/update.json")
		.then()
		.statusCode(200);
		*/
		/*given()
		.auth().oauth(consumerKey, consumerSecret, accessToken, accessSecret)
		.contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .when()
        .post("/update.json")
		.then()
		.statusCode(200);*/
		
		RequestSpecification request = given();
		
		request.auth().oauth(consumerKey,consumerSecret,accessToken,accessSecret);
		
		Response response = request.post();
		
		int code = response.getStatusCode();
		
		assertEquals(code, 200);
		
	}
	
	
	}
