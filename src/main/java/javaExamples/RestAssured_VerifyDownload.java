package javaExamples;

import org.testng.annotations.Test;

import java.io.File;

import static com.jayway.restassured.RestAssured.given;

public class RestAssured_VerifyDownload {

    @Test
    public void verifyFileDownload() {
        int fileSize;
        File filePath = new File(System.getProperty("user.dir") + "/resources/chromedriver_linux64.zip");
        fileSize = (int) filePath.length();
        byte[] expectedValue =
                given().
                        get("https://chromedriver.storage.googleapis.com/2.41/chromedriver_linux64.zip").
                        asByteArray();
        assert fileSize == expectedValue.length;
    }
}
