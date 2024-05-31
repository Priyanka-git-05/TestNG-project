package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Data {
	String path ="D:\\eclipse\\eclipse\\bigbasket\\Excel\\data.xlsx";
	
	private static void writedata() throws InvalidFormatException, IOException {
		String path ="D:\\eclipse\\eclipse\\bigbasket\\Excel\\data.xlsx";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fis);
		workbook.createSheet("File 1");
		workbook.getSheet("File 1").createRow(0).createCell(1).setCellValue("Yakshith");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		System.out.println("----Entry Added----");
		workbook.close();
	}
	

	public static void main(String[] args) throws InvalidFormatException, IOException {
		writedata();

	}

}
