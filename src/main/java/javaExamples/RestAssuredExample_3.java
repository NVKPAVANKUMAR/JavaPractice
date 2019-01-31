package javaExamples;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class RestAssuredExample_3 {
    ResponseSpecBuilder builder;
    ResponseSpecification rspec;

    @BeforeClass
    public void requestSpec() {
        RestAssured.baseURI = "https://maps.googleapis.com/";
        builder = new ResponseSpecBuilder();
        builder.expectContentType(ContentType.JSON);
        builder.expectStatusCode(200);
        rspec = builder.build();
    }

    @Test
    public void test_01() {
        given().
                param("query", "restaurants in mumbai").
                param("key", "AIzaSyD0crewmhY9pD7hKKOWuIjbZRcufru5NIE").
                when().
                get("maps/api/place/textsearch/json").
                then().
                spec(rspec);
    }
}
