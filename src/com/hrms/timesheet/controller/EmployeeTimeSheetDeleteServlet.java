package com.hrms.timesheet.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.timesheet.dao.AllDeleteDAO;
import com.hrms.timesheet.dao.AllListDAO;

public class EmployeeTimeSheetDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
		int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
		String project_master_name = request.getParameter("project_master_name");
		int day_id = Integer.parseInt(request.getParameter("day_id"));
		String day = request.getParameter("day");
		System.out.println("delete project name:"+project_master_name);
		System.out.println("delete employee_master_id" + employee_master_id);
		String date = request.getParameter("date");
		System.out.println("delete date" + date);
		int timesheet_master_id = Integer.parseInt(request.getParameter("timesheet_master_id"));
		System.out.println("delete timesheet_master_id" + timesheet_master_id);
		boolean result1 = allDeleteDAO.timeSheetDelete1(timesheet_master_id);
		
		
		
		String dayOfWeek = null;
		String startDate = null;
		String endDate = null;

		AllListDAO allListDAO1 = new AllListDAO();
		List<Object[]> timeSheetUpdateButton = allListDAO1.timeSheetUpdateButton(employee_master_id, date);
		System.out.println(timeSheetUpdateButton.size());
		
		
		request.setAttribute("timeSheetUpdateButton", timeSheetUpdateButton);
		String d = null;

		try {

			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			Date result = formater.parse(date);
			SimpleDateFormat AppDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			d = AppDateFormat.format(result);
			System.out.println(AppDateFormat.format(result));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			
			dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date1);

			System.out.println(dayOfWeek); 
			
			 Calendar c = GregorianCalendar.getInstance();

		        System.out.println("Current week = " + Calendar.DAY_OF_WEEK);

		        // Set the calendar to monday of the current week
		        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		        System.out.println("Current week = " + Calendar.DAY_OF_WEEK);

		        // Print dates of the current week starting on Monday
		        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		        startDate = "" ;
		        endDate = "";

		        startDate = df.format(c.getTime());
		        c.add(Calendar.DATE, 6);
		        endDate = df.format(c.getTime());

		        System.out.println("Start Date = " + startDate);
		        System.out.println("End Date = " + endDate);
			 
			 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AllListDAO allListDAO = new AllListDAO();
		List<Object[]> timeSheetUpdateButtonId = allListDAO.timeSheetUpdateButtonId1(timesheet_master_id,employee_master_id,date);
		System.out.println(timeSheetUpdateButtonId.size());
		request.setAttribute("timeSheetUpdateButton",timeSheetUpdateButton);
		request.setAttribute("getWeeklyTimesheet2",timeSheetUpdateButton);
		request.setAttribute("project_master_name", project_master_name);
		request.setAttribute("date", date);
		request.setAttribute("day", day);
		request.setAttribute("day_id", day_id);
		request.setAttribute("format", d);
		request.setAttribute("dayOfWeek",dayOfWeek);
		request.getRequestDispatcher("updateButtonEmployee.jsp").forward(request, response);

		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		}

}
