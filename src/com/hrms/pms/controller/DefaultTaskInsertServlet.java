package com.hrms.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskDefaultListBean;
import com.hrms.pms.bean.TaskMasterBean;

/**
 * Servlet implementation class DefaultTaskInsertServlet
 */
public class DefaultTaskInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			int dept_id = user.getDepartmentBean().getDepartment_id();
			int project_id = Integer.parseInt(request.getParameter("project_id"));
			
			
			AllListDAO allListDAO = new AllListDAO();
			ProjectMasterBean p = allListDAO.getDetailsOfProject(project_id);
			
			
			
			String plannedStartDate = p.getPlanned_start_date();
			String plannedEndDate = p.getPlanned_start_date();
			String duration = p.getProj_estimated_duration();
			double cost = 0;
			int priority_id = 1;
			int manager_id = user.getManagerBean().getManager_id();
			int dependent_id = 0;
			String resources = "1";
			int milestone_id = 1;
			int task_id = 0;
			int master_task_id = 0;
			
			
			
			List<TaskDefaultListBean> listOfDefaultTask = allListDAO.getListOfDefaultTask(dept_id);
			List<Object[]> listOfTask2 = allListDAO.getTaskListByProjectMilestoneID111(project_id,manager_id);

			if(listOfTask2.size() == 0){
			
			for(TaskDefaultListBean taskDefaultListBean : listOfDefaultTask){
				
				String task_name = taskDefaultListBean.getTask_default_list_name();
				String task_desc = taskDefaultListBean.getTask_default_list_name();
				
				
				
				AllInsertDAO allInsertDAO = new AllInsertDAO();
				TaskMasterBean taskMasterBean = new TaskMasterBean();
				boolean result = allInsertDAO.taskInsert(task_name, task_desc, plannedStartDate, plannedEndDate, duration, cost, priority_id, manager_id,project_id,dependent_id,resources,milestone_id,task_id,master_task_id);
			}
			
			request.getRequestDispatcher("addTask.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("addTask.jsp").forward(request, response);
			}
			
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}	
	
	}

}
