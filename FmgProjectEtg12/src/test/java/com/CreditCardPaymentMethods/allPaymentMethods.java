package com.CreditCardPaymentMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.commonfunctionality.paymentMethods;
import com.providio.testcases.baseClass;

public class allPaymentMethods extends baseClass {
	
	List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));
	
	//saved card list for stripe
	List<WebElement> stripeSavedCardsContainers= driver.findElements(By.id("saved-cards-container"));
	//to switch ,to add the new card
	List<WebElement> addNewCardListStripe= driver.findElements(By.id("switch-to-add-card"));
	
	
	//cybersource saved cards
	List<WebElement> savedCardsCyberSourece = driver.findElements(By.cssSelector("div.saved-payment-instrument"));
	//to add new card though having card 
	List<WebElement>  addNewCardListCyberSource = driver.findElements(By.cssSelector("button.add-payment"));
	paymentMethods pm = new paymentMethods();
	
	
	//salesforce
	List<WebElement> savedCardsSalesforce = driver.findElements(By.cssSelector("div.sfpp-payment-method-header-saved"));
	//to add new card though having card 
	List<WebElement> clickOnSalesforceCreditCard = driver.findElements(By.xpath("//div[contains(text(),'Credit Card')]"));

	 
	//brain tree
	List<WebElement> savedCardsBrainTree= driver.findElements(By.cssSelector("option.js_stored_card"));
	//to add new card though having card 
	List<WebElement> brainTree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
	
	//BrainTree
	public void BrainTreeMethod() throws InterruptedException {

        
		if(continueasAGuest.size()>0) {
			
 		   //guest user payment
			pm.braintreeGuest();
			

        }else {
        	//if user is registered and have saved cards then  this if will execute
        	if(savedCardsBrainTree.size()>0) {
        		
        		pm.savedCardsBrainTree();
        	}else {
        		//new user without saved cards in account 
        		pm.brainTreeReguser();
        	}
        	
        	
        }

	}
	
	//cyberSource
	public void cyberSource() throws InterruptedException {
		
		if(continueasAGuest.size()>0) {
	 		   //guest user payment
				pm.cyberSourceGuest();

	        }else {
	        	if(savedCardsCyberSourece.size()>0) {
		        	//if user is registered and have saved cards then  this if will execute
		        	pm.savedCardsCyberSource();
	        	}else {
	        		//if user want to add new card  into account without having the saved cards
		        	pm.withoutSavedCardsCyberReg();
	        	}
	        }
	}

	//salesforce
	public void salesForce() throws InterruptedException {
		
		if(continueasAGuest.size()>0) {
	 		   //guest user payment
				pm.salesforcePayment();

	        }else {
	        	
	        //	pm.addNewCardThoughExistingCardsInSalesforce();
	        	
	        	//if user is registered and have saved cards then  this if will execute
	        	if(savedCardsSalesforce.size()>0) {
	        		pm.savedCardsSalesforce();
	        	}else {
	        		//new user without saved cards and user saves the new card to account
	        		pm.withoutSavedCardSalesforceReg();
	        	}
	        	
	        }
	}

	//stripe payment method
	public void stripe() {
		
		if(continueasAGuest.size()>0) {
	 		   //guest user payment
				pm.stripePaymentGuest();

	        }else {
	        	//if user is registered and have saved cards then  this if will execute
	        	if(stripeSavedCardsContainers.size()>0) {
	        		pm.savedCardsStripe();
	        	}else {
	        		//if user want to add new card  into account without having the saved cards
	        		pm.withoutSavedCardStripeReg();
	        	}
	        	
	        }
		
	}
	public void addNewCardThoughExistingCards() throws InterruptedException {
		test.info("Adding new card to account though having the saved card.");
		if(addNewCardListStripe.size()>0) {
			//adding new card though user have saved cards
			pm.addNewCardThoughExistingCardsInStripe();
			
		}if(addNewCardListCyberSource.size()>0) {
			
			pm.addNewCardThoughExistingCardsInCyberSource();
			
		}if(clickOnSalesforceCreditCard.size()>0) {
			
			pm.addNewCardThoughExistingCardsInSalesforce();
			
		}if(brainTree.size()>0) {
			
			pm.addNewCardThoughExistingCardsInBrainTree();
		}
	}
}
