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

public class EmployeeTimeSheetPopupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int employee_master_id = user.getEmployee_master_id();
		System.out.println(employee_master_id);
		String date= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String startDate = null;
		String endDate = null;
		String dayOfWeek = null;
		
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
		
		
		
		
		/*TimeSheetBean timeSheetBean = new TimeSheetBean(timesheet_master_id, projectMasterBean, clientMasterBean, taskMasterBean, task_time_status, worked_hours, leave_hours);*/
			System.out.println("Successful");
			/*request.setAttribute("date",date);*/
			AllListDAO allListDAO1 = new AllListDAO();
			List<Object[]> getWeeklyTimesheet2 = allListDAO1.getWeeklyTimesheet2(employee_master_id);
			System.out.println(getWeeklyTimesheet2.size());
			request.setAttribute("duplicate", "<font color=red>*Timesheet already exist for this task .</font>");
			request.setAttribute("getWeeklyTimesheet2", getWeeklyTimesheet2);
			request.getRequestDispatcher("employeeTimesheet.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
		}
	}
