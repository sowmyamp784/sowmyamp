package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginAndPlaceOrderPOM {
	private WebDriver driver;

	//Constructor
	public LoginAndPlaceOrderPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * In this for Placing order related WebElement locators and methods are initialized
	 */
	@FindBy(xpath = "//input[@id='button-payment-address']")
	private WebElement billingDetailContinueBtn;

	@FindBy(xpath = "//input[@id='button-shipping-address']")
	private WebElement deliveryDetailsContinueBtn;

	@FindBy(xpath = "//textarea[@name='comment']")
	private WebElement commentBoxTextArea;

	@FindBy(xpath = "//input[@id='button-shipping-method']")
	private WebElement deliveryMethodContinueBtn;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement termsAndConditionsCheckbox;

	@FindBy(xpath = "//input[@id='button-payment-method']")
	private WebElement paymentMethodContinueBtn;

	//@FindBy(xpath = "//input[@id='button-confirm']")
	@FindBy(xpath = "//input[@type='button'][@id='button-confirm']")
	private WebElement confirmOrderBtn;

	@FindBy(xpath = "//p[contains(text(),'Your order has been successfully processed!')]")
	private WebElement orderConfirmationMessage;

	//Method to click continue button in Billing Details
	public void billingDetails() {
		this.billingDetailContinueBtn.click();
	}

	//Method to click continue button in Delivery Details
	public void deliveryDetails() {
		this.deliveryDetailsContinueBtn.click();
	}
	
	//Method to Enter comments and Click on Continue Button in Delivery Method
	public void deliveryMethod() {
		this.commentBoxTextArea.click();
		this.commentBoxTextArea.sendKeys("This product is very nice");
		this.deliveryMethodContinueBtn.click();
	}
	
	//Method to Click on T&C Checkbox and Click on Continue Button in Payment Method
	public void paymentMethod() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", termsAndConditionsCheckbox); 
		this.termsAndConditionsCheckbox.click();
		//or directly click the checkbox by commenting line 72,73
		//jse.executeScript("arguments[0].click();", termsAndConditionsCheckbox);
		
		this.paymentMethodContinueBtn.click();
	}
	
	//Method to Click on Confirm Order
	public void confirmOrder() {
		this.confirmOrderBtn.click();
	}
	
	//Method to get the Text when order is confirmed
	public String confirmOrderMessage() {
		return this.orderConfirmationMessage.getText();
	}
}
