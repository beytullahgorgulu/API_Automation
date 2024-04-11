package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlJsonPlaceDelete extends BaseUrlJsonPlaceUrl {
    /*
        Send a DELETE request to the https://jsonplaceholder.typicode.com/posts/50 endpoint,
        and test that the returned response:
            - has a status code of 200
            - has a response body of null
     */

    @Test
    public void test01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","50");
        Response response = given().when().spec(specJsonPlaceHolder).delete("{pp1}/{pp2}");

        response.then().assertThat().statusCode(200).body(Matchers.nullValue());
    }
}
