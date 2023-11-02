package com.Scenarios;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.PageObjects.CLPpage;
import com.PageObjects.homePage;
import com.providio.testcases.baseClass;

public class menuSelction extends baseClass {

    public static void menusss() throws InterruptedException {
    	
        randommenu();

        // Find all the "Add to Cart" buttons on the page.
        List<WebElement> plpPage = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
        logger.info(plpPage.size());
        
        if (plpPage.size() > 0) {
            logger.info("PLP page is already loaded");
        } else {
            menusss();
        }
    }

    public static void randommenu() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        // Find all the top-level menu elements on the webpage.
        List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@class,'nav-link dropdown')]"));
        
        // Get the total count of top-level menu elements.
        int count = elements.size();
        logger.info("Total menus count is " + count);
        
        // Create a random number generator.
        Random random = new Random();
        
        // Generate a random index to select a top-level menu item.
        int randomNumbermenu = random.nextInt(count) + 1;
        logger.info("Randomly selected menu number " + randomNumbermenu);
        
        if(count==randomNumbermenu) {
        	logger.info("random genrate is 8");
        	
        	// Locate and hover over the randomly selected top-level menu item.
            WebElement sales = driver.findElement(By.xpath("(//a[contains(@class,'nav-link dropdown')])[" + randomNumbermenu + "]"));
            js.executeScript("arguments[0].click();", sales);
            //sales.click();
            //select a banner form the listed below
            homePage hm = new homePage(driver);
            hm.selectHeroBanner();
        	
        }else if(randomNumbermenu==7) {
        	logger.info("random genrate is 7");
        	menusss();
        }else {

        // Find all the submenu elements for the randomly selected top-level menu item.
        List<WebElement> elementsofdrop = driver.findElements(By.xpath("(//li[contains(@class,'nav-item dropdown')])[" + randomNumbermenu + "]//a[@class='dropdown-link']"));
        
        // Get the total count of submenu elements.
        int countdropdown = elementsofdrop.size();
        logger.info("Total number of sub menus associated with the hovered menu " + countdropdown);

        // Generate a random index to select a submenu item.
        int randomNumberitem = random.nextInt(countdropdown) + 1;
        logger.info("Randomly selected sub menu number " + randomNumberitem);
        
        
        	// Locate and hover over the randomly selected top-level menu item.
            WebElement NavigationRandomMenu = driver.findElement(By.xpath("(//a[contains(@class,'nav-link dropdown')])[" + randomNumbermenu + "]"));
            Thread.sleep(5000L);
            Actions action = new Actions(driver);
            action.moveToElement(NavigationRandomMenu).perform();
            Thread.sleep(2000L);

            // Locate and click on the randomly selected submenu item using JavaScriptExecutor.
            WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[contains(@class,'nav-link dropdown')])[" + randomNumbermenu + "]/following::a[@role='menuitem'])[" + randomNumberitem + "]"));
            js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
            Thread.sleep(5000L);

            // Check if "Add to Cart" buttons are present on the page.
//            List<WebElement> addtoCartBtns = driver.findElements(By.xpath("//a[contains(@class, 'add-to-cart')]"));
//            logger.info(addtoCartBtns.size());
            List<WebElement> plpPage = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
            
            if (plpPage.size() > 0 ) {
                logger.info("PLP page is already loaded");
            } else {
                // Move to CLP to the PLP
                CLPpage clp = new CLPpage(driver);
                clp.selectaClpRandomly();
            }
        }

        
    }
}
