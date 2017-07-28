package api;

import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SimpleGet_opdracht3 {

   
    // resultaten laatste race, valideer dat verstappen in de body response staat
    //public void GetLastResults() {
        // Valideer dat de body in de response "verstappen" bevat
//        given().when()
//                .get("http://ergast.com/api/f1/current/last/results.json").then()
//                .assertThat().body("MRData.RaceTable.driverID",containsString("max_verstappen"));
//    }
//
    @Test
    public void testUrlParam() {
        given().pathParam("season","2016").
                when().get("http://ergast.com/api/f1/{season}/drivers/max_verstappen/results.json").
                then().statusCode(200);
    }
}
