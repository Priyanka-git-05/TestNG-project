package com.TestNG;

import org.testng.annotations.Test;

public class Grouping_Credentials {
	@Test(groups = "Username")
	private void log1() {
		System.out.println("abc");
	}
	@Test(groups = "Password")
	private void pass1() {
		System.out.println("abc@123");
	}
	@Test(groups="GreetMessage")
	private void greetings1() {
		System.out.println("Hello, abc");
	}
	@Test(groups = "Username")
	private void log2() {
		System.out.println("xyz");
	}
	@Test(groups = "Password")
	private void pass2() {
		System.out.println("xyz@123");
	}
	@Test(groups="GreetMessage")
	private void greetings2() {
		System.out.println("Hello, xyz");
	}
	@Test(groups = "Username")
	private void log3() {
		System.out.println("mno");
	}
	@Test(groups = "Password")
	private void pass3() {
		System.out.println("mno@123");
	}
	@Test(groups="GreetMessage")
	private void greetings3() {
		System.out.println("Hello, mno");
	}
	
	
}