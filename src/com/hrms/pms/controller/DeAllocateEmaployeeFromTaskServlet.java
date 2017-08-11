package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.dao.AllUpdateDAO;

/**
 * Servlet implementation class DeAllocateEmaployeeFromTaskServlet
 */
public class DeAllocateEmaployeeFromTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		int task_id = Integer.parseInt(request.getParameter("taskId"));
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.deallocateEmployeeFromTaskUpdate(task_id, employee_id);
		
		
		request.setAttribute("project_id", project_id);
		if(request.getParameter("creatorView") != null){
		request.setAttribute("creatorView", "creatorView");
		}
		request.setAttribute("activeView", "milestoneOrTask");
		request.getRequestDispatcher("redirection.jsp").forward(request, response);
		
		
	
	
	}

}
