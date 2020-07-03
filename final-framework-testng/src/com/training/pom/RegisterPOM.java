package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPOM {
	private WebDriver driver; 
	
	//Constructor
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * In this Register related WebElement locators and methods are initialized
	 */

	@FindBy(xpath="//i[@class='fa fa-user-o']")
	private WebElement acctIcon; 
	
	@FindBy(xpath="//span[contains(text(),'LOGIN')]")
	private WebElement loginRegister;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement registerLink; 
	
	@FindBy(xpath="//input[@type='text'][@name='firstname']")
	private WebElement firstnameTextbox; 
	
	@FindBy(xpath="//input[@type='text'][@name='lastname']")
	private WebElement lastnameTextbox; 
	
	@FindBy(xpath="//input[@type='email'][@name='email']")
	private WebElement emailTextbox; 
	
	@FindBy(xpath="//*[@name='telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@type='text'][@name='address_1']")
	private WebElement address1Textbox;
	
	@FindBy(xpath="//input[@type='text'][@name='address_2']")
	private WebElement address2Textbox;
	
	@FindBy(xpath="//input[@type='text'][@name='city']")
	private WebElement cityTextbox;
	
	@FindBy(xpath="//input[@type='text'][@name='postcode']")
	private WebElement postcodeTextbox;
	
	@FindBy(xpath="//select[@name='country_id']")
	private WebElement countryIdListbox;
	
	@FindBy(xpath="//select[@name='zone_id']")
	private WebElement zoneIdListbox;
	
	@FindBy(xpath="//input[@type='password'][@name='password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@type='password'][@name='confirm']")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(xpath="//label[contains(text(),'Yes')]")
	private WebElement newsletterRadioButton;
	
	@FindBy(xpath="//input[@type='checkbox'][@name='agree']")
	private WebElement agreeCheckbox;
	
	@FindBy(xpath="//input[@type='submit'][@value='Continue']")
	private WebElement continueSubmitButton;
	
	@FindBy(xpath="//p[contains(text(),'Congratulations! Your new account has been success')]")
	private WebElement acctCreationConfirmText;
	
	//Method to Mouse over to Account Icon
	public void clickLoginRegisterBtn() {
		Actions act = new Actions(driver);
		act.moveToElement(acctIcon).build().perform();
		this.loginRegister.click(); 
	}
	
	//Method to Click Login/Register button
	public void clickRegisterBtn() {
		this.registerLink.click(); 
	}
	
	//Method to Enter FirstName
	public void sendFirstName(String firstName) {
		this.firstnameTextbox.clear();
		this.firstnameTextbox.sendKeys(firstName);
	}
	
	//Method to Enter LastName
	public void sendLastName(String lastName) {
		this.lastnameTextbox.clear();
		this.lastnameTextbox.sendKeys(lastName);
	}
	
	//Method to Enter Email
	public void sendEmail(String email) {
		this.emailTextbox.clear();
		this.emailTextbox.sendKeys(email);
	}
	
	//Method to Enter Telephone
	public void sendTelephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}
	
	//Method to Enter Address1
	public void sendAddress1(String address1) {
		this.address1Textbox.clear();
		this.address1Textbox.sendKeys(address1);
	}
	
	//Method to Enter Address2
	public void sendAddress2(String address2) {
		this.address2Textbox.clear();
		this.address2Textbox.sendKeys(address2);
	}
	
	//Method to Enter City
	public void sendCity(String city) {
		this.cityTextbox.clear();
		this.cityTextbox.sendKeys(city);
	}
	
	//Method to Enter Postcode
	public void sendPostcode(String postcode) {
		this.postcodeTextbox.clear(); 
		this.postcodeTextbox.sendKeys(postcode); 
	}
	
	//Method to select Country
	public void selectCountry() {
		Select country = new Select(countryIdListbox);
		country.selectByVisibleText("India");
	}
	
	//Method to select Region
	public void selectRegion() {
		Select region = new Select(zoneIdListbox);
		region.selectByVisibleText("Karnataka");
	}
	
	//Method to Enter Password
	public void sendPassword(String password) {
		this.passwordTextbox.clear(); 
		this.passwordTextbox.sendKeys(password); 
	}
	
	//Method to Enter Confirm Password
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPasswordTextbox.clear(); 
		this.confirmPasswordTextbox.sendKeys(confirmPassword); 
	}
	
	//Method to Click News Letter Radio Button
	public void clickNewsletterRadioBtn() {
		this.newsletterRadioButton.click(); 
	}
	
	//Method to agree the T&C checkbox
	public void clickAgreeCheckbox() {
		this.agreeCheckbox.click(); 
	}
	
	//Method to Click Submit Registration Form
	public void continueSubmitBtn() {
		this.continueSubmitButton.click(); 
	}
	
	//Method to get the text when the Account is created
	public String acctCreationMessage() {
		return this.acctCreationConfirmText.getText(); 
	}
}
