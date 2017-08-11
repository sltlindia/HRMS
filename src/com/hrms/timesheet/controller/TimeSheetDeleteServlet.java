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

public class TimeSheetDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
		AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
			
		int timesheet_master_id = Integer.parseInt(request.getParameter("timesheet_id"));
		
		if(request.getParameter("unplan") != null){
			boolean result1 = allDeleteDAO.timeSheetUnplanDelete1(timesheet_master_id);
		}else{
			boolean result1 = allDeleteDAO.timeSheetDelete1(timesheet_master_id);
		}
		
		request.setAttribute("success","Timesheet Successfully deleted.");
		if(request.getParameter("action") != null){
			request.getRequestDispatcher("addTimesheet.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("updateTimesheet.jsp").forward(request, response);
		}
		
		
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		}
	
	}

