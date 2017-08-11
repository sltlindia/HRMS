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
import com.hrms.timesheet.dao.AllListDAO;

/**
 * Servlet implementation class TimeSheetUpdateButtonServlet
 */
public class TimeSheetUpdateButtonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
		String date = request.getParameter("date");
		String startDate = null;
		String endDate = null;
		String dayOfWeek = null;
		int day_id = 0;
		int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
		String project_master_name = request.getParameter("project_master_name");
		String client_master_name = request.getParameter("client_master_name");
		String task_master_name = request.getParameter("task_master_name");
		AllListDAO allListDAO1 = new AllListDAO();
		List<Object[]> timeSheetUpdateButton = allListDAO1.timeSheetUpdateButton(employee_master_id, date);
		System.out.println(timeSheetUpdateButton.size());
		/* String task_time_status= request.getAttribute("data"); */
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
			startDate = "";
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
		if (dayOfWeek.equalsIgnoreCase("Monday")) {
			day_id = 1;
		} else if (dayOfWeek.equalsIgnoreCase("Tuesday")) {
			day_id = 2;
		} else if (dayOfWeek.equalsIgnoreCase("Wednesday")) {
			day_id = 3;
		} else if (dayOfWeek.equalsIgnoreCase("Thursday")) {
			day_id = 4;
		} else if (dayOfWeek.equalsIgnoreCase("Friday")) {
			day_id = 5;
		} else if (dayOfWeek.equalsIgnoreCase("Saturday")) {
			day_id = 6;
		} else if (dayOfWeek.equalsIgnoreCase("Sunday")) {
			day_id = 7;
		}
		
		
		
		AllListDAO allListDAO = new AllListDAO();
		int timesheet_master_id = Integer.parseInt(request.getParameter("timesheet_master_id"));
		List<Object[]> timeSheetUpdateButtonId = allListDAO.timeSheetUpdateButtonId1(timesheet_master_id,employee_master_id,date);
		System.out.println(timeSheetUpdateButtonId.size());
		request.setAttribute("date", date);
		request.setAttribute("format", d);
		request.setAttribute("day_id", day_id);
		request.setAttribute("dayOfWeek",dayOfWeek);
		request.setAttribute("project_master_name", project_master_name);
		request.setAttribute("client_master_name", client_master_name);
		request.setAttribute("task_master_name", task_master_name);
		request.setAttribute("timeSheetUpdateButtonId", timeSheetUpdateButtonId);
		List<Object[]> getWeeklyTimesheet2 = allListDAO1.getWeeklyTimesheet2(employee_master_id);
		System.out.println(getWeeklyTimesheet2.size());
		request.setAttribute("getWeeklyTimesheet2", getWeeklyTimesheet2);
		request.getRequestDispatcher("updateButtonManager.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
