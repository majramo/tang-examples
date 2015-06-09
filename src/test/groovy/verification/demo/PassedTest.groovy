package verification.demo

import base.AnyTest
import org.testng.ITestContext
import org.testng.annotations.Test

public class PassedTest extends AnyTest {

    @Test(groups = "groupOne", description = "REQ ID = Pass Test")
    public void searchAtGooglePassTest(ITestContext iTestContext) {
        driver.openUrl("http://www.google.se")
        driver.type("lst-ib", "mAJID aRAM")
        driver.click("//*[@id='sblsbb']/button")
        tangAssert.assertTrue(driver.isDisplayed("//h3/a[contains(text(),'Majid Aram')]"), "Check the result contains text")
        takeScreenshot("")
        tangAssert.assertTrue(true, "Passing test method")


    }

}
