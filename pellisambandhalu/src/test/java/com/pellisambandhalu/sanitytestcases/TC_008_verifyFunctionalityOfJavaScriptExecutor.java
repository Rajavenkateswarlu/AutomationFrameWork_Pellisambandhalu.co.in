package com.pellisambandhalu.sanitytestcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pellisambandhalu.Library.Utility;



public class TC_008_verifyFunctionalityOfJavaScriptExecutor {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.lambdatest.com/selenium-playground/");
	}
		@Test
		public void jsFunctionality() {
			driver.findElement(By.linkText("Input Form Submit")).click();
			WebElement name =driver.findElement(By.id("name"));
			WebElement Email =driver.findElement(By.id("inputEmail4"));
			WebElement password =driver.findElement(By.id("inputPassword4"));
			WebElement company =driver.findElement(By.id("company"));
			WebElement websitename =driver.findElement(By.id("websitename"));
			WebElement inputCity =driver.findElement(By.id("inputCity"));
			WebElement inputAddress1 =driver.findElement(By.id("inputAddress1"));
			WebElement inputAddress2 = driver.findElement(By.id("inputAddress2"));

			//Highlight Element
			Utility.highlightWebElement(name);
			Utility.highlightWebElement(Email);
			Utility.highlightWebElement(password);
			Utility.highlightWebElement(company);
			Utility.highlightWebElement(websitename);
			Utility.highlightWebElement(inputAddress1);
			Utility.highlightWebElement(inputAddress2);
			Utility.highlightWebElement(inputCity);

		}

	}
