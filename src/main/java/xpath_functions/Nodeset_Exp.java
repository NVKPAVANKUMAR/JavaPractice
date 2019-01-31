package xpath_functions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Nodeset_Exp {
    private static WebDriver driver = null;

    public void tets_01() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/styling/checkboxes");
        //List<WebElement> checkboxes = driver.findElements(By.xpath(""))
        /* selecting checkboxes using XPATH
        1. Using descendant
         //*[@class="fieldlist"]/descendant::input[3]
        2. Using child
         //*[@class="fieldlist"]/child::li/input[1]
        3. Using @type
        //input[]
        */


    }
}
