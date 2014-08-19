package verification.linkedindataprovider

import base.AnyTest
import org.testng.Reporter
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import pages.linkedin.LinkedInSearchResultPage
import pages.linkedin.LinkedInStartPage

public class SearchLastNamesAtLinkedInTest extends AnyTest {

    private LinkedInStartPage linkedinStartPage
    private static final LT = "<"
    private static final GT = ">"

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        linkedinStartPage = new LinkedInStartPage(driver)
        linkedinStartPage.load()
    }

    @Test(dataProvider = "linkedInTestData")
    public void searchByLastNameTest(String lastName, Integer searchCount) {
        Reporter.log("Testing $LT$lastName$GT $LT$searchCount$GT")
        linkedinStartPage.typeSearchFirstName("")
        linkedinStartPage.typeSearchLastName(lastName)

        LinkedInSearchResultPage linkedInSearchResultPage = linkedinStartPage.clickSeacrh()
        tangAssert.assertTrue(linkedInSearchResultPage.getTextOfFoundPersons().contains(lastName), "Verify lastname is in text $LT$lastName$GT")
        def numberOfFoundPersons = linkedInSearchResultPage.getNumberOfFoundPersons()
        tangAssert.assertTrue((numberOfFoundPersons > searchCount), "Verify number of profiles $LT$numberOfFoundPersons$GT is more than $LT$searchCount$GT")
    }





    @DataProvider(name = "linkedInTestData")
    public Object[][] createData() {
        [
                ["Aram", new Integer(650)],
                ["Majid", new Integer(4000)],
                ["Test", new Integer(5600)],
                ["Automation", new Integer(400)],
                ["Vem", new Integer(100)],
                ["Verification", new Integer(25)],
                ["Robot", new Integer(180)]
        ] as Object[][]
    }


}
