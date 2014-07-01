package verification.image

import base.AnyTest
import dtos.FileUtilsHelper
import dtos.base.ImageHelper
import org.testng.ITestContext
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

public class CompareWebFileImagesTest extends AnyTest {
    private ImageHelper imageHelper
    private File firefoxBrowserImageFile
    private File chromeBrowserImageFile
    private File safariBrowserImageFile
    private FileUtilsHelper fileUtilsHelper = new FileUtilsHelper()


    @BeforeMethod
    public void before(ITestContext testContext) {
        if (firefoxBrowserImageFile == null) {
            imageHelper = new ImageHelper(testContext)
            driver.openUrl("https://www.google.se/#q=majid+aram&safe=active")
            driver.waitForPageReadyStateComplete()
            firefoxBrowserImageFile = driver.takeScreenShot("Firefox Search + majid +aram")
//            firefoxBrowserImageFile = fileUtilsHelper.loadResourceFile("/images/firefoxBrowserImage.png")
            driver.quit()

            driver.changeBrowserToSafari()
            driver.openUrl("https://www.google.se/#q=majid+aram&safe=active")
            driver.waitForPageReadyStateComplete()
            safariBrowserImageFile = driver.takeScreenShot("Safari Search + majid +aram")
//            safariBrowserImageFile = fileUtilsHelper.loadResourceFile("/images/safariBrowserImage.png")
            driver.quit()

            driver.changeBrowserToChrome()
            driver.openUrl("https://www.google.se/#q=majid+aram&safe=active")
            driver.waitForPageReadyStateComplete()
            chromeBrowserImageFile = driver.takeScreenShot("Chrome Search + majid +aram")
//            chromeBrowserImageFile = fileUtilsHelper.loadResourceFile("/images/chromeBrowserImage.png")
            driver.quit()

            //TODO: fix chrome och IE start

        }

    }


    @Test(groups = "groupOne", description = "Take an screen shot of google page with different browser and compare")
    public void compareFirefoxAndSafariBrowserTest() {
        imageHelper.addImageToReport(firefoxBrowserImageFile)
        imageHelper.addImageToReport(safariBrowserImageFile)

        imageHelper.checkIfImageFilesDiffer(firefoxBrowserImageFile, safariBrowserImageFile)
    }

    @Test(groups = "groupOne", description = "Take an screen shot of google page with different browser and compare")
    public void compareFirefoxAndSChromeBrowserTest() {
        imageHelper.addImageToReport(firefoxBrowserImageFile)
        imageHelper.addImageToReport(chromeBrowserImageFile)

        imageHelper.checkIfImageFilesDiffer(firefoxBrowserImageFile, chromeBrowserImageFile)
    }

    @Test(groups = "groupOne", description = "Take an screen shot of google page with different browser and compare")
    public void compareChromeAndSafariBrowserTest() {
        imageHelper.addImageToReport(chromeBrowserImageFile)
        imageHelper.addImageToReport(safariBrowserImageFile)

        imageHelper.checkIfImageFilesDiffer(chromeBrowserImageFile, safariBrowserImageFile)
    }



}
