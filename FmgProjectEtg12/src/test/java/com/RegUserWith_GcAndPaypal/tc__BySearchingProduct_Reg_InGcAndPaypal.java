

package com.RegUserWith_GcAndPaypal;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.SearchingProduct;
import com.commonfunctionality.Gc__CC_Paypal;

import com.providio.testcases.baseClass;

public class tc__BySearchingProduct_Reg_InGcAndPaypal extends baseClass {
	 
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {

		if(isLoggedIn) {    
 			
			
			    
			     
			     
			//searching a product 
				SearchingProduct sp = new SearchingProduct();
				sp.searchingProduct();
    	    
			    
		       	
				
		     //gc and paypal
				Gc__CC_Paypal gcAndPaypal = new Gc__CC_Paypal();
				gcAndPaypal.paymentProccessByGCandPaypal();
				
		 }else {
		   	 Assert.fail("User not logged in");
		   }
    }
}