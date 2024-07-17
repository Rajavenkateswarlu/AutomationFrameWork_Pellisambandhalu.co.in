package com.pellisambandhalu.browsers;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class Browsers {



	public static WebDriver driver;

	public static  WebDriver getBrowserInstance() {

		return driver;
	}



	public static WebDriver startBrowser(String browserName , String applicationUrl) {

		
		if(browserName.contains("Chrome")|| browserName.contains("GC")|| browserName.contains("Google Chrome")) {
			//ChromeOptions opt = new ChromeOptions();
			//opt.addArguments("--remote-allow-origins=*");
			// Launching the browser
			driver=new ChromeDriver();
			
		} else if(browserName.contains("Firefox")){

			driver = new FirefoxDriver();
		}
		else if( browserName.contains("Safari")) {
			driver = new SafariDriver();

		}else if(browserName.contains("Edge")) {
			driver = new EdgeDriver();
		}else {
			Reporter.log("Sorry "+ browserName + "Not Suppoted Running the test in default Browser ");

			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));

		driver.get(applicationUrl);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}


}
