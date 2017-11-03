package com.hrms.tds.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBConnection
{
	public static Connection getConnection(){
		 
        Connection connSQL = null;
        
        Statement smt;
        ResultSet rs = null;
        try {
        	
        	//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	String dbURL = "jdbc:sqlserver://192.168.182.243\\sqlexpress";
        	//String dbURL = "jdbc:sqlserver://hrserver\\sqlexpress";
            String user = "slt";
            String pass = "slt11";
            
            connSQL = DriverManager.getConnection(dbURL, user, pass);
            
           
            
            if (connSQL != null)
            {
              System.out.println("connected successfully..");
            }
            
 
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
        	// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connSQL;
    }
}
