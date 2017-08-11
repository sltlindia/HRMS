package com.hrms.grievancemanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.grievancemanagement.dao.AllUpdateGrievanceDAO;

public class GrivanceEscalationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int emp_id = Integer.parseInt(request.getParameter("employee_master_id"));
	int grievance_id = Integer.parseInt(request.getParameter("grievance_id"));
	
	
	AllUpdateGrievanceDAO allUpdateGrievanceDAO = new AllUpdateGrievanceDAO();
	boolean result = allUpdateGrievanceDAO.grievanceQueryEscalation(emp_id, grievance_id);
	
	request.getRequestDispatcher("allGrievanceList.jsp").forward(request, response);
	
	}

}
