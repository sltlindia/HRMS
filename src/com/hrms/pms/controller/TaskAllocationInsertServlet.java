package com.hrms.pms.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.criterion.PropertyProjection;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.ProjectAllocationPercentageBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.LoginDAO;

public class TaskAllocationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
			int myId = user.getEmployee_master_id();
			int manager_id = Integer.parseInt(request.getParameter("manager_id"));
			int startyear = Integer.parseInt(request.getParameter("startyear"));
			String[] startmonth = request.getParameterValues("startchkMonth");
			String[] employee_master_id = request.getParameterValues("chkEmployee");
			int alloc = 0;
			double costAllocation = 0;
			String endDate = request.getParameter("end_date");
			int project_id = Integer.parseInt(request.getParameter("project_id"));
			int taskId = Integer.parseInt(request.getParameter("task_id"));

			EmployeeBean employeeBean = new EmployeeBean();
			MonthBean monthBean = new MonthBean();
			YearBean yearBean = new YearBean();
			ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			TaskMasterBean taskMasterBean = new TaskMasterBean();

			System.out.println("Year:" + startyear);
			System.out.println("project:" + project_id);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String starDate = dateFormat.format(date);
			
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			AllListDAO allListDAO = new AllListDAO();
			ProjectAllocationPercentageBean allocationPercentageBean = new ProjectAllocationPercentageBean();
			
			for(String employee : employee_master_id ){
				System.out.println("employee:"+employee);
				int employee1 = Integer.parseInt(employee);
				employeeBean.setEmployee_master_id(employee1);
				
				
				LoginDAO loginDAO = new LoginDAO();
				
				EmployeeBean bean = loginDAO.getEmailIdEmployee(employee1);
				ProjectMasterBean projectMasterBean2 = allListDAO.getDetailsOfProject(project_id);
				
				String projectName = projectMasterBean2.getProject_code()+":"+projectMasterBean2.getProject_master_name();
				String email = bean.getEmail_id();
				String name = bean.getFirstname()+" "+bean.getLastname();
				
				
				
				if(request.getParameter("percentage"+employee1) != null){
					double PerAllocation = Double.parseDouble(request.getParameter("percentage"+employee1));
					if(request.getParameter("cost"+employee1) != null){
					costAllocation = Double.parseDouble(request.getParameter("cost:"+employee1));
					}
					
					List<Object[]> listOfallocation = allListDAO.getPerOfAllocation(employee1, project_id);
					
					if(listOfallocation.size() == 0){
					boolean allocation = allInsertDAO.ProjectAllocationPercentageInsert(project_id, PerAllocation, employee1,starDate,endDate,costAllocation,myId);
					int id = allocationPercentageBean.getProject_allocation_percentage_id();
					
					
					new Thread(new Runnable() {
					    @Override
					    public void run() {
					    	
					    	String to = email;
					    	String sub = "Allocation : "+projectName;
					    	
					    		Mailer.allocationReminder(to, sub, projectName, name);
					    		System.out.println("Done :"+name);
					    }
					}).start();
					
					
					}
					
				}
				
				
			}

		

			for (String startchkmonth : startmonth) {
				System.out.println("month:" + startchkmonth);
			}

			for (String chkempid : employee_master_id) {
				System.out.println("employee_master_id:" + chkempid);
			}


			for (String employee : employee_master_id) {
				System.out.println("employee:" + employee);
				int employee1 = Integer.parseInt(employee);
				employeeBean.setEmployee_master_id(employee1);
				
				yearBean.setYear_id(startyear);
				projectMasterBean.setProject_master_id(project_id);
				
				
					for (String startchkmonth : startmonth) {
					System.out.println("month:" + startchkmonth);
					int Month = Integer.parseInt(startchkmonth);
					monthBean.setMonth_id(Month);

					taskMasterBean.setTask_master_id(taskId);
					boolean result = allInsertDAO.projectAllocationInsert(yearBean, projectMasterBean, monthBean,
							employeeBean, manager_id, taskMasterBean,myId);
					System.out.println("task inserted");
					}

			}
			
			if(request.getParameter("endyear") != null){
				int endyear = Integer.parseInt(request.getParameter("endyear"));
				String[] endmonth = request.getParameterValues("endchkMonth");
				
				yearBean.setYear_id(endyear);
				projectMasterBean.setProject_master_id(project_id);
				
			for (String employee : employee_master_id) {
				System.out.println("employee:" + employee);
				int employee1 = Integer.parseInt(employee);
				employeeBean.setEmployee_master_id(employee1);
				
				
					for (String endchkmonth : endmonth) {
					System.out.println("month:" + endchkmonth);
					int Month = Integer.parseInt(endchkmonth);
					monthBean.setMonth_id(Month);

					taskMasterBean.setTask_master_id(taskId);
					
					boolean result = allInsertDAO.projectAllocationInsert(yearBean, projectMasterBean, monthBean,
							employeeBean, manager_id, taskMasterBean,myId);
					System.out.println("task inserted");
					}


			}
			
			}
			
			request.setAttribute("Employee", "Employees Allocated successfully");
			if(request.getParameter("creatorView") != null){
				request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response); 
			}else{
			request.getRequestDispatcher("addTask.jsp").forward(request, response); 
			}
			
			
			
			
		}
	else{
		request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	}

}
