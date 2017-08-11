package com.hrms.recruitement.controller;

import java.io.IOException
;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.recruitement.dao.LoginDAO;




public class LoginServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

	 int employee_code = Integer.parseInt(request.getParameter("employee_code"));	
	 String password = request.getParameter("password");
	 
	 
	 LoginDAO loginDAO = new LoginDAO();
	 
	 boolean result = loginDAO.authenticateUser(employee_code, password);
	 
	 
	 EmployeeBean employeeBean = loginDAO.getUserByUserId(employee_code);
	 if(employeeBean != null){
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
			 }else
				 if(id==10){
					 HttpSession session = request.getSession();
					 session.setAttribute("user", employeeBean);
					 response.sendRedirect("projAdmin.jsp");
				 }if(id==1){
					 HttpSession session = request.getSession();
					 session.setAttribute("user", employeeBean);
					 response.sendRedirect("managerHome.jsp");
				 }if(id==3){
					 HttpSession session = request.getSession();
					 session.setAttribute("user", employeeBean);
					 response.sendRedirect("managerHome.jsp");
				 }if(id==12){
					 HttpSession session = request.getSession();
					 session.setAttribute("user", employeeBean);
					 response.sendRedirect("hrHome.jsp");
				 }
				 if(id==8){
					 HttpSession session = request.getSession();
					 session.setAttribute("user", employeeBean);
					 response.sendRedirect("managerHome.jsp");
				 }
	 }
	 else{
		 request.setAttribute("error", "<font color=red>Invalid Id and password</font>");
		 request.getRequestDispatcher("login.jsp").forward(request, response);
	 }
	 }
}

}