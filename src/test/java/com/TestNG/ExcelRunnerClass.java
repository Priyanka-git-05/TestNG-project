package com.TestNG;

import com.utility.Excel_Reader;

public class ExcelRunnerClass{

	public static void main(String[] args) {
		Excel_Reader er = new Excel_Reader();
		er.launchBrowser();
		er.sendkeys();
		
	}

}
