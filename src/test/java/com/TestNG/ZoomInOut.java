package com.TestNG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

import com.base.BaseClass;

public class ZoomInOut extends BaseClass{
	private void browsersetup() {
		launchTheBrowser("Chrome");
		launchURL(driver, "https://www.google.com/", 5);

	}
	private void keyboardactions() throws AWTException {

		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ADD);
		rb.keyRelease(KeyEvent.VK_ADD);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		staticwait(5000);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_SUBTRACT);
		rb.keyRelease(KeyEvent.VK_SUBTRACT);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
	}
	public static void main(String[] args) throws AWTException {
		ZoomInOut z = new ZoomInOut();
		z.browsersetup();
		z.keyboardactions();
}

}
