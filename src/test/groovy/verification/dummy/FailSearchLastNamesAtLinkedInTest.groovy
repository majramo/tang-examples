package verification.dummy

import base.AnyTest
import org.testng.Reporter
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import pages.linkedin.LinkedInSearchResultPage
import pages.linkedin.LinkedInStartPage

import java.lang.reflect.Method

public class FailSearchLastNamesAtLinkedInTest extends AnyTest {

    private LinkedInStartPage linkedinStartPage
    private static final LT = "<"
    private static final GT = ">"

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method m) {
        linkedinStartPage = new LinkedInStartPage(driver)
        linkedinStartPage.load()
    }

    @DataProvider(name = "test1")
    public Object[][] createData() {
        [
                ["Aram", new Integer(6000)],
                ["Automation", new Integer(4003)]
        ] as Object[][]
    }

    @Test(dataProvider = "test1")
    public void searchByLastNameTest(String lastName, Integer searchCount) {
        Reporter.log("Testing $LT$lastName$GT $LT$searchCount$GT")
        linkedinStartPage.typeSearchFirstName("")
        linkedinStartPage.typeSearchLastName(lastName)

        LinkedInSearchResultPage linkedInSearchResultPage = linkedinStartPage.clickSeacrh()
        tangAssert.assertTrue(linkedInSearchResultPage.getTextOfFoundPersons().contains(lastName), "Verify lastname is in text $LT$lastName$GT")
        def numberOfFoundPersons = linkedInSearchResultPage.getNumberOfFoundPersons()
        tangAssert.assertTrue((numberOfFoundPersons > searchCount), "Verify number of profiles $LT$numberOfFoundPersons$GT is more than $LT$searchCount$GT")
    }


}
