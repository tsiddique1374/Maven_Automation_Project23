package Day5_031123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T3_ChromeOptions {
    public static void main(String[] args) throws InterruptedException {

        //set up your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //set your chrome options arguments for your web driver
        ChromeOptions options = new ChromeOptions();

        //add maximize for windows
        options.addArguments("start-maximized");
        //add --kiosk for mac/windows
        //options.addArguments("--kiosk");

        //add incognito mode to options
        options.addArguments("incognito");

        // add options to run your driver in the background)headless
        options.addArguments("headless");

        //define the chrome driver that you will use for automation test
        //option variable must be passed inside ChromeDriver in order for your driver to recognize those conditions
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");

        Thread.sleep(1000);

        //click on mail link
        driver.findElement(By.xpath("//a[contains(text(),'Mail')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

        Thread.sleep(1000);

        //print out sign in to yahoo text
        String result = driver.findElement(By.xpath("//*[@class='challenge-heading']")).getText();
        System.out.println("result: " + result);


        driver.close();
    }//end of main
}//end of class
