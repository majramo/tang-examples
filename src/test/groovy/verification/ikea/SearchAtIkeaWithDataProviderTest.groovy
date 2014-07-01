package verification.ikea

import base.AnyTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import pages.ikea.actions.GivenIkea
import pages.ikea.actions.ThenIkea
import pages.ikea.actions.WhenIkea

public class SearchAtIkeaWithDataProviderTest extends AnyTest {
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
    public void searchForValueInSe(String searchValue, int foundCount) {
        given.countryStartPageIsLoaded("se")
        when.searchFor(searchValue)
        then.resultShouldBeAtLeastPages(foundCount)
    }



    @DataProvider(name = "data")
    public Object[][] createData() {
        [
                ["billy", new Integer(49)],
                ["Billy", new Integer(94)],
                ["Stol", new Integer(545)],
                ["bord", new Integer(516)],
                ["ikea", new Integer(2971)],
                ["matbord", new Integer(97)],
                ["matbord askholmen", new Integer(2)],
                ["askholmen", new Integer(3)],
        ] as Object[][]
    }


}
