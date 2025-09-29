package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Bankloginpage {

    public Bankloginpage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[text()='Bank Manager Login']")
    public WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[text()='Customer Login']")
    public WebElement   CustomerLoginButton;
    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;

    @FindBy(id = "userSelect")
    public WebElement userDropdown;





}
