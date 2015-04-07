package verification.dummy

import base.AnyTest
import org.testng.ITestContext
import org.testng.SkipException
import org.testng.annotations.Test
import pages.linkedin.LinkedInStartPage

public class AllTest extends AnyTest {

    @Test(groups = "groupOne", description = "REQ ID = Pass Test")
    public void passTest(ITestContext iTestContext) {
        driver.openUrl("http://www.google.se")
        takeScreenshot("")

        tangAssert.assertTrue(true, "Passing test method")
    }


    @Test(groups = "groupOne", description = "REQ ID = Fail Test")
    public void failTestTwo(ITestContext iTestContext) {
        driver.openUrl("http://www.linkedin.com")

        tangAssert.assertTrue(false, "Failing test method")
    }

    @Test(groups = "groupOne", description = "REQ ID = Fail Test using SeleniumHelper")
    public void failTestThree(ITestContext iTestContext) {
        driver.openUrl("http://www.linkedin.com")

        driver.type("//unknownElement", "Some text")
    }


    @Test(groups = "groupOne", description = "REQ ID = Skip Test")
    public void skipTest(ITestContext iTestContext) {
        driver.openUrl("http://www.linkedin.com")

        throw new SkipException("Skip the test")
    }

    @Test(groups = "groupOne", description = "REQ ID = Failed Test")
    public void failTestFive(ITestContext iTestContext) {
        super.getDbResult(iTestContext, "Select * from IkeaSearchPhrases;", "Get data from table")
        super.getDbResult(iTestContext, "sqlServer", "Select * from IkeaSearchPhrases;", "Get data from table")
        LinkedInStartPage linkedinStartPage = new LinkedInStartPage(driver)
        linkedinStartPage.load()
        takeScreenshot("Screen shot on page 1")
        tangAssert.assertTrue(false, "Failing test method")
    }

    @Test(groups = "groupOne", description = "REQ ID = Failed Test")
    public void failTestFour(ITestContext iTestContext) {
        super.getDbResult(iTestContext, "Select * from IkeaSearchPhrases;", "Get data from table")
        super.getDbResult(iTestContext, "oracle", "Select * from IkeaSearchPhrases;", "Get data from table")
        LinkedInStartPage linkedinStartPage = new LinkedInStartPage(driver)
        linkedinStartPage.load()
        takeScreenshot("Screen shot on page 1")
        tangAssert.assertTrue(false, "Failing test method")
    }

}
