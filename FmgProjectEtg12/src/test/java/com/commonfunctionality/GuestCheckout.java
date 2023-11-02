package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.guestUserLoginPage;
import com.providio.testcases.baseClass;

public class GuestCheckout extends baseClass{
	
	public void clickContinueAsGuest() throws InterruptedException {
		
        List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Continue as guest')]"));
        logger.info(continueasAGuest.size());

        if (continueasAGuest.size() > 0) {
            guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
            //guestLoginPage.clickOnGuestCheckOut();
            logger.info("Guest checkout");
            
            
            int count = 100;
            Random random = new Random();
            int randomNumber = random.nextInt(count) + 1;
            String Email = "Testing"+randomNumber+"@Etggs.com";
            WebElement mail = driver.findElement(By.xpath("//input[@id='email-guest']"));
            mail.sendKeys(Email);
            
            //guestLoginPage.clickOnEmail(reEnterMail);
            logger.info("Guest mail again");
            guestLoginPage.clickOnContinueAsGuest();
            logger.info("Guest continue as guest");
            Thread.sleep(5000L);
          
        }
  
    }

}
