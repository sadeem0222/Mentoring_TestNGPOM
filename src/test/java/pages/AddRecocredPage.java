package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class AddRecocredPage {

  private By nameInput =By.id("nameInput");
    private  By ageInput =By.id("ageInput");
    private By countrySelect =By.id("countrySelect");
    private By addrecerodbuttun = By.xpath("//button[@onclick='addRecord()']");
    private String deletebuttunbyname = "//tr[contains(.,'%s')]//button[@class='delete-button']";
    private By tableBody=By.id("tableBody");


    public AddRecocredPage entername(String name){
        Driver.getDriver().findElement(nameInput).sendKeys(name);
        return this;
    }

    public AddRecocredPage enterage(String age){
        Driver.getDriver().findElement(ageInput).sendKeys(age);
        return this;
    }

    public AddRecocredPage selecetCountry(int index){
        new Select(Driver.getDriver().findElement(countrySelect)).selectByIndex(index);
        return this;
    }
    public AddRecocredPage selecetCountry(String text){
        new Select(Driver.getDriver().findElement(countrySelect)).selectByVisibleText(text);
        return this;
    }

    public  AddRecocredPage clickOnAddrecored(){
        Driver.getDriver().findElement(addrecerodbuttun).click();
        return this;
    }

    public AddRecocredPage deleteRecored(String recoredName){
        Driver.getDriver().findElement(By.xpath(String.format(deletebuttunbyname, recoredName))).click();
        return this;
    }

    public AddRecocredPage assertTableContainsText(String text) {
        assertTrue(Driver.getDriver().findElement(tableBody).getText().contains(text));
        return this;
    }
    public AddRecocredPage assertTablenotContainsText(String text) {
        assertFalse(Driver.getDriver().findElement(tableBody).getText().contains(text));
        return this;
    }


}
