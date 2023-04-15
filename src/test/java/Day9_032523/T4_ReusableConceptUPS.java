package Day9_032523;

import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T4_ReusableConceptUPS {
    public static void main(String[] args) throws InterruptedException {

        //on your test classes you still need to declare the WebDriver command you want to use
        WebDriver driver = ReusableMethods.defineChromeDriver();

        driver.navigate().to("https://www.ups.com/us/en/Home.page");

        //declare the explicit wait command
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //using ReusableMethods to click on Shipping
        ReusableMethods.clickMethod(driver,"//*[@id='mainNavDropdown1']","Shipping Link");

        //Using ReusableMethods to click on Schedule a Pickup
        Thread.sleep(2000);
        ReusableMethods.clickMethod(driver,"//*[text()='Schedule a Pickup']","Schedule a Pickup");

        //click on Freight
        ReusableMethods.clickMethod(driver,"//*[text()='Freight']", "Freight");

    }//end of main
}//end of class