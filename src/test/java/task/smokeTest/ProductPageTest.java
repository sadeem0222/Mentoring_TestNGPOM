package task.smokeTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import utilities.Driver;

public class ProductPageTest {

    @Test
    public void addProductToCart() {
        Driver.getDriver().get("https://www.saucedemo.com/v1/inventory.html");
        ProductPage prodcet =new ProductPage();
        prodcet.clickAddToCart();



    }
}
