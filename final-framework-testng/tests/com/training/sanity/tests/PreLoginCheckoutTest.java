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
import com.training.pom.LoginPOM;
import com.training.pom.PreLoginCheckoutPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PreLoginCheckoutTest {

	private WebDriver driver;
	private String baseUrl;
	private PreLoginCheckoutPOM preLoginCheckoutPOM;
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
		preLoginCheckoutPOM = new PreLoginCheckoutPOM(driver); 
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
	 * The Objective of this Test is to check user lands in Login Page before Checkout when the user is not logged into the retail application
	 */
	@Test
	public void preLoginCheckout() {
		//Click on Shop Link
		preLoginCheckoutPOM.clickShopLink();
		//Click on Ethnic Link
		preLoginCheckoutPOM.clickEthnicLink();
		//Sort the products to get the desired product
		preLoginCheckoutPOM.sortBy();
		//Click on the product
		preLoginCheckoutPOM.clickProduct();
		//Click on Quick view
		preLoginCheckoutPOM.clickQuickView();
		//Click on Add to cart
		preLoginCheckoutPOM.clickAddToCartBtn();
		//Click on Add to cart
		preLoginCheckoutPOM.clickOnCart();
		//Click on View cart
		preLoginCheckoutPOM.clickViewCartBtn();
		//Click on Checkout
		preLoginCheckoutPOM.clickCheckoutBtn();
		
		String newCustText = preLoginCheckoutPOM.newCustomerText();
		
		//Take Screenshot of Pre Login Checkout Page
		screenShot.captureScreenShot("Pre_Login_Checkout");
		
		//Assert to check user lands in New Customer screen
		Assert.assertEquals("New Customer", newCustText);
	}
}
