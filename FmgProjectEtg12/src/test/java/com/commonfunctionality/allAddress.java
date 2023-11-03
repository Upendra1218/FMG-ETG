package com.commonfunctionality;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.PageObjects.checkOutPage;
import com.testcases.baseClass;

public class allAddress extends baseClass{
	
public void ShippingAddress() throws InterruptedException {
    	test.info("Validate the shipping Page");
        WebElement existingAddress = driver.findElement(By.xpath("//select[@name='shipmentSelector' and @id='shipmentSelector-default']"));
        List<WebElement> options1 = existingAddress.findElements(By.xpath("./option"));
        System.out.println(options1.size());

        if (options1.size() > 1) {
            logger.info("Address already exists");
        } else {
        	checkOutPage cp = new checkOutPage(driver);
            cp.setFisrtName(fname);
            logger.info("Entered fname");
            test.pass("Entered fname");
            cp.setLastname(lname);
            logger.info("Entered lname");
            test.pass("Entered lname");
            WebElement Address1 = driver.findElement(By.xpath("//input[@id='shippingAddressOnedefault']"));
            //Random random = new Random();
            int randomNumber = 123; // Generates a random number between 100 and 999
            address = String.valueOf(randomNumber);
            Address1.sendKeys(address);
            WebElement Address11 = driver.switchTo().activeElement();
            //Actions actions = new Actions(driver);
            Thread.sleep(1000);
            Address11.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
//            Address11.sendKeys(Keys.ARROW_DOWN);
            Address11.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            test.pass("Enterd the Address form the auto Suggestions");
            cp.setPhone(phonenumber);
            logger.info("Entered phone number");
            test.pass("Entered phone number");
            Thread.sleep(10000L);
        }
    }

}
