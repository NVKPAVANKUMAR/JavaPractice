package javaExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class IEdriverExample {
    public WebDriver driver;

    @Test
    public void test_01() {
        System.setProperty("webdriver.edge.driver", "DriverJars/MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
        driver.get("http://www.google.com");

    }
}
