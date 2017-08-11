package com.hrms.pms.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectHoldHistoryBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class ProjectHoldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
	int project_id = Integer.parseInt(request.getParameter("project_id"));
	String reason = request.getParameter("reason");
	String action = request.getParameter("action");
	String resume_date = "-";
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
	String date1 = dateFormat.format(date);
	
	System.out.println(project_id);
	System.out.println(reason);
	
	
	ProjectMasterBean projectMasterBean = new ProjectMasterBean();
	projectMasterBean.setProject_master_id(project_id);
	
	AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
	boolean result = allUpdateDAO.projectUpdate(project_id, reason, date1);
	
	
	ProjectHoldHistoryBean projectHoldHistoryBean = new ProjectHoldHistoryBean(date1, resume_date, reason, projectMasterBean);
	
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	boolean resultInsert = allInsertDAO.holdHistoryInsert(projectHoldHistoryBean);
	
	
	
	if(action.equalsIgnoreCase("admin")){
		response.sendRedirect("projAdmin.jsp");
	}else if(action.equalsIgnoreCase("manager")){
		if(request.getParameter("redirect") != null){
			response.sendRedirect("projAdminList.jsp");
		}else{
	response.sendRedirect("projectList.jsp");
		}
	}
	
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	
	}

}
