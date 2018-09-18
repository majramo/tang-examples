package demo

import base.AnyTest
import base.TangAssert
import corebase.SeleniumHelper
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import java.text.Format
import java.text.SimpleDateFormat

public class GoogleSearchTest extends AnyTest {


    @Test
    public void searchAtGooglePassed1() {
        driver.openUrl("http://www.google.se/")
        driver.typeAndEnter("lst-ib", "Majid Aram Test")
        driver.isDisplayed("//*[@id='rso']//h3", 3)
        driver.takeScreenShot("My screenshot")

        tangAssert.assertTrue(driver.isDisplayed("//*[@id='rso']//h3/a[contains (text(), 'Majid Aram')]", 3), "Sidan ska innehålla texten |Majid Aram|>")
    }

    @Test
    public void searchAtGooglePassed2() {
        driver.openUrl("http://www.google.se/")
        driver.typeAndEnter("lst-ib", "Majid Aram +Racerförare")
        driver.isDisplayed("//*[@id='rso']//h3", 3)
        driver.takeScreenShot("My screenshot")

//        tangAssert.assertTrue(driver.isDisplayed("//*[@id='rso']//h3/a[contains (text(), 'Inga resultat')]", 3), "Sidan ska innehålla texten |Majid Aram Test Automation|")
        tangAssert.assertTrue(driver.isDisplayed("//*[@id='topstuff']//*[contains (text(), 'No result')]", 3), "Sidan ska innehålla texten |No result|")
    }

    @Test
    public void searchAtGooglePassed3() {
        driver.openUrl("http://www.google.se/")
        driver.typeAndEnter("lst-ib", "Majid Aram autoamtion")
        driver.isDisplayed("//*[@id='rso']//h3", 3)
        driver.takeScreenShot("My screenshot")

        tangAssert.assertTrue(driver.isDisplayed("//*[@id='rso']//h3/a[contains (text(), 'Majid Aram')]", 3), "Sidan ska innehålla texten |Majid Aram|>")
    }


}
