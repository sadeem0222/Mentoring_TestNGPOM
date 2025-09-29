package task.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;

public class HomePageTest {

    @Test
    public void verifyLogin() {
        Driver.getDriver().get("https://www.saucedemo.com/v1/index.html");

        HomePage login =new HomePage();
        login.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();


    }

}
