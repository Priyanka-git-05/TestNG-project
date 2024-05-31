package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPOM {

	public WebDriver driver;

	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")
	private WebElement adminbtn;

	@FindBy(xpath = "(//button[@type='button'])[5]")
	private WebElement addbtn;

	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	private WebElement userRoleField;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement adminuser;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement employeeField;

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement adminUserName;
	
	@FindBy(xpath="(//input[@type='password'])[1]")
	private WebElement pass1;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement pass2;

	public AdminPOM(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getAdminbtn() {
		return adminbtn;
	}

	public WebElement getAdminuser() {
		return adminuser;
	}

	public WebElement getAddbtn() {
		return addbtn;
	}

	public WebElement getUserRoleField() {
		return userRoleField;
	}

	public WebElement getEmployeeField() {
		return employeeField;
	}

	public WebElement getAdminUserName() {
		return adminUserName;
	}

	public WebElement getPass1() {
		return pass1;
	}
	public WebElement getPass2() {
		return pass2;
	}

	
	

}
