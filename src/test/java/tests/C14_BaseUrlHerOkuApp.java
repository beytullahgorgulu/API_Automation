package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C14_BaseUrlHerOkuApp extends BaseUrlHerOkuApp {
    /*
        //1-  Send a GET request to the https://restful-booker.herokuapp.com/booking endpoint
    //    and test that the returned response:
    //          - has a status code of 200
    //          - contains 12 bookings
     */

    @Test
    public void test01(){
        //1- Prepare the Endpoint and Request Body

        specHerOkuApp.pathParam("pp1","booking");

        //2- Prepare the expected Body

        //3- Save the response
        Response response = given().when().spec(specHerOkuApp).get("/{pp1}");

        //
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(51));
    }
}
