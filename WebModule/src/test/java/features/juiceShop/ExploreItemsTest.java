package features.juiceShop;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.juiceShop.HomePage;
import seleniumCore.CoreTest;

public class ExploreItemsTest extends CoreTest {

    private HomePage homePage;

    @BeforeMethod
    public void setup(){
        System.out.println("Calling inside Test Class");
        homePage = new HomePage();
    }

    @Test(description = "Verify all the products are displayed when the maximum items per page is selected")
    public void verifyAllProducts(){
        homePage.navigateToJuiceShop();
        homePage.closeWelcomeDialogue();
        homePage.selectMaxItemsPerPage();
        homePage.verifyAllItemsDisplayed();
    }

    @Test(description = "Verify the product details and open reviews")
    public void verifyProductDetail(){
        homePage.navigateToJuiceShop();
        homePage.closeWelcomeDialogue();
        homePage.selectFirstItem();
        homePage.verifyProductDetails("Apple Juice");
        homePage.expandReview();
        homePage.closeProductDetails();
    }

}
