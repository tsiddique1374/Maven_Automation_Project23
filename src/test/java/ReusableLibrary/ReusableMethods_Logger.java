package ReusableLibrary;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class ReusableMethods_Logger {

    public static WebDriver defineChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);

        return driver;  //return method will execute your statements along with returning some condition/value. example of return methods are WebDriver method and getText action
    }//end of WebDriver ReusableMethod


    //clickMethod ReusableMethod
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            System.out.println("Successfully clicked on " + elementName);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName + ": " + e);
            getScreenshot(driver, elementName, logger);
        }//end of clickMethod exception
    }//end of clickMethod ReusableMethod


    //clickByMethodIndex ReusableMethod
    public static void clickMethodByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            System.out.println("Successfully clicked on element " + elementName);
            logger.log(LogStatus.PASS, "Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName + ": " + e);
            getScreenshot(driver, elementName, logger);
        }
    }//end of clickMethodByIndex ReusableMethod


    //sendKeysMethod ReusableMethod
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on " + elementName);
            logger.log(LogStatus.PASS, "Successfully entered a value on" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to enter a value on " + elementName + ": " + e);
            getScreenshot(driver, elementName, logger);
        }//end of sendKeys exception
    }//end of sendKeys ReusableMethod


    //sendKeysByIndex ReusableMethod
    public static void sendKeysMethodByIndex(WebDriver driver, String xpath, String userValue, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            element.clear();
            element.sendKeys(userValue);
            System.out.println("Successfully entered a value on " + elementName);
            logger.log(LogStatus.PASS, "Successfully entered a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to enter a value on " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to enter a value on " + elementName + ": " + e);
            getScreenshot(driver, elementName, logger);
        }//end of sendKeys exception
    }//end of sendKeysByIndex ReusableMethod


    //captureTextMethod ReusableMethod
    public static String captureTextMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            System.out.println("Successfully captured a text from " + elementName);
            logger.log(LogStatus.PASS, "Successfully captured a text from " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text from " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to capture text from " + elementName + ": " + e);
            getScreenshot(driver, elementName, logger);
        }//end of captureTextMethod exception
        return result;
    }//end of captureTextMethod ReusableMethod


    //selectByText ReusableMethod
    public static void selectByText(WebDriver driver, String xpath, String visibleText, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropDown = new Select(element);
            dropDown.selectByVisibleText(visibleText);
            System.out.println("Successfully selected " + elementName);
            logger.log(LogStatus.PASS, "Successfully selected " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to select " + elementName + ": " + e);
            getScreenshot(driver, elementName, logger);
        }//end of selectByText exception
    }//end of selectByText ReusableMethod


    //scrollByElement ReusableMethod
    public static void scrollByElement(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView(true)", element);
            System.out.println("Successfully scrolled into " + elementName);
            logger.log(LogStatus.PASS, "Successfully scrolled into " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll into " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to scroll into " + elementName + ": " + e);
            getScreenshot(driver, elementName, logger);
        }//end of scrollByElement exception
    }//end of scrollByElement ReusableMethod


    //mouseHover ReusableMethod
    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        Actions mouseAction = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseAction.moveToElement(element).perform();
            System.out.println("Successfully moved mouse to " + elementName);
            logger.log(LogStatus.PASS, "Successfully moved mouse to " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to move mouse to " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to move mouse to " + elementName + ": " + e);
            getScreenshot(driver, elementName, logger);
        }//end of mouseHover exception
    }//end of mouseHover ReusableMethod


    //submitMethod ReusableMethod
    public static void submitMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            System.out.println("Successfully clicked on  " + elementName);
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName + ": " + e);
            getScreenshot(driver, elementName, logger);
        }//end of submitMethod exception
    }//end of submitMethod ReusableMethod


    //verifyBooleanStatement ReusableMethod
    public static void verifyBooleanStatement(WebDriver driver, String xpath, boolean expectedValue, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isSelected();
            System.out.println("Value: " + elementState);
            if (elementState) {
                System.out.println("Passed: Checkbox is " + expectedValue);
                logger.log(LogStatus.PASS, "Passed: Checkbox is " + expectedValue);
            } else {
                System.out.println("Failed: Checkbox is " + elementState);
                logger.log(LogStatus.FAIL, "Failed: Checkbox is " + elementState);
                getScreenshot(driver, elementName, logger);
            }
        } catch (Exception e) {
            System.out.println("Unable to verify element " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to verify element " + elementName + ": " + e);
            getScreenshot(driver, elementName, logger);
        }//end of exception
    }//end of verifyBooleanStatement


    //switchToTabByIndex Reusable Method
    public static void switchToTabByIndex(WebDriver driver, Integer windowTab, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(windowTab));
            System.out.println("Successfully switched tab to " + elementName);
            logger.log(LogStatus.PASS, "Successfully switched tab to " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to switch tab to " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to switch tab to " + elementName + ": " + e);
            getScreenshot(driver, elementName, logger);
        }//end of switchToTabByIndex exception
    }//end of switchToTabByIndex ReusableMethod


    //scrollByPixel ReusableMethod
    public static void scrollByPixel(WebDriver driver, Integer scrollPixelsX, Integer scrollPixelsY, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 7);
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(scrollPixelsX,scrollPixelsY");
            System.out.println("Successfully scrolled by " + scrollPixelsX + "and " + scrollPixelsY);
            logger.log(LogStatus.PASS, "Successfully scrolled by " + scrollPixelsX + "and " + scrollPixelsY);
        } catch (Exception e) {
            System.out.println("Unable to scroll" + e);
            logger.log(LogStatus.FAIL, "Unable to scroll " + e);
            getScreenshot(driver, elementName, logger);
        }//end of scrollByPixel exception
    }//end of scrollByPixel ReusableMethod

    //method to capture screenshot when logger fails
    public static void getScreenshot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.PASS, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error occurred while taking SCREENSHOT!! " + e);
        }
    }

}//end of class