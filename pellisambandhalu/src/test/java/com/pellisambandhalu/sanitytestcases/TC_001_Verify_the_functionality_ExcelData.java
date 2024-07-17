package com.pellisambandhalu.sanitytestcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pellisambandhalu.ExcelDataProviders.GetDataFromSheets;

public class TC_001_Verify_the_functionality_ExcelData {
	
	
	
	@Test(priority = 1,dataProvider = "RegistrationData",dataProviderClass = GetDataFromSheets.class)
	public void verifyRegisterData(
			String FullName, String Email ,String PassWord, String UserName,String Gender ,String MobileNumber ) {
		
		System.out.println(FullName + " " + Email + " "+ PassWord +" "+ UserName +" "+ Gender + " " + MobileNumber);
		
	}
	
	@Test(priority = 2,dataProvider  = "LoginData", dataProviderClass = GetDataFromSheets.class)
    public void verifyLogInDetails(String UserName , String password) {
		
		System.out.println(UserName + " " + password);
	}
	
	@Test(priority = 3,dataProvider  = "Emp", dataProviderClass = GetDataFromSheets.class)
    public void verifyEmpDetails(String firstName , String lastName, String Designation) {
		
		System.out.println(firstName + " " + lastName + " " + Designation);
	}
}
