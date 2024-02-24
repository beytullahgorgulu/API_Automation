package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C6_Post_ResponseBodyTest {
    /*
    When we send a POST request with the following body to the URL https://jsonplaceholder.typicode.com/posts:
        {
        “title”:“API”,
        “body”:“Learning API is great”,
        “userId”:10,
        }
    We should test that the returned Response:
        - has a status code of 201,
        - has a content type of application/json,
        - has "title" in the Response Body as "API",
        - has "userId" value less than 100,
        - has "body" containing the word "API".
     */

    @Test
    public void PostResponseBodyTest(){

        String url="https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody=new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","Learning API is great");
        reqBody.put("userId",10);

        //----------------------------------------

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title",equalTo("API"))
                .body("userId",lessThan(100))
                .body("body",containsString("API"));

    }
}
