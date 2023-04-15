package Day4_030523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_GoogleHome {

    public static void main(String[] args) throws InterruptedException {

        //setup your driver through web driver manager
        WebDriverManager.chromedriver().setup();

        //define the chrome driver that you will use for testing
        WebDriver driver = new ChromeDriver();

        //maximizing Chrome browser
        driver.manage().window().maximize();  //for windows
        //driver.manage().window().fullscreen(); for mac

        //navigate to google home
        driver.navigate().to("https://www.google.com");

        //waiting for 2 seconds
        Thread.sleep(2000);

        //enter keyword bmw to search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("BMW");

        //waiting for 1 second
        Thread.sleep(1000);

        //click on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //waiting for 1 second
        Thread.sleep(1000);

        //capture the search results using .getText()
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //System.out.println("Search results: " + result);

        //print out only the number
        String[] arrayResult = result.split(" ");
        System.out.println("Search Number: " + arrayResult[1]);

        //close
        //driver.close();

    }//end of main
}//end of class
