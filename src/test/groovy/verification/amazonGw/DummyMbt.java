package verification.amazonGw;

import base.AnyMbtTest;
import org.graphwalker.exceptions.InvalidDataException;
import org.graphwalker.generators.PathGenerator;
import pages.amazon.AmazonStartPage;

import java.io.File;

public class DummyMbt extends AnyMbtTest {

    private AmazonStartPage amazonStartPage;
    private int index = 1000;

    //    public ISeleniumHelper driver;
    public DummyMbt(File model, boolean efsm, PathGenerator generator, boolean weight, String browser, String outputDirectory) {
        super(model, efsm, generator, weight, browser, outputDirectory);
//        this.driver = super.driver;
    }


    /**
     * This method implements the Edge 'e_AddBookToCart'
     */
    public void e_AddBookToCart() {

    }

    /**
     * This method implements the Edge 'e_ClickBook'
     */
    public void e_ClickBook() {
    }

    /**
     * This method implements the Edge 'e_EnterBaseURL'
     */
    public void e_EnterBaseURL() {

    }

    /**
     * This method implements the Edge 'e_SearchBook'
     */
    public void e_SearchBook() {
    }

    /**
     * This method implements the Edge 'e_ShoppingCart'
     */
    public void e_ShoppingCart() {

    }

    /**
     * This method implements the Edge 'e_StartBrowser'
     */
    public void e_StartBrowser() {
    }

    /**
     * This method implements the Vertex 'v_BaseURL'
     */
    public void v_BaseURL() {
    }

    /**
     * This method implements the Vertex 'v_BookInformation'
     */
    public void v_BookInformation() {

    }

    /**
     * This method implements the Vertex 'v_BrowserStarted'
     */
    public void v_BrowserStarted() {
    }

    /**
     * This method implements the Vertex 'v_OtherBoughtBooks'
     *
     * @throws InterruptedException
     */
    public void v_OtherBoughtBooks() throws InterruptedException {


    }

    /**
     * This method implements the Vertex 'v_SearchResult'
     */
    public void v_SearchResult() {

    }

    /**
     * This method implements the Vertex 'v_ShoppingCart'
     *
     * @throws org.graphwalker.exceptions.InvalidDataException
     * @throws InterruptedException
     */
    public void v_ShoppingCart() throws InvalidDataException, InterruptedException {

    }


}
