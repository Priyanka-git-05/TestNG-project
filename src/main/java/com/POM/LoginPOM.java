package com.POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPOM {
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	public  LoginPOM (WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
	
}
