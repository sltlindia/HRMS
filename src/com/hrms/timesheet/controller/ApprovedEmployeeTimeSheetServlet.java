package com.hrms.timesheet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.timesheet.dao.AllListDAO;

public class ApprovedEmployeeTimeSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
			AllListDAO allListDAO1 = new AllListDAO();
			int employee_master_id = Integer.parseInt(request.getParameter("employee_master_id"));
			List<Object[]> approvedEmployeeTimeSheet = allListDAO1.approvedEmployeeTimeSheet(employee_master_id);
			System.out.println(approvedEmployeeTimeSheet.size());
			request.setAttribute("approvedEmployeeTimeSheet", approvedEmployeeTimeSheet);
			request.getRequestDispatcher("employeeApprovedTimesheet.jsp").forward(request, response);
	
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		
		}

	
	

}
