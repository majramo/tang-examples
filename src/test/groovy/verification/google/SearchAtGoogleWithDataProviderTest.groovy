package verification.google

import base.AnyTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import pages.google.GivenGoogle
import pages.google.ThenGoogle
import pages.google.WhenGoogle

import static org.testng.Reporter.log

public class SearchAtGoogleWithDataProviderTest extends AnyTest {
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

    @Test(enabled = false, dataProvider = "createGoogleSimpleSearchData")
    public void verifyResultContainsSearchSimpleStringTest(String searchString, Integer hitsOnPage) {
        log("Search: <$searchString>")
        log("HitsOnPage: <$hitsOnPage>")
        when.typeValueAndClickSearch(searchString)
        then.verifySearchResulsIsShown()
        then.verifySearchResulsContainTexts(searchString)
        then.verifySearchResultsHitsIsAtLeast(hitsOnPage)
    }

    @Test(enabled = true, dataProvider = "createGoogleCombinedSearchData")
    public void verifyResultContainsSearchCombinedStringsTest(String[] searchString, Integer hitsOnPage) {
        log("Search: <$searchString>")
        log("HitsOnPage: <$hitsOnPage>")
        when.typeValueAndClickSearch(searchString)
        then.verifySearchResulsIsShown()
        then.verifySearchResulsContainTexts(searchString)
        then.verifySearchResultsHitsIsAtLeast(hitsOnPage)
    }

    @DataProvider(name = "createGoogleSimpleSearchData")
    public Object[][] createGoogleSimpleSearchData() {
        [
                ["Aram", new Integer(10)],
                ["Majid", new Integer(10)],
                ["Test", new Integer(10)],
        ] as Object[][]
    }

    @DataProvider(name = "createGoogleCombinedSearchData")
    public Object[][] createGoogleCombinedSearchData() {
        String[] search1 = ["Majid", "Aram"]
        String[] search2 = ["Majid", "Aram", "TANG"]
        String[] search3 = ["Majid", "Aram", "TANG", "Automation"]
        String[] search4 = ["Majid", "Aram", "TANG", "Automation", "Test"]
        String[] search5 = ["Majid", "Aram", "TANG", "Automation", "Test", "kalle anka"]

        return [
                [search1, new Integer(9)],
                [search2, new Integer(2)],
                [search3, new Integer(2)],
                [search4, new Integer(2)],
                [search5, new Integer(5)],
        ] as Object[][]
    }

}
