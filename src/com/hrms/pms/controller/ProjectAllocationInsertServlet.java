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
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.timesheet.bean.ProjectAllocationBean;

public class ProjectAllocationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int myId = user.getEmployee_master_id();
	int manager_id =Integer.parseInt(request.getParameter("manager_id"));
	int startyear =Integer.parseInt(request.getParameter("startyear"));
	String[] startmonth = request.getParameterValues("startchkMonth");
	String[] employee_master_id = request.getParameterValues("chkEmployee");
	int project_id = Integer.parseInt(request.getParameter("project_id"));
	
	
	
	EmployeeBean employeeBean = new EmployeeBean();	
	MonthBean monthBean = new MonthBean();
	YearBean yearBean = new YearBean();
	ProjectMasterBean projectMasterBean = new ProjectMasterBean();
	TaskMasterBean taskMasterBean = new TaskMasterBean();
	
	System.out.println("Year:"+startyear);	
	System.out.println("project:"+project_id);
	
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	for(String chkmonth : startmonth ){
		System.out.println("month:"+chkmonth);
	}
	
	for(String chkempid : employee_master_id ){
		System.out.println("employee_master_id:"+chkempid);
	}
	
	
	AllListDAO allListDAO = new AllListDAO();
	
		
		for(String employee : employee_master_id ){
			System.out.println("employee:"+employee);
			int employee1 = Integer.parseInt(employee);
			employeeBean.setEmployee_master_id(employee1);
			
			yearBean.setYear_id(startyear);
			projectMasterBean.setProject_master_id(project_id);
			
			/*if(request.getParameter("percentage"+employee1) != null){
				double PerAllocation = Double.parseDouble(request.getParameter("percentage"+employee1));
				boolean allocation = allInsertDAO.ProjectAllocationPercentageInsert(project_id, PerAllocation, employee1);
				System.out.println("percentage inserted...");
			}*/
			
				for(String chkmonth : startmonth ){
			System.out.println("month:"+chkmonth);
				int Month = Integer.parseInt(chkmonth);
				monthBean.setMonth_id(Month);
				
							List<Object[]> listOfTask = allListDAO.taskList(project_id);
							for(Object[] aRow : listOfTask){
								TaskMasterBean t  = (TaskMasterBean) aRow[0];
								
								int task_id = t.getTask_master_id();
								taskMasterBean.setTask_master_id(task_id);
								
								
								boolean result = allInsertDAO.projectAllocationInsert(yearBean, projectMasterBean, monthBean, employeeBean, manager_id,taskMasterBean,myId);
								System.out.println("inserted:"+t.getTask_master_id());
							}
			
		}
		}
		
		
		if(request.getParameter("endyear") != null){
			int endyear = Integer.parseInt(request.getParameter("endyear"));
			String[] endmonth = request.getParameterValues("endchkMonth");
			
			yearBean.setYear_id(endyear);
			projectMasterBean.setProject_master_id(project_id);

		
		for(String employee : employee_master_id ){
			System.out.println("employee:"+employee);
			int employee1 = Integer.parseInt(employee);
			employeeBean.setEmployee_master_id(employee1);
			
			
				for(String chkmonth : endmonth ){
			System.out.println("month:"+chkmonth);
				int Month = Integer.parseInt(chkmonth);
				monthBean.setMonth_id(Month);
				
							List<Object[]> listOfTask = allListDAO.taskList(project_id);
							for(Object[] aRow : listOfTask){
								TaskMasterBean t  = (TaskMasterBean) aRow[0];
								
								int task_id = t.getTask_master_id();
								taskMasterBean.setTask_master_id(task_id);
								
								boolean result = allInsertDAO.projectAllocationInsert(yearBean, projectMasterBean, monthBean, employeeBean, manager_id,taskMasterBean,myId);
								System.out.println("inserted:"+t.getTask_master_id());
							}
				
		}
		}
		}
		request.setAttribute("Employee", "Employees Allocated successfully");
		request.getRequestDispatcher("addTask.jsp").forward(request, response);
		
		
	}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
