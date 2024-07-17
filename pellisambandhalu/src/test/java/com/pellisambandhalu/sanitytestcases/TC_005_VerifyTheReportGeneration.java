package com.pellisambandhalu.sanitytestcases;

import org.testng.annotations.Test;

import com.pellisambandhalu.base.BaseClass;

public class TC_005_VerifyTheReportGeneration {


	@Test
	public void reportGeneration() {

		BaseClass brow = new BaseClass();
		
		brow.setUpBrowser("Firefox", "https://pellisambandalu.com/");
	}
}



