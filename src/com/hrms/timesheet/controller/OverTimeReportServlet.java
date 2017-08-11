package com.hrms.timesheet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.dao.AllListDAO;

public class OverTimeReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		
		if (user != null) {
		
	String startDate = request.getParameter("startDate");
	String endDate = request.getParameter("endDate");
	int role_id = user.getRoleBean().getRole_id();
	int manager_id = user.getManagerBean().getManager_id();
	
	TimeSheetBean timeSheetBean = new TimeSheetBean();
	AllListDAO allListDAO = new AllListDAO();
	List<Object[]> listOfOverTimeReport = null;
	if(role_id == 1 || role_id == 2 || role_id == 3 || role_id ==12){
		listOfOverTimeReport = allListDAO.getOverTimeAllReportHours(startDate, endDate);
	}else{
	listOfOverTimeReport = allListDAO.getOverTimeReportHours(manager_id, startDate, endDate);
	}
	request.setAttribute("listOfOverTimeReport", listOfOverTimeReport );
	request.setAttribute("startDate", startDate);
	request.setAttribute("endDate", endDate);
	request.getRequestDispatcher("overTimeReport.jsp").forward(request, response);
	
	
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
