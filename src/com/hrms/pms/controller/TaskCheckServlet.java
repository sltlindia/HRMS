package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.dao.AllListDAO;


public class TaskCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		 
		 if(request.getParameter("action").equalsIgnoreCase("milestoneInsert")){
			 AllListDAO allListDAO = new AllListDAO();
			 int milestone_id = Integer.parseInt(request.getParameter("milestone_id"));
			 
			 List<Object[]> listOfTask = allListDAO.MilestonetaskList(milestone_id);
			 if(listOfTask.size() == 0){
				 
				 request.setAttribute("noTask","Their should be atleast one task in this Milestone");
				 request.getRequestDispatcher("addTask.jsp").forward(request, response);
			 }else{
				 request.getRequestDispatcher("projectAllocation.jsp").forward(request, response);
				 }
			 
			 
		 }
		 
		 if(request.getParameter("action").equalsIgnoreCase("projectInsert")){
			 AllListDAO allListDAO = new AllListDAO();
			
			 List<Object[]> listOfTasks = allListDAO.taskList(project_id);
			 if(listOfTasks.size() == 0){
					 request.setAttribute("noTask","Their should be atleast one task in this project..please add task in this project");
					 request.getRequestDispatcher("projectList.jsp").forward(request, response);
				}else{
					 request.getRequestDispatcher("projectAllocation.jsp").forward(request, response);
					 }
			 
		 }

	
	
	}

}
