package verification.linkedin

import base.AnyTest
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import pages.linkedin.LinkedInSearchResultPage
import pages.linkedin.LinkedInStartPage

public class SearchLastNameAtLinkedInTest extends AnyTest {

    private static final String FIRST_NAME = "Majid"
    private static final String LAST_NAME = "Aram"
    private static final int HITS_ON_PAGE = 25
    private LinkedInStartPage linkedinStartPage

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        linkedinStartPage = new LinkedInStartPage(driver)
        linkedinStartPage.load()
    }

    @Test
    public void searchByLastNameTest() {
        linkedinStartPage.typeSearchFirstName("")
        linkedinStartPage.typeSearchLastName(LAST_NAME)
        LinkedInSearchResultPage linkedInSearchResultPage = linkedinStartPage.clickSeacrh()

        Assert.assertTrue(linkedInSearchResultPage.getTextOfFoundPersons().contains(LAST_NAME), "Verify lastName is in text " + LAST_NAME)
        Assert.assertTrue(linkedInSearchResultPage.getNumberOfFoundPersons() > 100, "Verify number of profiles is more than " + 100)
        Assert.assertEquals(linkedInSearchResultPage.getNumberOfFoundPersonsOnPage(), HITS_ON_PAGE, "Verify number of hits on page is " + HITS_ON_PAGE)
    }

    @Test
    public void searchByFirstNameTest() {
        linkedinStartPage.typeSearchLastName("")
        linkedinStartPage.typeSearchFirstName(FIRST_NAME)
        LinkedInSearchResultPage linkedInSearchResultPage = linkedinStartPage.clickSeacrh()

        Assert.assertTrue(linkedInSearchResultPage.getTextOfFoundPersons().contains(FIRST_NAME), "Verify firstName is in text " + FIRST_NAME)
        Assert.assertEquals(linkedInSearchResultPage.getNumberOfFoundPersonsOnPage(), HITS_ON_PAGE, "Verify number of hits on page is " + HITS_ON_PAGE)
    }


    @Test
    public void searchByFirstNameAndPartOfLastNameTest() {
        linkedinStartPage.typeSearchLastName(LAST_NAME.substring(0, 1))
        linkedinStartPage.typeSearchFirstName(FIRST_NAME)
        LinkedInSearchResultPage linkedInSearchResultPage = linkedinStartPage.clickSeacrh()

        Assert.assertTrue(linkedInSearchResultPage.getTextOfFoundPersons().contains(FIRST_NAME), "Verify firstName is in text " + FIRST_NAME)
        Assert.assertNotEquals(linkedInSearchResultPage.getNumberOfFoundPersonsOnPage(), HITS_ON_PAGE, "Verify number of hits on page is not  " + HITS_ON_PAGE)
    }
}
