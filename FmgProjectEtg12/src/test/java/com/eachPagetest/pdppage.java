package com.eachPagetest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.CLPpage;
import com.PageObjects.homePage;
import com.PageObjects.productListingPage;
import com.Scenarios.pdpPage;
import com.Scenarios.plpPage;
import com.testcases.baseClass;

public class pdppage extends baseClass{
	@Test
	public void testing() throws InterruptedException {
		
//        // Launch the browser and navigate to the URL
//        launchBrowsering lb = new launchBrowsering();
//        lb.chromeBrowser();
//        Thread.sleep(4000);
//        int randomNumbermenu = 8;
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//     // Locate and hover over the randomly selected top-level menu item.
//        WebElement sales = driver.findElement(By.xpath("(//a[contains(@class,'nav-link dropdown')])[" + randomNumbermenu + "]"));
//        js.executeScript("arguments[0].click();", sales);
//        Thread.sleep(2000);
//        //sales.click();
//        //select a banner form the listed below
//        productListingPage hm = new productListingPage(driver);
//        hm.selectHeroBanner();
//        
//        List<WebElement> plpPagecheck = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
//        List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));
//      
//        
//        if (plpPagecheck.size() > 0 ) {
//            logger.info("PLP page is already loaded");
//            // Initialize and execute the PLP page scenario to add a product to the cart
//            plpPage.addtocartplp();
//        } else if(pdpPagecheck.size()>0) {
//        	 logger.info("pdp page is already loaded");
//        	 pdpPage.addtoCartPDP();
//        }
//        else {
//            // Move to CLP to the PLP
//            CLPpage clp = new CLPpage(driver);
//            clp.selectaClpRandomly();
//        }
//	   
//	   Thread.sleep(13000);
//	
		
		
		driver.get("https://storefront:FMG2023@sfccstage.firemountain.org/tools/displays/earring-cards/");
		Thread.sleep(5000);
		 homePage hp = new homePage(driver);
		 hp.clickconsentTracking();
		 
		 List<WebElement> addtoCartBtns = driver.findElements(By.xpath("//a[contains(@class, 'add-to-cart')]"));
		    
		    int displayedAddToCartCount = 0;
		    for (WebElement item : addtoCartBtns) {
		        if (item.isDisplayed()) {
		        	displayedAddToCartCount++;
		        }
		    }
		    logger.info(displayedAddToCartCount);

		
	}
	

}
