package com.pellisambandhalu.PropertiesFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	
	
	public static String getproperty(String key) {
		Properties  pro = new Properties();
		
		try {
			
			pro.load( new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/java/com/pellisambandhalu/PropertiesFiles/ObjectRepo.properties")));
		} catch (FileNotFoundException e) {
			System.out.println(" could not find the file " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not load the file " + e.getMessage());
			e.printStackTrace();
		}
		String value =pro.getProperty(key);
		return value;
	}

}
