package test.smoke_test;


import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CLAddUserPage;
import pages.CLCOntactPage;
import pages.CLCOntactlistPage;
import pages.CLHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_ContactList {

    /*
    Target: https://thinking-tester-contact-list.herokuapp.com/
    Test Scenario:
    1. Navigate to the application
    2. Create a new user account
    3. Login with the created user
    4. Add 5 different contacts
    5. Assert that all contacts are properly added and displayed
     */

    @Test
    void contactListTest(){
        CLHomePage hp=new CLHomePage();
        CLAddUserPage add=new CLAddUserPage();
        CLCOntactlistPage contatctlist=new CLCOntactlistPage();
        CLCOntactPage contact=new CLCOntactPage();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        hp.signup.click();
        add.firstname.sendKeys(Faker.instance().name().firstName());
        add.lastname.sendKeys(Faker.instance().name().lastName());
        add.email.sendKeys(Faker.instance().internet().emailAddress());
        add.password.sendKeys(Faker.instance().internet().password());
        add.submit.click();

        for(int i=0;i< 5;i++) {
            contatctlist.addContact.click();
            contact.firstName.sendKeys(Faker.instance().name().firstName());
            contact.lastName.sendKeys(Faker.instance().name().lastName());
            contact.submit.click();
        }


        Assert.assertEquals(contatctlist.contactRows.size(), 5);





        Driver.closeDriver();



    }
}