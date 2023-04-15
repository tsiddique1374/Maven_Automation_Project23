package ReusableLibrary;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class ReusableAnnotations {

    //you need to make your WebDriver driver variable static since we are calling it to our test class
    public static WebDriver driver;

    //declare the report variable
    public static ExtentReports reports;
    //declare the logger variable
    public static ExtentTest logger;


    //set before suite annotation method
    @BeforeSuite
    public void setDriver(){
        driver = ReusableMethods.defineChromeDriver();
        //set the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/automationReport.html",true);
    }//end of before suite

    //call before method annotation to capture each test name dynamically
    @BeforeMethod
    public void getTestName(Method methodName){
        //get a name of the test
        logger = reports.startTest(methodName.getName());
    }//end of before method

    @AfterSuite
    public void postCondition(){
        //quit the driver
        driver.quit();

        //end all loggers
        reports.endTest(logger);

        //write all the logs back to the html report including each test name
        reports.flush();
    }//end of after suite

}
