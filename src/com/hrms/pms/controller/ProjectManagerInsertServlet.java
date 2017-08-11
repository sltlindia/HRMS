package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectAssignToManagerBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllUpdateDAO;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class ProjectManagerInsertServlet
 */
public class ProjectManagerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
		
		String value = request.getParameter("employee_name");
		int manager_id = user.getManagerBean().getManager_id();
		int projetc_id = Integer.parseInt(request.getParameter("project_id"));
		
		
		
		String[] split = value.split(",");
		int emp_code = Integer.parseInt(split[0]);
		String name = split[1];
		int other_manager_id = 0;
		
		String[] splitName = name.split(" ");
		String firstName = splitName[0];
		String lastName = splitName[1];
		
		System.out.println("emp_code:"+emp_code);
		System.out.println("firstName:"+firstName);
		System.out.println("lastName:"+lastName);
		
		LoginDAO loginDAO = new LoginDAO();
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		
		EmployeeBean employeeBean1 = loginDAO.getUserByUserCodeAndName(emp_code, firstName, lastName);
		
		int emp_id = employeeBean1.getEmployee_master_id();
		EmployeeBean employeeBean = new EmployeeBean();
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
		employeeBean.setEmployee_master_id(emp_id);
		projectMasterBean.setProject_master_id(projetc_id);
		
		
		
		
		if(request.getParameter("assignId") != null){
			int assignId = Integer.parseInt(request.getParameter("assignId"));
			boolean result = allUpdateDAO.assignManagerIdUpdate(assignId, emp_id);
			
		}else{
			ProjectAssignToManagerBean projectAssignToManagerBean = new ProjectAssignToManagerBean(manager_id, projectMasterBean, employeeBean);
			boolean result = allInsertDAO.projectManagerAssignInsert(projectAssignToManagerBean);
		}
		
		
		request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
		
		
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
