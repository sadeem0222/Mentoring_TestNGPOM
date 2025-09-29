package task;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.Bankloginpage;
import pages.Managerpage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.List;



public class BankingApplicationTest {

    Bankloginpage login = new Bankloginpage();
    Managerpage manager = new Managerpage();
    Faker faker = new Faker();
    AccountPage accountPage = new AccountPage();

    @Test
     void creataccountTest() {
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        login.bankManagerLoginButton.click();
        handleAlertIfPresent();
        manager.openAccountButton.click();
        handleAlertIfPresent();
        manager.addCustomerTab.click();
        handleAlertIfPresent();

        for (int i = 0; i < 5; i++) {
            manager.firstNameInput.sendKeys(faker.name().firstName());
            manager.lastNameInput.sendKeys(faker.name().lastName());
            manager.postCodeInput.sendKeys(faker.address().zipCode());
            manager.addCustomerButton.click();
            handleAlertIfPresent();


        }
        //Assertion
        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            String text = alert.getText();
            System.out.println("Alert message: " + text);

            Assert.assertTrue(text.contains("Customer added successfully"));

            alert.accept();
        } catch (NoAlertPresentException e) {
            Assert.fail("No alert found after adding customer!");
        }


    }

    //alert handling
    public void handleAlertIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert message: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            // no alerts
        }
    }




    @Test
     void depositetest() {
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        login.CustomerLoginButton.click();
        Select selectCustomer = new Select(login.userDropdown);

        String[] customers = {"Hermoine Granger", "Harry Potter", "Ron Weasly", "Albus Dumbledore", "Neville Longbottom"};

        for (String customer : customers) {
            selectCustomer.selectByVisibleText(customer);
            login.loginButton.click();

            accountPage.depositTab.click();

            accountPage.amountInput.sendKeys("100");
            accountPage.depositButton.click();

            String successMsg = accountPage.successMessage.getText();
            System.out.println(customer + " deposit message: " + successMsg);
            Assert.assertTrue(successMsg.contains("Deposit Successful"), "Deposit failed for " + customer);

            Driver.getDriver().findElement(By.xpath("//button[text()='Logout']")).click();
        }
    }

    @Test
     void withdrawTest() {
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
        login.CustomerLoginButton.click();

        Select selectCustomer = new Select(login.userDropdown);
        selectCustomer.selectByVisibleText("Hermoine Granger");
        login.loginButton.click();

        accountPage.withdrawTab.click();

        accountPage.amountInput.sendKeys("100");

        accountPage.withdrawButton.click();

        // Assertion
        String depositMsg = accountPage.successMessage.getText();
        Assert.assertTrue(depositMsg.contains("Transaction successful"));

        System.out.println(accountPage.message.getText());

        accountPage.logoutButton1.click();


    }

    @Test
     void deleteAllTest() {
        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        manager.bankManagerLoginButton.click();
        manager.customersTab.click();


        List<WebElement> deleteButtons = manager.deleteButtons;

        while(!deleteButtons.isEmpty()){
            deleteButtons.get(0).click();
            deleteButtons = manager.deleteButtons;
        }

        // Assertion
        Assert.assertTrue(deleteButtons.isEmpty());
    }
    }
