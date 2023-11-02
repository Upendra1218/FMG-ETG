												package com.GuestUserWith_GiftCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.MinicartViewCartProcess;
import com.commonfunctionality.Gc__CC_Paypal;


import com.providio.testcases.baseClass;

public class tc__OrderByGc_GuestUser extends baseClass {
	 
	@Test
	public void paymentByGiftCardInGuestUser() throws InterruptedException  {
		
		
		//launching the browser and passing the url into it
				launchBrowsering lb = new launchBrowsering();
				lb.chromeBrowser();
				
				
				
			     
			     
	          
	          // selects a random catgory and product add to cart
		         
		         
	          
	          //checkoutProcess				        
			     MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
			     cp.checkoutprocess();
			     
			  //gc payment 
			     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
			     gc.paymentByGiftCard();
			   
			     
		}
}
