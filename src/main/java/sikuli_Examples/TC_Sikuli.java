package sikuli_Examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Sikuli {
    private WebDriver driver = null;
    private Screen scr = null;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "DriverJars/chromedriver.exe");
    }

    // @Test
    public void tc001_clickOnNewFolder() throws FindFailed {
        scr = new Screen();
        Pattern newFolderImg = new Pattern("sikuli_images/NewFolder_img.PNG");
        scr.find(newFolderImg);
        scr.doubleClick(newFolderImg);
    }

    @Test
    public void tc002_DoLogin() throws FindFailed {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.moodle.net/login/index.php");
        scr = new Screen();
        Pattern userName = new Pattern("sikuli_images/usname.PNG");
        Pattern passWd = new Pattern("sikuli_images/passwd.PNG");
        Pattern signInBtn = new Pattern("sikuli_images/lgnbtn.PNG");
        scr.wait(userName);
        scr.find(userName).highlight(2);
        scr.type(userName, "admin");
        scr.find(passWd).highlight(2);
        scr.type(passWd, "sandbox");
        scr.find(signInBtn).highlight(2);
        scr.click(signInBtn);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
