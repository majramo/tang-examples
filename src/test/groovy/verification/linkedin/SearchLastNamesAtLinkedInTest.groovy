package verification.linkedin

import base.AnyTest
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import pages.linkedin.LinkedInSearchResultPage
import pages.linkedin.LinkedInStartPage

public class SearchLastNamesAtLinkedInTest extends AnyTest {

    private LinkedInStartPage linkedInStartPage

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        linkedInStartPage = new LinkedInStartPage(driver)
        linkedInStartPage.load()
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
        linkedInStartPage.typeSearchFirstName("")
        linkedInStartPage.typeSearchLastName(lastName)
        LinkedInSearchResultPage linkedInSearchResultPage = linkedInStartPage.clickSeacrh()
        Assert.assertTrue(linkedInSearchResultPage.getTextOfFoundPersons().contains(lastName), "Verify lastName is in text " + lastName)
        Assert.assertTrue((linkedInSearchResultPage.getNumberOfFoundPersons() > searchCount), "Verify number of profiles is more than " + searchCount)
    }


}
