package com.listen;
import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.TestNG.ExtentReport_Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.BaseClass;

public class ITestListener_Class extends BaseClass implements ITestListener {
	
	public String testName;
	public String methodName;
	
	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			ExtentReport_Test.extentTest.pass(result.getMethod().getMethodName()+" : "+"Test Pass", 
					MediaEntityBuilder.createScreenCaptureFromPath(screenShot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentReport_Test.extentTest.fail(result.getMethod().getMethodName()+" : "+"Test Fail",
					MediaEntityBuilder.createScreenCaptureFromPath(screenShot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
