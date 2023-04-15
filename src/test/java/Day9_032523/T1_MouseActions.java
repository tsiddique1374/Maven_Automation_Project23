package Day9_032523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.usps.com");

        Thread.sleep(2000);

        //declare and define the mouse action
        Actions mouseAction = new Actions(driver);

        //use mouseAction to hover cursor on send tab to open up submodule/functionalities
        try{
            WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
            mouseAction.moveToElement(sendTab).perform();
        } catch (Exception a) {
            System.out.println("Unable to hover to Send Tab "+ a);
        }//end of send tab exception

        //use mouseAction to click on Tracking using mouse click
        try{
            WebElement trackingLink = driver.findElements(By.xpath("//*[text()='Tracking']")).get(0);
            mouseAction.moveToElement(trackingLink).click().perform();
        } catch (Exception b) {
            System.out.println("Unable to click on Tracking link "+ b);
        }//end of click tracking exception

        //use mouseAction to click and type on tracking link
        try{
            WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
            mouseAction.moveToElement(trackingField).click().sendKeys("12345678").perform();
        } catch (Exception c) {
            System.out.println("Unable to type on Tracking Input "+ c);
        }//end of click and type exception

        driver.quit();

    }//end of main
}//end of class
