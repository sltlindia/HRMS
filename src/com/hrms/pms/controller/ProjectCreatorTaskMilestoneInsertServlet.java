package com.hrms.pms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.bean.ProjectAdminTaskBean;
import com.hrms.pms.bean.ProjectDepartmentTaskBean;
import com.hrms.pms.bean.ProjectManagerListBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskDefaultListBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllInsertDAO;

/**
 * Servlet implementation class ProjectCreatorTaskMilestoneInsertServlet
 */
public class ProjectCreatorTaskMilestoneInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			
			int project_id = Integer.parseInt(request.getParameter("project_id"));
			int dept_id = user.getDepartmentBean().getDepartment_id();
			
			AllListDAO allListDAO = new AllListDAO();
			ProjectMasterBean p = allListDAO.getDetailsOfProject(project_id);

			List<ProjectAdminTaskBean> listOfDefaultTask = allListDAO.getListOfProjectAdminTask(project_id);
			
			String plannedStartDate = p.getPlanned_start_date();
			String plannedEndDate = p.getPlanned_end_date();
			String duration = p.getProj_estimated_duration();
			double cost = 0;
			int priority_id = 1;
			int manager_id = user.getManagerBean().getManager_id();
			if(request.getParameter("manager_id") != null){
				manager_id = Integer.parseInt(request.getParameter("manager_id"));
			}
			int dependent_id = 0;
			String resources = "1";
			int milestone_id = 1;
			int task_id = 0;
			int master_task_id  = 0;
			int master_task_or_not = 1;
			
			List<Object[]> listOfTask2 = allListDAO.getTaskListByProjectMilestoneID11(project_id,manager_id);

			if(listOfTask2.size() == 0 ){
				if(dept_id == 6 || dept_id == 7 || dept_id == 8 || dept_id == 9 || dept_id == 10 || dept_id == 11){
			
			for(ProjectAdminTaskBean projectAdminTaskBean : listOfDefaultTask){
				
				String task_name = projectAdminTaskBean.getTask_name();
				String task_desc = projectAdminTaskBean.getTask_name();
				AllInsertDAO allInsertDAO = new AllInsertDAO();
				TaskMasterBean taskMasterBean = new TaskMasterBean();
				boolean result = allInsertDAO.taskInsert0(task_name, task_desc, plannedStartDate, plannedEndDate, duration, cost, priority_id, manager_id,project_id,dependent_id,resources,milestone_id,task_id,master_task_id,master_task_or_not);
			
			}
			
			EmployeeBean employeeBean = new EmployeeBean();
			ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			
			employeeBean.setEmployee_master_id(1883);
			projectMasterBean.setProject_master_id(project_id);
			
			ProjectManagerListBean projectManagerListBean = new ProjectManagerListBean(employeeBean, projectMasterBean);
			boolean result1 = allInsertDAO.projectManagerInsert(projectManagerListBean);
				}
			}
			
			request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
			
			
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
