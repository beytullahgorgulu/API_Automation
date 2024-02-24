package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C5_Get_ResponseBodyTest {
    // When we send a GET request to the URL https://jsonplaceholder.typicode.com/posts/44,
    // We should test that:
    // - the returned Response has a status code of 200,
    // - the content type is application/json; charset=utf-8,
    // - the userId in the response body is 5,
    // - the title in the response body is "optio dolor molestias sit".

    @Test
    public void responseBodyTest() {

        // 1- Prepare the Endpoint
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- Prepare the expected data if provided in the question.

        // 3- Save the Actual Data

        Response response = given().when().get(url);

        //response.prettyPrint();

        // 4- Assertion Process
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("userId", equalTo(5))
                .body("title", equalTo("optio dolor molestias sit"));

    }
}
