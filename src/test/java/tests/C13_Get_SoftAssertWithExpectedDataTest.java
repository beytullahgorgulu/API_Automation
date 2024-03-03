package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertWithExpectedDataTest {

     /*
   Test that when we send a GET request to the URL http://dummy.restapiexample.com/api/v1/employee/3,
   the response is as follows:

       Response Body (expectedBody)
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
    public void softAssertTest(){

        //1- Prepare the Endpoint and Request Body
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        //2- Prepare the Expected Body
        JSONObject data = new JSONObject();
        data.put("id", 3);
        data.put("employee_name", "Ashton Cox");
        data.put("employee_salary", 86000);
        data.put("employee_age", 66);
        data.put("profile_image", "");

        JSONObject expBody = new JSONObject();
        expBody.put("status", "success");
        expBody.put("data", data);
        expBody.put("message", "Successfully! Record has been fetched.");

        //3- Send Request and Save Response
        Response response = given().when().get(url);

        //4- Assertion Process
        JsonPath respJP = response.jsonPath(); // Retrieve the response and cast it to JsonPath
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(respJP.get("status"), expBody.get("status"));
        softAssert.assertEquals(respJP.get("data.id"), expBody.getJSONObject("data").get("id"));
        softAssert.assertEquals(respJP.get("data.employee_name"), expBody.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(respJP.get("data.employee_salary"), expBody.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(respJP.get("data.employee_age"), expBody.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(respJP.get("data.profile_image"), expBody.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(respJP.get("message"), expBody.get("message"));

        softAssert.assertAll();
    }
}
