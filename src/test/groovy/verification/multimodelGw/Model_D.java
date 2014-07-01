package verification.multimodelGw;

import base.AnyMbtTest;
import org.graphwalker.generators.PathGenerator;

import java.io.File;

public class Model_D extends AnyMbtTest {
    private static final long SLEEP = 1000;


    public Model_D(File model, boolean efsm, PathGenerator generator, boolean weight, String browser, String outputDirectory) {
        super(model, efsm, generator, weight, browser, outputDirectory);
    }

    /**
     * This method implements the Edge 'e_A'
     *
     */
    public void e_D() throws InterruptedException {
        Thread.sleep(SLEEP);
    }


    /**
     * This method implements the Edge 'e_B'
     *
     */
    public void e_F() throws InterruptedException {
        Thread.sleep(SLEEP);
    }


    /**
     * This method implements the Vertex 'v_A'
     *
     */
    public void v_D() throws InterruptedException {
        Thread.sleep(SLEEP);
    }


    /**
     * This method implements the Vertex 'v_B'
     *
     */
    public void v_F() throws InterruptedException {
        Thread.sleep(SLEEP);
    }


}
