package com.PaymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.PageObjects.miniCartPage;
import com.PageObjects.paymentpPage;
import com.PageObjects.reviewOrderPage;
import com.PageObjects.viewCartPage;
import com.providio.Validations.Checkout_Validation;
import com.providio.testcases.baseClass;

public class CheckOutProcessByPayPal extends baseClass{
		
	 Checkout_Validation checkout= new Checkout_Validation();

	 
	 //checkout from viewcart paypal button
	    
	 		public void checkoutprocessFromViewCart() throws InterruptedException {
	 			List<WebElement> minicartcountList =  driver.findElements(By.cssSelector(".minicart-quantity"));
		    	if(minicartcountList.size()>0) {
		 			WebElement minicartcount = driver.findElement(By.cssSelector(".minicart-quantity"));
		 		    String countOfMinicart = minicartcount.getText();
		 		    int minicartCountValue = Integer.parseInt(countOfMinicart);
		 			//count of items in minicart 
			 		   if (minicartCountValue > 0) {
		
				            miniCartPage mc = new miniCartPage(driver);
				            
				            	Thread.sleep(5000);
				                mc.clickcartbuttonjs(driver);
				                Thread.sleep(2000);
				               // Checkout_Validation checkout= new Checkout_Validation();
				                
					           //validate minicart
					           checkout.validateMiniCartClick();
					            logger.info("Validated minicart");
					            
					            mc.clickviewCartButton(driver);
					            logger.info("Clicked on view cart button"  );
					            
					            checkout.validateViewCartClick();
					            logger.info("Validated the view cart ");
					            
					            viewCartPage vcp = new viewCartPage(driver);
				            
					            Thread.sleep(2000);
				            List<WebElement> brainPayPalButton = driver.findElements(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
				            List<WebElement> salesforcePayPalButton = driver.findElements(By.xpath("(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]"));
				            
					            if(brainPayPalButton.size()>0) {
					            	test.info("Braintree payment integration is activated");
					            	 vcp.braintreePayPalButton(driver);
					            }else if(salesforcePayPalButton.size()>0){
					            	test.info("Salesforce payment integration is activated");
					            	vcp.salesforcePayPalButton(driver);
					            	
					            }else {
					            	test.info("Cybersouce payment OR stripe payment integration  is activated so, No paypal for cybersouce and stripe");
					            	test.pass("No paypal integration for cybersource and stripe , choose another integration to do the payment with payment");
					            }
						        	paymentpPage pp =new paymentpPage(driver);
						        	Thread.sleep(2000);
						        	//validate paypal window
						        	// checkout.validatePaypalClick();
									pp.paypalPopup(driver);
										
									
									reviewOrderPage rop = new reviewOrderPage(driver);
						    		Thread.sleep(4000);	

						    		if(driver.getTitle().endsWith("Checkout | Providio")) {
						    		 rop.clickonplaceorderwithJsExuter(driver);
						    		 logger.info("successfully click on the place order button by normal click");
						    		
						    		}
						    		Thread.sleep(10000);
									if(driver.getTitle().endsWith("Order Confirmation | Providio")) {								
										 Checkout_Validation checkout= new Checkout_Validation();
									 //validate the final place the order page
										 checkout.validatePlacetheOrderPage();							
								     //ordernumberandOrderdate
										 checkout.ordernumberandOrderdate();
										 Thread.sleep(3000);
										}
			 		   	}
			 		   
		    	}	  	           
	 		}
	        
	    public void checkoutprocessFromCheckout() throws InterruptedException {

	    	List<WebElement> billingAddress= driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));
	    	
