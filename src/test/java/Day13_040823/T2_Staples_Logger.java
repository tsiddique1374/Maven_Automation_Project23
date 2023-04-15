package Day13_040823;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T2_Staples_Logger extends ReusableAnnotations {

    @Test(priority = 1)
    public void searchForCricket(){
        logger.log(LogStatus.INFO,"Navigate to Staples home page");
        driver.navigate().to("https://www.staples.com");

        ReusableMethods_Logger.sendKeysMethod(driver,"//*[@id='searchInput']","iphone",logger,"Search Field");
        ReusableMethods_Logger.clickMethod(driver,"//*[@class='search-bar-input__searchIcon']",logger,"Search Icon");
    }//end of test 1

    @Test(priority = 2)
    public void printOutSearchNumber() throws InterruptedException {

        ReusableMethods_Logger.clickMethodByIndex(driver,"//*[@class='standard-tile__image standard-tile__image_hover']",0,logger,"Iphone Image");
        ReusableMethods_Logger.clickMethodByIndex(driver,"//*[id='ctaButton']",0,logger,"Add to cart");

        Thread.sleep(3000);

        String result = ReusableMethods_Logger.captureTextMethod(driver,"//*[contains(text(),'starting at')]",logger,"Starting Price");
        System.out.println("Iphone result is " + result);
        logger.log(LogStatus.INFO,"Iphone result is " + result);
    }//end of test 2
}//end of class