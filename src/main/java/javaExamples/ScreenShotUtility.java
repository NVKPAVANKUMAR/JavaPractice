package javaExamples;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenShotUtility {

    public static void takeScreenshot(WebDriver driver, String imageTitle) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("screenshots/" + imageTitle + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
