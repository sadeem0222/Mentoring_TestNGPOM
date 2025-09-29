package task.smokeTest;

import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import utilities.Driver;

public class CheckoutPageTest {

    @Test
    public void completeCheckout() {
        Driver.getDriver().get("https://www.saucedemo.com/v1/");

        // Login
        HomePage login =new HomePage();
        login.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();

        // Add product
        ProductPage prodcet =new ProductPage();
        prodcet.clickAddToCart().clickShoppingCart();

        // Go to cart
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.openCart().clickRemove();

        // Finish
        Driver.closeDriver();


    }
}
