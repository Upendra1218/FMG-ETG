package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Scenarios.pdpPage;
import com.Validations.validationpopupMessages;
import com.testcases.baseClass;

public class allAttributesinOneFile extends baseClass{
	
	
	public static  void selectTheAttributesInPdp(WebDriver driver) throws InterruptedException {
		
		//selecting attributes from the  pdp page by checking the condition 
		//allAttributes();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
     
	
	//checking the  add to cart enabled and  in stock
    		List<WebElement> Stocksize = driver.findElements(By.xpath("//span[contains(text(),'Sold Out')]"));
     		test.info("Verify that the product is avaliable");
     	    // Check if the element is present
     	    if (Stocksize.size() <= 0) {
     	    	test.pass("The product is avaliable");
     	    	
     	    	List<WebElement> addtoCartButton = driver.findElements(By.xpath("//span[contains(text(),'Add to Cart')]"));
     	    
     	    	//addtocartbutton is enabled
     	    	test.info("Verify that the product is avaliable");
     	    	if(addtoCartButton.size()>0) {
     	    		logger.info("add to cart  button enabled");
     	    		WebElement addtoCartButtonClick = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));     	    		
     	            js.executeScript("arguments[0].click();", addtoCartButtonClick);
     	    		Thread.sleep(1000);
     	    	// Validate that the product is added to the cart
    	            validationpopupMessages.validatingProductisAddtoCart(driver);
     	    	}
      
     	    }else {
    	 
    	 	//if the prodcut is outof stock then it will search for new prodcut by selecting random menu and random product
     	    	System.out.println("Product is out of stock so searching for new product");	    	
    	 	
     	    	//navigating to random menu adding into navigating to plp r pdp page
     	    	pdpPage.addtoCartPDP();
     }	    
	     
	}

	public static void allAttributes() throws InterruptedException {
		
		//fetching the package size 
			List <WebElement> packageSizeList= driver.findElements(By.id("package-qty-feet-1"));
			System.out.println("The package size  " +packageSizeList.size());

		 	// checkoing the availbility of package size and randomizing the varities and selecting them
		 		if(packageSizeList.size()>0) {			
		 			if (!packageSizeList.isEmpty()) { 							
		 				List<WebElement> elementList = driver.findElements(By.cssSelector(".slick-slide.slick-active .single-custom-attribute"));
		 				Random random = new Random();
		 				int randomIndex = random.nextInt(elementList.size());
		 				WebElement randomElement = elementList.get(randomIndex);
		 				randomElement.click();
		 			      
		 			}
			}
	}

}


