package verification.image

import dtos.FileUtilsHelper
import dtos.base.ImageHelper
import org.testng.ITestContext
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

import static corebase.GlobalConstants.REPORT_NG_ESCAPE_OUTPUT_PROPERTY

public class CompareLocalFileImagesTest {
    private ImageHelper imageHelper
    private FileUtilsHelper fileUtilsHelper = new FileUtilsHelper()
    String expectedImage = "/images/expectedImage.png"
    String actualImage = "/images/actualImage.png"
    String actualImageColoredImage = "/images/actualImageColored.png"
    String defaultBrowserImage = "/images/defaultBrowserImage.png"
    String ieBrowserImage = "/images/ieBrowserImage.png"
    File expectedImageFile
    File actualImageColoredFile
    File actualImageFile
    File defaultBrowserFile
    File ieBrowserFile

    @BeforeClass(alwaysRun = true)
    public void beforeClass(ITestContext testContext) {
        imageHelper = new ImageHelper(testContext)
        System.setProperty(REPORT_NG_ESCAPE_OUTPUT_PROPERTY, "false")
        expectedImageFile = fileUtilsHelper.loadResourceFile(expectedImage)
        actualImageFile = fileUtilsHelper.loadResourceFile(actualImage)
        actualImageColoredFile = fileUtilsHelper.loadResourceFile(actualImageColoredImage)
        defaultBrowserFile = fileUtilsHelper.loadResourceFile(defaultBrowserImage)
        ieBrowserFile = fileUtilsHelper.loadResourceFile(ieBrowserImage)
    }

    @Test(groups = "groupOne", description = "Compare two images from resources")
    public void compareMissingPart() {
        imageHelper.addImageToReport(expectedImageFile)
        imageHelper.addImageToReport(actualImageFile)

        imageHelper.checkIfImageFilesDiffer(expectedImageFile, actualImageFile)
    }

    @Test(groups = "groupOne", description = "Compare two images from resources")
    public void compareByThreshold_Zero() {
        imageHelper.addImageToReport(expectedImageFile)
        imageHelper.addImageToReport(actualImageFile)

        imageHelper.checkIfImageFilesByThreshold(expectedImageFile, actualImageFile)
    }

    @Test(groups = "groupOne", description = "Compare two images from resources")
    public void compareByThreshold_5000() {
        imageHelper.addImageToReport(expectedImageFile)
        imageHelper.addImageToReport(actualImageFile)

        imageHelper.checkIfImageFilesByThreshold(expectedImageFile, actualImageFile, 5000)
    }

    @Test(groups = "groupOne", description = "Compare two images from resources")
    public void compareByColorFactor_Zero() {
        imageHelper.addImageToReport(expectedImageFile)
        imageHelper.addImageToReport(actualImageColoredFile)

        imageHelper.checkIfImageFilesDifferByColorFactor(expectedImageFile, actualImageColoredFile)
    }

    @Test(groups = "groupOne", description = "Compare two images from resources")
    public void compareByColorFactor_One() {
        imageHelper.addImageToReport(expectedImageFile)
        imageHelper.addImageToReport(actualImageColoredFile)

        imageHelper.checkIfImageFilesByColorFactor(expectedImageFile, actualImageColoredFile, 1)
    }

    @Test(groups = "groupOne", description = "Compare two images from resources")
    public void compareByColorFactor() {
        imageHelper.addImageToReport(expectedImageFile)
        imageHelper.addImageToReport(actualImageColoredFile)

        imageHelper.checkIfImageFilesDifferByColorFactor(expectedImageFile, actualImageColoredFile)
    }

    @Test(groups = "groupOne", description = "Compare two images from resources")
    public void comparePixelMove() {
        imageHelper.addImageToReport(defaultBrowserFile)
        imageHelper.addImageToReport(ieBrowserFile)

        imageHelper.checkIfImageFilesDifferByColorFactor(defaultBrowserFile, ieBrowserFile)
    }

}
