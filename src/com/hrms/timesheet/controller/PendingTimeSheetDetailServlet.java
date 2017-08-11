package com.hrms.timesheet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.timesheet.bean.UnplanProjectBean;
import com.hrms.timesheet.dao.AllListDAO;

public class PendingTimeSheetDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
		int employee_master_id	= Integer.parseInt(request.getParameter("employee_master_id"));
		String date = request.getParameter("date");
		AllListDAO allListDAO1 = new AllListDAO();
		List<Object[]> pendingTimesheetView = allListDAO1.pendingTimesheetView(employee_master_id,date);
		List<UnplanProjectBean> getdailyUnplanTimeSheetList = allListDAO1.getdayUnplanTimeSheetList(employee_master_id, date);
		System.out.println(pendingTimesheetView.size());
		request.setAttribute("pendingTimesheetView", pendingTimesheetView);
		request.setAttribute("getdailyUnplanTimeSheetList", getdailyUnplanTimeSheetList);
		request.getRequestDispatcher("viewAllPendingTimesheet.jsp").forward(request, response);
	
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
