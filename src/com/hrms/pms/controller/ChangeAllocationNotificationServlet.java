package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.dao.AllUpdateDAO;

public class ChangeAllocationNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int allocation_id = Integer.parseInt(request.getParameter("allocation_id"));
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		
		boolean result = allUpdateDAO.changeAllocationShowView(allocation_id);
		request.getRequestDispatcher("managerHome.jsp").forward(request, response);
		
		
	}

}
