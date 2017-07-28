package api;

import org.testng.annotations.Test;
import  io.restassured.RestAssured.*;
import  org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class SimpleGet {

    @Test
    // test die een GET doet op http://ergast.com/api/f1/current/last/results (HTTP 200)
    public void GetLastResults() {
        given().when().get("http://ergast.com/api/f1/current/last/results").then().statusCode(200);
    }
}
