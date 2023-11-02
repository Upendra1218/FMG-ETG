package com.GuestUserWith_GcAndPaypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.MinicartViewCartProcess;
import com.commonfunctionality.Gc__CC_Paypal;


import com.providio.testcases.baseClass;

public class tc__OrderByGC_PaypalGuestUser extends baseClass {
	 
	@Test
	public void paypalFromCheckoutPage() throws InterruptedException {	
	
			//launching the browser and passing the url into it
					launchBrowsering lb = new launchBrowsering();
					lb.chromeBrowser();
				
					
			
				     
				     
	          
	       
		         
		         
		           
		    //common checkoutProcess	         
				  MinicartViewCartProcess cp = new MinicartViewCartProcess();         
				  cp.checkoutprocess();
				
			//gc and paypal
				  Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
				  gcAndPaypal.paymentProccessByGCandPaypal();
	}
}
