package verification.amazonGw

import base.AnyTest
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import pages.amazon.AmazonStartPage

public class AmazonTest extends AnyTest {
    private AmazonStartPage amazonStartPage;


    @BeforeClass
    public void beforeClass() {
        amazonStartPage = new AmazonStartPage(driver, vemAssert);
        amazonStartPage.load()
    }


    @Test
    public void buyTest() {
        amazonStartPage.searchBook()
        amazonStartPage.verifyShoppingCart()


        amazonStartPage.searchBook()
        amazonStartPage.clickOnBook()
        amazonStartPage.verifyShoppingCart()


        amazonStartPage.searchBook()
        amazonStartPage.clickOnBook()
        amazonStartPage.addBookToCart()
        amazonStartPage.verifyShoppingCart()

        amazonStartPage.searchBook()
        amazonStartPage.clickOnBook()
        amazonStartPage.addBookToCart()
        amazonStartPage.verifyShoppingCart()

        amazonStartPage.searchBook()
        amazonStartPage.clickOnBook()
        amazonStartPage.addBookToCart()
        amazonStartPage.verifyShoppingCart()

    }
}
