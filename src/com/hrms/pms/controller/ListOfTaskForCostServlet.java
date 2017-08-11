package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllListDAO;

public class ListOfTaskForCostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		System.out.println("project_id:"+project_id);
		
		AllListDAO allListDAO = new AllListDAO();
		List<Object[]> listOfMilestone = allListDAO.getMilestoneListByProjectId(project_id);
		List<TaskMasterBean> listOfTask = allListDAO.getTaskListByProjectId1(project_id);
		ProjectMasterBean projectMasterBean = allListDAO.getDetailsOfProject(project_id);
		
		request.setAttribute("listOfMilestone", listOfMilestone);
		request.setAttribute("listOfTask", listOfTask);
		request.setAttribute("projectMasterBean", projectMasterBean);
		request.getRequestDispatcher("costVariance.jsp").forward(request, response);
		
	
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		}
	

}
