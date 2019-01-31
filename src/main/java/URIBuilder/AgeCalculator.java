package URIBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AgeCalculator {
    public WebDriver driver = null;

    @Test
    public void test_age() throws URISyntaxException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String fromDate = getDate();
        String url = getFormattedURI(fromDate);
        driver.get(url);
        String age_text = driver.findElement(By.xpath("//*[@id='content']/p[1]")).getText();
        System.out.println(age_text.replace("Age:", ""));
    }


    private String getDate() throws URISyntaxException {
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());

    }

    private String getFormattedURI(String fromDate) throws URISyntaxException {
        URIBuilder ub = new URIBuilder("https://www.calculator.net/age-calculator.html");
        ub.addParameter("today", fromDate);
        ub.addParameter("ageat", "04/10/2019");
        ub.addParameter("x", "72");
        ub.addParameter("y", "2");
        return ub.toString();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    //-----------------------------------------------------------------------
    // @Test
    private void createSearchQueryPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Date ");

        String date = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date2 = null;
        try {
            //Parsing the String
            date2 = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(date2);
        String path = null;
        //return path;
    }

    //@Test
    public void test_URIBuilder() throws URISyntaxException {
        URIBuilder ub = new URIBuilder("https://www.calculator.net/age-calculator.html");
        ub.addParameter("today", "04/10/2017");
        ub.addParameter("ageat", "07/02/2019");
        ub.addParameter("x", "72");
        ub.addParameter("y", "2");
        String url = ub.toString();
        System.out.println(url);
    }
}
