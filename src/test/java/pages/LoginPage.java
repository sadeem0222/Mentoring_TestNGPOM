package pages;


import org.openqa.selenium.By;
import utilities.Driver;

public class LoginPage {

    // Locators
    private By registerLink = By.id("signup");
    private By usernameInput = By.id("email");
    private By passwordInput = By.id("password");
    private By submitLoginBtn = By.id("submit");
    private By registerNameInput = By.id("firstName");
    private By registerLastNameInput = By.id("lastName");
    private By registerEmailInput = By.id("email");
    private By registerPasswordInput = By.id("password");
    private By submitRegisterBtn = By.id("submit");

    // Actions
    public LoginPage enterUsername(String username) {
        Driver.getDriver().findElement(usernameInput).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        Driver.getDriver().findElement(passwordInput).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        Driver.getDriver().findElement(submitLoginBtn).click();
        return this;
    }

    public LoginPage clickRegisterLink() {
        Driver.getDriver().findElement(registerLink).click();
        return this;
    }

    public LoginPage enterRegisterFirstName(String firstName) {
        Driver.getDriver().findElement(registerNameInput).sendKeys(firstName);
        return this;
    }

    public LoginPage enterRegisterLastName(String lastName) {
        Driver.getDriver().findElement(registerLastNameInput).sendKeys(lastName);
        return this;
    }

    public LoginPage enterRegisterEmail(String email) {
        Driver.getDriver().findElement(registerEmailInput).sendKeys(email);
        return this;
    }

    public LoginPage enterRegisterPassword(String password) {
        Driver.getDriver().findElement(registerPasswordInput).sendKeys(password);
        return this;
    }

    public LoginPage clickRegister() {
        Driver.getDriver().findElement(submitRegisterBtn).click();
        return this;
    }
}