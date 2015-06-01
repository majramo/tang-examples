package verification.multimodelGw;

import base.AnyMbtTest;
import org.graphwalker.generators.PathGenerator;

import java.io.File;

import static java.lang.Thread.sleep;

public class Model_A extends AnyMbtTest {
    private static final long SLEEP = 50000;


    public Model_A(File model, boolean efsm, PathGenerator generator, boolean weight, String browser, String outputDirectory) {
        super(model, efsm, generator, weight, browser, outputDirectory);
    }

    /**
     * This method implements the Edge 'e_A'
     *
     */
    public void e_A() throws InterruptedException {

        sleep(SLEEP);
    }


    /**
     * This method implements the Edge 'e_B'
     *
     */
    public void e_B() throws InterruptedException {

        sleep(SLEEP);
    }


    /**
     * This method implements the Vertex 'v_A'
     *
     */
    public void v_A() throws InterruptedException {

        sleep(SLEEP);
    }




    /**
     * This method implements the Vertex 'v_B'
     *
     */
    public void v_B() throws InterruptedException {

        sleep(SLEEP);
    }


}
