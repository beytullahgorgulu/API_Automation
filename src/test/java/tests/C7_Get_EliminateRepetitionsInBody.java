package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C7_Get_EliminateRepetitionsInBody {
    /*
    When we send a GET request to the URL "https://restful-booker.herokuapp.com/booking/10",
    the Response should have:
        - a status code of 200,
        - content type of application/json,
        - "firstname" as "Eric",
        - "lastname" as "Jackson",
        - "totalprice" as 866,
        - "depositpaid" as true,
        - "additionalneeds" as "Breakfast".
    Note: Data may vary, verify data in Postman.
     */

    @Test
    public void eliminateRepetitionsInBody(){
        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);

        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("firstname", equalTo("Eric"),"lastname",equalTo("Jackson"),
                        "totalprice",equalTo(866),"depositpaid",equalTo(true),
                        "additionalneeds",equalTo("Breakfast"));
        System.out.println(response.contentType());

    }
}
