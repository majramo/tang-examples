package verification.ikea

import base.AnyTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import pages.ikea.actions.GivenIkea
import pages.ikea.actions.ThenIkea
import pages.ikea.actions.WhenIkea

public class SearchPhraseInSeveralCountriesStaticDataproviderNoSlowDownAtIkeaTest extends AnyTest {
    WhenIkea when
    GivenIkea given
    ThenIkea then

    @BeforeClass
    public void beforeClass() {
        given = new GivenIkea(driver)
        when = new WhenIkea(driver)
        then = new ThenIkea(driver)
    }

    @BeforeMethod
    public void beforeMethod() {
        given.startPageIsLoaded()
    }


    @Test(dataProvider = "data")
    public void searchPhrase(String country, phrase, hits) {
        given.countryStartPageIsLoaded(country)
        when.searchFor(phrase)
        then.resultShouldBeAtLeastPages(hits)
    }





    @DataProvider(name = "data")
    public Object[][] createData() {
        [
                ["se", "billy", 49],
                ["se", "billy system", 43],
                ["us", "billy", 49],
                ["us", "billy system", 43],
                ["fr", "billy", 50],
                ["fr", "billy system", 44],
                ["es", "billy", 50],
                ["es", "BILLY Altillo", 9],


        ] as Object[][]
    }

}
