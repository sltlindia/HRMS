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

public class RejectedTimeSheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
		
		int manager_id = user.getManagerBean().getManager_id();
		
		AllListDAO allListDAO1 = new AllListDAO();
		List<Object[]> rejectedTimeSheet = allListDAO1.rejectedTimeSheet(manager_id);
		List<UnplanProjectBean> rejectedUnplanTimesheet = allListDAO1.UnplanRejectedTimeSheet(manager_id);
		
		request.setAttribute("rejectedUnplanTimesheet", rejectedUnplanTimesheet);
		request.setAttribute("rejectedTimeSheet", rejectedTimeSheet);
		request.getRequestDispatcher("rejectedTimesheets.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
