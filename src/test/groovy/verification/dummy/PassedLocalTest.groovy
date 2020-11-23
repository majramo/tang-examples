package verification.dummy

import base.AnyTest
import org.testng.Reporter
import org.testng.annotations.Test

public class PassedLocalTest extends AnyTest {

    @Test(groups = "groupTwo")
    public void passedLocalTest_1() {
        Reporter.log("Open ur: file:///Users/majidaram/dev/tang-examples/src/test/resources/file1.png")
        File file = new dtos.FileUtilsHelper().loadResourceFile("/file1.png")

        driver.openUrl(file.path)
        driver.takeScreenShot("Screen shot")
        tangAssert.assertTrue(true, "Passed test")
    }

    @Test(groups = "groupTwo")
    public void passedLocalTest_2() {
        File file1 = new dtos.FileUtilsHelper().loadResourceFile("/file1.png")
        Reporter.log("Open file: $file1")
        driver.openUrl(file1.path)
        driver.takeScreenShot("Screen shot 1")
        File file2 = new dtos.FileUtilsHelper().loadResourceFile("/file2.png")
        Reporter.log("Open ur: $file2")
        driver.openUrl(file2.path)
        driver.takeScreenShot("Screen shot 2")
        File diffApp = new dtos.FileUtilsHelper().loadResourceFile("/app/perceptualdiff")
        def cmd = "$diffApp.path $file1.path $file2.path"
        //Runtime.getRuntime().exec(cmd);
        Reporter.log("compare files")
        Reporter.log(cmd)

        tangAssert.assertTrue(true, "Passed test")
    }


    @Test(groups = "groupTwo")
    public void passedLocalTest_3() {
        Reporter.log("http://www.google.com")
        driver.openUrl("http://www.google.com")
        driver.takeScreenShot("Screen shot")
        tangAssert.assertTrue(true, "Passed test")
    }

    @Test(groups = "groupTwo")
    public void passedLocalTest_4() {
        driver.openUrl("http://www.ikea.se")
        driver.takeScreenShot("Ikea")
        if(driver.isClickable("//*[@id='onetrust-accept-btn-handler']")){
            driver.click("//*[@id='onetrust-accept-btn-handler']")
        }
        driver.type("/html/body/header/div/div/div/div[2]/div/div/form/div[1]/div/input", "billy")
        driver.takeScreenShot("Billy")
    }

}
