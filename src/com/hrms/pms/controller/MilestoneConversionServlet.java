package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.dao.AllDeleteDAO;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;

/**
 * Servlet implementation class MilestoneConversionServlet
 */
public class MilestoneConversionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			int task_id = Integer.parseInt(request.getParameter("task_id"));
			AllListDAO allListDAO = new AllListDAO();
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			/* TaskMasterBean taskMasterBean = allListDAO.getDetailsOfTask(task_id);
			 
			 String milestone_name = taskMasterBean.getTask_master_name();
			 String milestone_desc = taskMasterBean.getTask_description();
			 int priority = taskMasterBean.getPriorityBean().getPriority_id();
			 int project_id = taskMasterBean.getProjectMasterBean().getProject_master_id();
			 int manager_id = taskMasterBean.getManagerBean().getManager_id();
			 String planned_start_date = taskMasterBean.getTask_planned_start_date();
			 String planned_end_date = taskMasterBean.getTask_planned_end_date();
			 String duration = taskMasterBean.getTask_estimated_duration();
			 
			 PriorityBean priorityBean = new PriorityBean();
					 priorityBean.setPriority_id(priority);
			 ProjectMasterBean projectMasterBean = new ProjectMasterBean();
					projectMasterBean.setProject_master_id(project_id);
			 ManagerBean managerBean = new  ManagerBean();
			 		managerBean.setManager_id(manager_id);
			 
			 AllInsertDAO allInsertDAO = new AllInsertDAO();
				MilestoneBean milestoneBean = new MilestoneBean(milestone_name, milestone_desc, planned_start_date, planned_end_date, projectMasterBean, priorityBean, managerBean,duration);
				boolean result = allInsertDAO.milestoneInsert(milestoneBean);
				int milestone_id = milestoneBean.getMilestone_id();*/
				
				boolean result2 = allUpdateDAO.setMilestoneOrNot(task_id);
				
				/*AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
				boolean result1= allDeleteDAO.taskDelete(task_id);*/
				
				request.setAttribute("successChange", "Task Converted into Milestone...");
				request.getRequestDispatcher("addTask.jsp").forward(request, response);
			 
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
}
