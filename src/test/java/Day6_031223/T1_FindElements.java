package Day6_031223;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_FindElements {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito","headless");
        WebDriver driver = new ChromeDriver(options);

        //navigate to mclcalc.com
        driver.navigate().to("https://www.mlcalc.com");

        Thread.sleep(2000);

        //clear the auto-populated data from the purchase price and input 250000
        driver.findElement(By.xpath("//*[@name='ma']")).clear();
        driver.findElement(By.xpath("//*[@name='ma']")).sendKeys("250000");

        //click on calculate
        driver.findElement(By.xpath("//*[@value='Calculate']")).click();

        Thread.sleep(2000);

        //capture the monthly payment using findElements with an index of 0
        String result = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();
        System.out.println("Monthly Payment: " + result);

        //capture the total 360 payment using findElements with an index of 1
        String result2 = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(1).getText();
        System.out.println("Total 360 Payment: " + result2);


        Thread.sleep(1000);
        driver.close();
    }//end of main
}//end of class
