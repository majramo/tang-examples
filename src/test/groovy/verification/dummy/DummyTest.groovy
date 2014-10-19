package verification.dummy

import base.AnyTest
import org.testng.ITestContext
import org.testng.annotations.Test

public class DummyTest extends AnyTest {

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void testOne(ITestContext iTestContext) {
        driver.openUrl("file:///Users/majidaram/tmp/tang-examples/test-output/html/index.html")
        driver.takeScreenShot("")
        driver.waitForPageReadyStateComplete()
    }


}
