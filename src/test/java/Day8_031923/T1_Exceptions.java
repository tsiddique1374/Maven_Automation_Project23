package Day8_031923;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Exceptions {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mortgagecalculator.org");

        Thread.sleep(2000);

        //using try catch for each element to handle your errors
        //clear and enter home value
        try{
            WebElement homeVal = driver.findElement(By.xpath("//*[@name='param[homevalue]']"));
            homeVal.clear();
            homeVal.sendKeys("350000");
            System.out.println("Successfully entered home value on the field");
        } catch (Exception e) {
            System.out.println("Unable to enter a value on Home value field " + e);
        }//end of exception for home value

        //clear and enter an interest rate
        try{
            WebElement interestRate = driver.findElement(By.xpath("//*[@name='param[interest_rate]']"));
            interestRate.clear();
            interestRate.sendKeys("2.5");
            System.out.println("Successfully entered interest rate on the field");
        } catch (Exception e) {
            System.out.println("Unable to enter a value on Interest Rate field " + e);
        }//end of exception for interest rate

        //select start month
        try{
            WebElement strMonth = driver.findElement(By.xpath("//*[name='param[start_month]']"));
            Select dropDown = new Select(strMonth);
            dropDown.selectByVisibleText("Apr");
            System.out.println("Successfully selected month from the dropdown");
        } catch (Exception e) {
            System.out.println("Unable to select a value on the Month dropdown " + e);
        }//end of exception for interest rate

    }//end of main
}//end of class
