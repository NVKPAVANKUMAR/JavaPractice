package javaExamples;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class RestAssured_Xml {

    @BeforeClass
    public void setBaseUri() {
        RestAssured.baseURI = "https://maps.googleapis.com/";
    }

    @Test
    public void test_01() {
        Response resp = given().
                param("query", "churchgate station").
                param("key", "AIzaSyD0crewmhY9pD7hKKOWuIjbZRcufru5NIE").
                when().
                get("/maps/api/place/textsearch/xml").
                then().
                contentType(ContentType.XML).
                extract().response();
        resp.prettyPrint();

    }
}
