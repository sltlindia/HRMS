package com.hrms.pms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllInsertDAO;

public class TaskInsertServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
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
		int milestone_id = 1;
		int task_id = 0;
		int master_task_id =Integer.parseInt(request.getParameter("master_task_id"));
		if(request.getParameter("task_id") != null){
			task_id = Integer.parseInt(request.getParameter("task_id"));
		}
		
		
		
		
		
		
		
		String dt = plannedStartDate;
		
		int count = Integer.parseInt(duration)-1;
		
		
		try {
			c.setTime(sdf.parse(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=1;i<=count;i++){
		c.add(Calendar.DATE, 1);  // number of days to add
		dt = sdf.format(c.getTime());  // dt is now the new date
		System.out.println("Date:"+dt);
		plannedEndDate = dt;
		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
		    System.out.println("Sunday!");
		    count++;
		}
		}
		
		
		if(Integer.parseInt(duration) == 1){
			plannedEndDate = plannedStartDate;
		}
		
		
		duration = duration+" day(s)";
		
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
		ManagerBean managerBean = new  ManagerBean();
		PriorityBean priorityBean = new PriorityBean();
		EmployeeBean employeeBean = new EmployeeBean();
		MilestoneBean milestoneBean = new MilestoneBean();
		
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		TaskMasterBean taskMasterBean = new TaskMasterBean();
		boolean result = allInsertDAO.taskInsert(task_name, task_desc, plannedStartDate, plannedEndDate, duration, cost, priority_id, manager_id,project_id,dependent_id,resources,milestone_id,task_id,master_task_id);
		
		
		request.setAttribute("task", "One Task added");
		
		if(request.getParameter("view") != null){
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
