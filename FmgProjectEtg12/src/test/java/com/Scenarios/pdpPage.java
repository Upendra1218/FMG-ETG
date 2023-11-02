package com.Scenarios;

import com.PageObjects.navigationProcess;
import com.PageObjects.productListingPage;
import com.providio.testcases.baseClass;

public class pdpPage extends baseClass{

	public static void addtoCartPDP() throws InterruptedException {
		
		// Initialize navigationProcess to perform navigation tasks
        navigationProcess navProcess = new navigationProcess(driver);
        // Select a random menu item
        navProcess.selectRandomMenu(driver);
        
        // Initialize productListingPage to interact with product listing page
        productListingPage plp = new productListingPage(driver);
        plp.selectRandomProduct();
        
        
	}
}
