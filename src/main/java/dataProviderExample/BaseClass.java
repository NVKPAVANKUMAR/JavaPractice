package dataProviderExample;

import org.testng.annotations.DataProvider;

public class BaseClass {
    @DataProvider(name = "dp")
    public Object[][] createData() {
        return new Object[][]{
                {"usn", "pwd"},
                {"test", "pass"}
        };
    }

}
