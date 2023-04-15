package Day6_031223;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_WebElement {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito","headless");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mlcalc.com");

        Thread.sleep(2000);

        //creating a WebElement variable for the xpath
        WebElement pPrice =  driver.findElement(By.xpath("//*[@name='ma']"));

        //using the WebElement variable to click and send 250000
        pPrice.clear();
        pPrice.sendKeys("250000");

        driver.findElement(By.xpath("//*[@value='Calculate']")).click();

        Thread.sleep(2000);

        //if you want to use FindElements as a WebElement variable, you need to store it as an ArrayList
        //capture the monthly payment and total 360
        ArrayList<WebElement> paymentList = new ArrayList<>(driver.findElements(By.xpath("//*[@style='font-size: 32px']")));

       //print monthly payment
        System.out.println("Monthly Payment: " + paymentList.get(0).getText());
        //print total 360 payment
        System.out.println("Monthly Payment: " + paymentList.get(1).getText());

    }//end of main
}//end of class
