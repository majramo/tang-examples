package verification.amazonGw;

import org.apache.log4j.Logger;
import org.graphwalker.conditions.EdgeCoverage;
import org.graphwalker.conditions.ReachedVertex;
import org.graphwalker.exceptions.StopConditionException;
import org.graphwalker.generators.A_StarPathGenerator;
import org.graphwalker.generators.PathGenerator;
import org.graphwalker.generators.RandomPathGenerator;
import org.graphwalker.multipleModels.ModelHandler;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class AmazonMbtTestRun extends AmazonMbtTest {
    private final static Logger log = Logger.getLogger("AMT  ");
    private static final String MBT_GRAPH = "/model/AmazonShoppingCart.graphml";
    private static final String MBT_MODEL = "AmazonMbtTest";

    public AmazonMbtTestRun(File model, boolean efsm, PathGenerator generator, boolean weight) {
        super(model, efsm, generator, weight, "", "");
    }

    @Parameters({"browser", "environment"})
    @Test
    public static void aStar(@Optional("LOCAL_FIREFOX") String browser, @Optional("") String environment, ITestContext testContext) throws InterruptedException, StopConditionException, URISyntaxException {
        ModelHandler modelhandler = new ModelHandler();
        AmazonMbtTest mbtClass = null;
        URL url = null;
        File file = null;
        try {
            url = AmazonMbtTestRun.class.getResource(MBT_GRAPH);
            file = new File(url.toURI());
        } catch (Exception exception) {
            Reporter.log("Can't find file <" + MBT_GRAPH + ">");
            Reporter.log(exception.toString());
            Assert.assertTrue(false, "Test not started");
        }

        try {
            mbtClass = new AmazonMbtTest(file, true, new A_StarPathGenerator(new EdgeCoverage(1.0)), false, browser, testContext.getOutputDirectory());
            modelhandler.add(MBT_MODEL, mbtClass);
        } catch (Exception exception) {
            Reporter.log("Can't load model <" + AmazonMbtTest.class.getName() + ">");
            Reporter.log(exception.toString());
            Assert.assertTrue(false, "Test not started");
        }

        try {
            modelhandler.execute(MBT_MODEL);
        } catch (Exception exception) {
            Reporter.log(exception.toString());
            Reporter.log("Test execution crashed");
        }

        Reporter.log(modelhandler.getStatistics());
        mbtClass.driver.quit();
        vemAssert.assertTrue(modelhandler.isAllModelsDone(), MBT_MODEL + ": not all models are done");
    }

    @Parameters({"browser", "environment"})
    @Test
    public static void random(@Optional("LOCAL_FIREFOX") String browser, @Optional("") String environment, ITestContext testContext) throws InterruptedException, StopConditionException, URISyntaxException {
        ModelHandler modelhandler = new ModelHandler();
        AmazonMbtTest mbtClass = null;
        URL url = null;
        File file = null;
        try {
            url = AmazonMbtTestRun.class.getResource(MBT_GRAPH);
            file = new File(url.toURI());
        } catch (Exception exception) {
            Reporter.log("Can't find file <" + MBT_GRAPH + ">");
            Reporter.log(exception.toString());
            Assert.assertTrue(false, "Test not started");
        }

        try {
            mbtClass = new AmazonMbtTest(file, true, new RandomPathGenerator(new EdgeCoverage(1.0)), false, browser, testContext.getOutputDirectory());
            modelhandler.add(MBT_MODEL, mbtClass);
        } catch (Exception exception) {
            Reporter.log("Can't load model <" + AmazonMbtTest.class.getName() + ">");
            Reporter.log(exception.toString());
            Assert.assertTrue(false, "Test not started");
        }

        try {
            modelhandler.execute(MBT_MODEL);
        } catch (Exception exception) {
            Reporter.log(exception.toString());
            Reporter.log("Test execution crashed");
        }

        Reporter.log(modelhandler.getStatistics());
        mbtClass.driver.quit();
        vemAssert.assertTrue(modelhandler.isAllModelsDone(), MBT_MODEL + ": not all models are done");
    }

    @Parameters({"browser", "environment"})
    @Test
    public static void fastest(@Optional("LOCAL_FIREFOX") String browser, @Optional("") String environment, ITestContext testContext) throws InterruptedException, StopConditionException, URISyntaxException {
        ModelHandler modelhandler = new ModelHandler();
        AmazonMbtTest mbtClass = null;
        URL url = null;
        File file = null;
        try {
            url = AmazonMbtTestRun.class.getResource(MBT_GRAPH);
            file = new File(url.toURI());
        } catch (Exception exception) {
            Reporter.log("Can't find file <" + MBT_GRAPH + ">");
            Reporter.log(exception.toString());
            Assert.assertTrue(false, "Test not started");
        }

        try {
            mbtClass = new AmazonMbtTest(file, true, new A_StarPathGenerator(new ReachedVertex("v_ShoppingCart")), false, browser, testContext.getOutputDirectory());
            modelhandler.add(MBT_MODEL, mbtClass);
        } catch (Exception exception) {
            Reporter.log("Can't load model <" + AmazonMbtTest.class.getName() + ">");
            Reporter.log(exception.toString());
            Assert.assertTrue(false, "Test not started");
        }

        try {
            modelhandler.execute(MBT_MODEL);
        } catch (Exception exception) {
            Reporter.log(exception.toString());
            Reporter.log("Test execution crashed");
        }

        Reporter.log(modelhandler.getStatistics());
        mbtClass.driver.quit();
        vemAssert.assertTrue(modelhandler.isAllModelsDone(), MBT_MODEL + ": not all models are done");
    }

}
