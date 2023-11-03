package com.GuestUserWith_ViewCart_Paypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;

public class tc__PaypalFromViewCartPage_GuestUser extends baseClass {
	 
	@Test
	public void paypalFromViewCartPage() throws InterruptedException {
			//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			lb.chromeBrowser();
		
			
		
		     
		     
	     
		  // selects a random catgory and product add to cart
	         
	         
	          
	     
    	 //paypal checkout form view cart page
 	          CheckOutProcessByPayPal paypal= new CheckOutProcessByPayPal();	         
 	          paypal.checkoutprocessFromViewCart();
   
		        }

}
