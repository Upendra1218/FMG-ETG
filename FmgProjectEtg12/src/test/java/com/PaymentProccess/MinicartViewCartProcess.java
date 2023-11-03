package com.PaymentProccess;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.PageObjects.checkOutPage;
import com.PageObjects.miniCartPage;
import com.PageObjects.viewCartPage;
import com.Validations.miniCartAndCartValidation;
import com.commonfunctionality.GuestCheckout;
import com.commonfunctionality.allAddress;
import com.testcases.baseClass;

public class MinicartViewCartProcess extends baseClass {

    public void checkoutprocess() throws InterruptedException {
    	Thread.sleep(3000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll up using JavaScript
        // Negative 'y' value scrolls up
    	js.executeScript("window.scrollTo(0, 0);");

        // Check if the minicart is displayed
        List<WebElement> minicartdisplayedcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));
        if (minicartdisplayedcount.size() > 0) {

            // Get the number of products in the cart
            WebElement productCountInCart = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
            String countOfMinicart = productCountInCart.getText();
            int minicartProductCountValue = Integer.parseInt(countOfMinicart);

            // If products are in the minicart, proceed
            if (minicartProductCountValue > 0) {

                miniCartPage mc = new miniCartPage(driver);
                Thread.sleep(5000);

                // Click on the cart button in the minicart
                mc.howercartbutton(driver);
		            Thread.sleep(1000);
                mc.clickviewCartButton(driver);
            
             // Initialize the view cart page
                viewCartPage vcp = new viewCartPage(driver);

                // Click the "Checkout" button in the view cart page
                vcp.clickCheckout(driver);
                Thread.sleep(1000);
                
                GuestCheckout gc = new GuestCheckout();
                gc.clickContinueAsGuest();
                
                // Handle the shipping address
                allAddress sd = new allAddress();
                sd.ShippingAddress();
                
                checkOutPage cp = new checkOutPage(driver);
                cp.clickcontinueToBillingButton(driver);


            } else {
                logger.info("The cart value is empty");
                test.fail("The cart value is empty");
            }
        }
    }
}
