package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C15_BaseUrlHerOkuAppQueryParam extends BaseUrlHerOkuApp {
        /*

        Send a GET request to the "https://restful-booker.herokuapp.com/booking" endpoint
        with the necessary query parameters to test that there is a reservation with
        the "firstname" value of "Susan" in the response.
        Verify that the returned response:
            - has a status code of 200
            - contains at least one booking with the name "Jim"
         */

    @Test
    public void baseUrlQuery(){
        specHerOkuApp.pathParam("pp1","booking").queryParam("firstname","Susan");

        Response response = given().when().spec(specHerOkuApp).get("/{pp1}");

        //response.prettyPrint();

        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(305));
    }
}
