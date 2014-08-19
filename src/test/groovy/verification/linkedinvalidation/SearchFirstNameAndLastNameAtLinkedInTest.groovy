package verification.linkedinvalidation

import base.AnyTest
import corebase.HtmlXmlValidationEngine
import org.testng.ITestContext
import org.testng.Reporter
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import pages.linkedin.LinkedInStartPage

import static dtos.base.Constants.CR

public class SearchFirstNameAndLastNameAtLinkedInTest extends AnyTest {

    private static final String FIRST_NAME = "Majid"
    private static final String LAST_NAME = "Aram"
    private LinkedInStartPage linkedinStartPage

    @BeforeClass
    public void beforeClass() {
        linkedinStartPage = new LinkedInStartPage(driver)
        linkedinStartPage.load()
    }


    @Test
    public void seachByFirstNameAndLastNameTestValidateAll(ITestContext testContext) {
        linkedinStartPage.typeSearchFirstName(FIRST_NAME)
        linkedinStartPage.typeSearchLastName(LAST_NAME)

        def context = [:]
        context["testId"] = "majid"
        HtmlXmlValidationEngine hxve = new HtmlXmlValidationEngine(context, "LinkedInHtmlDTO", driver.getPageSource(), 1)
        def result = hxve.returnAssertResult()
        Reporter.log("Result of LinkedInHtmlDTO: " + result + CR)
        def assertFile = hxve.returnAsserttionFile()
        Reporter.log("See assertFile: " + getHtmlLinkTag(assertFile.toString()) + CR)
        takeScreenshot(!result)
        tangAssert.assertTrue(result, "Advanced validation result")

    }
}
