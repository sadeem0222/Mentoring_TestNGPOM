package task;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.OrangLoginPage;
import utilities.Driver;


@Listeners(utilities.ScreenshotListener.class)
public class FailingTestExample {



        @Test
        public void failingLoginTest() {
            Driver.getDriver().get("https://claruswaysda.github.io/signIn.html");

            OrangLoginPage login = new OrangLoginPage();
            login.enterUsername("wrongUser")
                    .enterPassword("wrongPass")
                    .clickLogin();

            //فشل متعمد علشان نصور Screensho
            Assert.assertTrue(false, "Intentional failure for screenshot demo");
        }
    }
