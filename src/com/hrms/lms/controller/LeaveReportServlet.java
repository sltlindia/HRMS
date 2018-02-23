package com.hrms.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.bean.LeavecutBalance;
import com.hrms.lms.dao.AllLMSListDAO;

public class LeaveReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int emp_code =Integer.parseInt(request.getParameter("employeeCode"));
		
		AllLMSListDAO allListDAO = new AllLMSListDAO();
		
		List<LeavecutBalance> listOfLeaveReport = allListDAO.getLeaveReport(emp_code);
		request.setAttribute("listOfLeaveReport", listOfLeaveReport);
		/*request.getRequestDispatcher("LeaveBalanceReport.jsp").forward(request, response);*/
		response.sendRedirect("LeaveBalanceReport.jsp");
 		
	}

}
