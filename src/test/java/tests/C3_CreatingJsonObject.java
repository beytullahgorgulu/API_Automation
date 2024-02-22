package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C3_CreatingJsonObject {
    /*
    Create the JSON Object below and print it on the console.
              {
              "title":"Ahmet",
              "body":"Hello",
              "userId":1
              }
     */
    @Test
    public void jsonData() {

        JSONObject jsonData = new JSONObject();

        jsonData.put("title", "Ahmet");
        jsonData.put("body", "Hello");
        jsonData.put("userId", 1);

        System.out.println("First Created JSON Data: " + jsonData);

    }

    /*
Create the JSON Object below and print it on the console.

{
"firstname":"Jim",
"additionalneeds":"Breakfast",
"bookingdates":{
               "checkin":"2018-01-01",
               "checkout":"2019-01-01"
               },
"totalprice":111,
"depositpaid":true,
"lastname":"Brown"
}
*/

    @Test
    public void innerJsonData() {
        JSONObject innerJson = new JSONObject();
        innerJson.put("checkin", "2018-01-01");
        innerJson.put("checkout", "2019-01-01");

        JSONObject outerJson = new JSONObject();
        outerJson.put("firstname", "Jim");
        outerJson.put("additionalneeds", "Breakfast");
        outerJson.put("bookingdates", innerJson);
        outerJson.put("totalprice", 111);
        outerJson.put("depositpaid", true);
        outerJson.put("lastname", "Brown");


        System.out.println(outerJson);

    }


}
