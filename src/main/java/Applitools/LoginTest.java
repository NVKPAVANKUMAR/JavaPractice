package Applitools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.net.util.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
    private static String password;
    public WebDriver driver;

    private static String decodeString(String password) {
        byte[] decodedString = Base64.decodeBase64(password);
        return new String(decodedString);
    }

    @Test
    public void test_login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.silverstripe.org/Security/login");
        driver.findElement(By.name("Email")).sendKeys("admin");
        driver.findElement(By.name("Password")).sendKeys(decodeString("cGFzc3dvcmQ="));
        driver.findElement(By.name("action_doLogin")).click();
    }

}
