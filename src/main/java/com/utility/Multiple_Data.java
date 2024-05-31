package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class Multiple_Data  {
	
	private static void Read_Multiple_Row_CellData() throws InvalidFormatException, IOException {
		
	
	String path ="D:\\eclipse\\eclipse\\bigbasket\\Excel\\data.xlsx";
	
	File file = new File(path);
	Workbook workbook = new XSSFWorkbook(file);
	Sheet sheetnum = workbook.getSheet("Credentials");
	
	int totalNoOfrows = sheetnum.getLastRowNum();//6
	int totalNoOfCols = sheetnum.getRow(0).getLastCellNum();
	
	List<Object> list = new ArrayList<Object>();
	
	for (int i = 1; i < totalNoOfrows; i++) {
		List<Object> list2 = new ArrayList<Object>();
		for (int j = 0; j < totalNoOfCols; j++) {
			Cell cell = sheetnum.getRow(i).getCell(j);
			DataFormatter df = new DataFormatter();
			String formatCellValue = df.formatCellValue(cell);
			list2.add(formatCellValue);
			list.add(list2);
			workbook.close();
		}
		}
	System.out.print(list);
	
	}
	public static void main(String[] args) throws InvalidFormatException, IOException {
		Read_Multiple_Row_CellData();
}
}