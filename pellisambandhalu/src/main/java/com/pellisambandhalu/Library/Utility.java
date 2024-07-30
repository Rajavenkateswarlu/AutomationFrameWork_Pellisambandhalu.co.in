package com.pellisambandhalu.Library;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utility {

	public static Select select;
	public static Actions act;
	public static JavascriptExecutor js;

	public static void enterData(WebElement element, String data) {

		element.sendKeys(data);
	}

	public static void click(WebElement element) {
		element.click();
	}
	public static void selectByVisibleText(WebElement element, String text) {

		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectByValue(WebElement element, String value) {

		select= new Select(element);
		select.selectByValue(value);
	}

	public static void mouseOver( WebElement element) {
		act.moveToElement(element).perform();
	}

	public static void moveAndClick(WebElement element) {
		act.moveToElement(element).click(element).build().perform();
	}

	// Comman actions across the Application.


	public static String getTimeStamp() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("HH_mm_ss");
		String timeStamp = s.format(d);
		return timeStamp;

	}



	public static void selectOptionFromDropDown(WebElement ele, String value) {

		select = new Select(ele);

		List<WebElement> allOptions = select.getOptions();

		for(WebElement option:allOptions) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}


		}
	}



	public static WebElement waitForElementPresent(WebDriver driver , By Locator,int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(Locator));

		return driver.findElement(Locator);
	}

	// Switch to Multilple Windows

	public static int getNumberOfTabsORWindows(WebDriver driver ) {

		Set<String> windows = driver.getWindowHandles();
		return windows.size();
	}

	public static void moveToMultipleWindow(WebDriver driver , int TabNumber) {

		if(TabNumber < getNumberOfTabsORWindows(driver)) {
			Set<String> windows = driver.getWindowHandles();

			Object[] window = windows.toArray();

			String activeWindow = window[TabNumber].toString();
			driver.switchTo().window(activeWindow);
		}else {
			System.out.println("Given tab Number is Invalid  " + TabNumber);
		}
	}

	// switch to frames 

	public static void switchToIFrameByIndex(WebDriver driver , int index) {
		driver.switchTo().frame(index);

	}

	public static void switchToIframeByNameOrId(WebDriver driver , String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public static void switchToIFrameByWebElement(WebDriver driver , WebElement ele) {
		driver.switchTo().frame(ele);	
	}

	public static void switchToDefaultConent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public static void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	// Wait for an ifram and switch to it:

	public static void waitAndSwitchToFrame(WebDriver driver,WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));

	}

	public static void waitAndSwitchToFrame(WebDriver driver,int index) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));

	}
	public static void waitAndSwitchToFrame(WebDriver driver,String nameOrId) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));

	}

	         // JavascriptExecutor functions

	// Click element using JavaScript
	public static void clickOnElementJs(WebDriver driver , WebElement ele) {

		js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].click();" , ele);
	}
	// getDomain name
	public static String getDomainName() {
		String domainName = js.executeScript("return document.domain;").toString();
	   return domainName;
	}
	
	// Scroll to element
	public static void scrollToElement(WebElement ele) {
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

	}
	// vertical scroll by 
	
	public static void scrollByVertically() {
		
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	
	// Get page title using js
	public static String  getPageTitle() {
		String titleText = js.executeScript("return document.title;").toString();
		return titleText;
	}
	
    // Open a new tab using js
	
	public static void openNewTab() {
		js.executeScript("window.open()");
	}
	
	// Get inner text of element
	public static String getInnerText(WebElement element) {
		String getText = js.executeScript("return arguments[0].innerText;", element).toString();
	    return getText;
	}
	
	// HighLightWebEleemnt
	public static void highlightWebElement(WebElement element) {
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;')",element);
		
	}
	
    // Get page load status
	
	public static Boolean isPageLoaded() {
		Boolean ispageloaded = js.executeScript("return document.readyState").equals("complete");
	    return ispageloaded;
	}
	
	 // Set value of input field
	public void setInputValue(WebElement element, String value) {
        js.executeScript("arguments[0].value=arguments[1];", element, value);
    }
	
	
	


}
