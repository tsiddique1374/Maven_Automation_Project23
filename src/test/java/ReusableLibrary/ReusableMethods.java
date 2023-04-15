package ReusableLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReusableMethods {

    //create a return method to return the WebDriver you are going to use on your test classes
    //static command allows your method to be global
    public static WebDriver defineChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);

        return driver;  //return method will execute your statements along with returning some condition/value. example of return methods are WebDriver method and getText action
    }//end of WebDriver ReusableMethod


    //void method will only perform the action but won't return anything. void actions are click, sendKeys, scrolling, submit, select, mouse hover, clear


    //clickMethod ReusableMethod
    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + ": " + e);
        }//end of clickMethod exception
    }//end of clickMethod ReusableMethod


    //clickByMethodIndex ReusableMethod
    public static void clickMethodByIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
        }
    }//end of clickMethodByIndex ReusableMethod


    //sendKeysMethod ReusableMethod
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on " + elementName + ": " + e);
        }//end of sendKeys exception
    }//end of sendKeys ReusableMethod


    //sendKeysByIndex ReusableMethod
    public static void sendKeysMethodByIndex(WebDriver driver, String xpath, String userValue, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on " + elementName + ": " + e);
        }//end of sendKeys exception
    }//end of sendKeysByIndex ReusableMethod


    //captureTextMethod ReusableMethod
    public static String captureTextMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured a text from " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text from " + elementName + ": " + e);
        }//end of captureTextMethod exception
        return result;
    }//end of captureTextMethod ReusableMethod


    //selectByText ReusableMethod
    public static void selectByText(WebDriver driver, String xpath, String visibleText, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(visibleText);
            System.out.println("Successfully selected " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select " + elementName + ": " + e);
        }//end of selectByText exception
    }//end of selectByText ReusableMethod


    //scrollByElement ReusableMethod
    public static void scrollByElement(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true)", element);
            System.out.println("Successfully scrolled into " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll into " + elementName + ": " + e);
        }//end of scrollByElement exception
    }//end of scrollByElement ReusableMethod


    //mouseHover ReusableMethod
    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        Actions mouseAction = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(element).perform();
            System.out.println("Successfully moved mouse to " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to move mouse to " + elementName + ": " + e);
        }//end of mouseHover exception
    }//end of mouseHover ReusableMethod


    //submitMethod ReusableMethod
    public static void submitMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully clicked on  " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + ": " + e);
        }//end of submitMethod exception
    }//end of submitMethod ReusableMethod


    //verifyBooleanStatement ReusableMethod
    public static void verifyBooleanStatement(WebDriver driver, String xpath, boolean expectedValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            System.out.println("Value: " + elementState);
            if (elementState == true) {
                System.out.println("Passed: Checkbox is " + expectedValue);
            } else {
                System.out.println("Failed: Checkbox is " + elementState);
            }
        } catch (Exception e) {
            System.out.println("Unable to verify element " + elementName + e);
        }//end of exception
    }//end of verifyBooleanStatement


    //switchToTabByIndex Reusable Method
    public static void switchToTabByIndex(WebDriver driver, Integer windowTab, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(windowTab));
            System.out.println("Successfully switched tab to " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to switch tab to " + elementName + ": " + e);
        }//end of switchToTabByIndex exception
    }//end of switchToTabByIndex ReusableMethod


    //scrollByPixel ReusableMethod
    public static void scrollByPixel(WebDriver driver, Integer scrollPixelsX, Integer scrollPixelsY) {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(scrollPixelsX,scrollPixelsY");
            System.out.println("Successfully scrolled by " + scrollPixelsX + "and " + scrollPixelsY);
        } catch (Exception e) {
            System.out.println("Unable to scroll" + e);
        }//end of scrollByPixel exception
    }//end of scrollByPixel ReusableMethod

}//end of class