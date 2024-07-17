package com.pellisambandhalu.sanitytestcases;

import org.testng.annotations.Test;

import com.pellisambandhalu.PropertiesFiles.ConfigReader;

public class TC_002VerifyPropertiesFileFunctionality {
	
	
	@Test
	public void getObjectRepoData() {
		System.out.println(ConfigReader.getproperty("url")+" || "+
				ConfigReader.getproperty("username") + " || " +
				ConfigReader.getproperty("password") + " || " +
				ConfigReader.getproperty("sigIn") + " || " + 
				ConfigReader.getproperty("frame1") + " || "+
				ConfigReader.getproperty("frame2") + " || "+
				ConfigReader.getproperty("URL"));
	}

}
