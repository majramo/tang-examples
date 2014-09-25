package excel;

import org.apache.xpath.ExtensionsProvider;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class ExcelObjectReaderTest {

    @Test(dataProvider = "all", dataProviderClass = ExcelObjectProvider.class)
    public void all(String number, String name, String age, String gender) {
        printOut(number, name, age, gender);
    }

    @Test(dataProvider = "fristTwo", dataProviderClass = ExcelObjectProvider.class)
    public void fristTwo(String number, String name, String age, String gender) {
        printOut(number, name, age, gender);
    }

    @Test(dataProvider = "thirdObject", dataProviderClass = ExcelObjectProvider.class)
    public void thirdObject(String number, String name, String age, String gender) {
        printOut(number, name, age, gender);
    }

    @Test(dataProvider = "secondObject", dataProviderClass = ExcelObjectProvider.class)
    public void secondObject(String number, String name, String age, String gender) {
        printOut(number, name, age, gender);
    }

    private void printOut(String number, String name, String age, String gender) {
        Reporter.log("Number: " + number + " Name: " + name + " Age: " + age + " Gender: " + gender);
    }

}
