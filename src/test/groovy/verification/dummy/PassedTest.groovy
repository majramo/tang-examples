package verification.dummy

import base.AnyTest
import org.testng.annotations.Test

public class PassedTest extends AnyTest {

    @Test(groups = "groupOne")
    public void passTestOne() {
        driver.openUrl("http://www.google.com")
        driver.takeScreenShot("Screen shot")
        tangAssert.assertTrue(true, "Passed test")
        reporterHelper.log("onConfigurationSuccess: beforeSuiteVemHt")
        reporterHelper.log("onConfigurationSuccess: beforeSuiteVemHt")
        reporterHelper.log("")
        reporterHelper.log("onConfigurationSuccess: beforeSuiteVemHt")
        reporterHelper.addPassedIcon()
        reporterHelper.addFaildIcon()
        reporterHelper.addPassedIcon()
        reporterHelper.addFaildIcon()

    }

    @Test(groups = "groupTwo")
    public void passTestTwo() {
        driver.openUrl("http://www.linkedin.com/")
        driver.takeScreenShot("Screen shot")
        tangAssert.assertTrue(true, "Passed test")
    }

}
