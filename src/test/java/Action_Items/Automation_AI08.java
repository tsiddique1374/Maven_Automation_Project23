package Action_Items;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods;
import org.testng.annotations.Test;

public class Automation_AI08 extends ReusableAnnotations {

    @Test
    public static void captureSearchResults() throws InterruptedException {

        //navigate to fideliscare.org
        driver.navigate().to("https://www.fideliscare.org/");

        //click on search button
        ReusableMethods.clickMethod(driver, "//*[@class='tool dropdown search']", "Search Button");

        //send get dental coverage to the search box
        ReusableMethods.sendKeysMethod(driver, "//*[@class='form-control search-input']", "get dental coverage", "Search Field");

        //click on the search button
        ReusableMethods.clickMethod(driver, "//*[@class='btn btn-primary btn-search']", "Search Field Button");

        //capture text and store as array, split by space and print out result
        String dentalResults = ReusableMethods.captureTextMethod(driver, "//*[@class='gsc-result-info']", "Search Results");
        String[] arrayDentalResults = dentalResults.split(" ");
        System.out.println("Search Number: " + arrayDentalResults[1]);

        //click on Get Dental Coverage
        ReusableMethods.clickMethod(driver, "//b[contains(text(),'Get Dental Coverage')]", "Dental Coverage Link");

        Thread.sleep(2000);
    }//end of test 1

    @Test(priority = 2)
    public static void enterPersonalInfo() throws InterruptedException {

        //switch to second browser tab
        ReusableMethods.switchToTabByIndex(driver, 1, "Browser Tab");

        //Enter personal details using sendKeys and selectByText
        ReusableMethods.sendKeysMethod(driver, "//*[@id='firstName']", "John", "First Name Text Box");
        ReusableMethods.sendKeysMethod(driver, "//*[@id='lastName']", "Doe", "Last Name Text Box");
        ReusableMethods.sendKeysMethod(driver, "//*[@id='zipCode']", "11218", "ZipCode Text Box");
        ReusableMethods.selectByText(driver, "//*[@id='county']","Kings","County Select Dropdown");
        ReusableMethods.sendKeysMethod(driver,"//*[@id='phoneNumber']","7189299292","Phone Number Text Box");
        ReusableMethods.sendKeysMethod(driver,"//*[@id='email']","johndoe123123@gmail.com","Email Text Box");

        //click on Contact Me checkbox using index of 1
        ReusableMethods.clickMethodByIndex(driver,"//*[@for='contactMe']",1,"Contact Me Checkbox");

        //click on Contact Me button
        ReusableMethods.clickMethod(driver,"//*[@type='submit']","Contact Me Button");
        Thread.sleep(1000);

        //capturing text and printing out the result
        String thankYou = ReusableMethods.captureTextMethod(driver, "//*[@class='alert alert-success']", "Submission Text");
        System.out.println(thankYou);

        //closing current tab
        driver.close();
        Thread.sleep(2000);
    }//end of test 2

    @Test(priority = 3)
    public static void fidelisLogin() throws InterruptedException {

        //switching to first browser tab
        ReusableMethods.switchToTabByIndex(driver,0,"Browser Tab");

        //clicking on login button
        ReusableMethods.clickMethod(driver,"//*[@class='dropdown-toggle']","Login Button");
        Thread.sleep(2000);

        //clicking on Member Online Portal link
        ReusableMethods.clickMethod(driver,"//h4[@class='link-external']","Member Online Portal Link");

        //switching to second browser tab
        ReusableMethods.switchToTabByIndex(driver, 1, "Browser Tab");

        //capturing helpful hints and printing out the result
        String helpfulHints = ReusableMethods.captureTextMethod(driver, "//*[@id='TipsPanel']", "Helpful Hints");
        System.out.println(helpfulHints);

        //closing current tab
        driver.close();
    }//end of test 3
}//end of class