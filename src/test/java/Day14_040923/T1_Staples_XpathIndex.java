package Day14_040923;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods_Logger;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T1_Staples_XpathIndex extends ReusableAnnotations {

    @Test(priority = 1)
    public void searchForCricket() throws InterruptedException {
        logger.log(LogStatus.INFO, "Navigate to Staples home page");
        driver.navigate().to("https://www.staples.com");

        ReusableMethods_Logger.sendKeysMethod(driver, "//*[@id='searchInput']", "iphone", logger, "Search Field");

        ReusableMethods_Logger.clickMethod(driver, "//*[@class='search-bar-input__searchIcon']", logger, "Search Icon");

        Thread.sleep(4000);

        //clicking on third image using xpath by index
        ReusableMethods_Logger.clickMethod(driver, "(//*[@class='standard-tile__image standard-tile__image_hover'])[3]", logger, "Iphone Image");

        Thread.sleep(2000);

    }//end of test
}//end of class