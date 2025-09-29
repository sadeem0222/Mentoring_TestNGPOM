package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrangLoginPage;
import utilities.Driver;

public class C05 {

    @Test
    void postivetest(){

        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        OrangLoginPage login = new OrangLoginPage();
        login.enterUsername("Admin")
                .enterPassword("admin123")
                .clickLogin().assertLogin();
        Driver.closeDriver();



    }

    @Test
    void negativetest() {

        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        OrangLoginPage login = new OrangLoginPage();
        login.enterPassword("admin123")
                .clickLogin().erroruserMessage();



        Driver.closeDriver();

    }
    @Test
    void negativetest1() {

        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        OrangLoginPage login = new OrangLoginPage();
        login.enterUsername("Admin")
                .clickLogin().errorpassMessage();



        Driver.closeDriver();

    }
    @Test
    void negativetes21() {

        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        OrangLoginPage login = new OrangLoginPage();
      login.enterUsername("").enterPassword("").clickLogin().erroruserMessage().errorpassMessage();



        Driver.closeDriver();

    }

}
