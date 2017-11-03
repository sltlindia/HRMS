package com.hrms.tds.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PayrollDBConnection {

public static Connection getConnection() {
		
		// variables
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		// Step 1: Loading or registering Oracle JDBC driver class
		try {

		    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch(ClassNotFoundException cnfex) {

		    System.out.println("Problem in loading or "
		            + "registering MS Access JDBC driver");
		    cnfex.printStackTrace();
		}

		// Step 2: Opening database connection
		try {
		  // String msAccDB = "D:\\allWorkSpace\\PayTest.mdb";
		 String msAccDB = "\\\\RIPAL\\PayrollDB//PayTest.mdb";
		   // String msAccDB = "C:\\xampp\\htdocs\\IPCF\\Parameter.accdb";
		    String dbURL = "jdbc:ucanaccess://" + msAccDB; 

		    // Step 2.A: Create and get connection using DriverManager class
		    connection = DriverManager.getConnection(dbURL); 

		    // Step 2.B: Creating JDBC Statement 
		    statement = connection.createStatement();

		    // Step 2.C: Executing SQL & retrieve data into ResultSet
		   /* resultSet = statement.executeQuery("SELECT * FROM wateroil");

		    System.out.println("ID\tName\t\t\tAge\tMatches");
		    System.out.println("==\t================\t===\t=======");

		    // processing returned data and printing into console
		    while(resultSet.next()) {
		        System.out.println(resultSet.getInt(1) + "\t" + 
		                resultSet.getString(2) + "\t" + 
		                resultSet.getString(3));
		    }*/
		}
		catch(SQLException sqlex){
		    sqlex.printStackTrace();
		}
		return connection;

		
	}
}
