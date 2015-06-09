package verification.demo

import base.AnyTest
import org.testng.ITestContext
import org.testng.annotations.Test

public class VerifyLinksTest extends AnyTest {

    @Test(groups = "groupOne", description = "REQ ID = ...")
    public void verifyLinksOnPage_1(ITestContext iTestContext) {
//        driver.openUrl("http://www.google.se")
        driver.openUrl("http://www.objektfabriken.se")
        driver.analyseLinksByXpath("//a")
    }

    @Test(groups = "groupOne", description = "REQ ID = ...")
    public void verifyLinksOnPage_2(ITestContext iTestContext) {
        driver.openUrl("http://www.objektfabriken.se/kontakt-2/")
        driver.analyseLinksByXpath("//img[@href]")
    }

    @Test(groups = "groupOne", description = "REQ ID = ...")
    public void verifyLinksOnPage_3(ITestContext iTestContext) {
        driver.openUrl("http://www.baggbron.se/")
        driver.analyseLinksByXpath("//*[@href]")
    }

    @Test(groups = "groupOne", description = "REQ ID = ...")
    public void verifyLinksOnPage_4(ITestContext iTestContext) {
        driver.openUrl("http://www.objektfabriken.se/kontakt-2/")
        driver.analyseLinksByXpath("//*[href]")
    }

}
