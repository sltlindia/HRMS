package com.hrms.timesheet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.timesheet.dao.AllDeleteDAO;
import com.hrms.timesheet.dao.AllUpdateDAO;

public class TimeSheetAllDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
		int employee_master_id = user.getEmployee_master_id();
		String date = request.getParameter("date");
		
		AllDeleteDAO allDeleteDAO= new AllDeleteDAO();
		boolean result = allDeleteDAO.timeSheetDelete(employee_master_id,date);
		boolean result1 = allDeleteDAO.timeSheetUnplanDelete(employee_master_id,date);
		
		request.setAttribute("success", "Timesheet successfully deleted.");
		request.getRequestDispatcher("showAllTimeSheetDetail.jsp").forward(request, response);
		
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
