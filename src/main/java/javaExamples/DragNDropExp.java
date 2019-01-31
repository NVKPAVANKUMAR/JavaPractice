package javaExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DragNDropExp {

    private static WebDriver driver = null;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "DriverJars/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
        Thread.sleep(2000);
    }

    @Test
    public void test_dragNdropMethod1() {
        Actions act = new Actions(driver);
        WebElement drag = driver.findElement(By.xpath(".//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath(".//*[@id='droppable']"));
        act.dragAndDrop(drag, drop).build().perform();
        ScreenShotUtility.takeScreenshot(driver, "method1");
    }

    @Test
    public void test_dragNdropMethod2() {
        Actions act = new Actions(driver);
        WebElement drag = driver.findElement(By.xpath(".//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath(".//*[@id='droppable']"));
        act.clickAndHold(drag).release(drop).build().perform();
        ScreenShotUtility.takeScreenshot(driver, "method2");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
