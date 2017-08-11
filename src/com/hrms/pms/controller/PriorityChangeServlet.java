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
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;
import com.hrms.timesheet.bean.ProjectAllocationBean;

public class PriorityChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		String action = request.getParameter("action");
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		AllListDAO allListDAO = new AllListDAO();
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		
		if(action.equalsIgnoreCase("project")){
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		int priority_id = Integer.parseInt(request.getParameter("priority_id"));
		 int milestone_id = 1;
		 int show_notification = 0;
		 int task_id = 0;
		boolean result = allUpdateDAO.projectPriorityUpdate(project_id, priority_id);
		
		List<Object[]> listOfAllocation = allListDAO.getListOfAllocationByProjectId(project_id);
		System.out.println("employee size :" +listOfAllocation.size());
		for(Object[] aRow : listOfAllocation){
			ProjectAllocationBean p = (ProjectAllocationBean) aRow[0];
			ProjectMasterBean p1 = (ProjectMasterBean) aRow[1];
			EmployeeBean e =  (EmployeeBean) aRow[2];
			
			int employee_id = e.getEmployee_master_id();
			
			boolean insert = allInsertDAO.cahngePriorityNotificationInsert(project_id, employee_id,priority_id,milestone_id,show_notification,task_id);
					
		}
		
		request.setAttribute("priority", "Project Priority change successfully");
		if(request.getParameter("redirect") !=null){
			request.getRequestDispatcher("projAdminList.jsp").forward(request, response);
		}else{
		request.getRequestDispatcher("projectList.jsp").forward(request, response);
		}
		}
		
		if(action.equalsIgnoreCase("milestone")){
			int milestone_id = Integer.parseInt(request.getParameter("milestone_id"));
			int priority_id = Integer.parseInt(request.getParameter("priority_id"));
			int project_id = Integer.parseInt(request.getParameter("project_id"));
			int show_notification = 0;
			int task_id = 0;
			boolean result = allUpdateDAO.milestonePriorityUpdate(milestone_id, priority_id);
			List<Object[]> listOfAllocation = allListDAO.getListOfAllocationByProjectId(project_id);
			System.out.println("employee size :" +listOfAllocation.size());
			for(Object[] aRow : listOfAllocation){
				ProjectAllocationBean p = (ProjectAllocationBean) aRow[0];
				ProjectMasterBean p1 = (ProjectMasterBean) aRow[1];
				EmployeeBean e =  (EmployeeBean) aRow[2];
				
				int employee_id = e.getEmployee_master_id();
				
				boolean insert = allInsertDAO.cahngePriorityNotificationInsert(project_id, employee_id,priority_id,milestone_id,show_notification,task_id);
						
			}
			request.setAttribute("priority", "Milestone Priority change successfully");
			request.getRequestDispatcher("addTask.jsp").forward(request, response);
			}
		
		if(action.equalsIgnoreCase("task")){
			int task_id = Integer.parseInt(request.getParameter("task_id"));
			int priority_id = Integer.parseInt(request.getParameter("priority_id"));
			int project_id = Integer.parseInt(request.getParameter("project_id"));
			int milestone_id = 1;
			int show_notification = 0;
			
			boolean result = allUpdateDAO.taskPriorityUpdate(task_id, priority_id);
			List<Object[]> listOfAllocation = allListDAO.getListOfAllocationByProjectId(project_id);
			System.out.println("employee size :" +listOfAllocation.size());
			for(Object[] aRow : listOfAllocation){
				ProjectAllocationBean p = (ProjectAllocationBean) aRow[0];
				ProjectMasterBean p1 = (ProjectMasterBean) aRow[1];
				EmployeeBean e =  (EmployeeBean) aRow[2];
				
				int employee_id = e.getEmployee_master_id();
				
				boolean insert = allInsertDAO.cahngePriorityNotificationInsert(project_id, employee_id,priority_id,milestone_id,show_notification,task_id);
						
			}
			request.setAttribute("priority", "task Priority change successfully");
			request.getRequestDispatcher("addTask.jsp").forward(request, response);
			}
	
		
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	}

}
