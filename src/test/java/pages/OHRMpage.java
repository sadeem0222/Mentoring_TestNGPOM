package pages;

import org.openqa.selenium.By;
import utilities.Driver;

public class OHRMpage extends OrangLoginPage {
    private By profileDD = By.xpath("//span[@class='oxd-userdropdown-tab']");

    public OHRMpage assertLogin() {
        assert Driver.getDriver().findElement(profileDD).isDisplayed();
        return this;
    }

}
