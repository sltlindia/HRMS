package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.StatusBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllUpdateDAO;

public class MilestoneInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int project_id = Integer.parseInt(request.getParameter("project_id"));
	int manager_id = Integer.parseInt(request.getParameter("manager_id"));
	int priority_id = Integer.parseInt(request.getParameter("priority_id"));
	String milestone_name = request.getParameter("milestone_name");
	String milestone_desc = request.getParameter("milestone_desc");
	String plannedStartDate = request.getParameter("plannedStartDate");
	String plannedEndDate = request.getParameter("plannedEndDate");
	String duration = request.getParameter("duration");
	
	
	ProjectMasterBean projectMasterBean = new ProjectMasterBean();
	ManagerBean managerBean = new  ManagerBean();
	PriorityBean priorityBean = new PriorityBean();
	StatusBean statusBean = new StatusBean();
	MilestoneBean milestoneBean = new MilestoneBean();
	
	projectMasterBean.setProject_master_id(project_id);
	managerBean.setManager_id(manager_id);
	priorityBean.setPriority_id(priority_id);
	
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	
	String task_hold_date = null;
	String task_hold_reason = null;
	String task_resume_date = null;
	double task_estimated_cost = 0;
	String task_estimated_resources = "1";
	String task_actual_start_date = null;
	String task_actual_end_date = null;
	String task_percentage_completion = null;
	int milestone_or_not = 1;
	int task_id = 0;
	
	statusBean.setStatus_id(3);
	milestoneBean.setMilestone_id(1);
	
	TaskMasterBean taskMasterBean = new TaskMasterBean(milestone_name, milestone_desc, plannedStartDate, plannedEndDate, task_hold_date, task_hold_reason, task_resume_date, task_estimated_cost, task_estimated_resources, duration, task_actual_start_date, task_actual_end_date, task_percentage_completion, task_id, milestone_or_not, projectMasterBean, priorityBean, managerBean, statusBean, milestoneBean); 
	boolean result = allInsertDAO.taskInsert(taskMasterBean);
	int milestoneTask_id = taskMasterBean.getTask_master_id();
	
	
	
	if(request.getParameterValues("chkTask") != null){
	String[] task_ids = request.getParameterValues("chkTask");
	AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
	for(String task_idd : task_ids){
		int taskId = Integer.parseInt(task_idd);
		System.out.println("task_id:"+taskId);
		boolean result1 = allUpdateDAO.milestoneIdUpdate1(milestoneTask_id, taskId);
	}
	
	}
	request.setAttribute("milestone", "One milestone added");
	request.getRequestDispatcher("addTask.jsp").forward(request, response);
	
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	
	}

}
