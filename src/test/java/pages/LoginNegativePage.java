package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class LoginNegativePage {
    private By username = By.id("username");
    private By password = By.id("password");
    private By signInButton = By.xpath("//input[@type='submit' and @value='Sign In']");
    private By errorMessage = By.id("errorMessage"); // إذا فيه رسالة خطأ



    public LoginNegativePage entername(String usrname) {
        Driver.getDriver().findElement(username).sendKeys(usrname);
        return this;
    }

    public LoginNegativePage enterpass(String pass) {
        Driver.getDriver().findElement(password).sendKeys(pass);
        return this;
    }


    public LoginNegativePage clickSignIn() {
        Driver.getDriver().findElement(signInButton).click();
        return this;
    }
    public String getErrorMessage() {
        return Driver.getDriver().findElement(errorMessage).getText();
    }


}
