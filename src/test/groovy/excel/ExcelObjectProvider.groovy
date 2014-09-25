package excel

import org.testng.annotations.DataProvider

/**
 * Created by Tavera on 2014-09-24.
 */
class ExcelObjectProvider {


    public static final String INPUT_FILE = "/excel/excelTestFile1.xls"

    @DataProvider(name = "all")
    public static Object[][] all() {
        return getData()
    }

    private static ArrayList<Object[][]> getData(int lines = 0) {
        ArrayList<Object[][]> valueList = new ArrayList<Object[][]>()
        (new ExcelFileObjectReader(INPUT_FILE).getBodyRowObjects(lines)).each {
            valueList.add([it.Number, it.Name, it.Age, it.Gender])
        }
        return valueList
    }


    @DataProvider(name = "fristTwo")
    public static Object[][] fristTwo() {
        return getData(2)
    }

    @DataProvider(name = "thirdObject")
    public static Object[][] thirdObject() {
        ArrayList<Object[][]> valueList = new ArrayList<Object[][]>()
        (new ExcelFileObjectReader(INPUT_FILE).getBodyRowObject(3)).each {
            valueList.add([it.Number, it.Name, it.Age, it.Gender])
        }
        return valueList
    }

    @DataProvider(name = "secondObject")
    public static Object[][] secondObject() {
        ArrayList<Object[][]> valueList = new ArrayList<Object[][]>()
        (new ExcelFileObjectReader(INPUT_FILE).getBodyRowObject(2)).each {
            valueList.add([it.Number, it.Name, it.Age, it.Gender])
        }
        return valueList
    }

    @DataProvider(name = "secondObjects")
    public static Object[][] secondObjects() {
        ArrayList<Object[][]> valueList = new ArrayList<Object[][]>()
        (new ExcelFileObjectReader(INPUT_FILE).getBodyRowObject(2)).each {
            valueList.add([it])
        }
        return valueList
    }



}
