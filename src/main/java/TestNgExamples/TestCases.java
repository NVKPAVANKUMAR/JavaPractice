package TestNgExamples;

import Utility.BrowserInstance;
import Utility.ConfigParser;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;


public class TestCases extends BrowserInstance {

    @BeforeClass
    public static void setupMethod() throws IOException {
        initiateDriver(ConfigParser.fetchProperity("browser"));
    }

    @AfterClass
    public static void teardownMethod() {
        closeBrowser();
    }

    @Test
    public void testcase_01() throws IOException {
        openUrl(ConfigParser.fetchProperity("url"));
    }


}
