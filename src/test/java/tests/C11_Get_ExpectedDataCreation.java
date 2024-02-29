package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_Get_ExpectedDataCreation {
    /*
        When we send a GET request to the URL https://jsonplaceholder.typicode.com/posts/22,
        we should test that the response body matches the given body below.

        Response body:

        {
        "userId":3,
        "id":22,
        "title":"dolor sint quo a velit explicabo quia nam",
        "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }

     */

    @Test
    public void expectedBodyTest(){

        //1- Prepare the endpoint and request body
        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2- Prepare the Expected Body
        JSONObject expBody=new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //3- Send the request and save the response
        Response response=given().when().get(url);

        //4- Assertion process
        JsonPath respJsonPath=response.jsonPath();

        assertEquals(expBody.get("userId"),respJsonPath.get("userId"));
        assertEquals(expBody.get("id"),respJsonPath.get("id"));
        assertEquals(expBody.get("title"),respJsonPath.get("title"));
        assertEquals(expBody.get("body"),respJsonPath.get("body"));

    }
}
