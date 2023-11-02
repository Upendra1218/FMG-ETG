package com.Scenarios;

import com.PageObjects.navigationProcess;
import com.PageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class plpPage extends baseClass{

	public static void addtocartplp() throws InterruptedException {
		
		// Initialize navigationProcess to perform navigation tasks
        navigationProcess navProcess = new navigationProcess(driver);
        // Select a random menu item
        navProcess.selectRandomMenu(driver);
        
        // Initialize productListingPage to interact with product listing page
        productListingPage plp = new productListingPage(driver);
        //sort the filters
        plp.selecttheFilters(2, driver);
        Thread.sleep(5000);
        //product add to the favorates
        plp.selecttheWishlist();
        
        // Add a product to the cart from PLP (Product Listing Page)
        plp.addToCartFromPlp();
	}
}
