package com.hrms.tds.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Temp 
{

	public static void main(String args[])
	{
		System.out.println("X");
		Connection conn;
		
		Statement st = null;
	ResultSet rs = null; 
		
	try
	{
		conn = PayrollDBConnection.getConnection();
		st = conn.createStatement();
		rs = st.executeQuery("SELECT * FROM TDS");
		
		while (rs.next()) 
		{
			System.out.println("ID " + rs.getInt(1) + " CONNV " + rs.getString(2) + " PTAX " + rs.getString(3));
			
		}
		
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		
	}
	
}
