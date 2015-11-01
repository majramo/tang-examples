package verification.dummy

import base.AnyTest
import base.TangAssert
import corebase.SeleniumHelper
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import java.text.Format
import java.text.SimpleDateFormat

public class GoogleSearchTest extends AnyTest {


    @Test
    public void searchAtGooglePassed() {
        driver.openUrl("http://www.google.se/")
        driver.type("lst-ib", "Majid Aram")
        driver.click("//*[@id='sblsbb']/button")
        driver.isDisplayed("//*[@id='rso']//h3")
        driver.takeScreenShot("My screenshot")

        tangAssert.assertTrue(driver.isDisplayed("//*[@id='rso']//h3/a[contains (text(), 'Majid Aram')] "), "Sidan ska innehålla texten |Majid Aram|>")
    }

    @Test
    public void searchAtGoogleFailed() {
        driver.openUrl("http://www.google.se/")
        driver.type("lst-ib", "Majid Aram Test Automation")
        driver.click("//*[@id='sblsbb']/button")
        driver.isDisplayed("//*[@id='rso']//h3")
        driver.takeScreenShot("My screenshot")

        tangAssert.assertTrue(driver.isDisplayed("//*[@id='rso']//h3/a[contains (text(), 'Majid Aram Test Automationn')]"), "Sidan ska innehålla texten |Majid Aram Test Automation|")
    }


}
