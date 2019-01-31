package javaExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class AutomateGoogleSearchExample {


    private WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
    }

    @Test
    public void test_GoogleSearch() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Java");
        Thread.sleep(10000);
        List<WebElement> suggestionBoxItems = driver.
                findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[contains(@class,'sbl1')]"));
        System.out.println(suggestionBoxItems.size());
    }
}
