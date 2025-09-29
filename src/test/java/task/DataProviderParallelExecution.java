package task;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginNegativePage;
import utilities.Driver;

public class DataProviderParallelExecution {

    @Test(dataProvider = "data")
    public void login(String user, String pass) {
        Driver.getDriver().get("https://claruswaysda.github.io/signIn.html");
        LoginNegativePage login =new LoginNegativePage();
        login.entername(user)
                        .enterpass(pass).clickSignIn();
        Driver.closeDriver();

        System.out.println("username and password: " + user + " " + pass + "||" + Thread.currentThread().getId());
    }

    // By default, parallel = false. To enable parallel execution, specify parallel = true
    @DataProvider(name = "data", parallel = true)
    public Object[][] myDataProvider() {
        Object data[][] = new Object[5][2];

        // First login
        data[0][0] = "admin";
        data[0][1] = "123";

        // Second login
        data[1][0] = "Jane";
        data[1][1] = "Smith";

        // Third login
        data[2][0] = "Peter";
        data[2][1] = "Jones";

        // Forth login
        data[3][0] = "Tom";
        data[3][1] = "Hawk";

        // fifth login
        data[4][0] = "Tom";
        data[4][1] = "Hawk";

        return data;

    }
}
