package com.pellisambandhalu.base;

import org.openqa.selenium.WebDriver;

import com.pellisambandhalu.browsers.Browsers;

public class BaseClass {

	
	// This class contains opening the Browser and Close the browser And WebDriver

   public void setUpBrowser(String BrowserName, String Application) {
	   //WebDriver driver =
	Browsers.startBrowser(BrowserName ,  Application);
   }
}
