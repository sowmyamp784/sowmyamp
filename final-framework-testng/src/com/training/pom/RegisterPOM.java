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
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

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
	
	
	public void clickLoginRegisterBtn() {
		Actions act = new Actions(driver);
		act.moveToElement(acctIcon).build().perform();
		this.loginRegister.click(); 
	}
	
	public void clickRegisterBtn() {
		this.registerLink.click(); 
	}
	
	public void sendFirstName(String firstName) {
		this.firstnameTextbox.clear();
		this.firstnameTextbox.sendKeys(firstName);
	}
	
	public void sendLastName(String lastName) {
		this.lastnameTextbox.clear();
		this.lastnameTextbox.sendKeys(lastName);
	}
	
	public void sendEmail(String email) {
		this.emailTextbox.clear();
		this.emailTextbox.sendKeys(email);
	}
	
	public void sendTelephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}
	
	public void sendAddress1(String address1) {
		this.address1Textbox.clear();
		this.address1Textbox.sendKeys(address1);
	}
	
	public void sendAddress2(String address2) {
		this.address2Textbox.clear();
		this.address2Textbox.sendKeys(address2);
	}
	
	public void sendCity(String city) {
		this.cityTextbox.clear();
		this.cityTextbox.sendKeys(city);
	}
	
	public void sendPostcode(String postcode) {
		this.postcodeTextbox.clear(); 
		this.postcodeTextbox.sendKeys(postcode); 
	}
	
	public void selectCountry() {
		Select country = new Select(countryIdListbox);
		country.selectByVisibleText("India");
	}
	
	public void selectRegion() {
		Select region = new Select(zoneIdListbox);
		region.selectByVisibleText("Karnataka");
	}
	
	public void sendPassword(String password) {
		this.passwordTextbox.clear(); 
		this.passwordTextbox.sendKeys(password); 
	}
	
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPasswordTextbox.clear(); 
		this.confirmPasswordTextbox.sendKeys(confirmPassword); 
	}
	
	public void clickNewsletterRadioBtn() {
		this.newsletterRadioButton.click(); 
	}
	
	public void clickAgreeCheckbox() {
		this.agreeCheckbox.click(); 
	}
	
	public void continueSubmitBtn() {
		this.continueSubmitButton.click(); 
	}
	
	public String acctCreationMessage() {
		return this.acctCreationConfirmText.getText(); 
	}
}
