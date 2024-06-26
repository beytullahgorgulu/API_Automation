package tests;

import baseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.HerOkuAppDatas;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_TestDataHerOKuAppPost extends BaseUrlHerOkuApp {

    /*
        When we send a POST request to the https://restful-booker.herokuapp.com/booking URL
        with the specified body, verify that the returned response, excluding the bookingid,
        is as follows:

        Request body:
            {
                "firstname" : "Ahmet",
                "lastname" : “Bulut",
                "totalprice" : 500,
                "depositpaid" : false,
                "bookingdates" : {
                    "checkin" : "2021-06-01",
                    "checkout" : "2021-06-10"
                },
                "additionalneeds" : "wi-fi"
            }

        Expected response body:
            {
                "booking": {
                    "firstname": "Ahmet",
                    "lastname": "Bulut",
                    "totalprice": 500,
                    "depositpaid": false,
                    "bookingdates": {
                        "checkin": "2021-06-01",
                        "checkout": "2021-06-10"
                    },
                    "additionalneeds": "wi-fi"
                }
            }
    */

    @Test
    public void test01(){
        specHerOkuApp.pathParam("pp1","booking");
        JSONObject reqBody = HerOkuAppDatas.createJsonRequest();
        JSONObject expBody = HerOkuAppDatas.createExpectedResponseBody();

        Response response = given().contentType(ContentType.JSON).when().spec(specHerOkuApp)
                .body(reqBody.toString()).post("{pp1}");

        JsonPath resJP = response.jsonPath();

        assertEquals(expBody.getJSONObject("booking").get("firstname"), resJP.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"), resJP.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"), resJP.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"), resJP.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"), resJP.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"), resJP.get("booking.bookingdates.checkout"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"), resJP.get("booking.additionalneeds"));
    }
}
