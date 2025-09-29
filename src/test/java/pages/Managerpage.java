package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Managerpage {
    public Managerpage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[text()[normalize-space()='Open Account']]")
    public WebElement openAccountButton;

    @FindBy(css = "button[ng-click='addCust()']")
    public WebElement addCustomerTab;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    public WebElement postCodeInput;

    @FindBy(xpath = "//button[text()='Add Customer']")
    public WebElement addCustomerButton;


    @FindBy(css = "button.home")
    public WebElement homeButton;

    @FindBy(css = "button[ng-click='manager()']")
    public WebElement bankManagerLoginButton;

    @FindBy(css = "button[ng-click='showCust()']")
    public WebElement customersTab;

    // جميع أزرار Delete لكل العملاء
    @FindBy(xpath = "//button[text()='Delete']")
    public List<WebElement> deleteButtons;






}
