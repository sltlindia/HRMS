package com.hrms.tds.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datadifference {

	public static void main(String args[]) throws ParseException {
	    
		String d1 = "2017-06-01";
		String d2 = "2017-12-01";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			
		Date joiningDate = dateFormat.parse(d1);
		Date ChangeDate = dateFormat.parse(d2);
		   
		long diff = ChangeDate.getTime() - joiningDate.getTime(); 
		    
		long days = (diff / (1000 * 60 * 60 * 24)) % 365;
		  
		System.err.println("Days :"+days);
	
	}
}
