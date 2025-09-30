package test;

import com.aventstack.extentreports.Status;
import org.testng.SkipException;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ExtentReportManager;


public class C06_extendesReport {

    @Test
    void test01(){
        System.out.println("pass");
        Driver.getDriver().get("https://google.com");
        ExtentReportManager.log(Status.INFO,"we are on google");
        Driver.closeDriver();
    }

    @Test
    void test02(){
        System.out.println("fail");
        Driver.getDriver().get("https://instgram.com");
        assert false;

    }

    @Test
    void test03(){
        System.out.println("skip");
        throw new SkipException("");
    }

}
