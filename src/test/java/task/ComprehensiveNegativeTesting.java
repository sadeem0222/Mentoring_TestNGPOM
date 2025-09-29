package task;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginNegativePage;
import utilities.Driver;

public class ComprehensiveNegativeTesting {


    @DataProvider(name = "negativeData")
    public Object[][] getNegativeData() {
        return new Object[][]{
                {"wrongUser", "wrongPass"},
                {"correctUser", "wrongPass"},
                {"wrongUser", "correctPass"},
                {"", "somePass"},
                {"someUser", ""},
                {"", ""}
        };
    }
    @Test(dataProvider = "negativeData")
    void ComprehensiveNegativeTestingtest(String username, String password) {
        Driver.getDriver().get("https://claruswaysda.github.io/signIn.html");

        LoginNegativePage page = new LoginNegativePage();

        page.entername(username)
                .enterpass(password)
                .clickSignIn();

        String error = page.getErrorMessage();
        Assert.assertTrue(error.contains("Invalid") || error.contains("required"),
                "Expected error message did not appear!");
    }

}
