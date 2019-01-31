package dataProviderExample;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderExp extends BaseClass {

    @Test(priority = 1, dataProvider = "dp")
    public void verifyData(String n1, String n2) {
        System.out.println(n1 + " - " + n2);
    }

    @Test(priority = 2, dataProvider = "data", dataProviderClass = DataClass.class)
    public void getData(String username, String passowrd) {
        System.out.println(username + " : " + passowrd);
    }

    @Parameters({"username", "password"})
    @Test(priority = 3)
    public void parseDataParameter(String username, String password) {
        System.out.println(username + " = " + password);
    }

}
