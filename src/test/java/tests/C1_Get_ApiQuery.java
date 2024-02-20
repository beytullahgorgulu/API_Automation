package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C1_Get_ApiQuery {

    /*
    tests.C1_Get_ApiQuery
    When a GET request is sent to the URL https://restful-booker.herokuapp.com/booking/10,
    test that the returned Response has:
    - a status code of 200,
    - a content type of application/json; charset=utf-8,
    - a Header named Server with a value of Cowboy,
    - a status Line of HTTP/1.1 200 OK,
    - and manually test that the response time is less than 5 seconds.
     */


    @Test
    public void get01(){

        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url)   ;

        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Content Type: "+response.getContentType());
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Header/Server:"+response.getHeader("Server"));
        System.out.println("Test Time: "+response.getTime()+"ms");

    }
}
