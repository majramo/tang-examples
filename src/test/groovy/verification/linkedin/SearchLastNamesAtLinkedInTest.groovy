package verification.linkedin

import base.AnyTest
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import pages.linkedin.LinkedInSearchResultPage
import pages.linkedin.LinkedInStartPage

public class SearchLastNamesAtLinkedInTest extends AnyTest {

    private LinkedInStartPage linkedinStartPage

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        linkedinStartPage = new LinkedInStartPage(driver)
        linkedinStartPage.load()
    }

    @DataProvider(name = "test1")
    public Object[][] createData() {
        [
                ["Aram", new Integer(600)],
                ["Majid", new Integer(4000)],
                ["Test", new Integer(5600)],
                ["Automation", new Integer(400)],
                ["Vem", new Integer(100)],
                ["Verification", new Integer(30)],
                ["Robot", new Integer(190)]
        ] as Object[][]
    }





    @Test(dataProvider = "test1")
    public void searchByLastNameTest(String lastName, Integer searchCount) {
        linkedinStartPage.typeSearchFirstName("")
        linkedinStartPage.typeSearchLastName(lastName)
        LinkedInSearchResultPage linkedInSearchResultPage = linkedinStartPage.clickSeacrh()
        Assert.assertTrue(linkedInSearchResultPage.getTextOfFoundPersons().contains(lastName), "Verify lastname is in text " + lastName)
        Assert.assertTrue((linkedInSearchResultPage.getNumberOfFoundPersons() > searchCount), "Verify number of profiles is more than " + searchCount)
    }


}
