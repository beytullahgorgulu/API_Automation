package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestListUsage {

    /*
    When we send a GET request to the URL "http://dummy.restapiexample.com/api/v1/employees",
    the Response should have:
        - a status code of 200,
        - a content type of Application.JSON,
        - 24 employees in the response body,
        - one of the employees named "Ashton Cox",
        - ages 61, 21, and 35 should be among the entered ages.
    */
    @Test
    public void listUsage(){
        //1- Prepare endpoint and request body
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        //2- Expected Body

        //3- Send the request and save the response
        Response response = given()
                .when()
                .get(url);
        //4- Assertion
        //response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("data.id", hasSize(24),
                        "data.employee_name", hasItem("Ashton Cox"),
                        "data.employee_age", hasItems(61, 21, 35));
    }
}
