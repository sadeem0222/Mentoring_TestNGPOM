package task;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddRecordPage;
import utilities.Driver;

public class DynamicWebTableManagement {




        @DataProvider(name = "recordsData")
        public Object[][] getRecords() {
            return new Object[][]{
                    {"Ali", "25", "USA"},
                    {"Sara", "30", "Germany"},
                    {"Omar", "28", "Canada"},
                    {"Lina", "22", "Australia"},
                    {"Mona", "35", "UK"}
            };
        }

        @Test(dataProvider = "recordsData")
        public void addRecordTest(String name, String age, String country) {
            Driver.getDriver().get("https://claruswaysda.github.io/addRecordWebTable.html");

            AddRecordPage page = new AddRecordPage();

            page.entername(name);
            page.enterage(age);
            page.selecetCountry(country);
            page.clickOnAddrecored();
              Assert.assertTrue(Driver.getDriver().getPageSource().contains(name));
        }
    }


