package verification.ikea

import base.AnyTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import pages.ikea.actions.GivenIkea
import pages.ikea.actions.ThenIkea
import pages.ikea.actions.WhenIkea

public class SearchAtIkeaAndFilterTest extends AnyTest {
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

    @Test
    public void searchForFurnitureInSe() {
        given.countryStartPageIsLoaded("se")
        given.searchFor("badrum")
        when.filter(100, 111)
        then.resultShouldBeAtLeastPages(481)
        then.productsShouldBeAtLeast(6)
    }

}
