package com.pellisambandhalu.sanitytestcases;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pellisambandhalu.Library.Utility;
import com.pellisambandhalu.screenshots.GetScreenShot;

public class TC_003_VerifyScreenShotFunctionality {
	
	WebDriver driver;
	@BeforeClass
	public void setUpBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.paypal.com/in/home");
	}
	
	@Test
	public void verifyScreenShotFunctionality() {
		
		GetScreenShot.getScreenShot(driver, "payPal");
		
		  
		
		}
	
	@Test
	public void getCurrentTime() {
		System.out.println(Utility.getTimeStamp());
	}
		
	}


