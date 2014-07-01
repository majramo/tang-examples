package verification.googledataprovider

import base.AnyTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import pages.google.actions.GivenGoogle
import pages.google.actions.ThenGoogle
import pages.google.actions.WhenGoogle

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
        given.googleSeacrhPageIsLoaded()
    }

    @Test(enabled = false, dataProvider = "createGoogleSimpleSearchData")
    public void verifyResultContainsSearchSimpleStringTest(String searchString, Integer hitsOnPage) {
        when.typeValueAndClickSearch(searchString)
        then.verifySearchResulsIsShown()
        then.verifySearchResulsContainTexts(searchString)
        then.verifySearchResulsHitsIsAtLeast(hitsOnPage)
    }

    @Test(enabled = true, dataProvider = "createGoogleCombinedSearchData")
    public void verifyResultContainsSearchCombinedStringsTest(String[] searchString, Integer hitsOnPage) {
        when.typeValueAndClickSearch(searchString)
        then.verifySearchResulsIsShown()
        then.verifySearchResulsContainTexts(searchString)
        then.verifySearchResulsHitsIsAtLeast(hitsOnPage)
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
        String[] search2 = ["Maj   id", "Aram", "Vem"]
        String[] search3 = ["Majid", "Aram", "Vem", "Automation"]
        String[] search4 = ["Majid", "Aram", "Vem", "Automation", "Test"]
        String[] search5 = ["Majid", "Aram", "Vem", "Automation", "Test", "kalle anka"]

        [
                [new String("1"), new Integer(10)],
                [search2, new Integer(10)],
                [search3, new Integer(10)],
                [search4, new Integer(10)],
                [search5, new Integer(10)],
        ] as Object[][]
    }

}
