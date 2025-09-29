package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class ActionFormPage {

    private By nameInput =By.id("name");
    private  By ageInput =By.id("age");
    private By options =By.id("options");
    private String checkboxXpath = "//input[@type='checkbox' and @value='%s']";
    private String radioXpath = "//input[@type='radio' and @value='%s']";
    private By submit1 =By.xpath("//button[text()='Generate Passcode']");
    private By submit = By.id("submitButton");

    private WebDriver driver;




    public ActionFormPage entername(String name){
        Driver.getDriver().findElement(nameInput).sendKeys(name);
        return this;
    }

    public ActionFormPage enterage(String age){
        Driver.getDriver().findElement(ageInput).sendKeys(age);
        return this;
    }



    public ActionFormPage selectCheckbox(String value) {
        Driver.getDriver().findElement(By.xpath(String.format(checkboxXpath, value))).click();
        return this;
    }

    public ActionFormPage selectRadio(String value) {
        Driver.getDriver().findElement(By.xpath(String.format(radioXpath, value))).click();
        return this;
    }

    public  ActionFormPage clickOnBUTTON(){
        driver = Driver.getDriver();
        driver.findElement(submit1).click();
        return this;
    }


    public ActionFormPage handleJSAlertPasscode() {

        String code = driver.switchTo().alert().getText().replaceAll("\\D", "");
        driver.switchTo().alert().accept();
        driver.switchTo().alert().sendKeys(code);
        driver.switchTo().alert().accept();

        return this;
    }

    public ActionFormPage clickSubmit() {
        Driver.getDriver().switchTo().frame(0);
        Driver.getDriver().findElement(submit).click();
        return this;
    }


}
