package verification.demo

import base.AnyTest
import org.testng.ITestContext
import org.testng.SkipException
import org.testng.annotations.Test

public class SkippedTest extends AnyTest {

    @Test(groups = "groupOne", description = "REQ ID = Skip Test")
    public void searchAtLinkedInSkipTest(ITestContext iTestContext) {
        driver.openUrl("http://www.linkedin.com")

        throw new SkipException("Skip the test")
    }

}
