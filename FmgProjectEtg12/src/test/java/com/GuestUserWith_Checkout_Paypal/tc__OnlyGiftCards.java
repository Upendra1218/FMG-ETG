package com.GuestUserWith_Checkout_Paypal;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.GiftCertificate;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.giftCard;
import com.providio.testcases.baseClass;

public class tc__OnlyGiftCards extends baseClass{
	int minicartCountValue ;
	@Test
	public void OnlyGiftCards() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		 

		
		 //checkoutProcess
		 MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
			     
	    //paypal process from checkout page
		 CheckOutProcessByPayPal cpp = new CheckOutProcessByPayPal();
		 cpp.checkoutprocessFromCheckout();
	}
}
