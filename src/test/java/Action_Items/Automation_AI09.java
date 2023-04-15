package Action_Items;

import ReusableLibrary.ReusableAnnotations;
import ReusableLibrary.ReusableMethods_Logger;
import org.testng.annotations.Test;

public class Automation_AI09 extends ReusableAnnotations {

    //go to today's deals and take a screenshot
    @Test(priority = 1)
    public void screenshotTodaysDeals() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com");
        //click on Today's Deals tab
        ReusableMethods_Logger.clickMethod(driver, "//*[@data-csa-c-slot-id='nav_cs_7']", logger, "Today's Deals");
        Thread.sleep(1000);
        //scroll down to all deals
        ReusableMethods_Logger.scrollByElement(driver, "//*[@class='a-text-bold']", logger, "All Deals");
        //take a screenshot
        ReusableMethods_Logger.getScreenshot(driver, "Todays Deals", logger);
    }//end of test 1

//testdaesdawd
    //search for webcam, click on first image, and capture price
    @Test(priority = 2)
    public void captureWebcamPrice() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com");
        //search for webcam
        ReusableMethods_Logger.sendKeysMethod(driver, "//*[@id='twotabsearchtextbox']", "Webcam", logger, "Search Box");
        //click on search
        ReusableMethods_Logger.clickMethod(driver, "//*[@id='nav-search-submit-button']", logger, "Submit Button");
        Thread.sleep(2000);
        //click on first webcam image
        ReusableMethods_Logger.clickMethod(driver, "(//*[@class='s-image'])[3]", logger, "Webcam Image");
        Thread.sleep(2000);
        //capture price as a string variable, then print it out
        String camPrice = ReusableMethods_Logger.captureTextMethod(driver, "//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']", logger, "Price");
        System.out.println("The Webcam Price is: " + camPrice);
        //take a screenshot
        ReusableMethods_Logger.getScreenshot(driver, "Webcam Page", logger);
    }//end of test 2

    //select appliances, search microwave, select 2 from dropdown, and add to cart
    @Test(priority = 3)
    public void addToCartApplicationMicrowave() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com");
        //selecting Appliances from search categories
        ReusableMethods_Logger.selectByText(driver, "//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']", "Appliances", logger, "Category Dropdown Menu");
        //search for microwave
        ReusableMethods_Logger.sendKeysMethod(driver, "//*[@id='twotabsearchtextbox']", "microwave", logger, "Search Box");
        //click on search button
        ReusableMethods_Logger.clickMethod(driver, "//*[@id='nav-search-submit-button']", logger, "Submit Button");
        Thread.sleep(1000);
        //click on first microwave image
        ReusableMethods_Logger.clickMethod(driver, "(//*[@class='a-section aok-relative s-image-fixed-height'])[3]", logger, "Microwave Image");
        Thread.sleep(1000);
        //select 2 from add to cart dropdown
        ReusableMethods_Logger.selectByText(driver, "//*[@id='quantity']", "2", logger, "Quantity Dropdown");
        //click on add to cart
        ReusableMethods_Logger.clickMethod(driver, "//*[@id='add-to-cart-button']", logger, "Add to Cart Button");
        //take a screenshot
        ReusableMethods_Logger.getScreenshot(driver, "Microwave Add to Cart", logger);
    }//end of test 3

    //navigate to book best sellers and take a screenshot
    @Test(priority = 4)
    public void screenshotBookBestSellers() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com");
        //click on main category hamburger menu button
        ReusableMethods_Logger.clickMethod(driver, "//*[@data-csa-c-slot-id='HamburgerMenuDesktop']", logger, "Category Button");
        //click on best sellers
        ReusableMethods_Logger.clickMethod(driver, "//*[@class='hmenu-item']", logger, "Best Sellers");
        Thread.sleep(1000);
        //click on books from categories
        ReusableMethods_Logger.clickMethod(driver, "(//*[@class='_p13n-zg-nav-tree-all_style_zg-browse-item__1rdKf _p13n-zg-nav-tree-all_style_zg-browse-height-small__nleKL'])", logger, "Books");
        //scroll down to best sellers banner
        ReusableMethods_Logger.scrollByElement(driver, "//*[@id='zg_banner']", logger, "Best Sellers Banner");
        //take a screenshot
        ReusableMethods_Logger.getScreenshot(driver, "Best Selling Books", logger);
    }//end of test 4

    //navigate to prime packages and take a screenshot
    @Test(priority = 5)
    public void capturePrimePackages() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com");
        //hover mouse over Prime tab
        ReusableMethods_Logger.mouseHover(driver, "//*[@id='nav-link-amazonprime']", logger, "Prime Tab");
        //click on Try Prime button
        ReusableMethods_Logger.clickMethod(driver, "//*[@class='prime-button-try']", logger, "Try Prime Button");
        Thread.sleep(1000);
        //scroll down to the prime packages
        ReusableMethods_Logger.scrollByElement(driver, "//*[@id='prime-pricing-module-content']", logger, "Prime Packages");
        //take a screenshot
        ReusableMethods_Logger.getScreenshot(driver, "Prime Packages", logger);
    }//end of test 5

    //open main hamburger menu, scroll down to amazon outlets, click on premium brands, sort by newest arrivals and take a screenshot
    @Test(priority = 6)
    public void captureNewArrivalsPremiumBrand() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com");
        //click on main category hamburger menu button
        ReusableMethods_Logger.clickMethod(driver, "//*[@data-csa-c-slot-id='HamburgerMenuDesktop']", logger, "Category Button");
        Thread.sleep(1000);
        //scroll down to programs and features
        ReusableMethods_Logger.scrollByElement(driver, "(//*[@class='hmenu-separator'])[2]", logger, "Programs & Features");
        //click on see all for programs and features
        ReusableMethods_Logger.clickMethod(driver, "(//*[@class='hmenu-item hmenu-compressed-btn'])[2]", logger, "Expand Programs & Features");
        //scroll down to amazon outlet
        ReusableMethods_Logger.scrollByElement(driver, "//*[@href='/outlet?ref_=nav_em_allpf_d_outlet_0_1_1_46']", logger, "Amazon Outlet");
        //click on amazon outlet
        ReusableMethods_Logger.clickMethod(driver, "//*[@href='/outlet?ref_=nav_em_allpf_d_outlet_0_1_1_46']", logger, "Amazon Outlet");
        Thread.sleep(1000);
        //click on premium brands
        ReusableMethods_Logger.clickMethod(driver, "//*[@id='a-autoid-2-announce']", logger, "Premium Brands");
        Thread.sleep(1000);
        //sort by newest arrivals
        ReusableMethods_Logger.selectByText(driver, "//*[@class='a-native-dropdown a-declarative']", "Newest Arrivals", logger, "Sort By Dropdown");
        //scroll down to page divider
        ReusableMethods_Logger.scrollByElement(driver, "//*[@class='a-section a-spacing-none s-messaging-widget-results-header']", logger, "Page Divider");
        //take a screenshot
        ReusableMethods_Logger.getScreenshot(driver, "Newest Premium Brand Arrivals", logger);
    }//end of test 6
}//end of class