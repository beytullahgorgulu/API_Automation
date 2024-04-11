package tests;

import baseUrl.BaseUrlJsonPlaceUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlJsonPlaceHolder extends BaseUrlJsonPlaceUrl {

    // When we send a GET request to the https://jsonplaceholder.typicode.com/posts/44 endpoint,
    //   verify that the returned response:
    //   - has a status code of 200
    //   - has the "title" value of "optio dolor molestias sit"

    @Test
    public void test01(){

        specJsonPlaceHolder.pathParams("pp1","posts","pp2","44");

        Response response = given().when().spec(specJsonPlaceHolder).get("{pp1}/{pp2}");

        response.then().assertThat()
                .statusCode(200)
                .body("title", Matchers.equalTo("optio dolor molestias sit"));
    }

    // When we send a GET request to the https://jsonplaceholder.typicode.com/posts endpoint,
    //   verify that the returned response:
    //   - has a status code of 200
    //   - contains 100 records

    @Test
    public void test02(){

        specJsonPlaceHolder.pathParam("pp1","posts");

        Response response = given().when().spec(specJsonPlaceHolder).get("{pp1}");

        //response.prettyPrint();

        response.then().assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));

    }
}
