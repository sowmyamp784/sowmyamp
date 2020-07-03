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
import com.training.pom.LoginAndPlaceOrderPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PreLoginCheckoutPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginAndPlaceOrderTest{

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private PreLoginCheckoutPOM preLoginCheckoutPOM;
	private LoginAndPlaceOrderPOM loginAndPlaceOrderPOM;
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
		preLoginCheckoutPOM = new PreLoginCheckoutPOM(driver);
		loginAndPlaceOrderPOM = new LoginAndPlaceOrderPOM(driver);
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
	 * The Objective of this Test is to check user is able to Login and Place Order in Retail Application
	 */
	@Test
	public void loginCheckout() {
		//Login to the retail Application with proper credentials
		loginPOM.clickLoginRegisterBtn();
		loginPOM.sendUserName("sowmya.mp@gmail.com");
		loginPOM.sendPassword("Test1234");
		loginPOM.clickLoginBtn(); 
		
		//Add desired product and Navigate to Checkout
		preLoginCheckoutPOM.clickShopLink();
		preLoginCheckoutPOM.clickEthnicLink();
		preLoginCheckoutPOM.sortBy();
		preLoginCheckoutPOM.clickProduct();
		preLoginCheckoutPOM.clickQuickView();
		preLoginCheckoutPOM.clickAddToCartBtn();
		preLoginCheckoutPOM.clickOnCart();
		preLoginCheckoutPOM.clickViewCartBtn();
		preLoginCheckoutPOM.clickCheckoutBtn();
		
		//Confirm order by providing Billing details, Delivery Method, Payment Method and confirm the order
		loginAndPlaceOrderPOM.billingDetails();
		loginAndPlaceOrderPOM.deliveryDetails();
		loginAndPlaceOrderPOM.deliveryMethod();
		loginAndPlaceOrderPOM.paymentMethod();
		loginAndPlaceOrderPOM.confirmOrder();
		
		String confirmOrderText = loginAndPlaceOrderPOM.confirmOrderMessage();
		
		//Take the screenshot of Login and Placing order page
		screenShot.captureScreenShot("Login_Checkout");
		
		//Assert to check whether the order is place successfully
		Assert.assertEquals("Your order has been successfully processed!", confirmOrderText);
	}
}
