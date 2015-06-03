package verification.dummy

import base.AnySqlTest
import org.testng.ITestContext
import org.testng.Reporter
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static dtos.base.Constants.dbRunTypeRows
import static dtos.base.Constants.dbRunTypeRowsSelects

public class MySqlDbTest extends AnySqlTest {

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void testOne(ITestContext iTestContext) {
        def query = "SELECT * FROM IkeaSearchPhrases"
        def dbResult = getDbResult("Get all data from table IkeaSearchPhrases", dbRunTypeRows, query, 0)
        int counter = 1
        dbResult.each {
            Reporter.log(counter++ + " " + it.toString())
        }
        tangAssert.assertTrue(dbResult.size() > 0, "Result should have some value")
//        tangAssert.assertTrue(dbResult.size() < 1, "Result should have some value")
    }

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void testTwo(ITestContext iTestContext) {
        def query = "SELECT * FROM IkeaSearchPhrases LIMIT 1;"
        def dbResult = getDbResult("Get top 1 data from table IkeaSearchPhrases", dbRunTypeRows, query, 0)
        int counter = 1
        dbResult.each {
            Reporter.log(counter++ + " " + it.toString())
        }
    }

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void testThree(ITestContext iTestContext) {
        def query = "SELECT * FROM IkeaSearchPhrases;"
        def dbResult = getDbResult("Get row 1 data from table IkeaSearchPhrases", dbRunTypeRowsSelects, query, 1)
        int counter = 1
        dbResult.each {
            Reporter.log(counter++ + " " + it.toString())
        }
    }

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void testFour(ITestContext iTestContext) {
        def query = "SELECT * FROM IkeaSearchPhrases;"
        def dbResult = getDbResult("Get row 2 data from table IkeaSearchPhrases", dbRunTypeRowsSelects, query, 2)
        int counter = 1
        dbResult.each {
            Reporter.log(counter++ + " " + it.toString())
        }
    }

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void testFive(ITestContext iTestContext) {
        def query = "SELECT * FROM IkeaSearchPhrases;"
        def dbResult = getDbResult("Get row 3 data from table IkeaSearchPhrases", dbRunTypeRowsSelects, query, 3)
        int counter = 1
        dbResult.each {
            Reporter.log(counter++ + " " + it.toString())
        }
    }

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void testSix(ITestContext iTestContext) {
        def query = "SELECT * FROM IkeaSearchPhrase"
        def dbResult = getDbResult("Get all data from table IkeaSearchPhrases", dbRunTypeRows, query, 0)
        int counter = 1
        dbResult.each {
            Reporter.log(counter++ + " " + it.toString())
        }
        tangAssert.assertTrue(dbResult.size() > 0, "Result should have some value")
//        tangAssert.assertTrue(dbResult.size() < 1, "Result should have some value")
    }

    @Test(dataProvider = "tableAndFieldsEqualNull", groups = "data", description = "REQ ID = Req abcd")
    public void checkNullValues(table, field) {
        Reporter.log("Table: $table Field: $field");
        checkNullValueInFieldInTableQuery(table, field);
    }


    @Test(dataProvider = "tableAndFieldsDuplicates", groups = "data", description = "REQ ID = Req abcd")
    public void checkDuplicatedValues(table, fields) {
        Reporter.log("Table: $table Fields: $fields");
        checkDuplicateOfRowsRegardingFieldsInTableQuery(table, fields);
    }




    @DataProvider(name = "tableAndFieldsEqualNull")
    public Object[][] tableAndFieldsEqualNull() {
        [
                ["IkeaSearchPhrases", "country"],
                ["IkeaSearchPhrases", "Phrase"],
                ["IkeaSearchPhrases", "hits"],
        ] as Object[][]
    }

    @DataProvider(name = "tableAndFieldsDuplicates")
    public Object[][] tableAndFieldsDuplicates() {
        [
                ["IkeaSearchPhrases", "concat(country , Phrase)"],
                ["IkeaSearchPhrases", "concat(country , Phrase , hits)"],
        ] as Object[][]
    }


}
