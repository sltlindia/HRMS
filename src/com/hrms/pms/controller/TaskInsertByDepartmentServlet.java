package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.DepartmentBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.ProjectDepartmentTaskBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;

/**
 * Servlet implementation class TaskInsertByDepartmentServlet
 */
public class TaskInsertByDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		String[] manager = request.getParameterValues("chkManager");
		int task_id = Integer.parseInt(request.getParameter("task_id"));
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		
		String[] taskArray = request.getParameterValues("chkTask");
		
		int milestone_id = 1;
	
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		AllListDAO allListDAO = new AllListDAO();
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
		ManagerBean managerBean = new ManagerBean();
		
		projectMasterBean.setProject_master_id(project_id);
		
		
		
		
		for(String mng : manager){
			int manager_id = Integer.parseInt(mng);
			System.out.println("manager_id:"+manager_id);
			
			managerBean.setManager_id(manager_id);
			
			boolean result1 = allUpdateDAO.setMasterTaskIdToZero(task_id,manager_id);
			
			ProjectDepartmentTaskBean projectDepartmentTaskBean1 = allListDAO.getProjectDepartmentTask(project_id, manager_id,task_id);
			
		
			if(projectDepartmentTaskBean1 == null){
			ProjectDepartmentTaskBean projectDepartmentTaskBean = new ProjectDepartmentTaskBean(task_id, milestone_id, managerBean,projectMasterBean);
			boolean result = allInsertDAO.taskInsertByDepartment(projectDepartmentTaskBean);
			}
			
			
			
		}
		
		
		if(taskArray != null){
		
		for(String task : taskArray){
			int taskId = Integer.parseInt(task);
			boolean result = allUpdateDAO.setMasterTaskId(task_id, taskId);
			
			
			List<TaskMasterBean> listOfTaskByTask = allListDAO.getTaskByTadskID(taskId);
			for(TaskMasterBean t : listOfTaskByTask){
				int taskId1 = t.getTask_master_id();
				
				boolean result1 = allUpdateDAO.setMasterTaskId(task_id, taskId1);
				
				
				List<TaskMasterBean> listOfTaskByTask1 = allListDAO.getTaskByTadskID(taskId1);
				
				for(TaskMasterBean t1 : listOfTaskByTask1){
					int taskId2 = t1.getTask_master_id();
					
					boolean result2 = allUpdateDAO.setMasterTaskId(task_id, taskId2);
					
					List<TaskMasterBean> listOfTaskByTask12 = allListDAO.getTaskByTadskID(taskId2);
					
					for(TaskMasterBean t2 : listOfTaskByTask1){
						int taskId3 = t1.getTask_master_id();
						
						boolean result3 = allUpdateDAO.setMasterTaskId(task_id, taskId3);
						
						
					}
					
				}
				
				
			}
			
		}
		}
		request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
		
	}

}
