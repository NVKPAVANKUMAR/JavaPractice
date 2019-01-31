package javaExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;

public class HandleCaptcha {

    private static WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void enterCaptcha() {
        driver.get("http://www1.icts.uci.edu/captcha/test.cfm");
        WebElement captchaTextBox = driver.findElement(By.id("captcha"));
        String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value: ");
        captchaTextBox.sendKeys(captchaVal);
    }

    @AfterTest
    public void teardownClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
