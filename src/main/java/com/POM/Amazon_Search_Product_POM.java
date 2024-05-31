package com.POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class Amazon_Search_Product_POM extends BaseClass{
	
	public WebDriver driver;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBar;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement goBtn;
	
	@FindBy(xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
	private WebElement product1;
	
	@FindBy(xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement product2;
	
	@FindBy(xpath="(//span[@class='a-size-base-plus a-color-base a-text-normal'])[3]")
	private WebElement product3;

	@FindBy(id="add-to-cart-button")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="(//input[@id='add-to-cart-button'])[2]")
	private WebElement addToCartBtn2;

	@FindBy(xpath="(//a[@class='a-button-text'])[1]")
	private WebElement goToCartBtn;
	
	@FindBy(name="proceedToRetailCheckout")
	private WebElement proceedToBuy;
	
	@FindBy(xpath="//input[@data-testid='Address_selectShipToThisAddress']")
	private WebElement defaultAddressbtn;
	
	@FindBy(name="ppw-instrumentRowSelection")
	private WebElement cardRadioBtn;
	
	@FindBy(xpath="(//a[contains(text(),'Enter')])[1]")
	private WebElement enterCardDetail;
	
	@FindBy(name="addCreditCardNumber")
	private WebElement cardsNum;
	
	@FindBy(name="ppw-widgetEvent:AddCreditCardEvent")
	private WebElement submitBtn;
	
	@FindBy(xpath="(//span[@class='a-list-item'])[1]")
	private WebElement errormsg;
	
	 public Amazon_Search_Product_POM(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public void searchProduct1() {
		launchURL(driver, "https://www.amazon.in/", 5); 
		passValue(driver, searchBar, "umbrella for women", 5);
		clickTheElement(driver, goBtn, 5);
		scroll(driver, 0, 500);
		clickTheElement(driver, product1,10);
		//Add to cart
		windowHandles();
		clickTheElement(driver, addToCartBtn, 5);
		clickTheElement(driver, goToCartBtn, 5);
		
	}
	
	public void searchProduct2() {
		passValue(driver, searchBar, "redmi note 13 pro", 5);
		clickTheElement(driver, goBtn, 5);
		scroll(driver, 0, 100);
		clickTheElement(driver, product2,5);
		windowHandles();
		scroll(driver, 0, 200);
		//Add to cart
		clickTheElement(driver, addToCartBtn,5);
		staticwait(20000);
		clickTheElement(driver, goToCartBtn, 5);
		scroll(driver, 0, 100);
		}
	
	public void searchProduct3() {
		passValue(driver, searchBar, "furniture for kitchen", 5);
		clickTheElement(driver, goBtn, 5);
		scroll(driver, 0, 100);
		clickTheElement(driver, product3,5);
		windowHandles();
		//Add to cart
		clickTheElement(driver, addToCartBtn,5);
		implicitWait(10);
		clickTheElement(driver, goToCartBtn, 5);
		scroll(driver, 0, 200);
		}
	
	public void payment() {
		clickTheElement(driver, proceedToBuy, 5);
		clickTheElement(driver, defaultAddressbtn, 10);
		staticwait(10000);
		scroll(driver, 0, 500);
		implicitWait(10);
		clickTheElement(driver, cardRadioBtn, 5);
		clickTheElement(driver, enterCardDetail, 5);
		frame(0);
		passValue(driver, cardsNum, "4892 7864 5152", 5);
		clickTheElement(driver, submitBtn, 5);
		Assert.assertEquals(errormsg.getText(), "Card number is not correct.");
	}


}