package com.hrms.pms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
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
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskDateHistoryBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;

/**
 * Servlet implementation class SubTaskInsertServlet
 */
public class SubTaskInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		int master_task_id = Integer.parseInt(request.getParameter("master_task_id"));
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		int priority_id = 1;
		int task_id = Integer.parseInt(request.getParameter("task_id"));
		String task_name = request.getParameter("task_name");
		String task_desc = task_name;
		String plannedStartDate = request.getParameter("plannedStartDate");
		String plannedEndDate = request.getParameter("plannedEndDate");
		String duration = request.getParameter("duration");
		double cost = 0;
		String resources = "1";
		int dependent_id = 0;
		int milestone_id = 1;
		int master_task_or_not = 0;
		
		if(request.getParameter("master_task_or_not") != null){
			master_task_or_not = Integer.parseInt(request.getParameter("master_task_or_not"));
		}
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		AllListDAO allListDAO = new AllListDAO(); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		
		
		
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
		boolean result = allInsertDAO.taskInsert0(task_name, task_desc, plannedStartDate, plannedEndDate, duration, cost, priority_id, manager_id,project_id,dependent_id,resources,milestone_id,task_id,master_task_id,master_task_or_not);
		
		ArrayList<String> arrayStartDate = new ArrayList<>();
		ArrayList<String> arrayEndDate = new ArrayList<>();
		
		Date pasreEndDate = null;
		Date parseOldEndDate = null;
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		try {
			pasreEndDate = formater.parse(plannedStartDate);
			parseOldEndDate = formater.parse(plannedEndDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		TaskMasterBean master = new TaskMasterBean();
		int parentTask_id = task_id;
		TaskMasterBean taskMasterBeann = allListDAO.getDetailsOfTask(task_id);
		String parentEndDate = taskMasterBeann.getTask_planned_end_date();
			
				
				
		String minStartDate = null;
		String maxEndDate = null;
		
		List<TaskMasterBean> listOfTaskByTaskId = allListDAO.getTaskByTadskID(parentTask_id);
		
		arrayStartDate.add(plannedStartDate);
		arrayEndDate.add(plannedEndDate);
		
		for(TaskMasterBean t : listOfTaskByTaskId){
			arrayStartDate.add(t.getTask_planned_start_date());
			arrayEndDate.add(t.getTask_planned_end_date());
			
			 
		}
		
		
		minStartDate = Collections.min(arrayStartDate);
		 maxEndDate = Collections.max(arrayEndDate);
		 
		 if(parseOldEndDate.before(pasreEndDate)){
		 	master.setTask_master_id(parentTask_id);
			TaskDateHistoryBean taskDateHistoryBean = new TaskDateHistoryBean(parentEndDate, plannedEndDate,master);
			boolean resultt = allInsertDAO.taskDateHistoryInsert(taskDateHistoryBean);
		 }
		
		 System.out.println("minDate:"+minStartDate+"array:"+arrayStartDate);
		 System.out.println("maxDate:"+maxEndDate+"array:"+arrayEndDate);
		
		boolean result1 = allUpdateDAO.taskDateUpdate(parentTask_id, minStartDate, maxEndDate);
		arrayStartDate.clear();
		arrayEndDate.clear();
		
		
		
		TaskMasterBean taskMasterBean1 = allListDAO.getDetailsOfTask(parentTask_id);
		int parentOfParentTask_id = taskMasterBean1.getTask_id();
		TaskMasterBean taskMasterBeann1 = allListDAO.getDetailsOfTask(parentOfParentTask_id);
		String parentOfParentEndDate = taskMasterBeann1.getTask_planned_end_date();
		
		master.setTask_master_id(parentOfParentTask_id);
		TaskDateHistoryBean taskDateHistoryBean1 = new TaskDateHistoryBean(parentOfParentEndDate, plannedEndDate,master);
		boolean resulttt = allInsertDAO.taskDateHistoryInsert(taskDateHistoryBean1);
		
		List<TaskMasterBean> listOfTaskByTaskId1 = allListDAO.getTaskByTadskID(parentOfParentTask_id);
		
		for(TaskMasterBean t : listOfTaskByTaskId1){
			arrayStartDate.add(t.getTask_planned_start_date());
			arrayEndDate.add(t.getTask_planned_end_date());
			
		}
		
		minStartDate = Collections.min(arrayStartDate);
	    maxEndDate = Collections.max(arrayEndDate);
		
	    System.out.println("minDate:"+minStartDate+"array:"+arrayStartDate);
		System.out.println("maxDate:"+maxEndDate+"array:"+arrayEndDate);
		
		
		boolean result2 = allUpdateDAO.taskDateUpdate(parentOfParentTask_id, minStartDate, maxEndDate);
		arrayStartDate.clear();
		arrayEndDate.clear();
		
		
		TaskMasterBean taskMasterBean2 = allListDAO.getDetailsOfTask(parentOfParentTask_id);
		int taskId = taskMasterBean2.getTask_id();
		
		if(taskId != 0){
			List<TaskMasterBean> listOfTaskByTaskId2 = allListDAO.getTaskByTadskID(taskId);
			
			for(TaskMasterBean t : listOfTaskByTaskId2){
				arrayStartDate.add(t.getTask_planned_start_date());
				arrayEndDate.add(t.getTask_planned_end_date());
			}
			
			minStartDate = Collections.min(arrayStartDate);
			maxEndDate = Collections.max(arrayEndDate);
			
			System.out.println("minDate:"+minStartDate+"array:"+arrayStartDate);
			System.out.println("maxDate:"+maxEndDate+"array:"+arrayEndDate);
			
			boolean result3 = allUpdateDAO.taskDateUpdate(taskId, minStartDate, maxEndDate);
			arrayStartDate.clear();
			arrayEndDate.clear();
		}
		

		
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
