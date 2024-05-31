package com.utility;
import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.BaseClass;


public class Excel_Reader extends BaseClass {
	String data;
	String path = "D:\\eclipse\\eclipse\\bigbasket\\Excel\\data.xlsx";
	
	public String getParticularCellData(){
		File file = new File(path);
		Workbook workbook;
		try {
			workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet("credentials");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(1);
			data = cell.getStringCellValue();
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		}
	
	public void launchBrowser() {
		Excel_Reader er = new Excel_Reader();
		er.launchTheBrowser("Chrome");
		er.launchURL(driver,"https://www.facebook.com/", 10);
	}	
	
	
	public void sendkeys() {
		Excel_Reader er = new Excel_Reader();
    	WebElement email = driver.findElement(By.id("email"));
    	String username=er.getParticularCellData();
    	passValue(driver,email,username, 10);
    	
	}
}









