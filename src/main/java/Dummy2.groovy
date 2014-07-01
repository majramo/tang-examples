import groovy.time.TimeCategory
import org.openqa.selenium.WebElement
import org.testng.annotations.Test

class Dummy2 {

    Date startTime
    int SLEPP_SECONDS = 2000

    boolean timeLeft(elapsedTime) {
        Date currentTime = new Date()
        println TimeCategory.minus(currentTime, startTime).seconds + " " + elapsedTime
        return TimeCategory.minus(currentTime, startTime).seconds < elapsedTime
    }
    /*
    require("")
    require("",10)
     */

    private boolean waitFor(xpath, Closure function, int elapsedTime) {
        startTime = new Date()
        while (timeLeft(elapsedTime)) {
            WebElement webElement = findElementByXpathOrId(xpath, false)
            if (function(webElement)) {
                return webElement
            }
            sleep SLEPP_SECONDS
        }
        println "Not"
    }

    WebElement findElementByXpathOrId(Object o, boolean b) {
        return null
    }

    def isDisplayed(WebElement webElement) {
        return false
    }

    def isTagAvailable(WebElement webElement) {
        if (webElement != null) {
            return true
        }
    }

    public WebElement requireVisibleXpath(String xpath, int wait = 10) {
        if (waitFor(xpath, this.&isDisplayed, wait)) {
            println "true"
        } else {
            println "false"
        }

    }

    public WebElement requireXpath(String xpath, int wait = 10) {
        if (waitFor(xpath, this.&isTagAvailable, wait)) {
            println "true"
        } else {
            println "false"
        }

    }

    @Test
    public void test1() {
        requireVisibleXpath("", 3)
    }

    @Test
    public void test2() {
        requireXpath("", 2)
    }

}
