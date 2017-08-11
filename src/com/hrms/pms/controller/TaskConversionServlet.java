package com.hrms.pms.controller;

import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllDeleteDAO;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class TaskConversionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int milestoneTask_id = Integer.parseInt(request.getParameter("milestoneTask_id"));
		
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result2 = allUpdateDAO.setMilestoneToTask(milestoneTask_id);
		
		
		request.setAttribute("successChange", "Milestone converted into Task...");
		request.getRequestDispatcher("addTask.jsp").forward(request, response);
		
		
		
	}

}
