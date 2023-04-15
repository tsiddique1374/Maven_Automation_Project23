package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Xpath_Text {
    public static void main(String[] args) throws InterruptedException {

        //setup driver for webdriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //navigate to google.com
        driver.navigate().to("https://www.google.com");

        Thread.sleep(2000);

        //click on About text link
        driver.findElement(By.xpath("//*[text()='About']")).click();

        Thread.sleep(2000);
        driver.close();

    }//end of main
}//end of class
