package com.hrms.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.pms.bean.EmployeeBean;


public class LeaveBalanceEmployeeReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null)
		{
			int emp_code = 0;
			emp_code = user.getEmployee_code();
			
			AllLMSListDAO allListDAO = new AllLMSListDAO();
			
			List<LeavecutBalance> listOfLeaveReport = allListDAO.getLeaveReport(emp_code);
			request.setAttribute("listOfLeaveReport", listOfLeaveReport);
			request.getRequestDispatcher("LeaveEmployeeBalanceReport.jsp").forward(request, response);
		
		}
		else
		{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	
	
	
	}

}
