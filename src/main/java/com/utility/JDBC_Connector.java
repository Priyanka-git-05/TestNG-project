package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBC_Connector {
	
	private static void getParticularColumn() {
		 String url="jdbc:mysql://localhost:3306/employees";
		 String userName="root";
		 String passWord="Yakshith@123";
		 String query="select * from salaries";
		try {
			//Build  a connection
			Connection connection = DriverManager.getConnection(url, userName, passWord);
			Statement createStatement = connection.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(query);
			executeQuery.next();
			int sino = executeQuery.getInt(1);
			System.out.println(sino);
			String username = executeQuery.getString(2);
			System.out.println(username);
			String password = executeQuery.getString(3);
			System.out.println(password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static List<Map<String, Object>> getAllData() {
		String url="jdbc:mysql://localhost:3306/employees";
		 String userName="root";
		 String passWord="Yakshith@123";
		 String query="SELECT * FROM employees.salaries limit 10";
		 
		 List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		 
		try {
			//Build  a connection
			Connection connection = DriverManager.getConnection(url, userName, passWord);
			Statement createStatement = connection.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(query);
			
			
			while(executeQuery.next()) {
			Map<String,Object> map = new LinkedHashMap<String, Object>();
			map.put(query, executeQuery.getString(1));
			map.put(query, executeQuery.getString(2));
			
			int sino = executeQuery.getInt(1);
			System.out.println(sino);
			String username = executeQuery.getString(2);
			System.out.println(username);
			String password = executeQuery.getString(3);
			System.out.println(password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		
		
		List<Map<String,Object>> allrowdata = getAllData();
		for (Map<String, Object> map : allrowdata) {
			System.out.println(map);
		}
	
	}

}
