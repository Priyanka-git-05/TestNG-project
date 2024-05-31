package com.TestNG;

import org.testng.annotations.Test;

import com.base.BaseClass;

public class Parallel_Execution extends BaseClass {
	@Test
	private void chrome() {
		launchTheBrowser("Chrome");
		launchURL(driver, "https://www.facebook.com/", 3);
		System.out.println("Browser ID - "+ Thread.currentThread().getId());
		
	}
	@Test
	private  void edge() {
		launchTheBrowser("Edge");
		launchURL(driver, "https://www.facebook.com/", 3);
		System.out.println("Browser ID - "+ Thread.currentThread().getId());
	}
	@Test
	private void firefox() {
		launchTheBrowser("Firefox");
		launchURL(driver, "https://www.facebook.com/", 3);
		System.out.println("Browser ID - "+ Thread.currentThread().getId());
	}
}

