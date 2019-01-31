package dataProviderExample;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelParser {
    private XSSFWorkbook wb;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    @DataProvider(name = "Excel")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("Excel/dataSheet.xlsx");
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(1);
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = row.getLastCellNum();
        System.out.println((rowCount - 2) + " : " + (colCount - 1));
        Object[][] data = new Object[rowCount - 2][colCount - 1];
        for (int i = 1; i <= rowCount - 2; i++) {
            for (int j = 0; j < colCount - 1; j++) {
                cell = sheet.getRow(i).getCell(j);
                data[i - 1][j] = cell;
                System.out.println(data[i - 1][j]);
            }
        }
        return data;
    }
}
