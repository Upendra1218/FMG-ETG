package com.providio.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MinicartViewCartProcess;
import com.commonfunctionality.attributesSelection;
import com.commonfunctionality.validatingInstock;


public class tc__NavigationEachMenuOneItem extends baseClass{
	
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
    public void Navigation() throws InterruptedException {
        test.info("Test case for the Login Page");
        
        if (isLoggedIn) {
            test.info("Test case for the Navigationmenu of Newarrival Page");
            

   		 WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
           String countOfMinicart = minicartcount.getText();
           int minicartCountValue = Integer.parseInt(countOfMinicart);
           logger.info(minicartCountValue);
            
            
            List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
	        int count = countofMenus.size();

	        Random random = new Random();

	        for(int i = 1; i <= count; ++i) {
	            System.out.println("Menu of number" + i);
	            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));
	            int countdropdown = noelementsofdrop.size();
	            int randomNumbermenuitem = random.nextInt(countdropdown)+1;

	                Thread.sleep(5000);
	                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));
	                String menuname = NavigationMenu.getText();

	                Thread.sleep(5000);
	                Actions action = new Actions(driver);
	                action.moveToElement(NavigationMenu).perform();
	                Thread.sleep(5000L);
	                
	                test.pass ("Successfully Howered on the" + menuname + " ");
	                logger.info("Successfully Howered on the" + menuname + " ");

	                
	                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + randomNumbermenuitem + "]"));
	                String submenuName = NavigationMenuitem.getText();
	                System.out.println("Menu name " + submenuName);
	                JavascriptExecutor js = (JavascriptExecutor)driver;
	                js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
	                Thread.sleep(5000L);
	                
	                test.pass( "Successfully clicked on the" + submenuName + " of " + menuname + "");
	                logger.info("Successfully clicked on the" + submenuName + " of " + menuname + "");
	                
           
	                List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));	    	        
	    	        int totalProductcount = products.size();	    	        
	    	        int randomselectProduct = random.nextInt(totalProductcount) + 1;

	    	        WebElement RandomSelectProductFormPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])"+"  "+"[" + randomselectProduct + "]"));
	    	       // String productName = RandomSelectProductFormPLP.getText();
	    	        //logger.info(productName);
	    	        js.executeScript("arguments[0].click();",  RandomSelectProductFormPLP);
	    	        
	    	        
	    	        //logger.info(productName);
	    	        Thread.sleep(5000);
	    	        
	    	    	
	    			List <WebElement> mainDiv= driver.findElements(By.xpath("//div[@class='attributes px-0']"));
	    			System.out.println("The total number of size division are " +mainDiv.size());
	    		
	    			List<WebElement> colorElement = driver.findElements(By.xpath("//span[contains(@class,' non-input-label')]"));
	    			System.out.println("The color count is " + colorElement.size());
	    			
	    			List<WebElement> sizeElement = driver.findElements(By.xpath("//select[@class='custom-select form-control select-size']"));
	    			System.out.println("The size count is " +  sizeElement.size());
	    			
	    			List<WebElement> memoryElement = driver.findElements(By.id("memorySize-null"));
	    			
	    			 List<WebElement> widthElements = driver.findElements(By.xpath(".//select[@id='width-null']"));
	    		     System.out.println(widthElements.size());
	    		     
	    		     List<WebElement> showName = driver.findElements(By.xpath("//select[contains(@class,'select-showName')]"));
	    		     System.out.println(showName.size());
	    		     
	    		     //another way of attributes
	    		     
	    		     List<WebElement> sizeBox= driver.findElements(By.xpath("//div[@class='select-size size-change d-flex flex-wrap']"));
	    		     	     	 	
	    		     List<WebElement> colorBox= driver.findElements(By.xpath("//button[contains(@class,'color-attribute')]"));
	    		     
	    		     List<WebElement> memoryBox = driver.findElements(By.xpath("//div[@class='select-memorySize size-change d-flex flex-wrap']"));
	    		     
	    			 List<WebElement> widthBox = driver.findElements(By.xpath("//div[@class='select-width size-change d-flex flex-wrap']"));
	    			 
	    			 List<WebElement> showNameBox= driver.findElements(By.cssSelector(".showName"));
	    		     
	    		     for(int i1=1; i1<=mainDiv.size();i1++) {
	    		    	 
	    				if(colorElement.size()>0|| colorBox.size()>0) {
	    					//productDescriptionPage pdp = new productDescriptionPage(driver);
	    					attributesSelection.colorSelection();
	    					System.out.println("selected color");
	    					Thread.sleep(4000);
	    				}if(sizeElement.size()>0|| sizeBox.size()>0 ) {
	    					
	    					//productDescriptionPage pdp = new productDescriptionPage(driver);
	    					attributesSelection.sizeSelction();
	    					System.out.println("selected size");
	    					Thread.sleep(4000);					
	    				} if(memoryElement.size()>0||  memoryBox.size()>0) {
	    					//productDescriptionPage pdp = new productDescriptionPage(driver);
	    					attributesSelection.memorySelection();
	    					System.out.println("selected memory size");
	    					Thread.sleep(4000);
	    				} if(widthElements.size()>0 || widthBox.size()>0) {
	    					Thread.sleep(4000);
	    					//productDescriptionPage pdp = new productDescriptionPage(driver);
	    					attributesSelection.widthSelection();
	    					System.out.println("selected width");
	    					Thread.sleep(4000);
	    				}if(showName.size()>0 || showNameBox.size()>0) {
	    					Thread.sleep(4000);
	    					//productDescriptionPage pdp = new productDescriptionPage(driver);
	    					//attributesSelection.selectShowName();
	    					System.out.println("Selected show name ");
	    				}
	    				
	    				validatingInstock.inStockValidation();
//	    				WebElement mainDiv1= driver.findElement(By.xpath("(//div[@class='attributes px-0']) [" +i+"]"));
//	    				
//	    				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mainDiv1);
	    				
//	    				JavascriptExecutor js = (JavascriptExecutor) driver;
//	    		        js.executeScript("window.scrollBy(0,700)", "");

	    		     }
	    	        
	    	        test.info("Verifying the product is added to cart or not ");		
	    			 
	    			 WebElement minicartcountafteraddotcart = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
	    	       String countOfMinicartafteraddotcart = minicartcountafteraddotcart.getText();
	    	       int minicartCountValueafteraddotcart = Integer.parseInt(countOfMinicartafteraddotcart);
	    	       logger.info(minicartCountValueafteraddotcart);

	    				  if(minicartCountValue!=minicartCountValueafteraddotcart) {
//	    					  Thread.sleep(5000);
//	    					  pratciie.Paynent();
	    						test.pass("Product added to cart");
	    						logger.info("Product is  added to cart");
	    				  }else {
	    					  //pratciie.Paynent();
	    					//test.fail("Product is not added to cart");
	    					logger.info("Product is not added to cart");
	    				  }
	    	        Thread.sleep(5000);

	               
	            }
	        
	        //checkoutProcess
	        
            MinicartViewCartProcess cp = new MinicartViewCartProcess();
            
            cp.checkoutprocess();
            
           //payment process
            
            CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
            
            cc.paymentByCreditCard(); 
            

            
        } else {
            Assert.fail("User not logged in");
        }
        
        // Assert all the soft assertions
        softAssert.assertAll();

    }

}
