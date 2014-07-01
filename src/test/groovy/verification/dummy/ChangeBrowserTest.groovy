package verification.dummy

import base.AnyTest
import org.testng.annotations.Test
import pages.linkedin.LinkedInStartPage

import static corebase.GlobalConstants.*

public class ChangeBrowserTest extends AnyTest {
    private LinkedInStartPage linkedInStartPage

    @Test(groups = "groupOne", description = "REQ ID = Failed Test")
    public void changeBrowser() {
        linkedInStartPage = new LinkedInStartPage(driver)
        goLinkedInAndTakeScreenShot(driver, "Default")

        driver.changeBrowser(LOCAL_FIREFOX)
        goLinkedInAndTakeScreenShot(driver, LOCAL_FIREFOX)

        driver.changeBrowserToInternetExplorer()
        goLinkedInAndTakeScreenShot(driver, LOCAL_INTERNETEXPLORER)

        driver.changeBrowserToChrome()
        goLinkedInAndTakeScreenShot(driver, LOCAL_CHROME)

        driver.changeBrowserToFirefox()
        goLinkedInAndTakeScreenShot(driver, LOCAL_FIREFOX)

    }

    private void goLinkedInAndTakeScreenShot(driver, browser) {
        linkedInStartPage = new LinkedInStartPage(driver)
        linkedInStartPage.load()
        driver.takeScreenShot("Screen shot on page in <$browser>")
        driver.close()
    }


}
