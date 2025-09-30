package pages;


import org.openqa.selenium.By;
import utilities.Driver;

public class AddContactPage {

    // Locators
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By birthdateInput = By.id("birthdate");
    private By emailInput = By.id("email");
    private By phoneInput = By.id("phone");
    private By address1Input = By.id("street1");
    private By address2Input = By.id("street2");
    private By cityInput = By.id("city");
    private By stateInput = By.id("stateProvince");
    private By postalCodeInput = By.id("postalCode");
    private By countryInput = By.id("country");
    private By submitBtn = By.id("submit");


    // Actions
    public AddContactPage enterFirstName(String firstName) {
        Driver.getDriver().findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public AddContactPage enterLastName(String lastName) {
        Driver.getDriver().findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public AddContactPage enterBirthdate(String birthdate) {
        Driver.getDriver().findElement(birthdateInput).sendKeys(birthdate);
        return this;
    }

    public AddContactPage enterEmail(String email) {
        Driver.getDriver().findElement(emailInput).sendKeys(email);
        return this;
    }

    public AddContactPage enterPhone(String phone) {
        Driver.getDriver().findElement(phoneInput).sendKeys(phone);
        return this;
    }

    public AddContactPage enterAddress1(String address) {
        Driver.getDriver().findElement(address1Input).sendKeys(address);
        return this;
    }

    public AddContactPage enterAddress2(String address) {
        Driver.getDriver().findElement(address2Input).sendKeys(address);
        return this;
    }

    public AddContactPage enterCity(String city) {
        Driver.getDriver().findElement(cityInput).sendKeys(city);
        return this;
    }

    public AddContactPage enterState(String state) {
        Driver.getDriver().findElement(stateInput).sendKeys(state);
        return this;
    }

    public AddContactPage enterPostalCode(String code) {
        Driver.getDriver().findElement(postalCodeInput).sendKeys(code);
        return this;
    }

    public AddContactPage enterCountry(String country) {
        Driver.getDriver().findElement(countryInput).sendKeys(country);
        return this;
    }

    public AddContactPage clickSubmit() {
        Driver.getDriver().findElement(submitBtn).click();
        return this;
    }
}