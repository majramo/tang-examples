package verification.dummy

import base.AnyTest
import org.testng.ITestContext
import org.testng.annotations.Test
import pages.linkedin.LinkedInStartPage

public class FailedTest extends AnyTest {

    @Test(groups = "groupOne", description = "REQ ID = Failed Test")
    public void failTestOne(ITestContext iTestContext) {
        LinkedInStartPage linkedinStartPage = new LinkedInStartPage(driver)
        linkedinStartPage.load()
        driver.takeScreenShot("Screen shot on page 1")
        driver.takeScreenShot("Screen shot on page 2")
        tangAssert.assertTrue(false, "Failing test method")
    }


}
