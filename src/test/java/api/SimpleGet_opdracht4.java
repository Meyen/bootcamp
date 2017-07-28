package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SimpleGet_opdracht4 {

    public static String season = "2016";
    public static String driver = "max_verstappen";

    @Test
    public void testUrlParam() {
        given().pathParam("season",season).pathParam("driver", driver).
                when().get("http://ergast.com/api/f1/{season}/drivers/{driver}/results.json").
                then().statusCode(200);
    }
}
