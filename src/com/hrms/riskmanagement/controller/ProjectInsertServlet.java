package com.hrms.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.ProjectStatusBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.LoginDAO;

public class ProjectInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			int under_manager_id = 0;
	String manager_name =user.getFirstname()+" "+user.getLastname();		
	under_manager_id =Integer.parseInt(user.getUnder_manager_id());
	int manager_id = Integer.parseInt(request.getParameter("manager_id"));
	String projectName = request.getParameter("project_name");
	String project_desc = request.getParameter("project_desc");
	 String desc = request.getParameter("project_desc");
	String startDate = request.getParameter("plannedStartDate");
	 String desc2 = request.getParameter("plannedStartDate");
	String endDate = request.getParameter("plannedEndDate");
	String desc3 = request.getParameter("plannedEndDate");
	int client_id = Integer.parseInt(request.getParameter("client_id"));
	double cost =  Double.parseDouble(request.getParameter("cost"));
	String duration = request.getParameter("duration");
	String resources = request.getParameter("resources");
	int priority_id = Integer.parseInt(request.getParameter("priority_id"));
	int misc_Project = Integer.parseInt(request.getParameter("rdbType"));
	
	int projectStatus = 3;
	String hold_date ="-";
	String hold_reason ="-";
	String resume_date="-";
	String actual_start="-";
	String actual_end="-";
	
	System.out.println(manager_id);
	System.out.println(projectName);
	System.out.println(startDate);
	System.out.println(endDate);
	
	ManagerBean managerBean = new ManagerBean();
	ProjectStatusBean projectStatusBean = new ProjectStatusBean();
	ClientMasterBean clientMasterBean = new ClientMasterBean();
	PriorityBean priorityBean = new PriorityBean();
	managerBean.setManager_id(manager_id);
	projectStatusBean.setProject_status_id(projectStatus);
	clientMasterBean.setClient_master_id(client_id);
	priorityBean.setPriority_id(priority_id);
	
	ProjectMasterBean projectMasterBean = new ProjectMasterBean(projectName, project_desc,startDate,endDate, managerBean, projectStatusBean, hold_date, hold_reason, resume_date,cost,resources,duration,actual_end,actual_start,clientMasterBean,priorityBean,misc_Project);
	AllInsertDAO allInsertDAO = new AllInsertDAO();
	boolean result = allInsertDAO.projectInsert(projectMasterBean);
	if(result == false){
		System.out.println("Not ADD");
		request.setAttribute("sameProject", "Project Already Exist");
		/*request.getRequestDispatcher("projectAllocationWithPercentage.jsp").forward(request, response);*/
		request.getRequestDispatcher("projectList.jsp").forward(request, response);
	}else if(result == true){
		System.out.println("ADD");
		LoginDAO loginDAO = new LoginDAO();
		for(int i =1;i<=3;i++){
			if(under_manager_id != i){
			EmployeeBean employeeBean = loginDAO.getEmailId(i);
			String to = employeeBean.getEmail_id();
			String subject = "New Project Creation";
	
			String msg ="Project :"+ projectName+" is created by " +manager_name;
			String desc1 = "Project Description :"+desc; 
			
	
			Mailer.send(to, subject, msg, desc1,desc2 ,desc3);
			System.out.println("message has been sent successfully");
			}
			}
		
		if(under_manager_id != 0){
			EmployeeBean employeeBean = loginDAO.getEmailId(under_manager_id);
			String to = employeeBean.getEmail_id();
			String subject = "New Project Creation";
			String msg = "Project :"+ projectName+" is created by " +manager_name;
			String desc1 = "Project Description :"+desc;
			String desc21 = "Planned Start Date :"+desc2;
			String desc31 = "Planned End Date :"+desc3;
			
			
			Mailer.send(to, subject, msg,desc1,desc21,desc31);
			System.out.println("message has been sent successfully");
		}
		
	System.out.println("project_id:"+projectMasterBean.getProject_master_id());
	request.setAttribute("project_id", projectMasterBean.getProject_master_id());
	request.setAttribute("endDate", endDate);
	request.setAttribute("startDate", startDate);
	request.setAttribute("project_name", projectName);
	request.setAttribute("plannedResources", resources);
	request.setAttribute("insertData", "Project Successfully Added");
	request.setAttribute("action", "projectAllocation");
	request.getRequestDispatcher("projectAllocationWithPercentage.jsp").forward(request, response);
	/*request.getRequestDispatcher("projectList.jsp").forward(request, response);*/
		}
	
		}else{
				request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
	
	}

}
