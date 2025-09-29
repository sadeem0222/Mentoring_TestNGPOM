package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.Driver;

public class OrangLoginPage {
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By erroruserMessage = By.xpath("//div[@class='oxd-form-row' and contains(., 'Username')]//span");
    private By errorpassMessage = By.xpath("//div[@class='oxd-form-row' and contains(., 'Password')]//span");

    public OrangLoginPage enterUsername(String username) {
        Driver.getDriver().findElement(usernameInput).sendKeys(username);
        return this;
    }

    public OrangLoginPage enterPassword(String password) {
        Driver.getDriver().findElement(passwordInput).sendKeys(password);
        return this;
    }

    public OHRMpage clickLogin() {
        Driver.getDriver().findElement(loginButton).click();
        return new OHRMpage();

    }

    public OrangLoginPage erroruserMessage() {
        Assert.assertEquals(Driver.getDriver().findElement(erroruserMessage).getText(), "Required");
        return this;
    }
    public OrangLoginPage errorpassMessage() {
        Assert.assertEquals(Driver.getDriver().findElement(errorpassMessage).getText(), "Required");

        return this;
    }
}