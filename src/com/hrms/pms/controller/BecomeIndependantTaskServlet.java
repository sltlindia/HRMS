package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.dao.AllUpdateDAO;

public class BecomeIndependantTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int task_id = Integer.parseInt(request.getParameter("task_id"));
	
	
	AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
	boolean result = allUpdateDAO.becomeInependantTask(task_id);
	request.setAttribute("successChange", "Task Successfully Become a Independant Task.");
	request.getRequestDispatcher("addTask.jsp").forward(request, response);
	
		
	}

}
