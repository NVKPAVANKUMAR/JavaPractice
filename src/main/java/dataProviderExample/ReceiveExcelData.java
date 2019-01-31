package dataProviderExample;

import org.testng.annotations.Test;


public class ReceiveExcelData {

    @Test(dataProvider = "Excel", dataProviderClass = ExcelParser.class)
    public void test_ExcelData(Object username, Object password) {
        System.out.println(username + " : " + password);
    }

}
