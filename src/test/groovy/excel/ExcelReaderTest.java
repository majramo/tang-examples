package excel;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReaderTest {


    @Test(dataProvider = "all")
    public void all(ExcelBodyRow excelBodyRow) {
        Reporter.log("Nr " + excelBodyRow.getColumn("Nr") + " Namn " + excelBodyRow.getColumn("Namn"));
    }

    @Test(dataProvider = "firstTwo")
    public void firstTwo_1(ExcelBodyRow excelBodyRow) {
        Reporter.log("Nr " + excelBodyRow.getColumn("Nr") + " Namn " + excelBodyRow.getColumn("Namn"));
    }

    @Test(dataProvider = "firstThree")
    public void firstThree(ExcelBodyRow excelBodyRow) {
        Reporter.log("Nr " + excelBodyRow.getColumn("Nr") + " Namn " + excelBodyRow.getColumn("Namn"));
    }

    @Test(dataProvider = "firstTwo")
    public void firstTwo_2(ExcelBodyRow excelBodyRow) {
        Reporter.log("Data " + excelBodyRow);
    }

    @Test(dataProvider = "firstTwo")
    public void firstTwo_3(ExcelBodyRow excelBodyRow) {
        Reporter.log("Missing column 'Unknown' " + excelBodyRow.getColumn("Unknown") + " Namn " + excelBodyRow.getColumn("Namn"));
    }


    @DataProvider(name = "all")
    public Object[][] getTableFieldChecksFromExcel1() {
        return (new ExcelFileReader("/excel/excelTestFile1.xls").getBodyRows());
    }


    @DataProvider(name = "firstTwo")
    public Object[][] getTableFieldChecksFromExcel2() {
        return (new ExcelFileReader("/excel/excelTestFile1.xls").getBodyRows(2));
    }


    @DataProvider(name = "firstThree")
    public Object[][] getTableFieldChecksFromExcel3() {
        return (new ExcelFileReader("/excel/excelTestFile1.xls").getBodyRow(3));
    }

}
