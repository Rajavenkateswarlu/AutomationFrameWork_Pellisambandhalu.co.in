package com.pellisambandhalu.sanitytestcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pellisambandhalu.Library.Utility;

public class TC_007_VerifyFunctionalityOfIFrames {
	
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.lambdatest.com/selenium-playground/");
		
		
	}
	
	
	@Test
	public void verifyIframesInUtility() {
		WebElement iframe =driver.findElement(By.linkText("iFrame Demo"));
		iframe.click();
		Utility.switchToIframeByNameOrId(driver, "iFrame1");
		
		WebElement yourContent = driver.findElement(By.className("rsw-ce"));
		yourContent.clear();
		yourContent.sendKeys("Welcome to Selenium");
		
		Utility.switchToDefaultConent(driver);
		
		Utility.switchToIframeByNameOrId(driver, "iFrame2");
		
		System.out.println(driver.findElement(By.xpath("//div[@class = 'Doc_intro_cta_text']")).getText());
		
	}
	
	@Test
	public void verifyNestedFrames() {
		driver.findElement(By.linkText("Nested Frames")).click();
		
		WebElement frame = driver.findElement(By.xpath("//frame[@name = 'frame-top']"));
		Utility.switchToIFrameByWebElement(driver, frame);
		
		String Toptext = driver.findElement(By.xpath("//body/p")).getText();
		System.out.println("TOP-FRAME TEXT " + Toptext);
		
		Utility.switchToParentFrame(driver);
		Utility.switchToIframeByNameOrId(driver, "frame-bottom");
		Utility.switchToIframeByNameOrId(driver, "frame-left");
		String leftText = driver.findElement(By.xpath("//body/p")).getText();
	    System.out.println("LEFT FRAME TEXT " + leftText);
	    
	    Utility.switchToDefaultConent(driver);
	    Utility.switchToIframeByNameOrId(driver, "frame-bottom");
	    Utility.switchToIframeByNameOrId(driver, "frame-middle");
	    String MiddleText = driver.findElement(By.xpath("//body/p")).getText();
	    System.out.println("MIDDLE TEXT " + MiddleText);
	    
	    Utility.switchToDefaultConent(driver);
	    Utility.switchToIframeByNameOrId(driver, "frame-bottom");
	    Utility.switchToIframeByNameOrId(driver, "frame-right");
	
	    String RightText = driver.findElement(By.xpath("//body/p")).getText();
	    System.out.println("RIGHT TEXT " + RightText);
	    
	}

}
