package javaExamples;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class RestAssured_LoggingTest {

    @BeforeClass
    public void setBaseUri() {
        RestAssured.baseURI = "https://maps.googleapis.com/";
    }

    @Test
    public void logTest() {
        given().
                param("query", "restaurants in mumbai").
                param("key", "AIzaSyD0crewmhY9pD7hKKOWuIjbZRcufru5NIE").
                when().
                log().
                all().
                get("maps/api/place/textsearch/json");
    }

    @Test
    public void logTest_2() {
        given().
                param("query", "restaurants in mumbai").
                param("key", "AIzaSyD0crewmhY9pD7hKKOWuIjbZRcufru5NIE").
                when().get("maps/api/place/textsearch/json").
                then().log().ifError().assertThat().statusCode(200);
    }

}
