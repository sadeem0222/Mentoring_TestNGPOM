package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class AddRecordPage {

    private By nameInput = By.id("nameInput");
    private By ageInput = By.id("ageInput");
    private By countrySelect = By.id("countrySelect");
    private By addrecerodbuttun = By.xpath("//button[@onclick='addRecord()']");
    private String deletebuttunbyname = "//tr[contains(.,'%s')]//button[@class='delete-button']";
    private By tableBody = By.id("tableBody");


    public AddRecordPage entername(String name) {
        Driver.getDriver().findElement(nameInput).sendKeys(name);
        return this;
    }

    public AddRecordPage enterage(String age) {
        Driver.getDriver().findElement(ageInput).sendKeys(age);
        return this;
    }

    public AddRecordPage selecetCountry(int index) {
        new Select(Driver.getDriver().findElement(countrySelect)).selectByIndex(index);
        return this;
    }

    public AddRecordPage selecetCountry(String text) {
        new Select(Driver.getDriver().findElement(countrySelect)).selectByVisibleText(text);
        return this;
    }

    public AddRecordPage clickOnAddrecored() {
        Driver.getDriver().findElement(addrecerodbuttun).click();
        return this;
    }
}
