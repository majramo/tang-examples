package verification.demo

import base.AnyTest
import org.testng.ITestContext
import org.testng.SkipException
import org.testng.annotations.Test
import pages.linkedin.LinkedInStartPage

public class FailedTest extends AnyTest {

    @Test(groups = "groupOne", description = "REQ ID = Fail Test")
    public void searchAtLinkedInFailTest(ITestContext iTestContext) {
        driver.openUrl("http://www.linkedin.com")
        driver.type("//*[@id='first']", "Majid")
        driver.type("//*[@id='last']", "Aram")
        driver.click("//*[@id='search']/form/p/input")

        tangAssert.assertTrue(driver.getText("result-set").contains("MajidAram"), "Failing test method, MajidAram was not found.")
    }

    @Test(groups = "groupOne", description = "REQ ID = Fail Test using SeleniumHelper")
    public void searchAtLinkedInFailUnknownElement(ITestContext iTestContext) {
        driver.openUrl("http://www.linkedin.com")

        driver.type("unKnownElementOnPage", "Some text")
    }
}
