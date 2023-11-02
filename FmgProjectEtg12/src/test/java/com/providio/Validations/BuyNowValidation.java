package com.providio.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

public class BuyNowValidation extends baseClass{

	
	public void buynow(WebDriver driver) {
		//validating the shiiping and address and crdit card detils ,and price of product
		List<WebElement> shippingAddressList= driver.findElements(By.xpath("(//div[@class='ship-to-block'])[1]"));
		if(shippingAddressList.size()>0) {
			//shipping address showing in buynow pop up is  (//div[contains(@class,'card-body-positioning')])[1]
			WebElement shippingAddress= driver.findElement(By.xpath("(//div[@class='ship-to-block'])[1]"));
			test.info(shippingAddress.getText());
			
			//price of product on pdp page
			WebElement priceParentDiv= driver.findElement(By.xpath("//div[@class='prices pull-left']"));
			WebElement priceInPdp= priceParentDiv.findElement(By.xpath("//span[@class='value']"));
			test.info("Price of prodcut in PDP is " + priceInPdp.getText());
			
			//price on buy now pop up
			WebElement priceOnBuyNow= priceParentDiv.findElement(By.xpath("(//div[@class='paywithblock'])[2]"));
			
			String  priceOnBuyNowPopUp= priceOnBuyNow.getText();
			test.info("Price of prodcut in PDP is " + priceOnBuyNowPopUp);
			
			if (priceOnBuyNowPopUp.matches("\\d+")) {
				int priceOnBuyNowValue = Integer.parseInt(priceOnBuyNowPopUp);
				System.out.println("The price is " +priceOnBuyNowValue);
				if(priceOnBuyNowValue> 0.00) {
					
				}
			}
		}	
	}
}
