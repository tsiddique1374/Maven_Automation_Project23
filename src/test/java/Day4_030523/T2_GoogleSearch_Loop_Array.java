package Day4_030523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T2_GoogleSearch_Loop_Array {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //setup the ArrayList of cars
        ArrayList<String>cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Mercedes");

        //iterate through the list of cars and print out the search number for each car
        for (int i=0; i<cars.size(); i++){
            driver.manage().window().maximize();
            driver.navigate().to("https://www.google.com");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cars.get(i));
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            Thread.sleep(1000);
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            String[] arrayResult = result.split(" ");
            System.out.println("For " + cars.get(i) + " the search number is " + arrayResult[1]);

        }//end of loop

        Thread.sleep(2000);
        driver.close();

    }//end of main
}//end of class
