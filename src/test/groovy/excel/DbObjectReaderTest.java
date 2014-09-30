package excel;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static excel.DbObjectProvider.getObject;
import static excel.DbObjectProvider.getObjects;

public class DbObjectReaderTest {
     private final static String QUERY = "SELECT TOP %s FIRSTNAME, CINT_SOC_SEC_NO_DASHLESS from FilteredContact where not CINT_SOC_SEC_NO_DASHLESS is null ORDER BY 1";

    @Test(dataProvider = "all")
    public void all(String firstName, String number) {
        printOut(firstName, number);
    }

    @Test(dataProvider = "firstTwo")
    public void fristTwo(String firstName, String number) {
        printOut(firstName, number);
    }

    @Test(dataProvider = "thirdObject")
    public void thirdObject(String firstName, String number) {
        printOut(firstName, number);
    }



    //######################################################### Providers

    @DataProvider(name = "all")
    public static Object[][] all() {
        return  getObjects("Test_MSCRM_DB", QUERY);
    }

    @DataProvider(name = "firstTwo")
    public static Object[][] firstTwo() {
        return  getObjects("Test_MSCRM_DB", QUERY, 2);
    }

    @DataProvider(name = "thirdObject")
    public static Object[][] thirdObject() {
        return  getObject("Test_MSCRM_DB", QUERY, 3);
    }


    //######################################################### Print out

    private void printOut(String firstName, String number) {
        Reporter.log("Firstname: " + firstName + " Number: " +   number);
    }

}
