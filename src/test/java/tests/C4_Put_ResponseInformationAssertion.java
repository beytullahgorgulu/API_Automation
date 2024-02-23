package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C4_Put_ResponseInformationAssertion {
    /*
    When we send a PUT request to the URL https://jsonplaceholder.typicode.com/posts/70
    with the following JSON format body:
        {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
        }
    Then assert that the response:
        - has a status code of 200,
        - has a content type of application/json; charset=utf-8,
        - contains a header named "Server" with a value of "cloudflare",
        - has a status line of HTTP/1.1 200 OK.
     */


    @Test
    public void put01(){

        //    1-Prepare the Endpoint
        String url="https://jsonplaceholder.typicode.com/posts/70";

        JSONObject reqBody=new JSONObject();
        reqBody.put("title", "Ahmet");
        reqBody.put("body", "Merhaba");
        reqBody.put("userId", 10);
        reqBody.put("id", 70);

        //    2-Prepare Expected Data if necessary

        //    3-Save Actual Data
        Response response=given().contentType(ContentType.JSON).when()
                .body(reqBody.toString()).put(url);

        //    4-Perform Assertion

        response.then().assertThat()
                .statusCode(200)
                .header("Server", "cloudflare")
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");

        response.prettyPrint();
        System.out.println(response.getHeaders());


    }





}
