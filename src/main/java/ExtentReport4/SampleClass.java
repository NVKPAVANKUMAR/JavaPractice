package ExtentReport4;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleClass {

    private WebDriver driver;
    private ExtentHtmlReporter htmlReporter;
    private ExtentReports extentReports;
    private ExtentTest extentTest;

    private static String getScreenshot(WebDriver driver, String screenShotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("screenshots/" + screenShotName + dateName + ".png");
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    @BeforeTest
    public void setExtent() {
        htmlReporter = new ExtentHtmlReporter("reports/my_report.html");

        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();

        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Hostname", "Qualitest");
        extentReports.setSystemInfo("OS", System.getProperty("os"));
        extentReports.setSystemInfo("QA", "PAVAN");
        extentReports.setSystemInfo("Browser", "CHROME");
    }

    @AfterTest
    public void endReport() {
        extentReports.flush();
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.silverstripe.org/Security/login");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_getTitle() {
        extentTest = extentReports.createTest("SilverStripe Demo Test");
        WebElement usernameInput = driver.findElement(By.name("Email"));
        highLightElement(usernameInput);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Log in » SilverStripe Demo");
    }

    @Test
    public void test_getCurrentUrl() {
        extentTest = extentReports.createTest("SilverStripe Demo Test");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://demo.silverstripe.org/Security/login");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
            extentTest.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());

            String screenshotPath = SampleClass.getScreenshot(driver, result.getName());
            extentTest.addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "Test Case PASSED IS " + result.getName());
        }
    }

    private void highLightElement(WebElement element) {
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;')", element);
    }
}
