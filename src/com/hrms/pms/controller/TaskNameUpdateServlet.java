package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.dao.AllUpdateDAO;

/**
 * Servlet implementation class TaskNameUpdateServlet
 */
public class TaskNameUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int task_id = Integer.parseInt(request.getParameter("task_id"));
		String task_name = request.getParameter("task_name");
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.taskNameUpdate(task_id, task_name);
		
		if(request.getParameter("projectCreator") != null){
			request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("addTask.jsp").forward(request, response);
		}		
		
	}

}
