package Day14_040923;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class test{
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.amazon.com");

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Microphone");

        driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();

        Thread.sleep(1000);

        String searchResult = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

        System.out.println("Saerch result is : " + searchResult);

        driver.quit();

    }
}
