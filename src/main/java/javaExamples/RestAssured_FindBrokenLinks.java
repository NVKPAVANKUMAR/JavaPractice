package javaExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class RestAssured_FindBrokenLinks {

    private WebDriver driver;
    private List<WebElement> anchors;
    private List<String> hrefs = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "DriverJars/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkBrokenLink() {
        driver.get("https://demo.silverstripe.org/Security/login?BackURL=%2Fadmin%2Fpages%2F");
        anchors = driver.findElements(By.tagName("a"));
        for (WebElement anchor : anchors) {
            if (anchor.getAttribute("href") != null) {
                hrefs.add(anchor.getAttribute("href"));
            }
        }

        for (String href : hrefs) {
            try {
                int responseCode = getResponseCode(href);
                if (responseCode != 200) {
                    System.out.println("Broken links are : " + href);
                } else {
                    System.out.println("Working links are : " + href);
                }
            } catch (Exception e) {
                System.out.println("URL: " + href + " -> " + e.getMessage());
            }
        }
    }

    @AfterTest
    public void testDown() {
        driver.quit();
    }

    private int getResponseCode(String href) {
        return given().when().get(href).statusCode();
    }
}
