package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class ActionClassPage {

    private By drag1 = By.id("drag1");
    private By drop1 = By.id("drop1");
    private By showSuccessButton = By.id("showSuccessButton");
    private By doubleClickButton = By.id("doubleClickButton");
    private By hoverButton = By.id("hoverButton");

    private Actions actions;

    public ActionClassPage() {
        this.actions = new Actions(Driver.getDriver());
    }

    public ActionClassPage dragAndDrop() {
        WebElement src = Driver.getDriver().findElement(drag1);
        WebElement dest = Driver.getDriver().findElement(drop1);
        actions.dragAndDrop(src, dest).perform();
        return this;
    }

    public ActionClassPage clickShowSuccess() {
        Driver.getDriver().findElement(showSuccessButton).click();
        return this;
    }

    public ActionClassPage doubleClick() {
        WebElement elem = Driver.getDriver().findElement(doubleClickButton);
        actions.doubleClick(elem).perform();
        return this;
    }

    public ActionClassPage hoverOverButton() {
        WebElement elem = Driver.getDriver().findElement(hoverButton);
        actions.moveToElement(elem).perform();
        return this;
    }
}