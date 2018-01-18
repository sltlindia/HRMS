package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllDeleteDAO;

public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int employee_dummy_id= Integer.parseInt(request.getParameter("employee_dummy_id"));
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
		boolean result = allDeleteDAO.employeeDelete(employee_dummy_id);
		
		if(result == true){
			System.out.println("deleted");
			request.getRequestDispatcher("employeeList.jsp").forward(request, response);
			return;
		}
		
		else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		
		}
		}
}
	
	
	
	
	
	
	
	

