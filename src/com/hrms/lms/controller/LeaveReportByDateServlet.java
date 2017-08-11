package com.hrms.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.dao.AllLMSListDAO;

public class LeaveReportByDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String date = request.getParameter("date");
	 AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
     List<LeaveBean> listOfEmployee = allLMSListDAO.getListOfEmployeeLeaveByDate(date);
     request.setAttribute("listOfEmployee", listOfEmployee);
     request.setAttribute("date", date);
     request.getRequestDispatcher("leaveReportByDate.jsp").forward(request, response);
	
	}

}
