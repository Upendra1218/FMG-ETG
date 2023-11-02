import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.navigationProcess;
import com.PageObjects.productListingPage;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MinicartViewCartProcess;
import com.providio.testcases.baseClass;

public class bulkOrdersPlacing extends baseClass{


	@Test(invocationCount = 5)
    public void guestlogin() throws InterruptedException {
    	
    	//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();
		
		//selects a random catgory and product add to cart
		navigationProcess navProccess = new navigationProcess(driver);
        navProccess.selectRandomMenu(driver);
        
        //click add to cart button
        productListingPage plp = new productListingPage(driver);
        plp.addToCartFromPlp();
        
    	
        //check out process
	     MinicartViewCartProcess cp = new MinicartViewCartProcess();			     
	     cp.checkoutprocess();
	    
	     //Payment process		     
	     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
	     cc.paymentByCreditCard();
	     
	     Thread.sleep(3000);
		}
    
}
