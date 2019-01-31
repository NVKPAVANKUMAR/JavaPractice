package selenium;

import Utility.HighlightElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenWebPage {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.moodle.net/login/index.php");
        WebElement loginButton = driver.findElement(By.id("username"));
        HighlightElement.highlight(driver, loginButton);
        loginButton.sendKeys("admin");
        driver.close();

    }
}
