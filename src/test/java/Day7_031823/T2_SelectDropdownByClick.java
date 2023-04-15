package Day7_031823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_SelectDropdownByClick {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mortgagecalculator.org");

        Thread.sleep(1000);

        //select start month as April from the dropdown using select function
        //if the dropdown ius not under the select tag, then click on the dropdown first
        driver.findElement(By.xpath("//*[@name='param[start_month]']")).click();

        //click on the dropdown value by using xpath text
        driver.findElement(By.xpath("//*[text()='Apr']")).click();

        //click on an empty area to close the dropdown
        driver.findElement(By.xpath("//*[@class='content-area']")).click();

        Thread.sleep(1000);
        driver.close();
    }
}
