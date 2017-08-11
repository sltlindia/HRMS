package com.hrms.timesheet.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.dao.AllListDAO;

public class EmployeeReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
		
		
		int project_master_id = projectMasterBean.getProject_master_id();
		
		
		EmployeeBean employeeBean = new EmployeeBean();
		ClientMasterBean clientMasterBean = new ClientMasterBean();
		clientMasterBean.getClient_master_id();
		clientMasterBean.getClient_master_name();
		
		TimeSheetBean timeSheetBean = new TimeSheetBean();
		String task_time_status = "submit";
		timeSheetBean.getWorked_hours();
/*		String task_time_status= timeSheetBean.getTask_time_status();*/
		int employee_master_id = Integer.parseInt(request.getParameter("employee_id"));
		double sum =0;
		
		AllListDAO allListDAO1 = new AllListDAO();
		List<Object[]> employeeReport = allListDAO1.employeeReport(employee_master_id);
		System.out.println("size:"+employeeReport.size());
		
		for(Object[] aRow : employeeReport){
			TimeSheetBean sheetBean = (TimeSheetBean) aRow[0];
			
			
			System.out.println(sheetBean.getTimesheet_master_id());
			System.out.println(sheetBean.getEmployeeBean().getFirstname());
			System.out.println(task_time_status);
			System.out.println(sheetBean.getProjectMasterBean().getProject_master_name());
			System.out.println(sheetBean.getClientMasterBean().getClient_master_name());
			System.out.println(sheetBean.getWorked_hours());
			sum = sum + sheetBean.getWorked_hours();
		}
		
		System.out.println("sum:"+sum);
	
		
		request.setAttribute("employeeReport", employeeReport);
		request.getRequestDispatcher("reportOfEmployee.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		}
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
