package javaExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DownloadLocationChangeExp {

    private WebDriver driver;
    private ChromeOptions options;
    private HashMap<String, Object> chromePrefs;
    private String downloadPath = "C:/Users/pavan.nemalikanti/Documents";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "DriverJars/chromedriver.exe");
        chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadPath);
        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void clickDownload() {
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement downloadLink = driver.findElement(By.
                xpath("//div[@class=\"control-group\"]/child::a[.=\"Test File to Download\"]"));
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript("arguments[0].scrollIntoView(true);", downloadLink);
        downloadLink.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
