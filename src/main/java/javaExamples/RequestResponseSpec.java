package javaExamples;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;

public class RequestResponseSpec {


    // instead of creating rsbuilder object, directly assigning to spec to builder
    private ResponseSpecification responseSpec = new ResponseSpecBuilder().
                                            expectStatusCode(200).
                                            expectContentType(ContentType.JSON).
                                            expectStatusLine("HTTP/1.1 200 OK").
                                            build();
    private RequestSpecification requestSpec = new RequestSpecBuilder().
                                            addParam("page",2).
                                            build();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void test_get(){
        given(requestSpec, responseSpec).
                get(baseURI + "/api/users");
    }
}
