package basic;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.OAuthScheme;
import io.restassured.authentication.OAuthSignature;
import io.restassured.specification.RequestSpecification;

public class GetTwitter {
	
	String consumerKey="rhuQGkuHtN8TPX5FU8DQy79Ck";
	String consumerSecret="iSpMAejAvm1B5oADicCrbzuBZvhIxMnPfzE5keBsxJgdvKZ1J1";
	String accessToken="965663515326345216-DjN3Xkot9jT1mNR9XaPGN1HhGEtO85U";
	String accessSecret="wnFRgszEZOMJyXWabxisZbGwmOsCVTXZsnb0Fq8YOCw4N";
	String oauth_signature_method="HMAC-SHA1";
	
@BeforeClass
public void setup() 
{

	
	RestAssured.baseURI ="https://api.twitter.com";
	RestAssured.basePath="/1.1/statuses"; 
}
@Test
public void statuscodeVerification() {
	RequestSpecification request = given();
	
	//request.auth().oauth(consumerKey,consumerSecret,accessToken,accessSecret);
	request.auth().oauth(consumerKey,consumerSecret,accessToken,accessSecret, OAuthSignature.HEADER);
	//OAuthScheme scheme = new OAuthScheme()
	
	request.when()
	.get("/user_timeline.json?screen_name=priyanka nishan")
	.then()
	.statusCode(200)
	.log().all();
	
}
}