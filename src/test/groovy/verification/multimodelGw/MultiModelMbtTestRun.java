package verification.multimodelGw;

import org.apache.log4j.Logger;
import org.graphwalker.conditions.EdgeCoverage;
import org.graphwalker.exceptions.StopConditionException;
import org.graphwalker.generators.A_StarPathGenerator;
import org.graphwalker.generators.PathGenerator;
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

public class MultiModelMbtTestRun extends Model_A {
    private final static Logger log = Logger.getLogger("AMT  ");
    private static final String MBT_MODEL_GRAPH_A = "/model/Model_A.graphml";
    private static final String MBT_MODEL_GRAPH_B = "/model/Model_B.graphml";
    private static final String MBT_MODEL_GRAPH_C = "/model/Model_C.graphml";
    private static final String MBT_MODEL_GRAPH_D = "/model/Model_D.graphml";
    private static final String MBT_MODEL_A = "Model A";
    private static final String MBT_MODEL_B = "Model B";
    private static final String MBT_MODEL_C = "Model C";
    private static final String MBT_MODEL_D = "Model D";

    public MultiModelMbtTestRun(File model, boolean efsm, PathGenerator generator, boolean weight) {
        super(model, efsm, generator, weight, "", "");
    }

    @Parameters({"browser", "environment"})
    @Test
    public static void aStar(@Optional("LOCAL_FIREFOX") String browser, @Optional("") String environment, ITestContext testContext) throws InterruptedException, StopConditionException, URISyntaxException {
        ModelHandler modelhandler = new ModelHandler();
        Model_A modelA = null;
        Model_B modelB = null;
        Model_C modelC = null;
        Model_D modelD = null;
        URL url_A = null;
        File file_A = null;
        URL url_B = null;
        File file_B = null;
        URL url_C = null;
        File file_C = null;
        URL url_D = null;
        File file_D = null;
        try {
             url_A = MultiModelMbtTestRun.class.getResource(MBT_MODEL_GRAPH_A);
             url_B = MultiModelMbtTestRun.class.getResource(MBT_MODEL_GRAPH_B);
             url_C = MultiModelMbtTestRun.class.getResource(MBT_MODEL_GRAPH_C);
             url_D = MultiModelMbtTestRun.class.getResource(MBT_MODEL_GRAPH_D);
             file_A = new File(url_A.toURI());
             file_B = new File(url_B.toURI());
             file_C = new File(url_C.toURI());
             file_D = new File(url_D.toURI());

        } catch (Exception exception) {
            Reporter.log("Can't find file <" + MBT_MODEL_GRAPH_A + ">");
            Reporter.log(exception.toString());
            Assert.assertTrue(false, "Test not started");
        }

        try {
            modelA = new Model_A(file_A, true, new A_StarPathGenerator(new EdgeCoverage(1.0)), false, browser, "");
            modelB = new Model_B(file_B, true, new A_StarPathGenerator(new EdgeCoverage(1.0)), false, browser, "");
            modelC = new Model_C(file_C, true, new A_StarPathGenerator(new EdgeCoverage(1.0)), false, browser, "");
            modelD = new Model_D(file_D, true, new A_StarPathGenerator(new EdgeCoverage(1.0)), false, browser, "");

            modelhandler.add(MBT_MODEL_A, modelA);
            modelhandler.add(MBT_MODEL_B, modelB);
            modelhandler.add(MBT_MODEL_C, modelC);
//            modelhandler.add(MBT_MODEL_D, modelD);
        } catch (Exception exception) {
            Reporter.log("Can't load model <" + Model_A.class.getName() + ">");
            Reporter.log(exception.toString());
            Assert.assertTrue(false, "Test not started");
        }

        try {
            modelhandler.execute(MBT_MODEL_A);
        } catch (Exception exception) {
            Reporter.log(exception.toString());
            Reporter.log("Test execution crashed");
        }

        Reporter.log(modelhandler.getStatistics());
        modelA.driver.quit();
        modelB.driver.quit();
        modelC.driver.quit();
        modelD.driver.quit();
        vemAssert.assertTrue(modelhandler.isAllModelsDone(), MBT_MODEL_A + ": not all models are done");
    }


}
