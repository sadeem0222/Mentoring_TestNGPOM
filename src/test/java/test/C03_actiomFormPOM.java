package test;

import org.testng.annotations.Test;
import pages.ActionClassPage;
import pages.ActionFormPage;
import utilities.Driver;

public class C03_actiomFormPOM {

    @Test
    void actionformtetst(){
        Driver.getDriver().get("https://claruswaysda.github.io/ActionsForm.html");

        ActionFormPage form =new ActionFormPage();
        form.entername("sadeem")
                .enterage("22")
                .selectCheckbox("coding")
                .selectRadio("female")
                .clickOnBUTTON().handleJSAlertPasscode()
                .clickSubmit();

//        Do all actions and assert
        Driver.getDriver().get("https://claruswaysda.github.io/actionsClickDrag.html");

        ActionClassPage actionsPage = new ActionClassPage();
        actionsPage.dragAndDrop();

        actionsPage.clickShowSuccess();

        actionsPage.doubleClick();

        actionsPage.hoverOverButton();



        Driver.closeDriver();
    }
}
