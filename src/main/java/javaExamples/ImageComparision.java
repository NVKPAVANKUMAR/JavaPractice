package javaExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImageComparision {


    private static WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void compare() throws IOException {
        driver.get("http://demo.automationtesting.in/Register.html");
        BufferedImage expectedImage = ImageIO.read(new File("images/original.png"));

        WebElement logoImage = driver.findElement(By.id("imagetrgt"));
        Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImage);
        BufferedImage actualImage = logoImageScreenshot.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
        System.out.println(diff.getDiffSize());
        Assert.assertFalse(diff.hasDiff(), "Images are Same");
    }

    @AfterTest
    public void teardownClass() {
        driver.quit();
    }
}
