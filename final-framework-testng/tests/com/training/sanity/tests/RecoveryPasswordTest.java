package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RecoverPasswordPOM;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RecoveryPasswordTest {

	private WebDriver driver;
	private String baseUrl;
	private RecoverPasswordPOM recoverPasswordPOM;
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
		recoverPasswordPOM = new RecoverPasswordPOM(driver); 
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
	public void validLoginTest() {
		recoverPasswordPOM.clickLoginRegisterBtn();
		recoverPasswordPOM.clickForgotPasswordBtn();
		recoverPasswordPOM.sendUserName("sowmya.mp@gmail.com");
		recoverPasswordPOM.clickContinueBtn(); 
		String alertText = recoverPasswordPOM.alertSuccessMessage();
		screenShot.captureScreenShot("Recovery_Password");
		Assert.assertEquals("An email with a confirmation link has been sent your email address.", alertText);
	}
}
