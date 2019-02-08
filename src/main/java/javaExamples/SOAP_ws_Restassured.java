package javaExamples;

import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;

public class SOAP_ws_Restassured {

    private String baseURI = null;

    @BeforeTest
    public void setUp() {
        baseURI = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
    }

    @Test(dataProvider = "countryCode_data")
    public void soapApiTest(String countryISOCode, String capitalName) {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/soap+xml");
        headers.put("charset", "UTF-8");

        //Assign the SOAP body to the below variable.
        String reqBody = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <web:CapitalCity>\n" +
                "         <web:sCountryISOCode>" + countryISOCode + "</web:sCountryISOCode>\n" +
                "      </web:CapitalCity>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        // Passing request body via string

        Response resp = given().
                request().
                headers(headers).
                body(DocumentBuilderDemo.getRequestBody(countryISOCode)).
                when().
                post(baseURI);

        // resp.prettyPrint();

        String actualResult = getResultValue(resp,
                "/soap:Envelope/soap:Body/m:CapitalCityResponse/m:CapitalCityResult");

        Assert.assertEquals(actualResult, capitalName);
    }


    private String getResultValue(Response resp, String xmlPath) {
        return resp.
                then().
                extract().
                path(xmlPath).toString();
    }

    @DataProvider(name = "countryCode_data")
    public Object[][] createCountryTestData() {
        return new Object[][]{
                {"IN", "New Delhi"},
                {"FR", "Paris"},
                {"US", "Washington"}
        };
    }


}
