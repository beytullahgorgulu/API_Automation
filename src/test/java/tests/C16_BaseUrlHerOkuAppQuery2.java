package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C16_BaseUrlHerOkuAppQuery2 extends BaseUrlHerOkuApp {
            /*
            Send a GET request to the "https://restful-booker.herokuapp.com/booking" endpoint
            with the necessary query parameters to test that there is a reservation with
            the "firstname" value of "Jim" and the "lastname" value of "Jackson" in the response.
            Verify that the returned response:
                - has a status code of 200
                - contains at least one booking with the name "Jim Jackson"
         */

    @Test
    public void queryParams(){
        specHerOkuApp.pathParam("pp1","booking").queryParams("firstname","Jim","lastname","Jackson");


        Response response = given().when().spec(specHerOkuApp).get("/{pp1}");

        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(1));
    }
}
