package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getParticularRowMultipleCellData {
	
	String path ="D:\\eclipse\\eclipse\\bigbasket\\Excel\\data.xlsx";

	public void getMultipleCellData(int row) throws InvalidFormatException, IOException {
	File file = new File(path);
	Workbook workbook = new XSSFWorkbook(file);
	Sheet sheetnum = workbook.getSheetAt(0);
//	int totalNoOfrows = sheetnum.getLastRowNum();
	int totalNoOfCols = sheetnum.getRow(1).getLastCellNum();
	
	Row rows = sheetnum.getRow(row);
	
	for (int i = 1; i <= totalNoOfCols; i++) {
		Cell cell = rows.getCell(i);
		DataFormatter df = new DataFormatter();
		String formatValue=df.formatCellValue(cell);
		System.out.println(formatValue);
		workbook.close();
		}
}
	public static void main(String[] args) throws InvalidFormatException, IOException {
		getParticularRowMultipleCellData rc = new getParticularRowMultipleCellData();
		rc.getMultipleCellData(1);
		
	}

}
