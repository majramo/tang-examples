package verification.amazonGw;

import base.AnyMbtTest;
import org.graphwalker.exceptions.InvalidDataException;
import org.graphwalker.generators.PathGenerator;
import pages.amazon.AmazonStartPage;

import java.io.File;

public class AmazonMbtTest extends AnyMbtTest {

    private AmazonStartPage amazonStartPage;
    private int index = 1000;

    public AmazonMbtTest(File model, boolean efsm, PathGenerator generator, boolean weight, String browser, String outputDirectory) {
        super(model, efsm, generator, weight, browser, outputDirectory);
    }


    /**
     * This method implements the Edge 'e_AddBookToCart'
     */
    public void e_AddBookToCart() {
        amazonStartPage.e_AddBookToCart();
    }

    /**
     * This method implements the Edge 'e_ClickBook'
     */
    public void e_ClickBook() {
        amazonStartPage.e_ClickBook();
    }

    /**
     * This method implements the Edge 'e_EnterBaseURL'
     */
    public void e_EnterBaseURL() {
        amazonStartPage.e_EnterBaseURL();

    }

    /**
     * This method implements the Edge 'e_SearchBook'
     */
    public void e_SearchBook() {
        amazonStartPage.e_SearchBook();
    }

    /**
     * This method implements the Edge 'e_ShoppingCart'
     */
    public void e_ShoppingCart() {
        amazonStartPage.e_ShoppingCart();

    }

    /**
     * This method implements the Edge 'e_StartBrowser'
     */
    public void e_StartBrowser() {
        amazonStartPage = new AmazonStartPage(driver, tangAssert, this);
        // driver = new ChromeDriver();
    }

    /**
     * This method implements the Vertex 'v_BaseURL'
     */
    public void v_BaseURL() {
        amazonStartPage.e_EnterBaseURL();

    }

    /**
     * This method implements the Vertex 'v_BookInformation'
     */
    public void v_BookInformation() {
        amazonStartPage.v_BookInformation();

    }

    /**
     * This method implements the Vertex 'v_BrowserStarted'
     */
    public void v_BrowserStarted() {
        tangAssert.assertNotNull(amazonStartPage.driver, "");
    }

    /**
     * This method implements the Vertex 'v_OtherBoughtBooks'
     *
     * @throws InterruptedException
     */
    public void v_OtherBoughtBooks() throws InterruptedException {
        amazonStartPage.v_OtherBoughtBooks();


    }

    /**
     * This method implements the Vertex 'v_SearchResult'
     */
    public void v_SearchResult() {
        amazonStartPage.v_SearchResult();

    }

    /**
     * This method implements the Vertex 'v_ShoppingCart'
     *
     * @throws org.graphwalker.exceptions.InvalidDataException
     *
     * @throws InterruptedException
     */
    public void v_ShoppingCart() throws InvalidDataException, InterruptedException {
        amazonStartPage.v_ShoppingCartMbt();

    }


}
