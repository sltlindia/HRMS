package com.hrms.pms.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectAllocationPercentageBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;

public class ProjectPercentageAllocationInsertServlet extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		
		if(user!=null){
			int myId = user.getEmployee_master_id();
	String[] employee_master_id = request.getParameterValues("chkEmployee");
	int project_id = Integer.parseInt(request.getParameter("project_id"));
	String action = request.getParameter("action");
	String endDate = request.getParameter("end_date");
	double costAllocation = 0;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String starDate = dateFormat.format(date);
	
	EmployeeBean employeeBean = new EmployeeBean();	
	
	
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	
	for(String chkempid : employee_master_id ){
		System.out.println("employee_master_id:"+chkempid);
	}
	
	
	ProjectAllocationPercentageBean allocationPercentageBean = new ProjectAllocationPercentageBean();
		
		for(String employee : employee_master_id ){
			System.out.println("employee:"+employee);
			int employee1 = Integer.parseInt(employee);
			employeeBean.setEmployee_master_id(employee1);
			
			
			if(request.getParameter("percentage"+employee1) != null){
				double PerAllocation = Double.parseDouble(request.getParameter("percentage"+employee1));
				if(request.getParameter("cost"+employee1) != null){
				costAllocation = Double.parseDouble(request.getParameter("cost"+employee1));
				}
				boolean allocation = allInsertDAO.ProjectAllocationPercentageInsert(project_id, PerAllocation, employee1,starDate,endDate,costAllocation,myId);
				int id = allocationPercentageBean.getProject_allocation_percentage_id();
				System.out.println("id:"+allocationPercentageBean.getProject_allocation_percentage_id());
				System.out.println("percentage inserted...");
				
			}
			
			
		}
		
		if(action.equalsIgnoreCase("projectAllocation")){		
		request.setAttribute("insertData", "Project Successfully Added");
		request.getRequestDispatcher("addTask.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("addTask")){
			request.setAttribute("insertData", "Employee Successfully added in Project");
			request.getRequestDispatcher("allocationChangeTransfer.jsp").forward(request, response);
		}if(action.equalsIgnoreCase("projAdmin")){
			request.setAttribute("insertData", "Employee Successfully added in Project");
			request.getRequestDispatcher("allocationChangeTransfer.jsp").forward(request, response);
		}
		
	}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
