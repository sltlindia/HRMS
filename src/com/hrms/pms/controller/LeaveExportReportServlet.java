package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.bean.LeaveHRBean;
import com.hrms.lms.dao.AllListDAO;


public class LeaveExportReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String toDate = request.getParameter("toDate");
		String fromDate = request.getParameter("fromDate");
		
		AllListDAO allListDAO = new AllListDAO();
		List<LeaveHRBean> listOfLeave = allListDAO.getLeaveHrByDate(toDate, fromDate);
		
		request.setAttribute("listOfLeave", listOfLeave);
		request.getRequestDispatcher("leaveExportReport.jsp").forward(request, response);
 		
		
		
	
	
	}

}
