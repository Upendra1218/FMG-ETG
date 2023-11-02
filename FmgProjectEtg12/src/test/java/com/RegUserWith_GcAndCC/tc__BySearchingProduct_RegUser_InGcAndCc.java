

package com.RegUserWith_GcAndCC;

import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.SearchingProduct;
import com.commonfunctionality.Gc__CC_Paypal;

import com.providio.testcases.baseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_RegUser_InGcAndCc extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
		 
		if(isLoggedIn) {
			
			//to pick the store
			     
			     
			     
			//searching a product 
				SearchingProduct sp = new SearchingProduct();
				sp.searchingProduct();
	    	
			//common checkout process
		         MinicartViewCartProcess cp = new MinicartViewCartProcess();        
		         cp.checkoutprocess();	
				
	        //semi gc and cc 
				Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
				gCandCC.paymentProccessByGCandCC(driver);
			
		 } else {
		        Assert.fail("User not logged in");
		    }
    }
}