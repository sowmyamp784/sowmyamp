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

import com.aventstack.extentreports.Status;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		loginPOM = new LoginPOM(driver); 
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
	 * The Objective of this test is to Login to the Retail application with Valid Credentials
	 */
	@Test(priority = 1)
	public void validLoginTest() {
		//Click on Account Icon
		loginPOM.clickLoginRegisterBtn();
		//Send username
		loginPOM.sendUserName("sowmya.mp@gmail.com");
		//Send password
		loginPOM.sendPassword("Test1234");
		//Click on Login Button
		loginPOM.clickLoginBtn(); 
		
		String pageTitle = driver.getTitle();
		
		//Take Screen shot of Login Page
		screenShot.captureScreenShot("Login");
		
		//Assert to Check user logged in successufully
		Assert.assertEquals("My Account", pageTitle);
	}
	
	/*
	 * The Objective of this test is to check Login fails when No match for E-Mail Address and/or Password in Retail application
	 */
	@Test(priority = 2)
	public void invalidLoginTest() {
		//Click on Account Icon
		loginPOM.clickLoginRegisterBtn();
		//Send Invalid username
		loginPOM.sendUserName("sowmya.mp5@gmail.com");
		//Send Invalid Password
		loginPOM.sendPassword("Test12345");
		//Click on Login Button
		loginPOM.clickLoginBtn(); 
		
		String invalidAcctMsgText = loginPOM.invalidAcctMessage();
		
		//Take Screen shot of Invalid Login Page
		screenShot.captureScreenShot("Invalid_Login");
		
		//Assert to check Warning message is displayed
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", invalidAcctMsgText );
	}
}
