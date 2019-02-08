package javaExamples;

import com.jayway.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssured_DDT {

    @Test(dataProvider = "zipcodes")
    public void test_ddt(String country, String zipcode, String city) {
        given().
                param("country", country).
                param("postal-code", zipcode).
                when().
                get("http://api.zippopotam.us/").
                then().
                assertThat().
                statusCode(200).
                and().
                body("places.place name", equalTo(city));
    }

    @DataProvider(name = "zipcodes")
    public Object[][] createZipCodeTestData() {
        return new String[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"}
        };
    }

    @Test
    public void test_get() {
        Response resp = given().
                when().
                get("http://api.zippopotam.us/us/12345");
        resp.prettyPrint();

    }
}
