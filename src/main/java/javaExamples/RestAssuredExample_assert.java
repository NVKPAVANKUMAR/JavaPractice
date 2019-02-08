package javaExamples;

import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.*;

public class RestAssuredExample_assert {


    private ResponseSpecification responseSpecification = new
            ResponseSpecBuilder().
            expectContentType("application/json").
            expectStatusCode(200).
            expectResponseTime(lessThanOrEqualTo(4L), SECONDS).
            build();

    @Test
    public void test_givenUrl() {
        given().
                when().
                get("https://jsonplaceholder.typicode.com/users").
                then().
                assertThat().
                spec(responseSpecification).
                and().
                body("id", hasItems(1, 2, 3)).
                body("id", any(List.class)).
                body("name[0]", is("Leanne Graham")).
                header("Server", is(equalTo("cloudflare"))).
                header("Content-Type", is(equalTo("application/json; charset=utf-8"))).
                body("name[0]", allOf(startsWith("Lea"), containsString("Graham"))).
                body("name[0]", anyOf(startsWith("Lea"), containsString("Graham"))).
                body("name[0]", describedAs("Leanne Graham is not Lenne.", is(not("Lenne")))).
                body("name[0]", is(anything("Bla Bla Bla"))).
                body("company[0].name", is(not(equalToIgnoringWhiteSpace("Bla"))));
    }

    @Test(dataProvider = "calculator_Data")
    public void soapApiTest(int firstNumber, int secondNumber, int expectedResult, String operation) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/soap+xml");
        headers.put("charset", "UTF-8");

        //Assign the SOAP body to the below variable.
        String reqBody = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:tem=\"http://tempuri.org/\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <tem:" + operation + ">\n" +
                "         <tem:intA>" + firstNumber + "</tem:intA>\n" +
                "         <tem:intB>" + secondNumber + "</tem:intB>\n" +
                "      </tem:" + operation + ">\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";

        Response resp = given().
                request().
                headers(headers).
                body(reqBody).
                when().
                post("http://www.dneonline.com/calculator.asmx");

        int actualResult = getResultValue(resp,
                "/soap:Envelope/soap:Body/" + operation + "Response/" + operation + "Result");

        Assert.assertEquals(actualResult, expectedResult);
    }

    private int getResultValue(Response resp, String xmlPath) {
        String output = resp.
                then().
                extract().
                path(xmlPath).toString();
        return Integer.parseInt(output);
    }

    @DataProvider(name = "addition_data")
    public Object[][] createAdditionTestData() {
        return new Integer[][]{
                {1, 2, 3},
                {100, 200, 300}
        };
    }

    @DataProvider(name = "calculator_Data")
    public Object[][] create_ArithmeticData() {
        return new Object[][]{
                {20, 10, 10, "Subtract"},
                {10, 20, 200, "Multiply"},
                {500, 5, 100, "Divide"},
                {10, 200, 210, "Add"}
        };
    }


    @Test
    public void test_GetViewsCount(){
        String URI = "https://www.googleapis.com/youtube/v3/videos?part=contentDetails,statistics&id=iSB-8Yes9XE&key=AIzaSyD0crewmhY9pD7hKKOWuIjbZRcufru5NIE";
        Response resp = given().
                        when().
                        contentType(ContentType.JSON).
                        get(URI);
        resp.prettyPrint();


    }

}
