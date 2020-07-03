package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverPasswordPOM {
	private WebDriver driver; 
	
	//Constructor
	public RecoverPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * In this Recover Password related WebElement locators and methods are initialized
	 */
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement acctIcon; 
	
	@FindBy(xpath="//span[contains(text(),'LOGIN')]")
	private WebElement loginRegister;
	
	@FindBy(xpath="//a[contains(text(),'Forgotten Password')]")
	private WebElement forgotPassword;
	
	@FindBy(id="input-email")
	private WebElement userName; 
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement continueBtn; 
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement alertSuccess; 
	
	//Method to Mouse over to Account Icon
	public void clickLoginRegisterBtn() {
		Actions act = new Actions(driver);
		act.moveToElement(acctIcon).build().perform();
		this.loginRegister.click();
	}
	
	//Method to Click ForgotPassword
	public void clickForgotPasswordBtn() {
		this.forgotPassword.click(); 
	}
	
	//Method to Enter Username
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	//Method to Click on Continue Button
	public void clickContinueBtn() {
		this.continueBtn.click(); 
	}
	
	//Method to get the text when Recover Password is sucessful
	public String alertSuccessMessage() {
		return this.alertSuccess.getText(); 
	}
}
