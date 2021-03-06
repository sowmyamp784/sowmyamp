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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminLoginTest {

	private WebDriver driver;
	private String baseUrl;
	private AdminLoginPOM adminLoginPOM;
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
		adminLoginPOM = new AdminLoginPOM(driver); 
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
	 * The Objective of this Test is to Login to Admin page with Admin Credentials
	 */
	@Test
	public void validAdminLoginTest() {
		//Enter admin username
		adminLoginPOM.sendUserName("admin");
		//Enter admin password
		adminLoginPOM.sendPassword("admin@123");
		//click on Admin Login Button
		adminLoginPOM.clickLoginBtn(); 
		
		String adminDashboard = driver.getTitle();
		
		//Taking Screenshot for Admin Logged in Page
		screenShot.captureScreenShot("Admin_Login");
		
		//Assert to check user is in Admin Dashboard page after login
		Assert.assertEquals("Dashboard", adminDashboard, "This is admin Dashboard");
	}
}
