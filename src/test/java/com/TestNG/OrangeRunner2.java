package com.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
public class OrangeRunner2 extends BaseClass {
	@BeforeMethod
	public void setup() {
		launchTheBrowser("Edge");
		launchURL(driver, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", 5);
		}
	
	@Test(priority=2)
	public void Invalid() {
		WebElement username = driver.findElement(By.name("username"));
		passValue(driver, username, "chsdfgyd", 2);
		WebElement password = driver.findElement(By.name("password"));
		passValue(driver, password, "bfsjegfwjeg", 2);
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		clickTheElement(driver, element, 2);
		}
	@Test(priority=1)
	public void valid() {
		WebElement username = driver.findElement(By.name("username"));
		passValue(driver, username, "Admin", 2);
		WebElement password = driver.findElement(By.name("password"));
		passValue(driver, password, "admin123", 2);
		WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
		clickTheElement(driver, element, 2);
		}
	@Test(enabled=false)
	public void omit() {
		driver.findElement(By.name("username")).sendKeys("Admin");;
		driver.findElement(By.name("password")).sendKeys("admin123");;
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@AfterMethod
	public void endSetUp() {
		staticwait(10000);
		terminateBrowser(driver);
	}	

}
