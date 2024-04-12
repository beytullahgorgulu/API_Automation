package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_TestDataJsonPlaceDynamic extends BaseUrlJsonPlaceUrl {


    /*
        When we send a GET request to the https://jsonplaceholder.typicode.com/posts/40 URL,
        verify that the returned response:
            - has a status code of 200
            - has a response body identical to the provided data below:

        Response body :
        {
            "userId":4,
            "id":40,
            "title":"enim quo cumque",
            "body":"ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
        }
     */
    @Test
    public void test01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","40");

        JSONObject expBody = JsonPlaceData.createJsonData(4, 40, "enim quo cumque", "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");

        Response response = given().when().spec(specJsonPlaceHolder).get("{pp1}/{pp2}");

        JsonPath resJP = response.jsonPath();
        assertEquals(JsonPlaceData.successStatusCode, response.getStatusCode());
        assertEquals(expBody.getInt("userId"), resJP.getInt("userId"));
        assertEquals(expBody.getInt("id"), resJP.getInt("id"));
        assertEquals(expBody.getString("title"), resJP.getString("title"));
        assertEquals(expBody.getString("body"), resJP.getString("body"));
    }

}
