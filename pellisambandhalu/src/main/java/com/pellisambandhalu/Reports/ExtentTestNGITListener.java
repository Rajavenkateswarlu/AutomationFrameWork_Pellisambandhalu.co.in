 package com.pellisambandhalu.Reports;

import org.openqa.selenium.WebDriver;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.pellisambandhalu.browsers.Browsers;
import com.pellisambandhalu.screenshots.*;

public class ExtentTestNGITListener  implements ITestListener{
	
	ExtentReports extent = ExtentManager.getIntance();
	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		ExtentTest extenttext = extent.createTest(result.getMethod().getMethodName());
		
		parentTest.set(extenttext);
	}
	
	public  void onTestSuccess(ITestResult result) {
		//WebDriver driver = Browserfactory.getBrowserInstance();
		WebDriver driver = Browsers.getBrowserInstance();
		String base64 = GetScreenShot.getScreenShot(driver);
		
		
		parentTest.get().pass("Test passed ", MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
	    
	  }
	
	 public void onTestFailure(ITestResult result) {
		 
		 WebDriver driver = Browsers.getBrowserInstance();
			String base64 = GetScreenShot.getScreenShot(driver);
		   parentTest.get().fail("Test failed" +result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
		   
		   
		  }
	 
	 public  void onTestSkipped(ITestResult result) {
		    parentTest.get().skip("Test Skipped"+ result.getThrowable().getMessage());
		  }
	 public void onFinish(ITestContext context) {
		    extent.flush();
		  }
	
	
	
	
	

}
