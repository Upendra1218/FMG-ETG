package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    WebDriver lDriver;

    // Constructor for the loginPage class
    public loginPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    // Element for Sign In button
    @FindBy(xpath = "//span[contains(text(), 'Sign In')]")
    WebElement signIn;

    // Method to click on the Sign In button
    public void clickSign() {
        signIn.click();
    }

    // Element for email input field
    @FindBy(name = "loginEmail")
    WebElement email;

    // Method to set the email input field
    public void setEmail(String name) {
        email.clear();
        email.sendKeys(name);
    }

    // Element for password input field
    @FindBy(name = "loginPassword")
    WebElement Password;

    // Method to set the password input field
    public void setPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }

    // Element for Login button
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    WebElement btnLogin;

    // Method to click the Login button with a sleep
    public void clickSubmit() throws InterruptedException {
        btnLogin.click();
        Thread.sleep(10000);
    }

    // Element for Login button (JavaScript click)
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    WebElement btnLoginjs;

    // Method to click the Login button using JavaScript with a sleep
    public void clickSubmitjs(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnLoginjs);
        btnLogin.click();
        Thread.sleep(10000);
    }

    // Element for Home page logo
    @FindBy(xpath = "//img[@class='logo']")
    WebElement forHomePage;

    // Method to click on the Home page logo using JavaScript with a sleep
    public void clickOnLogo(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", forHomePage);
    }
}
