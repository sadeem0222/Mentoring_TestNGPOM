package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserRegistationPage;
import utilities.Driver;

public class C09_UserRegistration {
    //US01: As a new user I want to register for an account by providing my personal information.
    /*
    Go to https://claruswaysda.github.io/Registration.html
    Enter valid SSN
    ..... Task ....
     */
    @Test
    void happyPathTest(){
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        UserRegistationPage register = new UserRegistationPage();
        register.enterSSN("123-34-1234")
                .enterfirstname("soso")
                .enterlastname("dodo")
                .selectGender("female")
                .selectJob("developer")
                .uploadCV("C:/Users/USER/Downloads/21-User Stories and Acceptance Criteria - User Registration.pdf")
                .enterusername("sadeem")
                .enteremail("sad33@gmail.com")
                .enterpassword("FGwegj_7872")
                .clickRegister();

    }

    //US02: As a new user I want to register for an account by providing my personal information.
    /*
    Go to https://claruswaysda.github.io/Registration.html
    Enter invalid SSN
    ..... Task ....
     */
    @Test
    void invalidSSNTest(){
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        UserRegistationPage register = new UserRegistationPage();

        register.enterSSN("123")
                .enterfirstname("soso")
                .enterlastname("dodo")
                .selectGender("female")
                .selectJob("developer")
                .uploadCV("C:/Users/USER/Downloads/21-User Stories and Acceptance Criteria - User Registration.pdf")
                .enterusername("sadeem")
                .enteremail("sad33@gmail.com")
                .enterpassword("FGwegj_7872")
                .clickRegister()
                .assertValidationMessage("يُرجى مطابقة التنسيق المطلوب.","ssn");



    }

    //US03: As a new user I want to register for an account by providing my personal information.
    /*
    Go to https://claruswaysda.github.io/Registration.html
    Enter invalid fisrt name
    ..... Task ....
     */
    @Test
    void invalidFirstnameTest(){
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        UserRegistationPage register = new UserRegistationPage();

        register.enterSSN("123-34-1234")
                .enterfirstname("3")
                .enterlastname("dodo")
                .selectGender("female")
                .selectJob("developer")
                .uploadCV("C:/Users/USER/Downloads/21-User Stories and Acceptance Criteria - User Registration.pdf")
                .enterusername("sadeem")
                .enteremail("sad33@gmail.com")
                .enterpassword("FGwegj_7872")
                .clickRegister()
                .assertValidationMessage("يُرجى مطابقة التنسيق المطلوب.","firstname");




    }
    //US04: As a new user I want to register for an account by providing my personal information.
    /*
    Go to https://claruswaysda.github.io/Registration.html
    Enter empty fil cv
    ..... Task ....
     */
    @Test
    void emptyFileCVTest(){
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        UserRegistationPage register = new UserRegistationPage();

        register.enterSSN("123-34-1234")
                .enterfirstname("soso")
                .enterlastname("dodo")
                .selectGender("female")
                .selectJob("developer")
                .uploadCV("")
                .enterusername("sadeem")
                .enteremail("sad33@gmail.com")
                .enterpassword("FGwegj_7872")
                .clickRegister();



    }

    //US05: As a new user I want to register for an account by providing my personal information.
    /*
    Go to https://claruswaysda.github.io/Registration.html
    Enter weak password
    ..... Task ....
     */
    @Test
    void weakPasswordTest(){
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        UserRegistationPage register = new UserRegistationPage();

        register.enterSSN("123-34-1234")
                .enterfirstname("3")
                .enterlastname("dodo")
                .selectGender("female")
                .selectJob("developer")
                .uploadCV("C:/Users/USER/Downloads/21-User Stories and Acceptance Criteria - User Registration.pdf")
                .enterusername("sadeem")
                .enteremail("sad33@gmail.com")
                .enterpassword("FGweg")
                .clickRegister()
                .assertValidationMessage("يُرجى إطالة هذا النص بحيث يصبح عدد الأحرف ٨ على الأقلّ (عدد الأحرف الحالي هو ٥).","password");




    }

    //US05: As a new user I want to register for an account by providing my personal information.
    /*
    Go to https://claruswaysda.github.io/Registration.html
    Enter invalid email
    ..... Task ....
     */
    @Test
    void invalidEmailTest(){
        Driver.getDriver().get("https://claruswaysda.github.io/Registration.html");
        UserRegistationPage register = new UserRegistationPage();

        register.enterSSN("123-34-1234")
                .enterfirstname("3")
                .enterlastname("dodo")
                .selectGender("female")
                .selectJob("developer")
                .uploadCV("C:/Users/USER/Downloads/21-User Stories and Acceptance Criteria - User Registration.pdf")
                .enterusername("sadeem")
                .enteremail("sad33")
                .enterpassword("FGweg")
                .clickRegister()
                .assertValidationMessage("يُرجى مطابقة التنسيق المطلوب.","firstname");




    }
}
