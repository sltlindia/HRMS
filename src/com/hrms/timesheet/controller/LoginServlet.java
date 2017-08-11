package com.hrms.timesheet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.timesheet.dao.LoginDAO;




public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

	 int employee_code = Integer.parseInt(request.getParameter("employee_code"));	
	 String password = request.getParameter("password");
	 
	 
	 LoginDAO loginDAO = new LoginDAO();
	 
	 boolean result = loginDAO.authenticateUser(employee_code, password);
	 
	 
	 EmployeeBean employeeBean = loginDAO.getUserByUserId(employee_code);
	 if(result == true){
		 int id = employeeBean.getRoleBean().getRole_id();
		 if(id==9){
		 HttpSession session = request.getSession();
		 session.setAttribute("user", employeeBean);
		 response.sendRedirect("empHome.jsp");
		 }else
			 if(id==6){
				 HttpSession session = request.getSession();
				 session.setAttribute("user", employeeBean);
				 response.sendRedirect("managerHome.jsp");
			 }
	 }
	 else{
		 response.sendRedirect("error.jsp");
	 }
}

}