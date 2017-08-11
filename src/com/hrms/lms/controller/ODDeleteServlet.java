package com.hrms.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.dao.AllUpdateDAO;

public class ODDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int od_id = Integer.parseInt(request.getParameter("OD_id"));
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.ODCancelEmployee(od_id);
		
		request.setAttribute("delete", "OD Cancelled Successfully....");
		request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);
		
	}

}
