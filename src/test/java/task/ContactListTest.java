package task;


import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ContactListPage;
import pages.AddContactPage;
import utilities.Driver;
import utilities.ExtentReportManager;

import java.util.concurrent.TimeUnit;

public class ContactListTest {


    LoginPage loginPage = new LoginPage();
    ContactListPage contactListPage=new ContactListPage();
    AddContactPage addContactPage=new AddContactPage();


    String email = "testuser" + System.currentTimeMillis() + "@mail.com";
    String password = "Pass1234";


    @Test(priority = 1)
    public void testRegistrationAndLogin() {
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/");
        ExtentReportManager.log(Status.INFO, "Navigated to Contact List app");


        // Registration
        loginPage
                .clickRegisterLink();
        ExtentReportManager.log(Status.INFO, "Clicked Register link");

        loginPage.enterRegisterFirstName("John")
                .enterRegisterLastName("Doe")
                .enterRegisterEmail(email)
                .enterRegisterPassword(password)
                .clickRegister();
        ExtentReportManager.log(Status.INFO, "Registered user: " + email);

        // Logout + back to login page
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/");
        ExtentReportManager.log(Status.INFO, "Navigated back to login page");

        // Login
        loginPage
                .enterUsername(email)
                .enterPassword(password)
                .clickLogin();
        ExtentReportManager.log(Status.INFO, "Logged in with user: " + email);
    }


    @Test(priority = 2, dependsOnMethods = "testRegistrationAndLogin")
    public void testAddFiveContacts() {
        for (int i = 1; i <= 5; i++) {
            ExtentReportManager.log(Status.INFO, "Adding contact #" + i);
            contactListPage.clickAddContact();
            addContactPage
                    .enterFirstName("Name" + i)
                    .enterLastName("Last" + i)
                    .enterBirthdate("2000-01-0" + i)
                    .enterEmail("contact" + i + "@mail.com")
                    .enterPhone("123456789" + i)
                    .enterAddress1("Street" + i)
                    .enterCity("City" + i)
                    .enterState("ST")
                    .enterPostalCode("1234" + i)
                    .enterCountry("Country")
                    .clickSubmit();
            ExtentReportManager.log(Status.PASS, "Contact #" + i + " added successfully");
        }

//        Assert.assertEquals(contactListPage.getContactsCount(), 5, " Not all contacts added!");
    }


}