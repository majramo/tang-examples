package verification.demo

import base.AnyTest
import org.testng.ITestContext
import org.testng.SkipException
import org.testng.annotations.Test

public class PassedTest extends AnyTest {

    @Test(groups = "groupOne", description = "REQ ID = Pass Test")
    public void searchAtGooglePassTest(ITestContext iTestContext) {
        driver.openUrl("http://www.google.se")
        driver.type("//*[@id='gbqfq']", "Majid Aram")
        driver.click("//button[@id='gbqfb']")
        driver.sleep(500)
        takeScreenshot("")

        tangAssert.assertTrue(true, "Passing test method")
    }

}
