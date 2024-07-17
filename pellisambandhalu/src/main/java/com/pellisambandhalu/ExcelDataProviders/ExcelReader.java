package com.pellisambandhalu.ExcelDataProviders;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static XSSFWorkbook wb;
	public static Object[][] getDataFromSheet(String sheetName){
		System.out.println("*******Loading the FROM DATA-EXCEL*********");
		Object [][] arr = null;
		try {
			
			//Load Excel
			wb = new XSSFWorkbook(new FileInputStream(new File (System.getProperty("user.dir")+ "/TestData/PellisambandhaluTestData.xlsx")));
			//wb = new XSSFWorkbook(new FileInputStream(new File (System.getProperty("user.dir")+"/DDT.xlsx")));
			// Load sheet
			XSSFSheet sheet=wb.getSheet(sheetName);
			
			//number of Rows
			int rows = sheet.getPhysicalNumberOfRows();
			
			//Number of cells
			int cell = sheet.getRow(0).getPhysicalNumberOfCells();
			
			//Create array based on Rows and columns from Excel
			arr = new Object[rows-1][cell];
			
			// transport Data from Excel to 2D object
			
			for(int i = 1; i< rows ; i++) {
				for(int j = 0; j< cell; j++) {
					/*String data = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(data);*/
					//System.out.print(getData(sheetName, i, j) + " ");
					arr[i-1][j] = getData(sheetName, i, j);
				}
				System.out.println(  );
			}
			//System.out.println(  );
			
					
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file  " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could load the file " + e.getMessage());
			e.printStackTrace();
		}
		return arr;
		
	}
	public static String getData(String sheetName, int row, int col) {
		Cell cell =wb.getSheet(sheetName).getRow(row).getCell(col);
		
		String data = " ";
		
		if(cell.getCellType() == CellType.STRING) {
			data= cell.getStringCellValue();
		}else if(cell.getCellType() == CellType.NUMERIC) {
			int datainDouble =(int) cell.getNumericCellValue();
			data = String.valueOf(datainDouble);
		}else if(cell.getCellType() == CellType.BLANK) {
			data= " ";
		}
		return data;
	}

}
