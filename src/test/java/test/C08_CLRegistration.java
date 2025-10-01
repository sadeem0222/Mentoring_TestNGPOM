package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CLContactListPage1;
import pages.CLRegistertionPage;
import utilities.Driver;

public class C08_CLRegistration {

    @Test
    void HappyPathTest() {
        CLRegistertionPage login = new CLRegistertionPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        login.firstName("sadeem")
                .lastNamee("abdulaziz")
                .email("sadeem@gmail.com")
                .pass("sadeem1234").click().assertSubmit();
    }

    @Test
    void EmptyfirstNameTest() {
        CLRegistertionPage login = new CLRegistertionPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");

        login.firstName("")
                .lastNamee("abdulaziz")
                .email("sadeem@gmail.com")
                .pass("sadeem1234").click().assertErrorMessage(" `firstName` is required.");


    }

    @Test
    void EmptylastNameTest() {
        CLRegistertionPage login = new CLRegistertionPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");

        login.firstName("sadeem")
                .lastNamee("")
                .email("sadeem@gmail.com")
                .pass("sadeem1234").click().assertErrorMessage("lastName` is required.");


    }

    @Test
    void MaximumlengthLastNameTest() {
        CLRegistertionPage login = new CLRegistertionPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");

        login.firstName("sadeem")
                .lastNamee("abdulazizabdulazizabdulaziz")
                .email("sadeem@gmail.com")
                .pass("sadeem1234").click().assertErrorMessage("`lastName` is too long.");

    }

    @Test
    void InvalidemailTest() {
        CLRegistertionPage login = new CLRegistertionPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");

        login.firstName("sadeem")
                .lastNamee("abdulaziz")
                .email("sadeem")
                .pass("sadeem1234").click().assertErrorMessage(" email: Email is invalid.");


    }

    @Test
    void PasswordminimumlengthTest() {
        CLRegistertionPage login = new CLRegistertionPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");

        login.firstName("sadeem")
                .lastNamee("abdulaziz")
                .email("sadeem@gmail.com")
                .pass("sa").click().assertErrorMessage("`password` is shorter than the minimum allowed length.");

    }

    @Test
    void FirstnamewithspicialcharacaterTest() {
        CLRegistertionPage login = new CLRegistertionPage();
        Driver.getDriver().get("https://thinking-tester-contact-list.herokuapp.com/addUser");

        login.firstName("-")
                .lastNamee("abdulaziz")
                .email("sadeem@gmail.com")
                .pass("sadeem1234").click().assertErrorMessage("`firstName` is invalid.");

    }

}
