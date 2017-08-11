package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectAllocationPercentageBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;
import com.hrms.pms.dao.LoginDAO;

public class TaskUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			int emp_id = 0;
			int under_manager_id = Integer.parseInt(user.getUnder_manager_id());
			LoginDAO loginDAO = new LoginDAO();
			EmployeeBean employeeBean = loginDAO.getEmployeeId(under_manager_id);
			if(employeeBean != null){
			emp_id = employeeBean.getEmployee_master_id();
			}
			
			int project_id = Integer.parseInt(request.getParameter("project_id"));	
		int priority_id = Integer.parseInt(request.getParameter("priority_id"));
		String task_name = request.getParameter("task_name");
		System.out.println("task_name:"+task_name);
		String task_desc = request.getParameter("task_desc");
		String plannedStartDate = request.getParameter("plannedStartDate");
		String plannedEndDate = request.getParameter("plannedEndDate");
		String duration = request.getParameter("duration");
		double cost = Double.parseDouble(request.getParameter("cost"));
		String resources = request.getParameter("resources");
		int dependent_id = Integer.parseInt(request.getParameter("dependent_id"));
		int task_id = Integer.parseInt(request.getParameter("task_id"));
		
		String actualStartDate = request.getParameter("actualStartDate");
		String actualEndDate = request.getParameter("actualEndDate");
		int actualResources = Integer.parseInt(request.getParameter("actualResources"));
		int changedResources = Integer.parseInt(resources);
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.taskUpdate(task_name, task_desc, plannedStartDate, plannedEndDate, cost, resources, duration, priority_id,task_id);
		
		AllListDAO allListDAO = new AllListDAO();
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		
		if(changedResources != actualResources){
			System.out.println("resourse");
		List<Object[]> listOfAllocation = allListDAO.getPerOfAllocationByProjectId(project_id);
		System.out.println("employee size :" +listOfAllocation.size());
		int resource_change = 1;
		int start_date_change = 0;
		int end_date_change = 0;
		
		
		for(Object[] aRow : listOfAllocation){
			ProjectAllocationPercentageBean p = (ProjectAllocationPercentageBean) aRow[0];
			EmployeeBean e =  (EmployeeBean) aRow[1];
			
			int employee_id = e.getEmployee_master_id();
			
			boolean insert = allInsertDAO.projectUpdateNotificationInsert1(project_id, employee_id,resource_change, start_date_change, end_date_change,task_id);
					
		}
		
		for(int i=5;i<=7;i++){
			if(emp_id != i){
			boolean insert = allInsertDAO.projectUpdateNotificationInsert1(project_id, i,resource_change, start_date_change, end_date_change,task_id);
		}
		}
		if(emp_id != 0){
			boolean insert = allInsertDAO.projectUpdateNotificationInsert1(project_id, emp_id,resource_change, start_date_change, end_date_change,task_id);
		}
		
		
		}
		
		if(actualStartDate.equalsIgnoreCase(plannedStartDate)){
			System.out.println("date not change");
		}else{
			System.out.println("start date");
			List<Object[]> listOfAllocation = allListDAO.getPerOfAllocationByProjectId(project_id);
			System.out.println("employee size :" +listOfAllocation.size());
			int resource_change = 0;
			int start_date_change = 1;
			int end_date_change = 0;
			
			for(Object[] aRow : listOfAllocation){
				ProjectAllocationPercentageBean p = (ProjectAllocationPercentageBean) aRow[0];
				EmployeeBean e =  (EmployeeBean) aRow[1];
				
				int employee_id = e.getEmployee_master_id();
				
				boolean insert = allInsertDAO.projectUpdateNotificationInsert1(project_id, employee_id,resource_change, start_date_change, end_date_change,task_id);
						
			}
			
			for(int i=5;i<=7;i++){
				if(emp_id != i){
				boolean insert = allInsertDAO.projectUpdateNotificationInsert1(project_id, i,resource_change, start_date_change, end_date_change,task_id);
			}
			}
			
			if(emp_id != 0){
				boolean insert = allInsertDAO.projectUpdateNotificationInsert1(project_id, emp_id,resource_change, start_date_change, end_date_change,task_id);
			}
			
			}
		
		
		if(actualEndDate.equalsIgnoreCase(plannedEndDate)){
			System.out.println("end date not change");
		}else{
			System.out.println("end date");
			List<Object[]> listOfAllocation = allListDAO.getPerOfAllocationByProjectId(project_id);
			System.out.println("employee size :" +listOfAllocation.size());
			int resource_change = 0;
			int start_date_change = 0;
			int end_date_change = 1;
			
			for(Object[] aRow : listOfAllocation){
				ProjectAllocationPercentageBean p = (ProjectAllocationPercentageBean) aRow[0];
				EmployeeBean e =  (EmployeeBean) aRow[1];
				
				int employee_id = e.getEmployee_master_id();
				
				boolean insert = allInsertDAO.projectUpdateNotificationInsert1(project_id, employee_id,resource_change, start_date_change, end_date_change,task_id);
						
			}
			
			for(int i=5;i<=7;i++){
				if(emp_id != i){
				boolean insert = allInsertDAO.projectUpdateNotificationInsert1(project_id, i,resource_change, start_date_change, end_date_change,task_id);
			}
			}
			
			if(emp_id != 0){
				boolean insert = allInsertDAO.projectUpdateNotificationInsert1(project_id, emp_id,resource_change, start_date_change, end_date_change,task_id);
			}
			
			
			}
		
		
		
		request.setAttribute("task", "One Task updated successfully");
		if(request.getParameter("creatorView") != null){
			request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response); 
		}else{
		request.getRequestDispatcher("addTask.jsp").forward(request, response); 
		}
		
		
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	
	}

}
