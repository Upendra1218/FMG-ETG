package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.GiftCertificate;
import com.PageObjects.navigationProcess;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.giftCard;
import com.Scenarios.pdpPage;
import com.providio.testcases.baseClass;

public class tc__GuestUserRandomProductFromPDP_InCc extends baseClass{
	int minicartCountValue ;
	@Test
	public void ProductFromPDP() throws InterruptedException {
		
		//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		 
		pdpPage.addtoCartPDP();
        
		
		 //checkoutProcess
		 MinicartViewCartProcess cp = new MinicartViewCartProcess();				     
	     cp.checkoutprocess();
			     
	     //Payment process		     
	     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
	     cc.paymentByCreditCard();
	}
}
