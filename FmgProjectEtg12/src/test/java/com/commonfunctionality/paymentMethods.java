package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.PageObjects.paymentpPage;
import com.providio.testcases.baseClass;

public class paymentMethods extends baseClass{
	
	paymentpPage pp = new paymentpPage(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	   //brain tree payment method of guest user
		public  void braintreeGuest() throws InterruptedException {
			
			pp.setcardholdername(driver);
			logger.info("entered card name");
			test.info("entered card name");
			
			pp.setcardnumber(driver);
			logger.info("entered card number");
			test.info("entered card number");
			
			pp.setcardcvv(driver);
			logger.info("entered cvv");
			test.info("entered cvv");
			
			pp.setcardexp(driver);
			logger.info("entered exp");
			test.info("entered exp");
			
		}
		
		//register user and select the new card and save the card
		public void brainTreeReguser() throws InterruptedException {

	    	pp.selectnewcardindropdown();  
			logger.info("Selectd the new card");
			test.info("Selectd the new card");
			
			braintreeGuest();
			
		}
		
		public void savedCardsBrainTree() throws InterruptedException {
			//clicks on drop down
			WebElement savedCardsBrainTree= driver.findElement(By.cssSelector("option.js_stored_card"));
		
			JavascriptExecutor js = (JavascriptExecutor) driver;

	       
			WebElement savedCardsDropDown= driver.findElement(By.id("braintreeCreditCardList"));
			// savedCardsDropDown.click();
			
			//randomizing the saved cards
			List<WebElement> countOfSavedCardsInBrainTree= driver.findElements(By.cssSelector("option.js_stored_card"));
			
			if (!countOfSavedCardsInBrainTree.isEmpty()) {
				test.info("User have saved cards");
				
				/* 	Actions action = new Actions(driver);
		    	action.moveToElement(savedCardsDropDown).perform();
		    	Thread.sleep(5000);
		    	WebElement savedCardsInBrainTree= driver.findElement(By.cssSelector("option.js_stored_card"));
		    	savedCardsInBrainTree.click();
    		// Generate a random index within the bounds of the list size
				Select select = new Select(savedCardsBrainTree);

		     // Get all the options in the dropdown
		        List<WebElement> options = select.getOptions();
				
		     // Generate a random index to select an option
    		    Random rand = new Random();    		    
    		    int randomIndex = rand.nextInt(options.size());
    		   

    		  //Click the random WebElement
    		    Thread.sleep(1000);
    		    //js.executeScript("arguments[0].click();", countOfSavedCardsInBrainTree.get(randomIndex));	
    		    countOfSavedCardsInBrainTree.get(randomIndex).click();	 		   
    		    System.out.println("Selected random card");	*/
    		    
		    	}else {
		    		test.info("No used cards for user");
		    	//enters the card details
		    		braintreeGuest();
		    	}
			
		}
		public void brainTreeDropDown() throws InterruptedException {
			//drop new new
			pp.selectnewcardindropdown();
		}
		
		public void addNewCardThoughExistingCardsInBrainTree() throws InterruptedException {
			//clicks on new card drop down
			pp.selectnewcardindropdown();
			
			// enter the card details into input box
			braintreeGuest();
		}
		
		
		//payment of cyber source  of guest user
		public void cyberSourceGuest() throws InterruptedException {
			
	        pp.latestcardnumber(driver);
	        logger.info("entered card number");
	        test.info("entered card number");
	        
	        pp.latestExpDate(driver);
	        logger.info("entered exp month");
	        test.info("entered exp month");
	        
	        pp.latestExpYear(driver);
	        logger.info("entered exp year");
	        test.info("entered exp year");
	        	        
	        pp.latestSceuritycode(driver);
	        logger.info("entered scecode");
	        test.info("entered scecode");
			
	        
	        
		}
		
		//payment reg user
		public void withoutSavedCardsCyberReg() throws InterruptedException {
			
			//cybersource method
			cyberSourceGuest();
			// save card to account is already enabled
				//pp.cyberAddpaymentBtn(driver);
				//logger.info("clicked on the add payment button");
	
		}
		
		public void addNewCardThoughExistingCardsInCyberSource() throws InterruptedException {
			
			//clicks on add paymnet
			 WebElement addPaymentCybersource = driver.findElement(By.cssSelector("button.add-payment"));
			 js.executeScript("arguments[0].click();", addPaymentCybersource);	
			 
			 //credit card details
			 cyberSourceGuest();
			 WebElement emailInReg = driver.findElement(By.xpath("//input[@name='dwfrm_billing_creditCardFields_email']"));
			 emailInReg.sendKeys("akhila.m@etg.digital");
		}
		
		public void savedCardsCyberSource() throws InterruptedException {
		
    		//select one and send the cvv number of that card	
			///list of saved cards
    		List<WebElement> savedCards = driver.findElements(By.cssSelector("div.saved-payment-instrument"));
    			Random random = new Random();
	            int randomIndex = random.nextInt(savedCards.size());
	            // Select the randomly chosen payment instrument
	            WebElement selectedPaymentInstrument = savedCards.get(randomIndex);
	           //clicking on random saved card 
	            js.executeScript("arguments[0].click();", selectedPaymentInstrument);
	           
	            //selected saved card
	            WebElement selectedCard = driver.findElement(By.xpath("//div[@class='row saved-payment-instrument selected-payment']"));
	            String selectedCardText= selectedCard.getText();
	            test.info("Selected card is " + selectedCardText); 
	           
	            //scrolling to saved card input box to enter cvv
	            WebElement securityCodeElement = selectedCard .findElement(By.id("saved-payment-security-code"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectedCard);
	            
	            //clicks to enter cvv 
	            js.executeScript("arguments[0].click();",securityCodeElement);
	           
	            if(selectedCardText.contains("Credit Amex")) {	
		            // Locate the security code element and send the generated code		           
		            Thread.sleep(1000);		          
		            //securityCodeElement.click();
		            js.executeScript("arguments[0].value = '1346';", securityCodeElement);		      
	            	
	            }else {   
		            // Locate the security code element and send the generated code		           
		            Thread.sleep(1000);
		            
		           // securityCodeElement.click();
		            JavascriptExecutor js = (JavascriptExecutor) driver;		           
		            js.executeScript("arguments[0].value = '836';", securityCodeElement);		                 		       
	            }
		}
		
		//method for back to saved cards
		public void backToSavedCards() throws InterruptedException {
			//clicking on add payment
			   WebElement addPayment = driver.findElement(By.cssSelector("button.add-payment"));
			   js.executeScript("arguments[0].click();", addPayment);
			
			//clicking on back to saved cards
			   WebElement backToSavedPaymnets = driver.findElement(By.cssSelector("button.cancel-new-payment"));
			   js.executeScript("arguments[0].click();", backToSavedPaymnets);
			   
			 //randomly selecting the saved card
			   savedCardsCyberSource();			 
		}
		
		//salesforce payment method
		public void salesforcePayment() throws InterruptedException {
			
			pp.cardNumber(driver);	    	
	    	logger.info("entered card number");
	    	test.info("entered card number");
	    	
	    	pp.expiryDate(driver);	    	
	    	logger.info("entered cvv");
	    	test.info("entered cvv");
	    	
	    	pp.cvc(driver);
	    	logger.info("entered exp");
	    	test.info("entered exp");
		}
		
		
     
	     public void savedCardsSalesforce() throws InterruptedException {
	    	 //randomize the saved cards in salesforce
	 		List<WebElement> savedCardsSalesforce = driver.findElements(By.cssSelector("div.sfpp-payment-method-header-saved"));
	 		
		 		if (!savedCardsSalesforce.isEmpty()) {
	    		    // Generate a random index within the bounds of the list size
	    		    Random rand = new Random();
	    		    int randomIndex = rand.nextInt(savedCardsSalesforce.size());
	    		    
	    		    System.out.println("The total number of saved cards are " +savedCardsSalesforce.size());
	    		    
	    		    // Click the random WebElement
	    		   // js.executeScript("arguments[0].click();",  savedCardsSalesforce.get(randomIndex));	
	    		    Thread.sleep(1000);
	    		    savedCardsSalesforce.get(randomIndex).click();
	    		    System.out.println("Selected random card");
	    		    test.info("Selected random saved card");
			    		
			    	}
	 	}
	     
	     public void withoutSavedCardSalesforceReg() throws InterruptedException {
	    	 
	    	 test.info("User don't have saved cards as new user");
	    	 //entering card details into input box
	    	 salesforcePayment();
	    	 
	    	 //saving card to account
	    	 WebElement saveToaccountInSalesforce = driver.findElement(By.cssSelector("input.sfpp-save-payment-method-input"));
	    	 js.executeScript("arguments[0].click();",  saveToaccountInSalesforce);	
	     }
	     public void addNewCardThoughExistingCardsInSalesforce() throws InterruptedException {
	    	 
	    	 test.info("Though user have saved cards want to add new card");
	    	 WebElement clickOnCreditCard = driver.findElement(By.xpath("//div[contains(text(),'Credit Card')]"));
	    	 js.executeScript("arguments[0].click();",   clickOnCreditCard);	
	    	 
	    	 //adding a new card into account saving it.
	    	 withoutSavedCardSalesforceReg();
	    	 
	     }
	     
	     //stripe payment method
	     public void stripePaymentGuest() {
	 		
	 		pp.cardNum(driver);
	 		test.info("entered card number");
	 		
	 		pp. expDate(driver);
	 		test.info("entered exp date");
	 		
	 		pp.cvv(driver);
	 		test.info("entered cvv");
	 		
	 		pp.postalCode();
	 		test.info("entered postal code");
	 	}
		
	     public void savedCardsStripe() {
    		// to randomaize the saved cards -randomly pick any saved card 
	    	 List<WebElement> countOfSavedCards= driver.findElements(By.xpath("//input[@name='saved_card_id']"));
    		if (!countOfSavedCards.isEmpty()) {
    		    // Generate a random index within the bounds of the list size
    		    Random rand = new Random();
    		    int randomIndex = rand.nextInt(countOfSavedCards.size());

    		    // Click the random WebElement
    		    js.executeScript("arguments[0].click();",  countOfSavedCards.get(randomIndex));	
    		    //countOfSavedCards.get(randomIndex).click();
    		    System.out.println("Selected random card");
		    		
		    	}
	     } 
	     public void withoutSavedCardStripeReg() {
		    	//enters paymnet details 
		    	 stripePaymentGuest();
	 			//clicking on save button 
	 			WebElement checkButtonToSaveCards= driver.findElement(By.id("stripe_save_card"));
	 			 js.executeScript("arguments[0].click();", checkButtonToSaveCards);	
	     }
	     public void addNewCardThoughExistingCardsInStripe() throws InterruptedException {
		    	//clicks on credit card label
				 WebElement stripeCreditCard = driver.findElement(By.xpath("//li[@data-method-id='CREDIT_CARD']"));
				 js.executeScript("arguments[0].click();",  stripeCreditCard);	
				 //stripeCreditCard.click();
			
				 WebElement addNewCard= driver.findElement(By.id("switch-to-add-card"));
				 js.executeScript("arguments[0].click();", addNewCard);	
				
				 //enters paymnet details 
				 stripePaymentGuest();
				
				 //clicking on save button 
				 WebElement checkButtonToSaveCards= driver.findElement(By.id("stripe_save_card"));
				 js.executeScript("arguments[0].click();", checkButtonToSaveCards);	
				 //checkButtonToSaveCards.click();
				 Thread.sleep(2000);
	     }
}
