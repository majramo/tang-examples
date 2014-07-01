package verification.dummy

import org.testng.ITestContext
import org.testng.annotations.Test

public class DummyCountTest {

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void test2013(ITestContext iTestContext) {
        Map periods1 = [:]
        Map periods2 = [:]
        periods1["201301"] = "201301"
        periods2["201311"] = "201312"
        def periods = periods1 + periods2

        checkPeriods(periods, 2013, 1)

    }

    @Test(groups = "groupOne", description = "REQ ID = Req abcd")
    public void test2014(ITestContext iTestContext) {
        Map periods1 = [:]
        Map periods2 = [:]
        periods1["201401"] = "201401"
        periods1["201402"] = "201402"
        periods1["201403"] = "201403"

        periods2["201404"] = "201404"
        periods2["201405"] = "201405"
        periods2["201406"] = "201406"
        periods2["201408"] = "201408"
        periods2["201412"] = "201412"
        def periods = periods1 + periods2

        checkPeriods(periods, 2014, 1)

    }

    private void checkPeriods(Map periods, year, month) {
        while (month <= 12) {
            def period = "${year}0$month"
            if (month > 9) {
                period = "${year}$month"
            }
            def expected = periods[period]
            print period
            if (expected == null) {
                println " Missing"
            } else {
                println " Ok"
            }
            month++
        }
    }

}
