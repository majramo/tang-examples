package verification.amazonGw;

import org.apache.log4j.Logger;
import org.graphwalker.conditions.EdgeCoverage;
import org.graphwalker.exceptions.StopConditionException;
import org.graphwalker.generators.A_StarPathGenerator;
import org.graphwalker.generators.PathGenerator;
import org.graphwalker.multipleModels.ModelHandler;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class DummyMbtTest extends DummyMbt {
    private final static Logger log = Logger.getLogger("AT   ");
    private static String browser;

    public DummyMbtTest(File model, boolean efsm, PathGenerator generator, boolean weight) {
        super(model, efsm, generator, weight, browser, "");
    }

    @Parameters({"browser", "environment"})
    @Test
    public static void a_star(@Optional("LOCAL_FIREFOX") String browser, @Optional("") String environment, ITestContext testContext) throws InterruptedException, StopConditionException, URISyntaxException {
        ModelHandler modelhandler = new ModelHandler();

        // Get the model from resources
        URL url = DummyMbtTest.class.getResource("/model/ShoppingCart.graphml");
        File file = new File(url.toURI());

        // Connect the model to a java class, and add it to graphwalker's modelhandler.
        // The model is to be executed using the following criteria:
        // EFSM: Extended finite state machine is set to true, which means we are using the data domain
        // in the model
        // Generator: a_star, we want to walk through the model using shortest possible path.
        // Stop condition: Edge coverage 100%, we want to walk every edge in the model.
        DummyMbt mbtClass = new DummyMbt(file, true, new A_StarPathGenerator(new EdgeCoverage(1.0)), false, browser, testContext.getOutputDirectory());
        modelhandler.add("DummyMbt", mbtClass);

        // Start executing the test
        modelhandler.execute("DummyMbt");
        mbtClass.driver.quit();
        // Verify that the execution is complete, fulfilling the criteria from above.
        Assert.assertTrue(modelhandler.isAllModelsDone(), "Not all models are done");

        // Print the statistics from graphwalker
        String actualResult = modelhandler.getStatistics();
        System.out.println(actualResult);
    }

}
