package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTest {

	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	//Reading Properties file
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	//Instantiating driver and objects
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	//closing the browser after completing each test
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	/*
	 * The Objective of this Test is to Fill the Registration form to create the Account in Retail application
	 */
	@Test
	public void validRegisterTest() {
		//Click on Account Icon
		registerPOM.clickLoginRegisterBtn();
		//Click on Login/Register
		registerPOM.clickRegisterBtn();
		//Pass username
		registerPOM.sendFirstName("Sowmya");
		//Pass lastname
		registerPOM.sendLastName("MP");
		//Pass E-mail Address
		registerPOM.sendEmail("sowmya.mps00005@gmail.com");
		//Pass Telephone
		registerPOM.sendTelephone("9686830100");
		//Pass Address1
		registerPOM.sendAddress1("BSK");
		//Pass Address2
		registerPOM.sendAddress2("Bank Colony");
		//Pass City
		registerPOM.sendCity("Bangalore");
		//Pass Pincode
		registerPOM.sendPostcode("560050");
		//Select country
		registerPOM.selectCountry("India");
		//Select Region
		registerPOM.selectRegion("Karnataka");
		//Send Password
		registerPOM.sendPassword("Test1234");
		//Send Confirm Password
		registerPOM.sendConfirmPassword("Test1234");
		//Click on NewsLetter Subscription Radio button
		registerPOM.clickNewsletterRadioBtn();
		//Click on agree checkbox
		registerPOM.clickAgreeCheckbox();
		//Click on Submit button
		registerPOM.continueSubmitBtn();
		
		String acctCreationConfirmText = registerPOM.acctCreationMessage();
		
		//Take Screenshot of for Register 
		screenShot.captureScreenShot("Register");
		
		//Asserting to check whether the Account is created
		Assert.assertEquals("Your Account Has Been Created!",acctCreationConfirmText);
		
	}
}
