package com.POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class AmazonLoginPOM extends BaseClass {
	
	public WebDriver driver;
	
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	private WebElement signInBtn;
	
	@FindBy(name="email")
	private WebElement mobileNumField;
	
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[@class='a-list-item']")
	private WebElement errorMsg;
	
	public AmazonLoginPOM(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
		}
	
	public boolean validLogin(ExtentTest extenttest) {
		try {
			implicitWait(30);
			launchURL(driver, "https://www.amazon.in/", 5);
			clickTheElement(driver, signInBtn, 5);
			passValue(driver, mobileNumField, "8610872002", 5);
			clickTheElement(driver, continueBtn, 5);
			passValue(driver,passwordField,"Yak@123" , 5);
			clickTheElement(driver, submitBtn, 5);
			String title = driver.getTitle();
			Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
			extenttest.log(Status.PASS, "Login Sucessfull");
			} 
			catch (AssertionError e) {
			extenttest.log(Status.FAIL, "Login Failed"+ e.getMessage());
		return false;
			}
		return true;
		}
	
	public void invalidLogin() {
		launchURL(driver, "https://www.amazon.in/", 5);
		clickTheElement(driver, signInBtn, 5);
		passValue(driver, mobileNumField, "8610872002", 5);
		clickTheElement(driver, continueBtn, 5);
		passValue(driver,passwordField,"yak@123" , 5);
		clickTheElement(driver, submitBtn, 5);
		Assert.assertEquals(errorMsg.getText(),"Your password is incorrect");
	}
	
	}
	

