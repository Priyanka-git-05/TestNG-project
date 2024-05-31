package com.TestNG;
import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;

public class ExtentReport_Test {
	
	public static ExtentTest extentTest;
	
	@BeforeSuite
	public void ReportStart() throws IOException{
		BaseClass baseclass = new BaseClass();
		baseclass.extendReportStart(null);
	}
	@AfterSuite
	public void ReportEnd() throws IOException {
		BaseClass baseclass = new BaseClass();
		baseclass.extendReportEnd(null);

	}
}
