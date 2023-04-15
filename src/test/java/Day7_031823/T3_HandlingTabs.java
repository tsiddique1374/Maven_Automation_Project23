package Day7_031823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_HandlingTabs {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.fideliscare.org");

        //click on shop for a plan
        driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();

        Thread.sleep(1000);

        //click on second shop for a plan
        driver.findElement(By.xpath("//*[text()='Shop for a Plan']")).click();

        Thread.sleep(2000);

        //click on find a doctor
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(0).click();

        //call the window handles in array list
        ArrayList<String>tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to the new tab by index of 1
        driver.switchTo().window(tabs.get(1));

        Thread.sleep(1000);
        
        //enter zipcode on the location field
       driver.findElement(By.xpath("//*[@id='searchLocation']")).sendKeys("11218");



        Thread.sleep(2000);
        driver.close();
    }
}
