package com.pellisambandhalu.ExcelDataProviders;

import org.testng.annotations.DataProvider;

public class GetDataFromSheets {
	
	
	@DataProvider(name = "RegistrationData")
	public Object[][] getRegisterData(){
		Object[][] arr =ExcelReader.getDataFromSheet("Register");
		
		return arr;
		
	}
	
	@DataProvider(name = "LoginData")
	public Object[][] getLogInData(){
		Object[][] arr =ExcelReader.getDataFromSheet("LoginDetails");

		return arr;
		
	}
	
	@DataProvider(name = "Emp")
	public Object[][] getEmpolyeeData(){
		Object[][] arr =ExcelReader.getDataFromSheet("Employees");

		return arr;
		
	}

}
