package javaExamples;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class RestAssuredExample_2 {

    RequestSpecification rspec;
    RequestSpecBuilder build;

    @BeforeClass
    public void requestSpec() {
        build = new RequestSpecBuilder();
        build.setBaseUri("https://maps.googleapis.com");
        build.setBasePath("maps/api/place/textsearch/json");
        build.addParam("query", "restaurants in mumbai");
        build.addParam("key", "AIzaSyD0crewmhY9pD7hKKOWuIjbZRcufru5NIE");
        rspec = build.build();
    }

    @Test
    public void test_01() {
        Response resp = given().spec(rspec).when().get("");
        resp.then().contentType(ContentType.JSON).statusCode(200);
    }

    //@Test
    public void test_02() {
        Response resp = given().param("query").when().get("");
    }
}
