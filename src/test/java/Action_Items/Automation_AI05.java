package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Automation_AI05 {
    public static void main(String[] args) throws InterruptedException {

        //Creating the WebDriver for chrome and setting up the ChromeOptions
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);

        Thread.sleep(1000);

        //creating an arraylist of zipcodes
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11226");
        zipCodes.add("11218");
        zipCodes.add("11224");

        //beginning a for loop statement
        for (int i = 0; i < zipCodes.size(); i++) {
            //navigating to weightwatchers website
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            //clicking the Find a Workshop button on the top right
            driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();

            Thread.sleep(1000);

            //clicking In-Person
            driver.findElement(By.xpath("//*[text()='In-Person']")).click();

            Thread.sleep(1000);

            //Storing the search box as a WebElement variable using findElement
            WebElement zipCodeLocator = driver.findElement(By.xpath("//*[@title='location-search']"));

            Thread.sleep(1000);

            //using the WebElement variable to clear the box and send the zipcodes from the arraylist
            zipCodeLocator.clear();
            zipCodeLocator.sendKeys(zipCodes.get(i));

            Thread.sleep(1000);

            //clicking on the search arrow button
            driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();

            Thread.sleep(3000);

            //storing the links as a WebElement variable using findElements
            ArrayList<WebElement> studio = new ArrayList<>(driver.findElements(By.xpath("//*[contains(text(),'WW Studio')]")));

            //using an if,else if conditional statement to click on the corresponding link
            if (i == 0) {
                studio.get(1).click();
            } else if (i == 1) {
                studio.get(2).click();
            } else if (i == 2) {
                studio.get(0).click();
            }

            //retrieving the address and splitting it so only the address is printed out
            String addressAndInfo = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
            String[] address = addressAndInfo.split("In-Person");
            System.out.println(("The studio address is " + address[0]));

            Thread.sleep(1000);

            //using JavascriptExecutor to scroll down to the workshop schedule
            WebElement workshopSchedule = driver.findElement(By.xpath("//*[@class='title-bEfSM']"));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true)", workshopSchedule);
            String schedule = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).get(0).getText();

            System.out.println("Schedule is " + schedule);

            Thread.sleep(2000);
        }//end of for loop
        driver.close();
    }//end of main
}//end of class