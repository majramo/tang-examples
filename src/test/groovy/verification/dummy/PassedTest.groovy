package verification.dummy

import base.AnyTest
import org.apache.log4j.Logger
import org.testng.annotations.Test

public class PassedTest extends AnyTest {
    public final static Logger log = Logger.getLogger("PT   ")

    @Test(groups = "groupOne")
    public void passTestOne() {
        log.trace("Trace Message!");
        driver.sleep(100)
        log.debug("Debug Message!");
        log.info("Info Message!");
        log.warn("Warn Message!");
        log.error("Error Message!");
        log.fatal("Fatal Message!");
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
