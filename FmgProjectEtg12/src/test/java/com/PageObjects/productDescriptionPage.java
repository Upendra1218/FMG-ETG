package com.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.providio.testcases.baseClass;

public class productDescriptionPage extends baseClass{

    WebDriver ldriver;

    public productDescriptionPage(WebDriver rdriver ){   
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

  
    // WebElement for navigating through breadcrumbs
    @FindBy(xpath = "(//ol[@class='breadcrumb mb-0']//a[contains(text(),'Womens')])[1]")
    WebElement allBreadCrumbs;
    // Method to click on breadcrumbs
    public void clickOnBreadCrumbs(WebDriver driver) throws InterruptedException{
        Actions actions = new Actions(driver);
        actions.moveToElement(allBreadCrumbs);
        allBreadCrumbs.click();
    }

   
    // WebElement to decrease the quantity
    @FindBy (xpath="//span[@class='qty-minus']")
    WebElement decreaseTheQunatity;
    // Method to click on decreasing quantity
    public void clickOndecreaseTheQunatity() throws InterruptedException {
        if (decreaseTheQunatity.isEnabled()) {
            for(int i=1; i<=5; i++) {
                decreaseTheQunatity.click();
                Thread.sleep(1000);
            }
        } else {
            System.out.println("decrease quantity is not enabled");
        }
        Thread.sleep(1000);
    }

    // WebElement to increase the quantity
    @FindBy(xpath="//span[@class='qty-plus']")
    WebElement increaseTheQuantity;

    // Method to click on increasing quantity
    public void clickInIncreaseQuantity() throws InterruptedException {
        if (increaseTheQuantity.isEnabled()) {
            for(int i=1; i<=5; i++) {
                increaseTheQuantity.click();
                Thread.sleep(1000);
            }
        } else {
            System.out.println("increase quantity is not enabled");
        }
        Thread.sleep(1000);
    }

    // WebElement for adding to wishlist from PDP
    @FindBy(xpath="//button[@type='submit' and span[text()='Wishlist']]")
    WebElement wishlist;
    // Method to click on adding to wishlist
    public void clickOnWishlist() {
        wishlist.click();
    }

   
    // WebElement for the "Add to Cart" button
    @FindBy(xpath = "//button[contains(@class,'add-to-cart')]")
    WebElement CartButton;
    // Method to click on the "Add to Cart" button
    public void clickcartbutton(WebDriver driver) throws InterruptedException{
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CartButton);
        js.executeScript("arguments[0].click();", CartButton);
        Thread.sleep(2000);
    }


    // Validations for elements on the PDP page
    // Validation for product name
    public  void productNameValidation(WebDriver driver) {
        WebElement productName = driver.findElement(By.xpath("//h1[contains(@class, 'product-name hidden-sm-down')]"));
        if (productName.isDisplayed()) {
            logger.info("Product Name is displayed on the page.");
        } else {
            logger.info("Product Name is not displayed on the page.");
        }
    }

    // Validation for product image
    public  void productImageValidation(WebDriver driver) {
        WebElement productImage = driver.findElement(By.xpath("(//img[@class ='d-block img-fluid'])[1]"));
        if (productImage.isDisplayed()) {
            logger.info("Product Image is displayed on the page.");
        } else {
            logger.info("Product Image is not displayed on the page.");
        }
    }

    // Validation for product review link
    public  void productReviewLinkValidation(WebDriver driver) {
        WebElement productreviewLink = driver.findElement(By.xpath("//a[@class ='pr-snippet-write-review-link pr-underline']"));
        if (productreviewLink.isDisplayed()) {
            logger.info("Product Review Link is displayed on the page.");
        } else {
            logger.info("Product Review Link is not displayed on the page.");
        }
    }

    // Validation for product "Add to Cart" button
    public  void productAddtocartButtonValidation(WebDriver driver) {
        WebElement productAddtoCartButton = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart')]"));
        if (productAddtoCartButton.isDisplayed()) {
            logger.info("Product 'Add to Cart' button is displayed on the page.");
        } else {
            logger.info("Product 'Add to Cart' button is not displayed on the page.");
        }
    }

    // Validation for product specifications
    public  void productSepecificationsValidation(WebDriver driver) {
        WebElement productSpecs = driver.findElement(By.xpath("//h2[contains(@class, 'title') and text()='Description']"));
        if (productSpecs.isDisplayed()) {
            logger.info("Product Specifications are displayed on the page.");
        } else {
            logger.info("Product Specifications are not displayed on the page.");
        }
    }
}
