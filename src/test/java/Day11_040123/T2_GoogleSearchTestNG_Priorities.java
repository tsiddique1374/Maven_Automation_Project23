package Day11_040123;

import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_GoogleSearchTestNG_Priorities {
    WebDriver driver;

    //creating a Test with priority 1
    @Test(priority = 1)
    public void searchForBmw() {
        //navigate to google home
        driver.navigate().to("https://www.google.com");
        //enter bmw on search field
        ReusableMethods.sendKeysMethod(driver, "//*[@name='q']", "BMW", "Search Field");
        //submit google search
        ReusableMethods.submitMethod(driver, "//*[@name='btnK']", "Google Search");
    }//end of test 1

    //creating a Test with priority 2
    @Test(priority = 2)
            public void captureSearchNumberForBMW(){
        //capture the text and print out the number
        String result = ReusableMethods.captureTextMethod(driver, "//*[@id='result-stats']", "Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("Search number for BMW: " + arrayResult[1]);
    }//end of test 2

    //creating a Test with priority 3
    @Test(priority = 3)
    public void clickOnFinance() {
        ReusableMethods.clickMethod(driver," //div[text()='Finance']","Finance");
    }//end of test 3

    @BeforeSuite
    public void setUpDriver() {
        driver = ReusableMethods.defineChromeDriver();
    }

    @AfterSuite
    public void quitSession() {
        driver.quit();
    }

}//end of class