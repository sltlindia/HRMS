package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;

/**
 * Servlet implementation class TaskAllocationServlet
 */
public class TaskAllocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
	int emp_id = Integer.parseInt(request.getParameter("empId"));
	int manager_id = Integer.parseInt(request.getParameter("managerId"));
	int projectId = Integer.parseInt(request.getParameter("project_id"));
	int myId = user.getEmployee_master_id();
	
	String[] taskArray = request.getParameterValues("task_id");
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	AllListDAO allListDAO = new AllListDAO();
	
	TaskMasterBean taskMasterBean = new TaskMasterBean();
	EmployeeBean employeeBean = new EmployeeBean();
	ProjectMasterBean projectMasterBean = new ProjectMasterBean();
	YearBean yearBean = new YearBean();
	MonthBean monthBean = new MonthBean();
	
	projectMasterBean.setProject_master_id(projectId);
	employeeBean.setEmployee_master_id(emp_id);
	
	
	ProjectMasterBean bean =  allListDAO.getDetailsOfProject(projectId);
	String startDate = bean.getPlanned_start_date();
	
	String[] split = startDate.split("-");
	int year = Integer.parseInt(split[0]);
	int month = Integer.parseInt(split[1]);
	
	YearBean bean2 = allListDAO.detailsOfYear(year);
	int year_id = bean2.getYear_id();
	
	yearBean.setYear_id(year_id);
	monthBean.setMonth_id(month);
	
	
	for(String t : taskArray){
		int task_id = Integer.parseInt(t);
		System.out.println(task_id);
		
		taskMasterBean.setTask_master_id(task_id);
		
		boolean result = allInsertDAO.projectAllocationInsert(yearBean, projectMasterBean, monthBean,
				employeeBean, manager_id, taskMasterBean,myId);
		
	}
	
	
	request.setAttribute("Employee", "Employees Allocated successfully");
	if(request.getParameter("creatorView") != null){
		request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response); 
	}else{
	request.getRequestDispatcher("addTask.jsp").forward(request, response); 
	}
	
		}else{
		request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	}

}
