package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountPage {
    public AccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "button[ng-click='deposit()']")
    public WebElement depositTab;

    @FindBy(xpath = "//input[@ng-model='amount']")
    public WebElement amountInput;

    @FindBy(xpath = "//button[text()='Deposit']")
    public WebElement depositButton;

    @FindBy(css = ".error.ng-binding") // الرسالة بعد الإيداع
    public WebElement successMessage;

    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutButton;


    @FindBy(css = "button[ng-click='withdrawl()']")
    public WebElement withdrawTab;

    @FindBy(xpath = "//input[@ng-model='amount']")
    public WebElement amountInput1;

    @FindBy(xpath = "//button[text()='Withdraw']")
    public WebElement withdrawButton;

    @FindBy(css = ".error.ng-binding") // الرسالة بعد السحب
    public WebElement message;

    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutButton1;


    @FindBy(css = "button[ng-click='home()']")
    public WebElement homeButton;
}

