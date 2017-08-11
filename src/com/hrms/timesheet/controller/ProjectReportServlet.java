package com.hrms.timesheet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.timesheet.bean.TimeSheetBean;

/**
 * Servlet implementation class ProjectReportServlet
 */
public class ProjectReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
		
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
		
		
		int project_master_id = projectMasterBean.getProject_master_id();
		
		
		EmployeeBean employeeBean = new EmployeeBean();
		ClientMasterBean clientMasterBean = new ClientMasterBean();
		clientMasterBean.getClient_master_id();
		clientMasterBean.getClient_master_name();
		
		TimeSheetBean timeSheetBean = new TimeSheetBean();
		String task_time_status = "submit";
		timeSheetBean.getWorked_hours();
		int employee_master_id = Integer.parseInt(request.getParameter("employee_id"));
		int sum =0;
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
