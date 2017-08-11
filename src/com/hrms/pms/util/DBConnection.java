package com.hrms.pms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String driverClassName = "com.mysql.jdbc.Driver";
	private static String connectionURL = "jdbc:mysql://localhost:3306/hrms";
	private static String userName = "root";
	private static String password = "root";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driverClassName);
			conn=DriverManager.getConnection(connectionURL,userName,password);
			
			if(conn!=null){
				System.out.println("Connected with DB...");
			}else{
				System.out.println("Connection failed...");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}
