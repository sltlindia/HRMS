package com.hrms.timesheet.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.timesheet.bean.ProjectAllocationBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.dao.AllListDAO;


public class StatusReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		
		if (user != null) {
		
	String startDate = request.getParameter("startDate");
	String endDate = request.getParameter("endDate");
	int employee_id = user.getEmployee_master_id();	
	int department_id = user.getDepartmentBean().getDepartment_id();	
	
	LocalDate startOfTask = LocalDate.parse(endDate);
	startOfTask = startOfTask.plusDays(6);
	System.out.println("Start date of Task:" + startOfTask);
	String date = startOfTask.toString();
	
		TimeSheetBean timeSheetBean = new TimeSheetBean();
		AllListDAO allListDAO = new AllListDAO();
		
		List<ProjectAllocationBean> listofTask = allListDAO.getListOfTaskByDate1(employee_id, endDate,
				date);
		List<TimeSheetBean> listOfStatusReport = allListDAO.getStatusReportAll(startDate, endDate,employee_id,department_id);
		request.setAttribute("listofTask", listofTask);
		request.setAttribute("listOfStatusReport", listOfStatusReport);
		
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.getRequestDispatcher("statusReport.jsp").forward(request, response);
		
		
			}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
}
