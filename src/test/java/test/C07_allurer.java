package test;

import com.aventstack.extentreports.Status;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.SkipException;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ExtentReportManager;

public class C07_allurer {


    @Test
    @Description("sucsses")
    @Severity(SeverityLevel.BLOCKER)
    void test01(){
        System.out.println("pass");
        Driver.getDriver().get("https://google.com");
        ExtentReportManager.log(Status.INFO,"we are on google");
        login();
        addProduct();
        checkOut();
        logout();
        Driver.closeDriver();
    }

    @Test
    @Description("fail")
    @Severity(SeverityLevel.CRITICAL)
    void test02(){
        System.out.println("fail");
        Driver.getDriver().get("https://instgram.com");
        assert false;

    }

    @Test
    @Description("SKPPED")
    @Severity(SeverityLevel.TRIVIAL)
    void test03(){
        System.out.println("skip");
        throw new SkipException("");
    }

    @Step
    void login(){
        System.out.println("login");

    }
    @Step
    void addProduct(){
        System.out.println("addProduct");

    }

    @Step
    void checkOut(){
        System.out.println("checkOut");

    }
    @Step
    void logout(){
        System.out.println("logout");

    }

}
