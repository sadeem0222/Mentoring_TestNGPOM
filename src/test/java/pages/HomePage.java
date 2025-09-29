package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class HomePage {

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");

    public HomePage enterUsername(String username) {
        Driver.getDriver().findElement(usernameInput).sendKeys(username);
        return this;
    }

    public HomePage enterPassword(String password) {
        Driver.getDriver().findElement(passwordInput).sendKeys(password);
        return this;
    }

    public HomePage clickLogin() {
        Driver.getDriver().findElement(loginButton).click();
        return this;

    }



}
