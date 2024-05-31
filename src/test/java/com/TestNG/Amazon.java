package com.TestNG;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.POM.AmazonLoginPOM;
import com.POM.Amazon_Search_Product_POM;
import com.base.BaseClass;
import com.listen.ITestListener_Class;

@Listeners(ITestListener_Class.class)
public class Amazon extends BaseClass {

	public static WebDriver driver;

	@BeforeSuite
	public void extentstartup() {
		extendReportStart("D:\\eclipse\\eclipse\\TestNG\\ExtentReport");
	}

	@BeforeTest
	public void setup() {
		driver = BaseClass.launchTheBrowser("Chrome");
	}

	@Test(priority = 2)
	public void ValidLoginTest() {
		ExtentReport_Test.extentTest = extentReports
				.createTest("LoginTest" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid Credentials");
		AmazonLoginPOM login = new AmazonLoginPOM(driver);
		Assert.assertTrue(login.validLogin(ExtentReport_Test.extentTest));

	}

	@Test(priority = 1)
	public void InvalidLogin() {
		ExtentReport_Test.extentTest = extentReports
				.createTest(
						"InvalidLoginTest" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Invalid Credentials");
		AmazonLoginPOM login = new AmazonLoginPOM(driver);
		login.invalidLogin();
	}

	@Test(dependsOnMethods = "ValidLoginTest")
	public void Umbrella() {
		ExtentReport_Test.extentTest = extentReports
				.createTest("Search Product One" + ":"
						+ Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Search Product One");
		Amazon_Search_Product_POM search = new Amazon_Search_Product_POM(driver);
		search.searchProduct1();
	}

	@Test(priority = 4)
	public void MobilePhone() {
		ExtentReport_Test.extentTest = extentReports
				.createTest("Search Product Two" + ":"
						+ Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Search Product Two");
		Amazon_Search_Product_POM search = new Amazon_Search_Product_POM(driver);
		search.searchProduct2();
	}

	@Test(priority = 5)
	public void Furniture() {
		ExtentReport_Test.extentTest = extentReports
				.createTest("Search Product Three" + ":"
						+ Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Search Product Three");
		Amazon_Search_Product_POM search = new Amazon_Search_Product_POM(driver);
		search.searchProduct3();
	}

	@Test(priority = 6)
	public void CheckOutPayment() {
		ExtentReport_Test.extentTest = extentReports
				.createTest("Check Out Payment" + ":"
						+ Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Check Out Payment");
		Amazon_Search_Product_POM search = new Amazon_Search_Product_POM(driver);
		search.payment();
	}

	@AfterTest
	public void end() {
		terminateBrowser(driver);
	}

	@AfterSuite
	public void extentEnd() throws IOException {
		extendReportEnd("D:\\eclipse\\eclipse\\TestNG\\ExtentReport\\index.html");
	}

}
