package Day6_031223;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_ScrollIntoView {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2000);

        //scroll into the calculate button and set that as the initial point of the page
        WebElement calculate = driver.findElement(By.xpath("//*[@value='Calculate']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",calculate);

    }//end of main
}//end of class