		    	  if(billingAddress.size()>0) {					
		    	 
		    			// total price of products 
						List<WebElement> totalPriceList = driver.findElements(By.xpath("//span[@class='grand-total-sum']"));
						if(totalPriceList.size()>0) {
							WebElement totalPrice = driver.findElement(By.xpath("//span[@class='grand-total-sum']"));
							test.info("The total price of products is " + totalPrice.getText());
						}	
		    		  
			    	 	List<WebElement> brainPaypalAcc = driver.findElements(By.cssSelector("img[title='PayPal Credit']"));			    
				    	List<WebElement> salesforcePaypal= driver.findElements(By.xpath("(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]"));
				    	JavascriptExecutor js = (JavascriptExecutor) driver;	    		  
			    		js.executeScript("window.scrollBy(0,300)", "");
		
			    	 if(brainPaypalAcc.size()>0) {	
			    		 
				    		test.info("Brain tree payment integration is activated");		    	
				    		paymentpPage pp =new paymentpPage(driver);	   
				    		Thread.sleep(2000);
				    		pp.braintreePaypal(driver);
				    		Thread.sleep(2000);
				    		
				    		WebElement reviewOrderButton= driver.findElement(By.xpath("//button[contains(@class,'submit-payment')]"));
				    		
			    		if (reviewOrderButton.isDisplayed()) {
			    			
			    			reviewOrderPage rop = new reviewOrderPage(driver);
			    			Thread.sleep(2000);
			    			
			    	    //review order page 
				    		rop.clickonReviewOrder(driver);
				    		logger.info("Clicked on review order button");			    		
				    		Thread.sleep(4000);
				    		
				    	//place order 
				    		 rop.clickonplaceorderwithJsExuter(driver);
				    		 logger.info("successfully click on the place order button by normal click");
				    		 
			    			
				    		
						}else  {
							pp.brainTreeAfterClick(driver);
							logger.info("A click to Enter into paypal");				
					    	pp.paypalPopup(driver);
					    	logger.info("Clicked on paypal button");
					    	
					    	reviewOrderPage rop = new reviewOrderPage(driver);
				    		Thread.sleep(4000);		
				    		//REView order page 
					    		rop.clickonReviewOrder(driver);
					    		logger.info("Clicked on review order button");
					    		
					    		Thread.sleep(4000);		    		
	
					    		
					    		Thread.sleep(4000);
					    	//place order 
					    		 rop.clickonplaceorderwithJsExuter(driver);
					    		 logger.info("successfully click on the place order button by normal click");
					    		
					    		
					    		
					    		
						}
			    	}else if(salesforcePaypal.size()>0) {	 
			    	
			    		test.info("salesoforce payment integration is activated");
			    		// Use FluentWait to wait for the visibility of the "Dashboard" elemen		            
					    paymentpPage pp = new paymentpPage(driver);		   	         
					    pp.salesforcePaypalCheckout(driver);	
					    logger.info("Clicked on paypal button after clicking on paypal icon");
					    Thread.sleep(2000);
				    	pp.paypalPopup(driver);
				    	logger.info("Clicked on paypal button");
			    	}else {
			    		test.info("Cybersouce payment OR stripe payment integration  is activated so, No paypal for cybersouce and stripe");
		            	test.pass("No paypal integration for cybersource and stripe , choose another integration to do the payment with payment");
			    	}
		    	  }
			    	  
			    	  
		    		Thread.sleep(10000);
		    		if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
		    			
		    			 Checkout_Validation checkout= new Checkout_Validation();
		    		 //validate the final place the order page
		    			 checkout.validatePlacetheOrderPage();
		    		
		    	     //ordernumberandOrderdate
		    			 checkout.ordernumberandOrderdate();
		    			 Thread.sleep(5000);
		    			}
	    }
	    
	    public void paypalCheckoutFromPDP() throws InterruptedException {
 
	    	
	 			    Thread.sleep(4000);
	 				paymentpPage pp =new paymentpPage(driver);
	 				pp.paypalPopup(driver);
	 				
	 				reviewOrderPage rop = new reviewOrderPage(driver);
					Thread.sleep(2000);
					

		    		 rop.clickonplaceorderwithJsExuter(driver);
		    		 logger.info("successfully click on the place order button by normal click");
		    		
		    		
					if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
						
						 Checkout_Validation checkout= new Checkout_Validation();
					 //validate the final place the order page
						 checkout.validatePlacetheOrderPage();
					
				     //ordernumberandOrderdate
						 checkout.ordernumberandOrderdate();
						} 
	 		  
	    }
	    
	    public void paypalFromLoginPage() throws InterruptedException {
	    	
		    	List<WebElement> paypalList= driver.findElements(By.xpath("(//div[contains(@class,'paypal-buttons-layout-horizontal')])[1]"));
		    	if(paypalList.size()>0) {	
		    		test.info("Paypal in login page");
		    		WebElement paypal= driver.findElement(By.xpath("(//div[contains(@class,'paypal-buttons-layout-horizontal')])[1]"));
		    		paypal.click();
		    		Thread.sleep(4000);
	 				paymentpPage pp =new paymentpPage(driver);
	 				pp.paypalPopup(driver);
	 				// checkOutPage cp = new checkOutPage(driver);
			          //selecting shipping address
			            
		            //tc__MinicartViewCartProcess cop = new tc__MinicartViewCartProcess();
		            //cop.selectShippingAddress(cp);
		           // cop.selectPaymentMethod(cp);
		            
	 				 reviewOrderPage rop = new reviewOrderPage(driver);
		    		 rop.clickonplaceorderwithJsExuter(driver);
		    		 logger.info("successfully click on the place order button by normal click");
		    		 
		    		 
					if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
						
						 Checkout_Validation checkout= new Checkout_Validation();
					 //validate the final place the order page
						 checkout.validatePlacetheOrderPage();
					
				     //ordernumberandOrderdate
						 checkout.ordernumberandOrderdate();
						}
		    	}else {
		    		test.info("No paypal button in login page in brain tree it is only for salesforce");
		    		
		    	}
	 			  
	    }

		
}
