package com.Ninza.hrm.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {

	public String getDataFromExcel(int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/TestDataForDataProvider1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("DataProvider").getRow(rowNum).getCell(cellNum).toString();
		wb.close();
		return data;
		
	}
	
	public void getDataBackToFromExcel(int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/TestDataForDataProvider1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet("DataProvider").getRow(rowNum).getCell(cellNum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("Pass");
		
		FileOutputStream fos=new FileOutputStream("./TestData/TestDataForDataProvider1.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	
	public int getLastRowNum() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/TestDataForDataProvider1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 int lastRowNum = wb.getSheet("DataProvider").getLastRowNum();
		 return lastRowNum;
	}
}
