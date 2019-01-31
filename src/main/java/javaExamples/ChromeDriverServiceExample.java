package javaExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ChromeDriverServiceExample {

    private static ChromeDriverService service;
    WebDriver driver;
    ChromeOptions options;
    File chromeExePath = new File("DriverJars/chromedriver.exe");

    @BeforeClass
    public void setUp() throws IOException {
        service = new ChromeDriverService.Builder().
                usingDriverExecutable(chromeExePath).
                usingAnyFreePort().build();
        service.start();
        options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new RemoteWebDriver(service.getUrl(), options);
    }

    @Test
    public void test_01() {
        driver.get("https://demo.silverstripe.org/Security/login?BackURL=%2Fadmin%2Fpages%2F");
    }

    @Test
    public void test_02() {
        driver.get("https://semaphoreci.com/community/tutorials/testing-rest-endpoints-using-rest-assured");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
