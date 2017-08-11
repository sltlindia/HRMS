package com.hrms.lms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.lms.dao.AllUpdateDAO;

public class CODeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int co_id = Integer.parseInt(request.getParameter("CO_id"));
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.COCancelEmployee(co_id);
		
		request.setAttribute("delete", "CO Cancelled Successfully....");
		request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);
	}

}
