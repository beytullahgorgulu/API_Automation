package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_TestDataJsonPlacePUT extends BaseUrlJsonPlaceUrl {
    /*
        When we send a PUT request with the following body to the https://jsonplaceholder.typicode.com/posts/70 URL,
        verify that the returned response:
            - has a status code of 200,
            - has a content type of "application/json; charset=utf-8",
            - has a Connection header value of "keep-alive",
            - and has a response body identical to the provided data below

        Request Body:
            {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
            }

        Response Body (Expected Data):
            {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
            }
     */

    @Test
    public void test01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");

        JSONObject reqBody = JsonPlaceData.createJsonData(10, 70, "Ahmet", "Merhaba");
        JSONObject expBody = JsonPlaceData.createJsonData(10, 70, "Ahmet", "Merhaba");

        Response response = given().contentType(ContentType.JSON)
                .when().spec(specJsonPlaceHolder).body(reqBody.toString())
                .put("{pp1}/{pp2}");

        JsonPath resJP = response.jsonPath();

        assertEquals(JsonPlaceData.successStatusCode, response.getStatusCode());
        assertEquals(JsonPlaceData.contentType, response.getContentType());
        assertEquals(JsonPlaceData.header, response.getHeader("Connection"));
        assertEquals(expBody.getInt("userId"), resJP.getInt("userId"));
        assertEquals(expBody.getInt("id"), resJP.getInt("id"));
        assertEquals(expBody.getString("title"), resJP.getString("title"));
        assertEquals(expBody.getString("body"), resJP.getString("body"));
    }
}
