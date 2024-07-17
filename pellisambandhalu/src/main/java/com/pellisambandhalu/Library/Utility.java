package com.pellisambandhalu.Library;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

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
	
	public static void clickOnElementJs(WebDriver driver , WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].click()" , ele);
	}
	
	public static WebElement waitForElementPresent(WebDriver driver , By Locator,int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(Locator));

		return driver.findElement(Locator);
	}
}
