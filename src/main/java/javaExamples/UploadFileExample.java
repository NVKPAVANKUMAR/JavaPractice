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

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static javaExamples.HighlightElementUtility.highlightElement;
import static javaExamples.ScreenShotUtility.takeScreenshot;

public class UploadFileExample {

    private WebDriver driver;
    private ChromeOptions options;
    private String uploadFilePath1 = "C:\\Users\\pavan.nemalikanti\\Documents\\Test-File-to-Download.xlsx";
    private String uploadFilePath2 = "C:\\Users\\pavan.nemalikanti\\Documents\\Test-File-to-Download";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "DriverJars/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test(description = "using sendkeys")
    public void uploadFile_1() {
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement uploadButton = driver.findElement(By.xpath("//*[@id=\"photo\"]"));
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript("arguments[0].scrollIntoView(true);", uploadButton);
        highlightElement(driver, uploadButton);
        uploadButton.sendKeys(uploadFilePath1);
        takeScreenshot(driver, "File_Upload_method1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(description = "using RobotClass")
    public void uploadFile_2() throws AWTException, InterruptedException {
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement uploadButton = driver.findElement(By.xpath("//*[@id=\"photo\"]"));
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript("arguments[0].scrollIntoView(true);", uploadButton);
        highlightElement(driver, uploadButton);
        uploadButton.click();
        StringSelection ss = new StringSelection(uploadFilePath2);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        takeScreenshot(driver, "File_Upload_method2");
        Thread.sleep(5000);
    }

    // @Test(description = "using AUTOIT")
    public void uploadFile_3() throws IOException, InterruptedException {
        driver.get("http://toolsqa.com/automation-practice-form/");
        WebElement uploadButton = driver.findElement(By.xpath("//*[@id=\"photo\"]"));
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript("arguments[0].scrollIntoView(true);", uploadButton);
        highlightElement(driver, uploadButton);
        uploadButton.click();
        Runtime.getRuntime().exec("Script.exe");
        takeScreenshot(driver, "File_Upload_method3");
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}

