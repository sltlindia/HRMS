package com.hrms.timesheet.controller;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TimesheetTimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  TimerTask tasknew = new TimesheetTimerSchedulePeriod();
		   Timer timer = new Timer();
		      
		   // scheduling the task at interval
		   timer.schedule(tasknew,100,90000000);  
		
	}

}
