package javaExamples;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElementUtility {

    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript("arguments[0].setAttribute('style',arguments[1]);",
                element, "color:yellow;border:3px solid red;");
    }
}
