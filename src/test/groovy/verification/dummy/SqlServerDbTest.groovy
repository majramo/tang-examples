package verification.dummy

import base.AnySqlTest
import org.testng.ITestContext
import org.testng.Reporter
import org.testng.SkipException
import org.testng.annotations.Test

import static dtos.base.Constants.dbRunTypeRows

public class SqlServerDbTest extends AnySqlTest {

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void testOne(ITestContext iTestContext) {
        def query = "SELECT * FROM IkeaSearchPhrases"
        def dbResult = getDbResult("Get data from table IkeaSearchPhrases", dbRunTypeRows, query, 0)
        int counter = 1
        dbResult.each {
            Reporter.log(counter++ + " " + it.toString())
        }
        tangAssert.assertTrue(dbResult.size() > 0, "Result should have some entries")
    }

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void testTwo(ITestContext iTestContext) {
        def query = "SELECT country, phrase, hits, COUNT(*)count FROM IkeaSearchPhrases " +
                "GROUP BY country, phrase, hits " +
                "HAVING COUNT(*) > 1"
        def dbResult = getDbResult("Get data from table IkeaSearchPhrases", dbRunTypeRows, query, 0)
        int counter = 1
        dbResult.each {
            Reporter.log(counter++ + " " + it.toString())
        }
        tangAssert.assertTrue(dbResult.size() == 0, "Result should have no entries")
    }

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void testThree(ITestContext iTestContext) {
        def query = "SELECT country, hits, COUNT(*)count FROM IkeaSearchPhrases " +
                "GROUP BY country, hits " +
                "HAVING COUNT(*) > 1"
        def dbResult = getDbResult("Get data from table IkeaSearchPhrases", dbRunTypeRows, query, 0)
        int counter = 1
        dbResult.each {
            Reporter.log(counter++ + " " + it.toString())
        }
        tangAssert.assertTrue(dbResult.size() == 0, "Result should have no entries")
    }

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void skipTest(ITestContext iTestContext) {
        throw new SkipException("Just skipped")

    }



}
