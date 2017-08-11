package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectDepartmentTaskBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllDeleteDAO;
import com.hrms.pms.dao.AllListDAO;

public class AllDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
		AllListDAO allListDAO = new AllListDAO();
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		
	if(request.getParameter("task_id")!=null){
		
	int task_id = Integer.parseInt(request.getParameter("task_id"));
	int project_id = Integer.parseInt(request.getParameter("project_id"));
	
	boolean result0 = allDeleteDAO.taskDelete(task_id);
	boolean result00 = allDeleteDAO.allocationDeleteByTaskId(task_id);
	
	
	List<ProjectDepartmentTaskBean> listOfDepartmentTask0 = allListDAO.getListOfDepartmentByTaskId(task_id);
	for(ProjectDepartmentTaskBean pdtb : listOfDepartmentTask0){
		int manager_id = pdtb.getManagerBean().getManager_id();
		boolean deptResult = allUpdateDAO.setMasterTaskIdToZero(task_id,manager_id);
	}
	
	
	List<TaskMasterBean> listOfSubTask = allListDAO.getTaskByTadskID(task_id);
	for(TaskMasterBean t1 : listOfSubTask){
		int task_id1 = t1.getTask_master_id();
		
		boolean result1 = allDeleteDAO.taskDelete(task_id1);
		boolean result11 = allDeleteDAO.allocationDeleteByTaskId(task_id1);
		boolean result111 = allDeleteDAO.departmentDeleteByTaskId(task_id1);
		
		
		List<ProjectDepartmentTaskBean> listOfDepartmentTask = allListDAO.getListOfDepartmentByTaskId(task_id1);
		for(ProjectDepartmentTaskBean pdtb : listOfDepartmentTask){
			int manager_id = pdtb.getManagerBean().getManager_id();
			boolean deptResult = allUpdateDAO.setMasterTaskIdToZero(task_id1,manager_id);
		}
		
		
		
		
		List<TaskMasterBean> listOfSubTask1 = allListDAO.getTaskByTadskID(task_id1);
		for(TaskMasterBean t2 : listOfSubTask1){
			int task_id2 = t2.getTask_master_id();
			
			boolean result2 = allDeleteDAO.taskDelete(task_id2);
			boolean result22 = allDeleteDAO.allocationDeleteByTaskId(task_id2);
			boolean result222 = allDeleteDAO.departmentDeleteByTaskId(task_id2);
			
			List<ProjectDepartmentTaskBean> listOfDepartmentTask1 = allListDAO.getListOfDepartmentByTaskId(task_id2);
			for(ProjectDepartmentTaskBean pdtb1 : listOfDepartmentTask){
				int manager_id = pdtb1.getManagerBean().getManager_id();
				boolean deptResult = allUpdateDAO.setMasterTaskIdToZero(task_id2,manager_id);
			}
			
			
			List<TaskMasterBean> listOfSubTask2 = allListDAO.getTaskByTadskID(task_id2);
			for(TaskMasterBean t3 : listOfSubTask2){
				int task_id3 = t3.getTask_master_id();
				
				boolean result3 = allDeleteDAO.taskDelete(task_id3);
				boolean result33 = allDeleteDAO.allocationDeleteByTaskId(task_id3);
				boolean result333 = allDeleteDAO.departmentDeleteByTaskId(task_id3);
				
				List<ProjectDepartmentTaskBean> listOfDepartmentTask2 = allListDAO.getListOfDepartmentByTaskId(task_id2);
				for(ProjectDepartmentTaskBean pdtb2 : listOfDepartmentTask){
					int manager_id = pdtb2.getManagerBean().getManager_id();
					boolean deptResult = allUpdateDAO.setMasterTaskIdToZero(task_id3,manager_id);
				}
				
				
			}
			
		}
		
	}
	
	if(result0 == true){
		request.setAttribute("delete", "task deleted");
	}else{
		request.setAttribute("error", "task not deleted");
	}
	if(request.getParameter("creatorView") != null){
		request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
	}else{
		request.getRequestDispatcher("addTask.jsp").forward(request, response);
	}
		}
		
		/*if(request.getParameter("milestone_id") != null){
			int milestone_id = Integer.parseInt(request.getParameter("milestone_id"));
			int project_id = Integer.parseInt(request.getParameter("project_id"));
			boolean result = allDeleteDAO.milestoneDelete(milestone_id);
			if(result == true){
				request.setAttribute("delete", "milestone deleted");
			}else{
				request.setAttribute("erroe", "milestone not deleted");
			}
			
			if(request.getParameter("creatorView") != null){
				request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("addTask.jsp").forward(request, response);
			}
		}*/
		
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

}
