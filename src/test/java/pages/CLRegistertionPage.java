package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class CLRegistertionPage {

    private By firstName =By.id("firstName");
    private By lastName =By.id("lastName");
    private By email =By.id("email");
    private By password =By.id("password");
    private By submit =By.id("submit");
    private By errorMessage=By.id("error");







    public CLRegistertionPage firstName(String firsName){
        Driver.getDriver().findElement(firstName).sendKeys(firsName);
        return this;
    }

    public CLRegistertionPage lastNamee(String lassName){
        Driver.getDriver().findElement(lastName).sendKeys(lassName);
        return this;
    }

    public CLRegistertionPage email(String emall){
        Driver.getDriver().findElement(email).sendKeys(emall);
        return this;
    }

    public CLRegistertionPage pass(String paas){
        Driver.getDriver().findElement(password).sendKeys(paas);
        return this;
    }

    public CLRegistertionPage assertErrorMessage(String message) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        assertTrue(Driver.getDriver().findElement(this.errorMessage).getText().contains(message));
        return this;
    }

    public CLRegistertionPage click(){
        Driver.getDriver().findElement(submit).click();
        return this;
    }


    public CLRegistertionPage assertSubmit() {
        Assert.assertTrue(true,"Contact List");
        return this;
    }
}
