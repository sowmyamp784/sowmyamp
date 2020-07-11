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

import com.training.dataproviders.RegisterDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterDBTest {
	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	// Reading Properties file
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	// Instantiating driver and objects
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPOM = new RegisterPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	// closing the browser after completing each test
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	/*
	 * The Objective of this Test is to Fill the Registration form to create the
	 * Account in Retail application by fetching data from DataBase
	 */
	@Test(dataProvider = "db-inputs", dataProviderClass = RegisterDataProviders.class)
	public void registerDBTest(String fName, String lName, String email, String tel, String add1, String add2,
			String city, String pcode, String country, String region, String password, String confirmPass) {
		// Click on Account Icon
		registerPOM.clickLoginRegisterBtn();
		// Click on Login/Register
		registerPOM.clickRegisterBtn();
		// Pass username
		registerPOM.sendFirstName(fName);
		// Pass lastname
		registerPOM.sendLastName(lName);
		// Pass E-mail Address
		registerPOM.sendEmail(email);
		// Pass Telephone
		registerPOM.sendTelephone(tel);
		// Pass Address1
		registerPOM.sendAddress1(add1);
		// Pass Address2
		registerPOM.sendAddress2(add2);
		// Pass City
		registerPOM.sendCity(city);
		// Pass Pincode
		registerPOM.sendPostcode(pcode);
		// Select country
		registerPOM.selectCountry(country);
		// Select Region
		registerPOM.selectRegion(region);
		// Send Password
		registerPOM.sendPassword(password);
		// Send Confirm Password
		registerPOM.sendConfirmPassword(confirmPass);
		// Click on NewsLetter Subscription Radio button
		registerPOM.clickNewsletterRadioBtn();
		// Click on agree checkbox
		registerPOM.clickAgreeCheckbox();
		// Click on Submit button
		registerPOM.continueSubmitBtn();

		String acctCreationConfirmText = registerPOM.acctCreationMessage();

		// Take Screenshot of for Register
		screenShot.captureScreenShot("Register_Using_DB");

		// Asserting to check whether the Account is created
		Assert.assertEquals("Your Account Has Been Created!", acctCreationConfirmText);
	}

}