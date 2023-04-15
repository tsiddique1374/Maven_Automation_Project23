package Day9_032523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class T3_ExplicitWait {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.ups.com/us/en/Home.page");

        //declare the explicit wait command
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //click on shipping
        //your explicit wait condition replaces your driver.findElement(s)
        //presenceOfAllElementsLocatedBy is the same as findElements
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='mainNavDropdown1']"))).click();

        //click on Schedule a Pickup
        //when you see an element that can't be interacted with exception, then you have to use Thread.sleep for a few seconds before
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Schedule a Pickup']"))).click();

        //enter a tracking number on the box
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='tracknumlist']"))).sendKeys("123445555");

    }//end of main
}//end of class