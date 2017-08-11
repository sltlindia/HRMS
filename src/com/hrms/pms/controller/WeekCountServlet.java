package com.hrms.pms.controller;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;

public class WeekCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		String startDate = request.getParameter("plannedStartDate");
		String endDate = request.getParameter("plannedEndDate");
		String action = request.getParameter("action");
		LocalDate e = null;
		
		
		LocalDate leaveStart = LocalDate.parse(startDate);
		LocalDate leaveEnd = LocalDate.parse(endDate);
		List<LocalDate> totalDates = new ArrayList<>();
		List<String> weekDates = new ArrayList<>();
		
		while (!leaveStart.isAfter(leaveEnd)) {
			totalDates.add(leaveStart);
			leaveStart = leaveStart.plusDays(6);
		}
		
		for(LocalDate dayList : totalDates){
			System.out.println("leave:"+dayList);
			String parseDate = dayList.toString();
			e = LocalDate.parse(parseDate);
			weekDates.add(parseDate);
			}
	
		if(leaveEnd.isAfter(e)){
			System.out.println(endDate);
			weekDates.add(endDate);
		}
		
		request.setAttribute("weekDates", weekDates);
		if(action.equalsIgnoreCase("costReport")){
			request.getRequestDispatcher("weeklyCostReport.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("hourReport")){
		request.getRequestDispatcher("weeklyHourReport.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("taskReport")){
			request.getRequestDispatcher("weeklyTaskReport.jsp").forward(request, response);
		}
		
		
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
