package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Automation_AI04 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();                                                        //importing and setting up drivers needed for Google Chrome
        WebDriver driver = new ChromeDriver();

        ArrayList<String> hobby = new ArrayList<>();                                                    //creating an arraylist for hobbies
        hobby.add("Cycling");                                                                           //hobbies being added are Cycling, Driving, Surfing and Book reading
        hobby.add("Driving");
        hobby.add("Surfing");
        hobby.add("Book reading");

        for (int i=0; i<hobby.size(); i++) {                                                            //creating a for loop
            driver.manage().window().maximize();                                                        //maximizing the browser
            driver.navigate().to("https://www.bing.com");                                            //navigating to bing.com
            Thread.sleep(1000);                                                                   //waiting for 1 second
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobby.get(i));         //entering the hobbies in the arraylist in order
            Thread.sleep(1000);                                                                   //waiting for 1 second
            driver.findElement(By.xpath("//*[@name='q']")).submit();                       //pressing enter because there is no search button to click
            Thread.sleep(1000);                                                                   //waiting for 1 second
            String result = driver.findElement(By.xpath("//*[@data-bm='4']")).getText();   //retrieving the search results text
            if (result.startsWith("About")) {
                result.replace("About","");
            }
            String[] arrayResult = result.split(" ");                                             //splitting the text above by spaces
            System.out.println("For " + hobby.get(i) + " the search number is " + arrayResult[0]);
      /*      if(arrayResult[0] == "About"){
                System.out.println("For " + hobby.get(i) + " the search number is " + arrayResult[1]);      //im not sure why but bing will randomly change the results to have "About"
            } else {                                                                                        //before the search result numbers. I tried to make an if else statement to try and
                System.out.println("For " + hobby.get(i) + " the search number is " + arrayResult[0]);      //pull the 2nd result but it isn't working as I intend.
            } */

        }//end of for loop

        Thread.sleep(2000);                                                                       //waiting for 2 seconds
        driver.close();                                                                                 //closing driver / closing browser

    }//end of main
}//end of class