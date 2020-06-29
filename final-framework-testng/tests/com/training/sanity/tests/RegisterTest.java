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
import com.training.pom.AdminLoginPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTest {

	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validRegisterTest() {
		registerPOM.clickLoginRegisterBtn();
		registerPOM.clickRegisterBtn();
		registerPOM.sendFirstName("Sowmya");
		registerPOM.sendLastName("MP");
		registerPOM.sendEmail("sowmya.mp5@gmail.com");
		registerPOM.sendTelephone("9686830100");
		registerPOM.sendAddress1("BSK");
		registerPOM.sendAddress2("Bank Colony");
		registerPOM.sendCity("Bangalore");
		registerPOM.sendPostcode("560050");
		registerPOM.selectCountry();
		registerPOM.selectRegion();
		registerPOM.sendPassword("Test1234");
		registerPOM.sendConfirmPassword("Test1234");
		registerPOM.clickNewsletterRadioBtn();
		registerPOM.clickAgreeCheckbox();
		registerPOM.continueSubmitBtn();
		String acctCreationConfirmText = registerPOM.acctCreationMessage();
		screenShot.captureScreenShot("Register");
		Assert.assertEquals("Congratulations! Your new account has been successfully created!", acctCreationConfirmText);
		
	}
}
