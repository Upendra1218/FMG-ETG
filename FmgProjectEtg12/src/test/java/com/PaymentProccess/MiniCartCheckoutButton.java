package com.PaymentProccess;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.PageObjects.checkOutPage;
import com.PageObjects.guestUserLoginPage;
import com.PageObjects.miniCartPage;
import com.PageObjects.viewCartPage;
import com.providio.Validations.CartPageValidation;
import com.providio.Validations.miniCartAndCartValidation;
import com.providio.testcases.baseClass;

public class MiniCartCheckoutButton extends baseClass {

    public void checkoutprocess() throws InterruptedException {
    	
    	 /* List <WebElement> minicartcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));
    	     
          //CommonProccessFromMiniCartForViewCartAndCheckout 
          CommonProccessFromMiniCartForViewCartAndCheckout  commonProccess= new CommonProccessFromMiniCartForViewCartAndCheckout ();
          
          // minicart and check out validation
          miniCartAndCartValidation validation= new miniCartAndCartValidation();
   	       if(minicartcount.size()>0) {
   	    	   WebElement miniCartDisplay = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
   	    	   if(miniCartDisplay.isDisplayed()) {
   		    	   WebElement minicartcount1 = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
   		    	   String countOfMinicart = minicartcount1.getText();
   		    	   int minicartCountValue = Integer.parseInt(countOfMinicart);
   		
   		        if (minicartCountValue > 0) {		
   		            miniCartPage mc = new miniCartPage(driver);		            
   		            Thread.sleep(5000);		               
   		            //click on the cart button
   		            mc.howercartbutton(driver);
   		            Thread.sleep(1000);
   		            
   		            List <WebElement> minicartPopUp = driver.findElements(By.xpath("(//h1)[1]"));
   		            if(minicartPopUp.size()>0) {
   			            //validate the button click   			          
   			            validation.validateMiniCartClick();
   		            }
   		            
   	         
   		         viewCartPage vcp = new viewCartPage(driver);
		            
		           //click the checkout button	           
		             vcp.clickCheckout(driver);
		            
		          // checkout validation  
		          //  validation.validateCheckoutafterClick();
		            Thread.sleep(1000);
          
          
		            //Taxcalculation
		            
			           // tc__TaxCalculationCheckoutPage tc = new tc__TaxCalculationCheckoutPage();           
			           // tc.taxCalculation();
			            
			           //if any guest user means guest checkout
			            commonProccess.clickContinueAsGuest();
			            Thread.sleep(2000);
			            
			            
			            CartPageValidation cartPage =new CartPageValidation();
						cartPage.cartPage(driver);
						
						AddressDetails address = new AddressDetails();
						address.address();
						
			       }/*else {
			            logger.info("The cart value is empty");
			            test.fail("The cart value is empty");
			       }*/
		    //   }
    }

    }


