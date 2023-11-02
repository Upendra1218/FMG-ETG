// Import necessary packages and classes
package com.Login;

import com.PageObjects.loginPage;
import com.commonfunctionality.waitForTheElement;
import com.providio.testcases.baseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

// Define a test class named "tc__Login"
public class tc__Login extends baseClass {
	// Create an instance of the SoftAssert class to perform soft assertions
	SoftAssert softAssert = new SoftAssert();

    // Define a test method named "loginTest"
    @Test
    public void loginTest() throws InterruptedException {
    	
        // Log test information
        test.info("Test case validation started");
        
        // Navigate to the application's base URL
        driver.get(baseURL);
        logger.info("Entered into URL");
        Thread.sleep(2000L);
        
        // Create an instance of the "loginPage" class
        loginPage lp = new loginPage(driver);
        
        // Click on the "Sign In" button
        lp.clickSign();
        logger.info("Clicked on Sign In");
        Thread.sleep(2000L);
        
        // Enter the email address
        lp.setEmail(name);
        logger.info("Entered email");
        Thread.sleep(2000L);
        
        // Enter the password
        lp.setPassword(password);
        logger.info("Entered password");
        Thread.sleep(2000L);
        
        // Click on the "Submit" button
        lp.clickSubmit();
        logger.info("Clicked on the Submit button");
        Thread.sleep(5000L);
        
        // Use FluentWait to wait for the visibility of the "Dashboard" element
        Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
        WebElement loginTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //h1[@class ='account-page-title']")));
        
        // Get the actual title from the "Dashboard" element
        String expectedTitle = "Dashboard";
        String actualTitle = loginTitle.getText();
        
        // Check if the actual title matches the expected title
        if (actualTitle.equals(expectedTitle)) {
        	// Log a pass message if the user is logged in successfully
        	test.pass("User logged in successfully");
            logger.info("User logged in successfully");
            isLoggedIn = true;
            
            //registered user name 
            WebElement userName = driver.findElement(By.xpath("(//dd)[1]"));
            test.info("Name of User name is " + userName.getText());
            logger.info("Name of User name is " + userName.getText());
            
            //registered email id 
            WebElement regMail = driver.findElement(By.xpath("(//dd)[2]"));
            test.info("Email is " + regMail.getText());
            logger.info("Email  is " + regMail.getText());
            
        } else {
        	// Log a fail message if the page title does not match the expected title
        	test.fail("The page Title does not match expected " + expectedTitle + " but found " + actualTitle);
            logger.info("Click failed");
        }
        
        // Assert all the soft assertions
        softAssert.assertAll();
    }
}
