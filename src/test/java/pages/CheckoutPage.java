package pages;

import org.openqa.selenium.By;
import utilities.Driver;


public class CheckoutPage {

    // Locators
    private By removeButton   = By.xpath("//button[contains(@class,'btn_secondary') and text()='REMOVE']");
    private By checkoutButton = By.xpath("//a[text()='CHECKOUT']");
    private By cartLink       = By.className("shopping_cart_link");

    // Actions
    public CheckoutPage openCart() {
        Driver.getDriver().findElement(cartLink).click();
        return this;
    }

    public CheckoutPage clickCheckout() {
        Driver.getDriver().findElement(checkoutButton).click();
        return this;
    }

    public CheckoutPage clickRemove() {
        Driver.getDriver().findElement(removeButton).click();
        return this;
    }
}
