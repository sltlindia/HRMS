package com.hrms.timesheet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.timesheet.dao.AllUpdateDAO;

public class TimesheetIndividualUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int timesheet_id = Integer.parseInt(request.getParameter("timesheet_id"));
	double workedHour = Double.parseDouble(request.getParameter("workedHours"));
	double percentage_completed = Double.parseDouble(request.getParameter("percentage_completed"));
	String comment = request.getParameter("comment");
	String task_time_status = request.getParameter("status");
	
	AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
	if(request.getParameter("unplanUpdate") != null){
		String task_name = request.getParameter("task_name");
		String project_name = request.getParameter("project_name");
		boolean result = allUpdateDAO.timeSheetUnplanUpdate(timesheet_id,workedHour,percentage_completed,task_time_status,comment,task_name,project_name);
	}else{
		int task_id = Integer.parseInt(request.getParameter("task_id"));
		boolean result = allUpdateDAO.timeSheetUpdate(timesheet_id,workedHour,percentage_completed,task_time_status,comment,task_id);
	}
	request.setAttribute("success", "Timesheet Updated Successfully");
	request.getRequestDispatcher("addTimesheet.jsp").forward(request, response);
	
	}

}
