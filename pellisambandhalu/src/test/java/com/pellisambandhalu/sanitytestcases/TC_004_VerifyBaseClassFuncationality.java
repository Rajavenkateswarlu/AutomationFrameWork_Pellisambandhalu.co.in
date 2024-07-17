package com.pellisambandhalu.sanitytestcases;

import org.testng.annotations.Test;

import com.pellisambandhalu.base.BaseClass;

public class TC_004_VerifyBaseClassFuncationality {
	
	
	
	@Test
	public void setUpChrome() {
		
		BaseClass brow = new BaseClass();
		brow.setUpBrowser("Chrome", "https://www.phonepe.com/");
		
	}
	
	@Test
	public void setUpEdge() {
		
		BaseClass brow = new BaseClass();
		brow.setUpBrowser("Edge", "https://www.phonepe.com/");	
	}
	
	@Test
	public void setUpFireFox() {
		
		BaseClass brow = new BaseClass();
		brow.setUpBrowser("Firefox", "https://www.phonepe.com/");
		
	}

}
