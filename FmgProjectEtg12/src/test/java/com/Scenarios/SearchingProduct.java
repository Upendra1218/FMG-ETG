package com.Scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.PageObjects.homePage;
import com.commonfunctionality.addtoCartValidation;

import com.providio.testcases.baseClass;

public class SearchingProduct extends baseClass{

	public  void searchingProduct() throws InterruptedException {

		
   	  //searching a product
       homePage homepage = new homePage(driver);
       homepage.clickOnSearchBar(this.searchBar);
       test.info("searched a product " + this.searchBar);
       
       //clicked on searched product
       homepage.clickOnSearchedProduct();
       test.info("clicked on searched product");
   
		
		 List<WebElement> pdpPage = driver.findElements(By.xpath("//button[contains(@class,'add-to-cart btn btn-primary')]"));
		 if( pdpPage.size()>0) {
			   //validating the product is add to the cart
			   addtoCartValidation.validatingProductisAddtoCart(driver);
		 }
		  
	

	}

}
