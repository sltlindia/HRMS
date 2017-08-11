package com.hrms.timesheet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.timesheet.bean.UnplanProjectBean;
import com.hrms.timesheet.dao.AllListDAO;


public class DuplicatTimesheetCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int employee_master_id = user.getEmployee_master_id();	
		int project_id = 0;
		String date = null;
		
			if(request.getParameter("date") != null){
				if(request.getParameter("project_id") != null){
			project_id = Integer.parseInt(request.getParameter("project_id"));
				}
			date = request.getParameter("date");
			}else{
				project_id = (Integer) request.getAttribute("project_id");
				date =(String) request.getAttribute("date");
			}
			
			AllListDAO allListDAO = new AllListDAO();
			List<Object[]> duplicatTimesheetForDate = allListDAO.getDuplicateDateTimesheet(employee_master_id, date);
			List<UnplanProjectBean> duplicatUnplanTimesheetForDate = allListDAO.getDuplicateDateUnplanTimesheet(employee_master_id, date);
			int duplicate = duplicatTimesheetForDate.size() + duplicatUnplanTimesheetForDate.size();
			
			List<Object[]> allTimesheet = allListDAO.getallTimesheet(employee_master_id, date);
			List<UnplanProjectBean> allUnplanTimesheet = allListDAO.getSumOfHoursEmployeeWiseUnplanList(employee_master_id, date);
			int totalTimesheet = allTimesheet.size() + allUnplanTimesheet.size();
			
		
			if(request.getParameter("update") != null){
				if(totalTimesheet!=0){
					request.getRequestDispatcher("updateTimesheet.jsp").forward(request, response);
				}else{
					request.setAttribute("error", "Timesheet of this date is not exist.");
					request.getRequestDispatcher("timesheet.jsp").forward(request, response);
				}
			}else if(request.getParameter("allList") != null){
				if(totalTimesheet!=0){
					request.getRequestDispatcher("updateTimesheet.jsp").forward(request, response);
					}
			}else if(request.getParameter("insert") !=null){
				if(duplicate != 0){
					if(request.getParameter("update") != null){
						request.setAttribute("error", "You can't update timesheet of this date because it's already submited.");
					}else{
					request.setAttribute("error", "Timesheet of this date is already submited.");
					}
					request.getRequestDispatcher("timesheet.jsp").forward(request, response);
				}else{
			request.getRequestDispatcher("addTimesheet.jsp").forward(request, response);
			}
		}	
		
		}
	}

}
