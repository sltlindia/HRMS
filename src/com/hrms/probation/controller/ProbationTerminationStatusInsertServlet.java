package com.hrms.probation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.probation.dao.AllUpdateProbationDAO;

public class ProbationTerminationStatusInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
	String manager_status = request.getParameter("action");
	String manager_rejection_remarks = null;
	manager_rejection_remarks = request.getParameter("remarks");
	
	AllUpdateProbationDAO allUpdateProbationDAO = new AllUpdateProbationDAO();
	allUpdateProbationDAO.updateManagerStatus(employee_master_id,manager_status,manager_rejection_remarks);
	
	request.getRequestDispatcher("probationFormApprovalManager.jsp").forward(request, response);
	
	}

}
