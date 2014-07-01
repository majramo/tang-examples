package verification.dummy

import base.AnySqlTest
import org.testng.ITestContext
import org.testng.Reporter
import org.testng.annotations.Test

import static dtos.base.Constants.dbRunTypeRows

public class SqlServerDbTest extends AnySqlTest {

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void testOne(ITestContext iTestContext) {
        def query = "SELECT * FROM IkeaSearchPhrases"
        def dbResult = getDbResult("Get all data from table IkeaSearchPhrases", dbRunTypeRows, query, 0)
        int counter = 1
        dbResult.each {
            Reporter.log(counter++ + " " + it.toString())
        }
        vemAssert.assertTrue(dbResult.size() > 0, "Result should have some value")
    }


}
