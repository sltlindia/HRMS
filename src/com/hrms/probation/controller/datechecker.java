package com.hrms.probation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class datechecker {

	public static void main(String[] args) {
	String dateStart = "11/03/14 09:29:58";
	String dateStop = "11/03/14 09:33:43";

	// Custom date format
	SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");  

	Date d1 = null;
	Date d2 = null;
	try {
	    d1 = format.parse(dateStart);
	    d2 = format.parse(dateStop);
	} catch (ParseException e) {
	    e.printStackTrace();
	}    

	// Get msec from each, and subtract.
	long diff = d2.getTime() - d1.getTime();
	long diffSeconds = diff / 1000;         
	long diffMinutes = diff / (60 * 1000);         
	long diffHours = diff / (60 * 60 * 1000);                      
	System.out.println("Time in seconds: " + diffSeconds + " seconds.");         
	System.out.println("Time in minutes: " + diffMinutes + " minutes.");         
	System.out.println("Time in hours: " + diffHours + " hours."); 
}
}
