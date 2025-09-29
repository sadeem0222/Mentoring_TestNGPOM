package test.smoke_test;

import org.testng.annotations.Test;
import pages.AddRecocredPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_AddRecoredFluentPOM {


    @Test
    void AddRecoredFluentPOMtest(){
        Driver.getDriver().get("https://claruswaysda.github.io/addRecordWebTable.html");

        AddRecocredPage record = new AddRecocredPage();

        List<String> names = new ArrayList<>(Arrays.asList("dd","fr","fe","ww","kk"));
        List<String> ages = new ArrayList<>(Arrays.asList("22","11","22","33","77"));
        List<String> contreies = new ArrayList<>(Arrays.asList("USA","Germany","Australia","Canada","Canada"));

        for (int i = 0; i < names.size(); i++){
            record.entername(names.get(i));
            record.enterage(ages.get(i));
            record.selecetCountry(contreies.get(i));
            record.clickOnAddrecored();

        }

        record
                .deleteRecored(names.getFirst())
                .assertTablenotContainsText(names.getFirst());


        Driver.closeDriver();
    }
}
