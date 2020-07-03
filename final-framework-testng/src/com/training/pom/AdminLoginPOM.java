package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPOM {
	private WebDriver driver; 
	
	//Constructor
	public AdminLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	/*
	 * In this Admin Login WebElement locators and methods are initialized
	 */

	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	//Method to enter Username
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	//Method to enter Password
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	//Method for Clicking Login button in Admin Page
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
}
