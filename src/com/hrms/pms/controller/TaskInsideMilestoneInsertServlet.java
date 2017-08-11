package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.AllUpdateDAO;

public class TaskInsideMilestoneInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		
		
	int milestoneTaskId = Integer.parseInt(request.getParameter("task_id"));
	String[] task_ids = request.getParameterValues("chkTask");
	
	AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
	for(String task_id : task_ids){
		int taskId = Integer.parseInt(task_id);
		System.out.println("task_id:"+taskId);
		boolean result = allUpdateDAO.milestoneIdUpdate1(milestoneTaskId, taskId);
	}
	System.out.println("done");
	request.setAttribute("milestone", "task are added into Milestone");
	request.getRequestDispatcher("addTask.jsp").forward(request, response);
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		}

}
