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
import com.hrms.timesheet.bean.DayBean;
import com.hrms.timesheet.dao.AllInsertDAO;
import com.hrms.timesheet.dao.AllListDAO;

/**
 * Servlet implementation class NewUnplannedValidationManagerServlet
 */
public class NewUnplannedValidationManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
		String date = (String) session.getAttribute("date");
		System.out.println(date);
		int day_id =(int) session.getAttribute("day_id");
		String dayOfWeek = (String) session.getAttribute("dayOfWeek");
		System.out.println("day_id:"+day_id);
		System.out.println("dayOfWeek:"+dayOfWeek);
		/* String[] dateParts = string.split("/"); */
		/*
		 * String year = dateParts[0]; String month = dateParts[1]; String day =
		 * dateParts[2];
		 */
		String status = "pending";
		String worked_hours = "0";
		String leave_hours = "0";
		String startDate = null;
		String endDate = null;
		String employee_comment = null;
		String approval_status = "null";
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

		System.out.println(date);
		
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
		} catch (Exception e) {
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

		EmployeeBean employeeBean = new EmployeeBean();
		DayBean dayBean = new DayBean();
		AllInsertDAO allInsertDAO = new AllInsertDAO();

		/*
		 * System.out.println(day); System.out.println(month);
		 * System.out.println(year);
		 * 
		 * int Day = Integer.parseInt(day); int Month = Integer.parseInt(month);
		 * int Year = Integer.parseInt(year);
		 */

		int employee_master_id = user.getEmployee_master_id();
		AllListDAO allListDAO = new AllListDAO();
		List<Object[]> listOfTimeSheet = allListDAO.getmanagerTimeSheetList(employee_master_id, date);
		System.out.println(listOfTimeSheet.size());
		request.setAttribute("listOfTimeSheet", listOfTimeSheet);

		AllListDAO allListDAO1 = new AllListDAO();
		List<Object[]> getWeeklyTimesheet = allListDAO1.getWeeklyTimesheet(employee_master_id, startDate, endDate);
		System.out.println(getWeeklyTimesheet.size());
		request.setAttribute("getWeeklyTimesheet2", getWeeklyTimesheet);
		request.setAttribute("getWeeklyTimesheet", getWeeklyTimesheet);
		request.setAttribute("date", date);
		System.out.println(date);
		request.setAttribute("format", d);
		request.setAttribute("day_id", day_id);
		request.setAttribute("dayOfWeek", dayOfWeek);
		
		List<Object[]> timeSheetUpdateButton = allListDAO1.timeSheetUpdateButton(employee_master_id,date);
		System.out.println(timeSheetUpdateButton.size());
		request.setAttribute("timeSheetUpdateButton", timeSheetUpdateButton);
		
		request.setAttribute("validation", "<font color=red>*Timesheet already exist</font>");
		List<Object[]> getdayTimeSheetList = allListDAO1.getdayTimeSheetList(employee_master_id, date);
		System.out.println(getdayTimeSheetList.size());
		request.setAttribute("getdayTimeSheetList", getdayTimeSheetList);
		request.getRequestDispatcher("addUnplannedTaskManager.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	
		// TODO Auto-generated method stub
	}

}
