package Day7_031823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_SelectStatement {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mortgagecalculator.org");

        Thread.sleep(1000);

        //select start month as April from the dropdown using the Select function
        //store the start month locator as a WebElement
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));

        //call Select function to store the dropdown locator
        Select startMonthDropdown = new Select(startMonth);

        //select by visible text (BEST METHOD)
        startMonthDropdown.selectByVisibleText("Apr");

        //select by value
        //startMonthDropdown.selectByValue("4");

        //select by index
        //startMonthDropdown.selectByIndex(3);




        Thread.sleep(1500);
        driver.close();
    }//end of main
}//end of class
