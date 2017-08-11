package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.ProjectDepartmentTaskBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;

/**
 * Servlet implementation class TaskInsertWithoutManagerServlet
 */
public class TaskInsertWithoutManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
	
		
		
		
		
		if(taskArray != null){
		
		for(String task : taskArray){
			int taskId = Integer.parseInt(task);
			boolean result = allUpdateDAO.milestoneIdUpdate1(task_id, taskId);
			
			
			/*List<TaskMasterBean> listOfTaskByTask = allListDAO.getTaskByTadskID(taskId);
			for(TaskMasterBean t : listOfTaskByTask){
				int taskId1 = t.getTask_master_id();
				
				boolean result1 = allUpdateDAO.milestoneIdUpdate1(task_id, taskId1);
				
				
				List<TaskMasterBean> listOfTaskByTask1 = allListDAO.getTaskByTadskID(taskId1);
				
				for(TaskMasterBean t1 : listOfTaskByTask1){
					int taskId2 = t1.getTask_master_id();
					
					boolean result2 = allUpdateDAO.milestoneIdUpdate1(task_id, taskId2);
					
					List<TaskMasterBean> listOfTaskByTask12 = allListDAO.getTaskByTadskID(taskId2);
					
					for(TaskMasterBean t2 : listOfTaskByTask1){
						int taskId3 = t1.getTask_master_id();
						
						boolean result3 = allUpdateDAO.milestoneIdUpdate1(task_id, taskId3);
						
						
					}
					
				}
				
				
			}*/
			
		}
		}
		request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
		
	}

}
