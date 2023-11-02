package com.Launchingbrowser;

import com.PageObjects.homePage;
import com.providio.testcases.baseClass;

public class launchBrowsering extends baseClass{
	
	public void chromeBrowser() throws InterruptedException {
		
		//launching the browser and passing the url into it
		 driver.get(baseURL);
		 logger.info("Entered into url");
		 logger.info("Placing the order as guest user");
		 
		 homePage hp = new homePage(driver);
		 hp.clickconsentTracking();
	}

}
