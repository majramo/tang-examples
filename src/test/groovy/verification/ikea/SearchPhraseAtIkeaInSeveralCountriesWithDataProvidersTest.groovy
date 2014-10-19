package verification.ikea

import base.AnyTest
import org.testng.Reporter
import org.testng.SkipException
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import pages.ikea.actions.GivenIkea
import pages.ikea.actions.ThenIkea
import pages.ikea.actions.WhenIkea
import static dtos.base.Constants.dbRunTypeRows;

public class SearchPhraseAtIkeaInSeveralCountriesWithDataProvidersTest extends AnyTest {
    private static final String IKEA_PHRASE_INPUT_FILE = "/ikea/ikeaSearchPhrases.xls"
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

    @Test(dataProvider = "databaseProvider")
    public void searchPhraseDb(country, phrase, hits) {
        given.countryStartPageIsLoaded(country)
        when.searchFor(phrase)
        then.resultShouldBeAtLeastPages(hits.toInteger())
    }

    @Test(dataProvider = "excelProvider")
    public void searchPhraseExcel(country, phrase, hits) {
        given.countryStartPageIsLoaded(country)
        when.searchFor(phrase)
        then.resultShouldBeAtLeastPages(hits.toInteger())
    }


    @DataProvider(name = "databaseProvider")
    public Object[][] getDataFromDatabase() {
        def query = "select * from IkeaSearchPhrases where phrase like 'bill%'"
        query = "select * from IkeaSearchPhrases"

        def dbResult = getDbResult("Get data from ikea", dbRunTypeRows, query, 0, "mySqlDb")
        List<String[]> dataToBeReturned = new ArrayList<String[]>()
        dbResult.each {
            dataToBeReturned.add([it[0], it[1], it[2]])
        }
        Reporter.log("From table IkeaSearchProducts:")
        Reporter.log("Result size: $dataToBeReturned.size")

        dataToBeReturned.each {
            Reporter.log("Row> $it")
        }
        return dataToBeReturned
    }
}
