package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C2_Get_ResponseInfoAssertion {
       /*
    When a GET request is sent to the URL https://restful-booker.herokuapp.com/booking/10,
    test that the returned Response has:
    - a status code of 200,
    - a content type of application/json; charset=utf-8,
    - a Header named Server with a value of Cowboy,
    - and a status Line of HTTP/1.1 200 OK using assertions.
 */

    @Test
    public void get01(){

        // 1- Preparation by determining the Endpoint
        String url="https://restful-booker.herokuapp.com/booking/1";

        // 2- Preparation of Expected Data if necessary


        //  3- Saving Actual Data
        Response response=given().when().get(url);

        //   4- Assertion Process
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");

    }
}
