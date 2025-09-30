package pages;


import org.openqa.selenium.By;
import utilities.Driver;

public class ContactListPage {

    // Locators
    private By addContactBtn = By.id("add-contact");
    private By contactRows = By.cssSelector(".contactTableBodyRow"); // كل contact row
    private By logoutBtn = By.id("logout");


    // Actions
    public ContactListPage clickAddContact() {
        Driver.getDriver().findElement(addContactBtn).click();
        return this;
    }

    public int getContactsCount() {
        return Driver.getDriver().findElements(contactRows).size();
    }

    public ContactListPage clickLogout() {
        Driver.getDriver().findElement(logoutBtn).click();
        return this;
    }




}