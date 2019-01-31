package restAssured_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class GetAllLinks {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        System.setProperty("webdriver.chrome.driver", "DriverJars/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demo.moodle.net/login/index.php");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println(allLinks.size());
        for (WebElement link : allLinks) {
            System.out.println(link.getAttribute("href"));
        }
        for (int i = 1; i <= 4; i++) {
            List<WebElement> allCredentials = driver.findElements(By.cssSelector(String.format("li:nth-child(%d)", i)));
            for (WebElement ele : allCredentials) {
                System.out.println(ele.getText());
            }
        }
        driver.quit();
    }
}
