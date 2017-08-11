package com.hrms.pms.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class AllocationPercentageChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
	int myId = user.getEmployee_master_id();
	double allcationPercentage =Double.parseDouble(request.getParameter("allcationPercentage"));
	int id =Integer.parseInt(request.getParameter("allcation_id"));
	int project_id =Integer.parseInt(request.getParameter("project_id"));
	int emlployee_id =Integer.parseInt(request.getParameter("employee_id"));
	String endDate1 =request.getParameter("endDate");
	double cost = 0;
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
	String endDate = dateFormat.format(date);
	
	AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	boolean result = allUpdateDAO.projectAllocationPercentageUpdate(endDate, id);
	
	boolean allocation = allInsertDAO.ProjectAllocationPercentageInsert(project_id, allcationPercentage, emlployee_id,endDate,endDate1,cost,myId);
	request.setAttribute("successChange", "allocation Percentage successfully changed");
	
	if(request.getParameter("employeeStatus") != null){
		request.getRequestDispatcher("employeeAllocationStatus.jsp").forward(request, response);
	}else{
		if(request.getParameter("creatorView") != null){
			request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response); 
		}else{
		request.getRequestDispatcher("addTask.jsp").forward(request, response); 
		}
	}
	
	
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
