package verification.demo

import base.AnyTest
import org.testng.Assert
import org.testng.ITestContext
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

public class VerifyGermanWordsTest extends AnyTest {

    static boolean firstRun = true
    final static boolean PAGE_CONTAINS_NOT_THE_WORD = true
    final static boolean PAGE_CONTAINS_THE_WORD = true
    static def pageText = ""
    public static final String URL = "http://www.google.com"
    static int dataProviderinvalidWordsCounter = 0
    static int pageinvalidWordsCounter = 0
    static int dataProviderValidWordsCounter = 0
    static int pageValidWordsCounter = 0
    boolean screenShotTaken = false

    @Test(dataProvider = "invalidWords", groups = "groupOne", description = "REQ ID = ...")
    public void verifyPageContainsNotInvalidWord_NoScreenShot(word) {

        reporterLogLn()
        reporterLogLn("Page $URL")
        openPage()

        dataProviderinvalidWordsCounter++
        String displayWord = "[$word]"
        reporterLogLn()
        reporterLogLn("Counter $dataProviderinvalidWordsCounter $displayWord")
        boolean wordResult = pageText.contains(word.toLowerCase())
        if (wordResult) {
            pageinvalidWordsCounter++
            reporterLogLn("Invalid word found: $pageinvalidWordsCounter($dataProviderinvalidWordsCounter) $displayWord")
            takeScreenShotNow()
            Assert.fail()
        } else {
            reporterLogLn("Invlaid word $displayWord not found")
        }

    }

    Closure takeScreenShotNow() {
        if (!screenShotTaken) {
            driver.takeScreenShot("")
            screenShotTaken = true
        }
    }

    @Test(dataProvider = "validWords", groups = "groupOne", description = "REQ ID = ...")
    public void verifyPageContainsValidWord_NoScreenShot(word) {

        reporterLogLn("Page $URL")
        String displayWord = "[$word]"
        openPage()
        
        dataProviderValidWordsCounter++
        reporterLogLn()
        reporterLogLn("Counter $dataProviderValidWordsCounter $displayWord")
        boolean wordResult = pageText.contains(word.toLowerCase())
        if (!wordResult) {
            pageValidWordsCounter++
            reporterLogLn("Valid word not found: $pageValidWordsCounter($dataProviderValidWordsCounter) $displayWord")
            takeScreenShotNow()
            Assert.fail()
        } else {
            reporterLogLn("Valid word $displayWord found")
        }

    }

    private boolean openPage() {
        if (firstRun) {
            driver.openUrl(URL)
            pageText = driver.getText("/*").toLowerCase()
            firstRun = false
        } 
    }

    @DataProvider(name = "invalidWords")
    public Object[][] invalidWords() {
        [
                ["Picture"],
                ["log in"],
                ["Search"],
                ["Gmail"],

        ] as Object[][]
    }

    @DataProvider(name = "validWords")
    public Object[][] validWords() {
        [
                ["Inställningar"],
                ["Logga in"],
                ["Gmail"],
                ["Log in"],

        ] as Object[][]
    }





}
