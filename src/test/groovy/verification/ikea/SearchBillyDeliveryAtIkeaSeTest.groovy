package verification.ikea

import base.AnyTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import pages.ikea.actions.GivenIkea
import pages.ikea.actions.ThenIkea
import pages.ikea.actions.WhenIkea

public class SearchBillyDeliveryAtIkeaSeTest extends AnyTest {
    WhenIkea when
    GivenIkea given
    ThenIkea then

    @BeforeClass
    public void beforeClass() {
        driver.setSlowDownOn(3000)
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
        when.searchForProduct("798.934.17")
        when.chooseWareHouse(2)
        then.wareHouseShouldHaveProductInStock()
    }

}
