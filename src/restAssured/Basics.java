package restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Basics {

	
	@Test
	public void addPlace() {
		// TODO Auto-generated method stub
		
		//BaseURL or Host
		RestAssured.baseURI = "https://216.10.245.166";
		
		given().
			queryParam("key", "qaclick123").
			body("{\r\n" + 
					"    \"location\":{\r\n" + 
					"        \"lat\" : -38.383494,\r\n" + 
					"        \"lng\" : 33.427362\r\n" + 
					"    },\r\n" + 
					"    \"accuracy\":50,\r\n" + 
					"    \"name\":\"Frontline house\",\r\n" + 
					"    \"phone_number\":\"(+91) 983 893 3937\",\r\n" + 
					"    \"address\" : \"29, side layout, cohen 09\",\r\n" + 
					"    \"types\": [\"shoe park\",\"shop\"],\r\n" + 
					"    \"website\" : \"http://google.com\",\r\n" + 
					"    \"language\" : \"French-IN\"\r\n" + 
					"}\r\n" + 
					"").
			
/*			{
			    \"location\":{
			        \"lat\" : -38.383494,
			        \"lng\" : 33.427362
			    },
			    \"accuracy\":50,
			    \"name\":\"Frontline house\",
			    \"phone_number\":\"(+91) 983 893 3937\",
			    \"address\" : \"29, side layout, cohen 09\",
			    \"types\": [\"shoe park\",\"shop\"],
			    \"website\" : \"http://google.com\",
			    \"language\" : \"French-IN\"
			}
*/
			
			
			
				when().
					get("/maps/api/place/add/json").
					then().
					assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
					body("status", equalTo("OK"));
				//param("location","-33.8670522,151.1957362").
				//param("radius","500");

	}

}
