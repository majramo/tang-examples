package verification.linkedin

import base.AnyTest
import corebase.HtmlXmlValidationEngine
import htmls.LinkedInDatabaseVerificationHtmlDTO
import org.testng.Reporter
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import pages.linkedin.LinkedInSearchResultPage
import pages.linkedin.LinkedInStartPage

import static dtos.base.Constants.CR

public class SearchFirstNameAndLastNameAtLinkedInDbTest extends AnyTest {

    private LinkedInStartPage linkedInStartPage

    @BeforeMethod
    public void beforeMethod() {
        linkedInStartPage = new LinkedInStartPage(driver)
        linkedInStartPage.load()
    }


    @Test(dataProvider = "test1")
    public void searchByFirstNameAndLastNameVerifyDatabaseTest(String firstName, String lastName, String searchString) {
        linkedInStartPage.typeSearchFirstName(firstName)
        linkedInStartPage.typeSearchLastName(lastName)
        LinkedInSearchResultPage linkedInSearchResultPage = linkedInStartPage.clickSeacrh()
        linkedInSearchResultPage.clickOnResultContaining(searchString)
        Map context = [:]
        context["testId"] = "$firstName.$lastName"
        HtmlXmlValidationEngine hxve = new HtmlXmlValidationEngine(context, LinkedInDatabaseVerificationHtmlDTO.simpleName, driver.getPageSource(), 1)
        def result = hxve.returnAssertResult()
        Reporter.log("Result of LinkedInDbHtmlDTO " + result + CR)
        def assertFile = hxve.returnAsserttionFile()
        Reporter.log("See assertFile: " + getHtmlLinkTag(assertFile.toString()) + CR)
        takeScreenshot(!result)
        tangAssert.assertTrue(result, "Advanced verification result")

    }

    @DataProvider(name = "test1")
    public Object[][] createData() {
        [
                ["Patrick", "Nawrocki", "Objektfabriken"],
                ["Majid", "Aram", "Stockholm"],
                ["Frank", "Lindholm", "Objektfabriken"],
        ] as Object[][]
    }


}
