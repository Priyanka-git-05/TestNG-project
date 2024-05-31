package com.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.poma.PageObjectManager;
import com.property.FileReaderManager;


public class OrangeRunner extends BaseClass{
	PageObjectManager poma = new PageObjectManager();
	
	@BeforeTest
	public void browserLaunch() {
		launchTheBrowser("chrome");
		String url = FileReaderManager.getInstanseFileReaderManager().getInstanceConfig().getURL();
		launchURL(driver, url,30);
	}
	@Test(priority = 1)
	public void login() {
		implicitWait(30);
		String username = FileReaderManager.getInstanseFileReaderManager().getInstanceConfig().getusername();
		passValue(driver, poma.getLoginpage().getUsername(), username, 10);
		String password = FileReaderManager.getInstanseFileReaderManager().getInstanceConfig().getpassword();
		passValue(driver,poma.getLoginpage().getPassword(), password, 10);
		clickTheElement(driver, poma.getLoginpage().getLogin(), 10);
	}	
	@Test(priority = 2)
	public void admin() {
		clickTheElement(driver, poma.getAdminpage().getAdminbtn(), 10);
		clickTheElement(driver, poma.getAdminpage().getAddbtn(), 10);
		String employeename = FileReaderManager.getInstanseFileReaderManager().getInstanceConfig().getEmployeename();
		passValue(driver, poma.getAdminpage().getEmployeeField(),employeename,5);
		String name = poma.getAdminpage().getAdminUserName().getText();
		passValue(driver, poma.getAdminpage().getAdminuser(),name, 5);
		String password2 = FileReaderManager.getInstanseFileReaderManager().getInstanceConfig().getpassword2();
		passValue(driver, poma.getAdminpage().getPass1(), password2,5);
		passValue(driver, poma.getAdminpage().getPass2(), password2,5);
	}
//	@AfterTest
//	public void EndSetup() {
//		terminateBrowser(driver);
//	}
}


