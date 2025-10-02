package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class UserRegistationPage {

    private By ssn = By.id("ssn");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By femaleLabel = By.cssSelector("label[for='female']");
    private By jobDropdown = By.id("job");
    private By cvUpload = By.id("cv");
    private By username = By.id("username");
    private By email = By.id("email");
    private By password = By.id("password");
    private By registerButton = By.cssSelector(".submit-btn");



    public UserRegistationPage enterSSN(String ssninput) {
        Driver.getDriver().findElement(ssn).sendKeys(ssninput);
        return this;
    }


    public UserRegistationPage enterfirstname(String fisrtinput) {
        Driver.getDriver().findElement(firstName).sendKeys(fisrtinput);
        return this;
    }


    public UserRegistationPage enterlastname(String lastinput) {
        Driver.getDriver().findElement(lastName).sendKeys(lastinput);
        return this;
    }


    public UserRegistationPage selectGender(String gender) {
        By locator = By.cssSelector("label[for='" + gender.toLowerCase() + "']");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement label = wait.until(ExpectedConditions.elementToBeClickable(locator));
        label.click();

        return this;
    }



    public UserRegistationPage selectJob(String jobValue) {
        WebElement dropdown = Driver.getDriver().findElement(jobDropdown);
        Select select = new Select(dropdown);
        select.selectByValue(jobValue);
        return this;
    }

    public UserRegistationPage uploadCV(String filePath) {
        Driver.getDriver().findElement(cvUpload).sendKeys(filePath);
        return this;
    }


    public UserRegistationPage enterusername(String usernameinput) {
        Driver.getDriver().findElement(username).sendKeys(usernameinput);
        return this;
    }


    public UserRegistationPage enteremail(String emailinput) {
        Driver.getDriver().findElement(email).sendKeys(emailinput);
        return this;
    }


    public UserRegistationPage enterpassword(String passinput) {
        Driver.getDriver().findElement(password).sendKeys(passinput);
        return this;
    }


    public UserRegistationPage clickRegister() {
        Driver.getDriver().findElement(registerButton).click();
        return this;
    }

    public UserRegistationPage assertJSAlert(String message) {
        WebDriver driver=Driver.getDriver();
        assertEquals(Driver.getDriver().switchTo().alert().getText(), message);
        driver.switchTo().alert().accept();
        return this;
    }

    public UserRegistationPage assertValidationMessage(String message,String input) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        By by=null;
        switch (input.toLowerCase()){
            case "ssn":
                 by = ssn;
                 break;
            case "firstname":
                by = firstName;
                break;
            case "lastname":
                by = lastName;
                break;
            case "username":
                by = username;
                break;
            case "password":
                by = password;
                break;

        }
        String error = (String) js.executeScript("return arguments[0].validationMessage;", Driver.getDriver().findElement(by));
        assertEquals(error,message);
        return this;
    }



}
