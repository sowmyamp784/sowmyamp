package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	//Constructor
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * In this Login related WebElement locators and methods are initialized
	 */
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement acctIcon; 
	
	@FindBy(xpath="//span[contains(text(),'LOGIN')]")
	private WebElement loginRegister;
	
	@FindBy(id="input-email")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement loginBtn; 
		
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement warningMsg; 
	
	//Method to Mouse over to Account Icon
	public void clickLoginRegisterBtn() {
		Actions act = new Actions(driver);
		act.moveToElement(acctIcon).build().perform();
		this.loginRegister.click();
	}
	
	//Method to Enter Username
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	//Method to Enter Password
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	//Method to Enter Login Button
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	//Method to get Text when No match for E-Mail Address and/or Password
	public String invalidAcctMessage() {
		return this.warningMsg.getText(); 
	}
}
