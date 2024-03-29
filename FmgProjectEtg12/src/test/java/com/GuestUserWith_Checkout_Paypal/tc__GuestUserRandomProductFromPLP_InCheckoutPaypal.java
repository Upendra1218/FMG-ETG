package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.GiftCertificate;
import com.PageObjects.navigationProcess;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.giftCard;
import com.Scenarios.plpPage;
import com.testcases.baseClass;

public class tc__GuestUserRandomProductFromPLP_InCheckoutPaypal extends baseClass{
	 @Test
	    public void GuestUserRandomProductFromPLP_InCheckoutPaypal() throws InterruptedException {
	        // Launch the browser and navigate to the URL
	        launchBrowsering lb = new launchBrowsering();
	        lb.chromeBrowser();
	        
			// Initialize navigationProcess to perform navigation tasks
	        navigationProcess navProcess = new navigationProcess(driver);
	        // Select a random menu item
	        navProcess.selectRandomMenu(driver);

	        // Initialize and execute the PLP page scenario to add a product to the cart
	        plpPage.addtocartplp();

	        // Initialize MinicartViewCartProcess to perform the checkout process
	        MinicartViewCartProcess cartProcess = new MinicartViewCartProcess();
	        // Perform the checkout process
	        cartProcess.checkoutprocess();

	     // Initialize CheckOutProcessByPayPal to perform the PayPal checkout process
	        CheckOutProcessByPayPal cpp = new CheckOutProcessByPayPal();
	        // Perform the PayPal checkout process
	        cpp.checkoutprocessFromCheckout();
	    }
}
