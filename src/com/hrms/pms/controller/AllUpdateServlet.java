package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.dao.AllUpdateDAO;

public class AllUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		if(request.getParameter("milestone_id") != null){
		
		int milestone_id =Integer.parseInt(request.getParameter("milestone_id"));
		String milestone_name = request.getParameter("milestone_name");
		String milestone_description = request.getParameter("milestone_desc");
		int priority = Integer.parseInt(request.getParameter("priority_id"));
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		String start_date = request.getParameter("plannedStartDate");
		String end_date = request.getParameter("plannedEndDate");
		String duration = request.getParameter("duration");
		
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.milestoneUpdate(milestone_id, milestone_name, milestone_description, priority,start_date,end_date,duration);
		request.setAttribute("update", "update successfully");
		request.getRequestDispatcher("addTask.jsp").forward(request, response);
		
		
		
		
	}	
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
