package com.pellisambandhalu.sanitytestcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pellisambandhalu.Library.Utility;

public class TC_006_VerifytheFunctinalityOfWindowHandlesInLibrary {


	@Test
	public void getNumberOfWindows() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.sap.com/india/partners/login.html");

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		WebElement ele = driver.findElement(By.linkText("Log in to SAP Partner Portal"));
		wait.until(ExpectedConditions.visibilityOf(ele));

		Utility.clickOnElementJs(driver, ele);
		/*
		driver.navigate().to("https://login.salesforce.com/?locale=in");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("privacy-link"));
		 */
		//Utility.click(ele);
		int numberOfWindows = Utility.getNumberOfTabsORWindows(driver);
		System.out.println(numberOfWindows);
	}

	@Test
	public void switchToSpecifiedWindow() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.sap.com/india/partners/login.html");

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

		WebElement ele = driver.findElement(By.linkText("Log in to SAP Partner Portal"));
		wait.until(ExpectedConditions.visibilityOf(ele));

		Utility.clickOnElementJs(driver, ele);
		Utility.moveToMultipleWindow(driver, 1);
		System.out.println(driver.getTitle()); //SAP Partner Portal | welcome
		Utility.moveToMultipleWindow(driver, 0);
		
		System.out.println(driver.getTitle());//SAP Partner Portal l Login
		driver.close();

	}
}
