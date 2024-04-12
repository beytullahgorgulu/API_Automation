package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C19_UsingTestDataJsonPlace extends BaseUrlJsonPlaceUrl {

    /*
    When we send a GET request to the https://jsonplaceholder.typicode.com/posts/22 URL,
    verify that the returned response:
        - has a status code of 200
        - has a response body identical to the provided data below:

    Response body :
    {
        "userId":3,
        "id":22,
        "title":"dolor sint quo a velit explicabo quia nam",
        "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
    */

    @Test
    public void test01(){
        // Prepare Endpoint and Request Body if available
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","22");

        // Prepare Expected Body
        JSONObject expBody = JsonPlaceData.createExpectedDataForPost22();

        // Send Request and Save Response
        Response response = given().when().spec(specJsonPlaceHolder).get("{pp1}/{pp2}");

        // Perform Assertion
        JsonPath resJP = response.jsonPath();
        assertEquals(JsonPlaceData.successStatusCode, response.getStatusCode());
        assertEquals(expBody.getInt("userId"), resJP.getInt("userId"));
        assertEquals(expBody.getInt("id"), resJP.getInt("id"));
        assertEquals(expBody.getString("title"), resJP.getString("title"));
        assertEquals(expBody.getString("body"), resJP.getString("body"));
    }
}
