package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C9_Post_JsonPathWithBodyTest {
    /*
    When we send a POST request to the https://restful-booker.herokuapp.com/booking URL with the following body:
     {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" :{
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
                        },
        "additionalneeds" : "wi-fi"
     }
     Then we should test that the returned Response:
     - has a status code of 200,
     - has a content type of application/json,
     - has "firstname" in the response body as "Ahmet",
     - has "lastname" in the response body as "Bulut",
     - has "totalprice" in the response body as 500,
     - has "depositpaid" in the response body as false,
     - has "checkin" date as 2021-06-01 and "checkout" date as 2021-06-10,
     - has "additionalneeds" in the response body as "wi-fi"
    */

    @Test
    public void JsonPathWithBodyTest(){
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject dates=new JSONObject();
        dates.put( "checkin" , "2021-06-01");
        dates.put( "checkout" , "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",dates);
        reqBody.put("additionalneeds", "wi-fi");

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        response.then().assertThat()
                .statusCode(200).contentType("application/json")
                .body("booking.firstname", equalTo("Ahmet"),
                        "booking.lastname", equalTo("Bulut"),
                        "booking.totalprice", equalTo(500),
                        "booking.depositpaid", equalTo(false),
                        "booking.bookingdates.checkin", equalTo("2021-06-01"),
                        "booking.bookingdates.checkout", equalTo("2021-06-10"),
                        "booking.additionalneeds",equalTo("wi-fi"));

    }


}




