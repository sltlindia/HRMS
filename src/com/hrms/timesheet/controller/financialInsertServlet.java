package com.hrms.timesheet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.dao.AllInsertDAO;

public class financialInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int goal_department_id = Integer.parseInt(request.getParameter("goal_department_id"));
	int score_area_id = Integer.parseInt(request.getParameter("score_area_id"));
	String goal_details = request.getParameter("goal_details");
	String operating_defination = request.getParameter("operating_defination");
	int startyear = Integer.parseInt(request.getParameter("startyear"));
	int endyear= Integer.parseInt(request.getParameter("endyear"));
	int owner = Integer.parseInt(request.getParameter("employee_master_id"));
	int unit_of_measurement_id = Integer.parseInt(request.getParameter("unit_of_measurement_id"));
	String goal_value = request.getParameter("goal_value");
	
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	
	
	
	
	
	}

}
