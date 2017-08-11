package com.hrms.timesheet.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.timesheet.dao.AllListDAO;


public class TaskSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	int projectId = Integer.parseInt(request.getParameter("projectId"));
	System.out.println("projectId:"+projectId);
	AllListDAO allListDAO = new AllListDAO();
	List<TaskMasterBean> listOfTask = allListDAO.getTaskListByProjectId2(projectId);
	request.setAttribute("listOfTask", listOfTask);
	System.out.println("akash ramani");
	request.getRequestDispatcher("delayedTaskReport.jsp").forward(request, response);
	
	
	
	}

}
