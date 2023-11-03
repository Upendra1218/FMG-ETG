package com.GuestUserWith_CreditCard;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MinicartViewCartProcess;
import com.Scenarios.homePagePlp;
import com.testcases.baseClass;

public class tc__HomePageBannerPLPInCC extends baseClass {
    
    @Test//(invocationCount=5)
    public void HomePageBannerPLP() throws InterruptedException {
        // Launch the browser and navigate to the URL
        launchBrowsering lb = new launchBrowsering();
        lb.chromeBrowser();

        // Execute the scenario to navigate to the PLP page from the home page banner
        homePagePlp.homePagePLP();

        // Initialize MinicartViewCartProcess to perform the checkout process
        MinicartViewCartProcess cartProcess = new MinicartViewCartProcess();
        // Perform the checkout process
        cartProcess.checkoutprocess();

        // Initialize CreditCardPaymentProcess to perform the payment using a credit card
        CreditCardPaymentProcess ccPaymentProcess = new CreditCardPaymentProcess();
        // Perform the payment using a credit card
        ccPaymentProcess.paymentByCreditCard();
    }
}
