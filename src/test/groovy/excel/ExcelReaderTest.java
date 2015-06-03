package excel;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReaderTest {


    @Test(dataProvider = "all")
    public void all(ExcelBodyRow excelBodyRow) {
        Reporter.log("Nr " + excelBodyRow.getColumn("Number") + " Namn " + excelBodyRow.getColumn("Name"));
    }

    @Test(dataProvider = "firstTwo")
    public void firstTwo_1(ExcelBodyRow excelBodyRow) {
        Reporter.log("Nr " + excelBodyRow.getColumn("Number") + " Namn " + excelBodyRow.getColumn("Name"));
    }

    @Test(dataProvider = "thirdRow")
    public void thirdTest(ExcelBodyRow excelBodyRow) {
        Reporter.log("Nr 3: " + excelBodyRow.getColumn("Number") + " Namn " + excelBodyRow.getColumn("Name"));
    }

    @Test(dataProvider = "fourthRow")
    public void fourthTest(ExcelBodyRow excelBodyRow) {
        Reporter.log("Nr 4: " + excelBodyRow.getColumn("Number") + " Namn " + excelBodyRow.getColumn("Name"));
    }

    @Test(dataProvider = "firstTwo")
    public void firstTwo_2(ExcelBodyRow excelBodyRow) {
        Reporter.log("Data " + excelBodyRow);
    }

    @Test(dataProvider = "firstTwo")
    public void firstTwo_3(ExcelBodyRow excelBodyRow) {
        Reporter.log("Missing column 'Unknown' " + excelBodyRow.getColumn("Unknown") + " Namn " + excelBodyRow.getColumn("Name"));
    }


    @DataProvider(name = "all")
    public Object[][] getTableFieldChecksFromExcel1() {
        return (new ExcelFileReader("/excel/excelTestFile1.xls").getBodyRows());
    }


    @DataProvider(name = "firstTwo")
    public Object[][] getTableFieldChecksFromExcel2() {
        return (new ExcelFileReader("/excel/excelTestFile1.xls").getBodyRows(2));
    }


    @DataProvider(name = "thirdRow")
    public Object[][] getExcelThirdRow() {
        return (new ExcelFileReader("/excel/excelTestFile1.xls").getBodyRow(3));
    }

    @DataProvider(name = "fourthRow")
    public Object[][] getExcelFourthRow() {
        return (new ExcelFileReader("/excel/excelTestFile1.xls").getBodyRow(4));
    }
}
