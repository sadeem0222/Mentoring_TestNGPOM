package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class ProductPage {
     private By addToCartBtn = By.xpath("//button[text()='ADD TO CART']");
    private By shoppingCartIcon = By.xpath("//*[name()='svg' and @data-icon='shopping-cart']");



    public ProductPage clickAddToCart() {
        Driver.getDriver().findElement(addToCartBtn).click();
        return this;
    }

    public ProductPage clickShoppingCart() {
        Driver.getDriver().findElement(shoppingCartIcon).click();
        return this;
    }
}
