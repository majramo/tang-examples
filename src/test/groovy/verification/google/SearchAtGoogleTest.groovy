package verification.google

import base.AnyTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import pages.google.GivenGoogle
import pages.google.ThenGoogle
import pages.google.WhenGoogle

import static org.testng.Reporter.log

public class SearchAtGoogleTest extends AnyTest {
    private static final String MAJID_ARAM = "Majid Aram"
    private static final String TEST_AUTOMATION = "Test automation"
    private static final String MAJID = "Majid"
    private static final String ARAM = "Aram"
    private static final String VEM = "Vem"
    private static final String WIKIPEDIA_STR = "Wikipedia"
    private static final Q = '"'
    WhenGoogle when
    GivenGoogle given
    ThenGoogle then

    @BeforeClass
    public void beforeClass() {
        given = new GivenGoogle(driver)
        when = new WhenGoogle(driver)
        then = new ThenGoogle(driver)
    }

    @BeforeMethod
    public void beforeMethod() {
        given.googleSearchPageIsLoaded()
    }

    @Test
    public void verifyResultContainsSearchStringTestAutomation() {
        final int HITS_ON_PAGE = 1
        log("Search: <$TEST_AUTOMATION $WIKIPEDIA_STR>")
        log("hitsOnPage: <$HITS_ON_PAGE>")
        when.typeValueAndClickSearch(TEST_AUTOMATION, WIKIPEDIA_STR)
        then.verifySearchResulsIsShown()
        then.verifySearchResulsContainTexts(TEST_AUTOMATION, WIKIPEDIA_STR)
        then.verifySearchResultsHitsIsAtLeast(HITS_ON_PAGE)
    }

    @Test
    public void verifyResultContainsSearchStringMajidAram() {
        final int HITS_ON_PAGE = 8
        log("Search: <$MAJID $ARAM>")
        log("hitsOnPage: <$HITS_ON_PAGE>")
        when.typeValueAndClickSearch(MAJID, ARAM)
        then.verifySearchResulsIsShown()
        then.verifySearchResulsContainTexts(MAJID, ARAM)
        then.verifySearchResultsHitsIsAtLeast(HITS_ON_PAGE)
    }

    @Test
    public void verifyResultContainsSearchStringVemMajidAram() {
        final int HITS_ON_PAGE = 8
        log("Search: <$VEM $MAJID $ARAM>")
        log("hitsOnPage: <$HITS_ON_PAGE>")
        when.typeValueAndClickSearch(VEM, MAJID, ARAM)
        then.verifySearchResulsIsShown()
        then.verifySearchResulsContainTexts(VEM, MAJID, ARAM)
        then.verifySearchResultsHitsIsAtLeast(HITS_ON_PAGE)
    }

    @Test
    public void verifyResultContainsSearchStringVem() {
        final int HITS_ON_PAGE = 8
        log("Search: <$VEM>")
        log("hitsOnPage: <$HITS_ON_PAGE>")
        when.typeValueAndClickSearch(VEM)
        then.verifySearchResulsIsShown()
        then.verifySearchResulsContainTexts(VEM)
        then.verifySearchResultsHitsIsAtLeast(HITS_ON_PAGE)
    }

    @Test
    public void verifyResultContainsSearchStringMajidAram_TestAutomation() {
        final int HITS_ON_PAGE = 4
        log("Search: <$Q$MAJID_ARAM$Q, $Q$TEST_AUTOMATION$Q>")
        log("hitsOnPage: <$HITS_ON_PAGE>")
        when.typeValueAndClickSearch("$Q$MAJID_ARAM$Q", "$Q$TEST_AUTOMATION$Q")
        then.verifySearchResulsIsShown()
        then.verifySearchResulsContainTexts(MAJID_ARAM, TEST_AUTOMATION)
        then.verifySearchResultsHitsIsAtLeast(HITS_ON_PAGE)
    }
}
