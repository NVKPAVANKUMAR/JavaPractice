package javaExamples;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.jayway.restassured.RestAssured.given;

public class RestAssuredExample {



    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test(enabled = false)
    public void currencyExchangeValue() {
        Response resp =
                given().
                        when().
                        get("http://www.google.com");
        resp.getBody().prettyPrint();
    }

    // GET Request Example
    @Test
    public void test_01() {
        Response resp = given().
                when().contentType(ContentType.JSON).
                get(String.format("/api/users/%s", 2));
        resp.prettyPrint();
        int res = resp.then().contentType(ContentType.JSON).extract().path("data.id");
        System.out.println(res);
        assert resp.statusCode() == 200;
    }

    @Test
    public void test_07() {
        Response resp = given().
                when().
                contentType(ContentType.JSON).
                get("https://reqres.in/api/users?page=2");
        resp.prettyPrint();
        int res = resp.
                then().
                contentType(ContentType.JSON).
                extract().
                path("data.id");
        System.out.println(res);
        assert resp.statusCode() == 200;
    }


    // POST Request Example
    @Test
    public String test_02() {
        Map<String, String> map = getPostRequest_payload();
        Response resp = given().
                body(map).
                when().
                contentType(ContentType.JSON).
                post("/api/users");
        // resp.prettyPrint();
        String id = resp.
                then().
                contentType(ContentType.JSON).
                extract().
                path("id");
        assert resp.statusCode() == 201;
        return id;
    }

    private Map<String, String> getPostRequest_payload() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "morpheus");
        map.put("job", "leader");
        return map;
    }

    // PUT Request Example
    @Test
    public void test_03() {
        Map<String, String> map = getPutRequest_payload();
        Response resp = given().
                body(map).
                when().
                contentType(ContentType.JSON).
                put("/api/users/2");
        String name = resp.then().contentType(ContentType.JSON).extract().path("name");
        assert name.equalsIgnoreCase(map.get("name"));
        assert resp.statusCode() == 200;
    }

    private Map<String, String> getPutRequest_payload() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "morpheus");
        map.put("job", "zion resident");
        return map;
    }


    // PATCH Request Example
    @Test
    public void test_04() {
        Map<String, String> map = getPatchRequest_payload();
        Response resp = given().
                body(map).
                when().
                contentType(ContentType.JSON).
                put("/api/users/2");
        String job = resp.
                then().
                contentType(ContentType.JSON).
                extract().
                path("job");
        assert job.equalsIgnoreCase(map.get("job"));
        assert resp.statusCode() == 200;
    }

    private Map<String, String> getPatchRequest_payload() {
        Map<String, String> map = new HashMap<>();
        map.put("job", "master");
        return map;
    }


    //DELETE Request Example
    @Test
    public void test_05() {
        Response resp = given().
                when().
                contentType(ContentType.JSON).
                delete("/api/users/2");
        assert resp.statusCode() == 204;
    }




}
