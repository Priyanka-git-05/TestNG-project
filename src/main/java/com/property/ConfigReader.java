package com.property;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	FileInputStream fi;
	Properties prop = new Properties();
	
	public ConfigReader() {
		
		File f = new File("D:\\eclipse\\eclipse\\TestNG\\src\\main\\java\\com\\property\\dataproperties");
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getURL() {
		String urlname = prop.getProperty("url");
		return urlname;
	}
	public String getusername() {
		String username = prop.getProperty("username");
		return username;
	}
	public String getpassword() {
		String password = prop.getProperty("password");
		return password;
	}
	public String getEmployeename() {
		String employee = prop.getProperty("employeename");
		return employee;
	}
	public String getpassword2() {
		String pass2 = prop.getProperty("password2");
		return pass2;
}
	
}