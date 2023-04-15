package Action_Items;

import ReusableLibrary.ReusableMethods;
import org.openqa.selenium.WebDriver;

public class Automation_AI07 {
    public static void main(String[] args) throws InterruptedException {
        //setting up chrome driver
        WebDriver driver = ReusableMethods.defineChromeDriver();

        //navigating to bestbuy
        driver.navigate().to("https://www.bestbuy.com/");

        //entering iphone into search field
        ReusableMethods.sendKeysMethod(driver, "//*[@id='gh-search-input']", "iPhone", "Search Field");

        //clicking on search button
        ReusableMethods.clickMethod(driver, "//*[@class='header-search-button']", "Search Button");

        //sorting dropdown by Best Selling using selectByText
        ReusableMethods.selectByText(driver, "//*[@class='tb-select']", "Best Selling", "Best Selling");

        Thread.sleep(1000);

        //clicking on first image by index
        ReusableMethods.clickMethodByIndex(driver, "//*[@class='product-image ']", 0, "iPhone Image");

        //scrolling to Learn About TotalTech
        ReusableMethods.scrollByElement(driver, "//*[@class='c-button c-button-outline c-button-md c-button-block v-m-top-xs']", "Total Tech");

        //clicking on Add to Cart button
        ReusableMethods.clickMethod(driver, "//*[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button']", "Add to Cart");

        Thread.sleep(4000);

        //capturing and printing out the cart subtotal
        String cartTotal = ReusableMethods.captureTextMethod(driver, "//*[@class='sub-total v-fw-medium']", "Cart Subtotal");
        System.out.println("Cart subtotal is " + cartTotal);

        //hover mouse to Continue Shopping
        ReusableMethods.mouseHover(driver, "//*[@class='c-button-link continue-shopping']", "Continue Shopping");

        //clicking on Continue Shopping
        ReusableMethods.clickMethod(driver, "//*[@class='c-button-link continue-shopping']", "Continue Shopping");

    }//end of main
}//end of class