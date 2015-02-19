package verification.image

import base.AnyTest
import dtos.FileUtilsHelper
import dtos.base.ImageHelper
import org.testng.ITestContext
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

public class CompareWebFileImagesInFfTest extends AnyTest {
    private ImageHelper imageHelper
    private File firefoxBrowserImageFile1
    private File firefoxBrowserImageFile2
    private File firefoxBrowserImageFile3
    private FileUtilsHelper fileUtilsHelper = new FileUtilsHelper()


    @BeforeMethod
    public void before(ITestContext testContext) {
        if (firefoxBrowserImageFile1 == null) {
            imageHelper = new ImageHelper(testContext)
            driver.openUrl("https://www.google.se/#q=majid+aram&safe=active")
            driver.waitForPageReadyStateComplete()
            firefoxBrowserImageFile1 = driver.takeScreenShot("Firefox Search majid+aram&safe=active")

            driver.openUrl("https://www.google.se/#q=aram+majid&safe=active")
            sleep(1000)
            driver.waitForPageReadyStateComplete()
            firefoxBrowserImageFile2 = driver.takeScreenShot("Firefox Search aram+majid&safe=active")


            driver.openUrl("https://www.google.se/#q=majid+majid+aram&safe=active")
            sleep(1000)
            driver.waitForPageReadyStateComplete()
            firefoxBrowserImageFile3 = driver.takeScreenShot("Firefox Search majid+majid+aram&safe=active")
        }

    }


    @Test(groups = "groupOne", description = "Take an screen shot of google page with different browser and compare")
    public void compareFirefox1_2_Test() {
        imageHelper.addImageToReport(firefoxBrowserImageFile1)
        imageHelper.addImageToReport(firefoxBrowserImageFile2)

        imageHelper.checkIfImageFilesDiffer(firefoxBrowserImageFile1, firefoxBrowserImageFile3)
    }

    @Test(groups = "groupOne", description = "Take an screen shot of google page with different browser and compare")
    public void compareFirefox1_3_Test() {
        imageHelper.addImageToReport(firefoxBrowserImageFile1)
        imageHelper.addImageToReport(firefoxBrowserImageFile3)

        imageHelper.checkIfImageFilesDiffer(firefoxBrowserImageFile1, firefoxBrowserImageFile2)
    }

    @Test(groups = "groupOne", description = "Take an screen shot of google page with different browser and compare")
    public void compareFirefo2_3_Test() {
        imageHelper.addImageToReport(firefoxBrowserImageFile2)
        imageHelper.addImageToReport(firefoxBrowserImageFile3)

        imageHelper.checkIfImageFilesDiffer(firefoxBrowserImageFile2, firefoxBrowserImageFile3)
    }



}
