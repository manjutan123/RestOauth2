package testusingOuth2;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.PreemptiveOAuth2HeaderScheme;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.given;

public class Testauth {

	@Test()
	public void testoauth() {
		
		//save token generated in variable
		String access_token = "6f19ed1fbe263737d4208ff6aed1b78059d1d1f9";

		RestAssured.baseURI = "https://api.github.com";
	
	    //pass oauth authentication token to request
		given().when().auth().oauth2(access_token)
       
		//verify response return 
        .get("").then().log().all().statusCode(200).and().body("hub_url", equalTo("https://api.github.com/hub"));

	    //below some other way to pass token as parameter as specified in documentation

		//given().queryParam("access_token",access_token).when().get("").then().log().all();

	}
}
