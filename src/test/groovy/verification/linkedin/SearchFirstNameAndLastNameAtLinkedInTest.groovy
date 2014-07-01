package verification.linkedin

import base.AnyTest
import org.testng.Assert
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import pages.linkedin.LinkedInSearchResultPage
import pages.linkedin.LinkedInStartPage

public class SearchFirstNameAndLastNameAtLinkedInTest extends AnyTest {

    private static final String FIRST_NAME = "Majid"
    private static final String LAST_NAME = "Aram"
    private static final String NAME = FIRST_NAME + LAST_NAME
    private LinkedInStartPage linkedinStartPage

    @BeforeClass
    public void beforeClass() {
        linkedinStartPage = new LinkedInStartPage(driver)
        linkedinStartPage.load()
    }



    @Test(enabled = true)
    public void seachByFirstNameAndLastNameTest() {
        linkedinStartPage.typeSearchFirstName(FIRST_NAME)
        linkedinStartPage.typeSearchLastName(LAST_NAME)
        LinkedInSearchResultPage linkedInSearchResultPage = linkedinStartPage.clickSeacrh()

        Assert.assertEquals(FIRST_NAME, linkedInSearchResultPage.getFoundPersonsFirstName(), "Verify firstname to be" + FIRST_NAME)
        Assert.assertEquals(LAST_NAME, linkedInSearchResultPage.getFoundPersonsLastName(), "Verify lastname to be " + LAST_NAME)
        Assert.assertEquals(NAME, linkedInSearchResultPage.getFoundPersonsName(), "Verify name to be " + NAME)
    }

}
