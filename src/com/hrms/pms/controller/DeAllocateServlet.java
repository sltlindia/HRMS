package com.hrms.pms.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.ProjectAllocationPercentageBean;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class DeAllocateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int deAllocate_id = Integer.parseInt(request.getParameter("allocate_id"));
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
	String endDate = dateFormat.format(date);
	AllUpdateDAO allUpdateDAO = new  AllUpdateDAO();
	
	AllListDAO allListDAO = new AllListDAO();
	ProjectAllocationPercentageBean projectAllocationPercentageBean = allListDAO.getProjectAllocation(deAllocate_id);
	int project_id = projectAllocationPercentageBean.getProjectMasterBean().getProject_master_id();
	int emp_id = projectAllocationPercentageBean.getEmployeeBean().getEmployee_master_id();
	
	System.out.println(project_id);
	System.out.println(emp_id);
	
	boolean result = allUpdateDAO.deallocateTask(project_id, emp_id);
	System.out.println(result);
	
	boolean result1 = allUpdateDAO.projectAllocationPercentageUpdate(endDate, deAllocate_id);
	request.setAttribute("deAllocate", "Employee Successfully Deallocated in this project");
	
	if(request.getParameter("employeeStatus") != null){
		request.getRequestDispatcher("employeeAllocationStatus.jsp").forward(request, response);
	}else{
		if(request.getParameter("creatorView") != null){
			request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response); 
		}else{
		request.getRequestDispatcher("addTask.jsp").forward(request, response); 
		}
	}
	
	}

}
