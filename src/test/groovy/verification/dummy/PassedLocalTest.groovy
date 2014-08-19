package verification.dummy

import base.AnyTest
import org.testng.Reporter
import org.testng.annotations.Test

public class PassedLocalTest extends AnyTest {


    @Test(groups = "groupTwo")
    public void passedLocalTest_1() {
        Reporter.log("Open ur: file:///Users/majidaram/dev/tang-examples/src/test/resources/file1.png")
        driver.openUrl("file:///Users/majidaram/dev/tang-examples/src/test/resources/file1.png")
        driver.takeScreenShot("Screen shot")
        tangAssert.assertTrue(true, "Passed test")
    }

    @Test(groups = "groupTwo")
    public void passedLocalTest_2() {
        Reporter.log("Open ur: file:///Users/majidaram/dev/tang-examples/src/test/resources/file1.png")
        driver.openUrl("file:///Users/majidaram/dev/tang-examples/src/test/resources/file1.png")
        driver.takeScreenShot("Screen shot 1")
        Reporter.log("Open ur: file:///Users/majidaram/dev/tang-examples/src/test/resources/file2.png")
        driver.openUrl("file:///Users/majidaram/dev/tang-examples/src/test/resources/file2.png")
        driver.takeScreenShot("Screen shot 2")
        tangAssert.assertTrue(true, "Passed test")
    }

}
