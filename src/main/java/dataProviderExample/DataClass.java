package dataProviderExample;

import org.testng.annotations.DataProvider;

public class DataClass {
    @DataProvider(name = "data")
    public static Object[][] createData() {
        return new Object[][]{
                {"user1", "pwd1"},
                {"test1", "pass2"}
        };
    }
}
