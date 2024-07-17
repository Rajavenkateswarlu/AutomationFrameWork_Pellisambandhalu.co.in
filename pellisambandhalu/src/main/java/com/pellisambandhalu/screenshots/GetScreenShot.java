package com.pellisambandhalu.screenshots;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.pellisambandhalu.Library.Utility;


public class GetScreenShot {
	
public static String getScreenShot(WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		
		return base64;
	}


	public static void getScreenShot(WebDriver driver,String nameOfScreenShot) {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File capture = ts.getScreenshotAs(OutputType.FILE);

		File destination = new File(System.getProperty("user.dir")+"/src/main/java/com/pellisambandhalu/screenshots/"+nameOfScreenShot+".png");
		
		//File destination = new File(System.getProperty("user.dir")+"/src/main/java/com/pellisambandhalu/screenshots/"+nameOfScreenShot+"_"+Utility.getTimeStamp()+".png");
		//(System.getProperty("user.dir")+ "/Reports/Automation_"+Utility.getCurrentTime()+".html" );
		
		try {
			FileHandler.copy(capture, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getTimeStamp() {
		 Date d = new Date();
		    SimpleDateFormat s = new SimpleDateFormat("dd:MM:YY:HH:mm:ss");
		   String timeStamp = s.format(d);
		   return timeStamp;
		
	}
}
