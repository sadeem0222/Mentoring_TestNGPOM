package utilities;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
public class MyTestListener implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    private int retryCount = 0;
    private static final int maxRetryCount = 1; // Retry failed test once

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " started.");
        ExtentReportManager.createTest(result.getMethod().getMethodName());
        ExtentReportManager.log(Status.INFO, "Test started at: " + LocalTime.now());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " is SUCCESS!");
        ExtentReportManager.log(Status.INFO, "Test finished at: " + LocalTime.now());
        ExtentReportManager.logResult(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " is FAILED!!!");
        ExtentReportManager.log(Status.INFO, "Test finished at: " + LocalTime.now());
        ExtentReportManager.logResult(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " is SKIPPED!!!");
        ExtentReportManager.log(Status.INFO, "Test finished at: " + LocalTime.now());
        ExtentReportManager.logResult(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test started at: " + context.getStartDate());
        Path allureResults = Paths.get("allure-results");

        if (Files.exists(allureResults)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(allureResults)) {
                for (Path entry : stream) {
                    Files.deleteIfExists(entry);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test finished at: " + context.getEndDate());

        // Flush Extent Report once
        ExtentReportManager.flushReport();

        // Optional: Auto open allure report
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd.exe", "/c", "allure serve")
                        .inheritIO()
                        .start();
            } else {
                new ProcessBuilder("bash", "-c", "allure serve")
                        .inheritIO()
                        .start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Driver.closeDriver();
    }

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(MyTestListener.class);
    }

}