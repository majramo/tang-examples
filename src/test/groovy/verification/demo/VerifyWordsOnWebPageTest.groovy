package verification.demo

import base.AnyTest
import org.testng.Assert
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

public class VerifyWordsOnWebPageTest extends AnyTest {

    static boolean firstRun = true
    static String pageText = ""
    public static final String PAGE_URL = "http://www.google.com"
    static int dataProviderInvalidWordsCounter = 0
    static int pageInvalidWordsCounter = 0
    static int dataProviderValidWordsCounter = 0
    static int pageValidWordsCounter = 0
    boolean screenShotTaken = false

    @Test(dataProvider = "invalidWords", groups = "groupOne", description = "REQ ID = ...")
    public void pageContainsNotInvalidWord_NoScreenShot(String word) {

        reporterLogLn()
        reporterLogLn("Page $PAGE_URL")
        openPage()

        dataProviderInvalidWordsCounter++
        String displayWord = "[$word]"
        reporterLogLn()
        reporterLogLn("Counter $dataProviderInvalidWordsCounter $displayWord")
        boolean wordResult = pageText.contains(word.toLowerCase())
        if (wordResult) {
            pageInvalidWordsCounter++
            reporterLogLn("Invalid word found: $pageInvalidWordsCounter($dataProviderInvalidWordsCounter) $displayWord")
            takeScreenShotNow()
            Assert.fail()
        } else {
            reporterLogLn("Invlaid word $displayWord not found")
        }

    }

    private void takeScreenShotNow() {
        if (!screenShotTaken) {
            driver.takeScreenShot("")
            screenShotTaken = true
        }
    }

    @Test(dataProvider = "validWords", groups = "groupOne", description = "REQ ID = ...")
    public void pageContainsValidWord_NoScreenShot(String word) {

        reporterLogLn("Page $PAGE_URL")
        String displayWord = "[$word]"
        openPage()
        
        dataProviderValidWordsCounter++
        reporterLogLn()
        reporterLogLn("Counter $dataProviderValidWordsCounter $displayWord")
        boolean wordResult = pageText.contains(word.toLowerCase())
        if (wordResult.equals(false)) {
            pageValidWordsCounter++
            reporterLogLn("Valid word not found: $pageValidWordsCounter($dataProviderValidWordsCounter) $displayWord")
            takeScreenShotNow()
            Assert.fail()
        } else {
            reporterLogLn("Valid word $displayWord found")
        }

    }

    private void openPage() {
        if (firstRun) {
            driver.openUrl(PAGE_URL)
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
