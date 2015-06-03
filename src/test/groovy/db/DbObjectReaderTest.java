package db;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static db.DbObjectProvider.getObject;
import static db.DbObjectProvider.getObjects;

public class DbObjectReaderTest {
     private final static String QUERY = "SELECT TOP %s firstName from Contact";

    @Test(dataProvider = "all")
    public void all(String firstName) {
        printOut(firstName);
    }

    @Test(dataProvider = "firstTwo")
    public void firstTwo(String firstName) {
        printOut(firstName);
    }

    @Test(dataProvider = "thirdObject")
    public void thirdObject(String firstName) {
        printOut(firstName);
    }



    //######################################################### Providers

    @DataProvider(name = "all")
    public static Object[][] all() {
        return  getObjects("DataBase", QUERY);
    }

    @DataProvider(name = "firstTwo")
    public static Object[][] firstTwo() {
        return  getObjects("DataBase", QUERY, 2);
    }

    @DataProvider(name = "thirdObject")
    public static Object[][] thirdObject() {
        return  getObject("DataBase", QUERY, 3);
    }


    //######################################################### Print out

    private void printOut(String firstName) {
        Reporter.log("FirstName: " + firstName );
    }

}
