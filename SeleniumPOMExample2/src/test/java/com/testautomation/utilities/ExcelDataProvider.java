package com.testautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	public XSSFWorkbook wb; //make workbook obj public so it can be used across methods
	public XSSFSheet sh;

	//Constructor: initializes & loads the Excel file
	public ExcelDataProvider() throws NullPointerException {
		//System.out.println("inside ExceLlDataProvider const");
		try {
			//Read Excel file inside constructor
			File src = new File("./src/test/java/com/testautomation/utilities/TestDataFiles/TestData.xlsx");
			FileInputStream fis = new FileInputStream(src); //open file
			//System.out.println("fis: "+fis.toString());
			wb = new XSSFWorkbook(fis);
			
		}catch (Exception e) {
			System.out.println("Unable to read the Excel file: "+e.getMessage());
			}
	}
	
		public String getStringData(String sheetName, int rowNum, int colNum) throws IOException {
			
			System.out.println("inside getStringData method");
			sh = wb.getSheet(sheetName);
			//System.out.println(sh.getRow(rowNum).getCell(colNum).getStringCellValue());
			String excelData = sh.getRow(rowNum).getCell(colNum).getStringCellValue();
			wb.close();
			return excelData;
		}
	
		
}

