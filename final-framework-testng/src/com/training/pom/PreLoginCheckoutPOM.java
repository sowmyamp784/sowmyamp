package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PreLoginCheckoutPOM {
	private WebDriver driver;

	//Constructor
	public PreLoginCheckoutPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * In this Pre Login Checkout related WebElement locators and methods are initialized
	 */
	@FindBy(xpath = "//span[contains(text(),'Shop')]")
	private WebElement shopLink;

	@FindBy(xpath = "//span[contains(text(),'Ethnic')]")
	private WebElement ethnicLink;

	@FindBy(xpath = "//div[@class='sort']//select")
	private WebElement sortBy;

	@FindBy(xpath = "//div[@class='col col-xs-fill']//a[contains(text(),'Integer vitae iaculis massa')]")
	private WebElement selectProduct;

	@FindBy(xpath = "//text()[contains(.,'Quickview')]/ancestor::a[1]")
	private WebElement quickView;

	@FindBy(xpath = "//div[@class='modal-body']//iframe")
	private WebElement switchFrame;

	@FindBy(xpath = "//button[text()='Add to Cart']")
	private WebElement addToCart;

	@FindBy(xpath = "//i[@class='tb_icon ico-linea-ecommerce-bag']")
	private WebElement bagIcon;

	@FindBy(xpath = "//a[contains(text(),'View Cart')]")
	private WebElement viewCart;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement checkoutBtn;

	@FindBy(xpath = "//h2[contains(text(),'New Customer')]")
	private WebElement newCustomer;

	//Method to click on Shop Link
	public void clickShopLink() {
		Actions act = new Actions(driver);
		act.moveToElement(shopLink).build().perform();
		this.shopLink.click();
	}

	//Method to click on Ethnic Link
	public void clickEthnicLink() {
		this.ethnicLink.click();
	}

	//Method Sort the Products
	public void sortBy() {
		this.sortBy.click();
		WebElement SortByLabel = sortBy;
		Select sortByText = new Select(SortByLabel);
		sortByText.selectByVisibleText("Rating (Highest)");
	}
	
	//Method to Click on Product
	public void clickProduct() {
		this.selectProduct.click();
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println(parentWindowHandle);
		driver.switchTo().window(parentWindowHandle);
	}
	
	//Method to click on quickview
	public void clickQuickView() {
		driver.navigate().refresh();
		Actions mouseOverProduct = new Actions(driver);
		mouseOverProduct.moveToElement(quickView).build().perform();
		this.quickView.click();
	}
	
	//Method to add product
	public void clickAddToCartBtn() {
		driver.switchTo().frame(switchFrame);
		this.addToCart.click();
		driver.navigate().refresh();
	}
	
	//Method to click on Cart Icon
	public void clickOnCart() {
		Actions mouseOverCart = new Actions(driver);
		mouseOverCart.moveToElement(bagIcon).build().perform();
	}
	
	//Method to click on View Cart
	public void clickViewCartBtn() {
		this.viewCart.click();
	}
	
	//Method to Click on Checkout Button
	public void clickCheckoutBtn() {
		this.checkoutBtn.click();
	}
	
	//Method to check and get Text of New customer element if the user lands in Login page
	public String newCustomerText() {
		//return this.newCustomer.getText();
		return driver.getTitle();
	}
}
