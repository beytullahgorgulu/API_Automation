package tests;

import baseUrl.BaseUrlDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.DummyData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_TestDataDummyGET extends BaseUrlDummy {
     /*
        When we send a GET request to the http://dummy.restapiexample.com/api/v1/employee/3 URL,
        verify that the returned response has:
            - a status code of 200,
            - a content type of application/json,
            - and a body as follows:

          Expected Response Body:
            {
                "status":"success",
                "data":{
                        "id":3,
                        "employee_name":"Ashton Cox",
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":""
                        },
                "message":"Successfully! Record has been fetched."
            }
         */

    @Test
    public void test01(){
        specDummy.pathParams("pp1","employee","pp2","3");

        JSONObject expBody = DummyData.createExpectedData(3,"Ashton Cox",86000,66,"");

        Response response = given().spec(specDummy).when().get("{pp1}/{pp2}");

        JsonPath resJP = response.jsonPath();

        assertEquals(DummyData.successStatusCode, response.getStatusCode());
        assertEquals(DummyData.contentType, response.getContentType());
        assertEquals(expBody.get("status"), resJP.getString("status"));
        assertEquals(expBody.get("message"), resJP.getString("message"));
        assertEquals(expBody.getJSONObject("data").get("id"), resJP.getInt("data.id"));
        assertEquals(expBody.getJSONObject("data").get("employee_name"), resJP.getString("data.employee_name"));
        assertEquals(expBody.getJSONObject("data").get("employee_salary"), resJP.getInt("data.employee_salary"));
        assertEquals(expBody.getJSONObject("data").get("employee_age"), resJP.getInt("data.employee_age"));
        assertEquals(expBody.getJSONObject("data").get("profile_image"), resJP.getString("data.profile_image"));
    }
}
