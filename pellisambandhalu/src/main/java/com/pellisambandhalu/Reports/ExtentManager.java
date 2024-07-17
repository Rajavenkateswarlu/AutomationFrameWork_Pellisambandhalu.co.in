package com.pellisambandhalu.Reports;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pellisambandhalu.Library.Utility;



public class ExtentManager {
	
	public static ExtentReports extent ;
	
	public static ExtentReports getIntance() 
	{
		
		if(extent == null) {
			extent = createInstance();
			return extent;
		}
		else
		{
			return extent;
		}
		
	}
	
	
	public static ExtentReports createInstance() {
		
		ExtentReports extent = new ExtentReports();
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "/Reports/pellisambandhalu"+Utility.getTimeStamp()+".html" );
		spark.config().setDocumentTitle("Pellisambandhalu_Web");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("AutomationScript");
		
		extent.attachReporter(spark);
		
		return extent;
		
		
	}
	
	
	
	

}
