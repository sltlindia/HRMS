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

import com.hrms.pms.bean.TaskDateHistoryBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.AllInsertDAO;
import com.hrms.pms.dao.AllListDAO;
import com.hrms.pms.dao.AllUpdateDAO;

/**
 * Servlet implementation class DateUpdationByDaysServlet
 */
public class DateUpdationByDaysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		
		
		String startDate = request.getParameter("tStartDate");
		String endDate = request.getParameter("tEndDate");
		int task_id = Integer.parseInt(request.getParameter("task_id"));
		int layer = 0;
		if(request.getParameter("layer") != null ){
			layer = Integer.parseInt(request.getParameter("layer"));
		}
		
		int days = Integer.parseInt(request.getParameter("days"));
		System.out.println("days:"+days);
		
		SimpleDateFormat formater1 = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat formater11 = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date parseResult = formater1.parse(startDate);
			/*Date parseResult1 = formater1.parse(endDate);*/
			
			startDate = formater11.format(parseResult);
			/*endDate = formater11.format(parseResult1);*/
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		String dt = startDate;
		
		int count = days-1;
		
		
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
		endDate = dt;
		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
		    System.out.println("Sunday!");
		    count++;
		}
		}
		
		
		if(days == 1){
			endDate = startDate;
		}
		
		
		
		if(request.getParameter("actual") != null){
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			boolean result = allUpdateDAO.taskActualDateUpdate(task_id, startDate, endDate);
			
		}else{
		
		AllListDAO listDAO = new AllListDAO();
		TaskMasterBean taskBean = listDAO.getDetailsOfTask(task_id);
		
		String oldPlannedEndDate = taskBean.getTask_planned_end_date();
		AllInsertDAO allInsertDAO = new AllInsertDAO();
		TaskMasterBean master = new TaskMasterBean();
		
		Date pasreEndDate = null;
		Date parseOldEndDate = null;
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		try {
			pasreEndDate = formater.parse(endDate);
			parseOldEndDate = formater.parse(oldPlannedEndDate);
			
			if(parseOldEndDate.before(pasreEndDate) ){
				master.setTask_master_id(task_id);
				TaskDateHistoryBean taskDateHistoryBean = new TaskDateHistoryBean(oldPlannedEndDate, endDate,master);
				boolean result = allInsertDAO.taskDateHistoryInsert(taskDateHistoryBean);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		AllListDAO allListDAO = new AllListDAO();
		boolean result = allUpdateDAO.taskDateUpdate(task_id, startDate, endDate);
		
		
		
		
		ArrayList<String> arrayStartDate = new ArrayList<>();
		ArrayList<String> arrayEndDate = new ArrayList<>();
		
		if(layer == 1){
			
			TaskMasterBean taskMasterBean = allListDAO.getDetailsOfTask(task_id);
			int taskId = taskMasterBean.getTask_id();
			
			System.out.println("milestoneName:"+taskMasterBean.getMilestoneBean().getMilestone_name());
			String minStartDate = null;
			String maxEndDate = null;
			
			if(taskId != 0){
				List<TaskMasterBean> listOfTaskByTaskId = allListDAO.getTaskByTadskID(taskId);
				
				for(TaskMasterBean t : listOfTaskByTaskId){
					arrayStartDate.add(t.getTask_planned_start_date());
					arrayEndDate.add(t.getTask_planned_end_date());
				}
				
				minStartDate = Collections.min(arrayStartDate);
				maxEndDate = Collections.max(arrayEndDate);
				
				System.out.println("minDate:"+minStartDate+"array:"+arrayStartDate);
				System.out.println("maxDate:"+maxEndDate+"array:"+arrayEndDate);
				
				boolean result1 = allUpdateDAO.taskDateUpdate(taskId, minStartDate, maxEndDate);
				arrayStartDate.clear();
				arrayEndDate.clear();
			}
			
		}else if(layer == 2){
			TaskMasterBean taskMasterBean = allListDAO.getDetailsOfTask(task_id);
			int parentTask_id = taskMasterBean.getTask_id();
			TaskMasterBean taskMasterBeann = allListDAO.getDetailsOfTask(parentTask_id);
			String parentEndDate = taskMasterBeann.getTask_planned_end_date();
			
			System.out.println("parentTask:"+taskMasterBean.getTask_master_name());
			String minStartDate = null;
			String maxEndDate = null;
			
			if(parseOldEndDate.before(pasreEndDate)){
			master.setTask_master_id(parentTask_id);
			TaskDateHistoryBean taskDateHistoryBean = new TaskDateHistoryBean(parentEndDate, endDate,master);
			boolean resultt = allInsertDAO.taskDateHistoryInsert(taskDateHistoryBean);
			}
			
			List<TaskMasterBean> listOfTaskByTaskId = allListDAO.getTaskByTadskID(parentTask_id);
			
			for(TaskMasterBean t : listOfTaskByTaskId){
				arrayStartDate.add(t.getTask_planned_start_date());
				arrayEndDate.add(t.getTask_planned_end_date());
			}
			
			minStartDate = Collections.min(arrayStartDate);
			maxEndDate = Collections.max(arrayEndDate);
			
			System.out.println("minDate:"+minStartDate+"array:"+arrayStartDate);
			System.out.println("maxDate:"+maxEndDate+"array:"+arrayEndDate);
			
			boolean result1 = allUpdateDAO.taskDateUpdate(parentTask_id, minStartDate, maxEndDate);
			arrayStartDate.clear();
			arrayEndDate.clear();
			
			TaskMasterBean taskMasterBean1 = allListDAO.getDetailsOfTask(parentTask_id);
			int taskId = taskMasterBean1.getTask_id();
			
			if(taskId != 0){
				List<TaskMasterBean> listOfTaskByTaskId1 = allListDAO.getTaskByTadskID(taskId);
				
				for(TaskMasterBean t : listOfTaskByTaskId1){
					arrayStartDate.add(t.getTask_planned_start_date());
					arrayEndDate.add(t.getTask_planned_end_date());
				}
				
				minStartDate = Collections.min(arrayStartDate);
				maxEndDate = Collections.max(arrayEndDate);
				
				System.out.println("minDate:"+minStartDate+"array:"+arrayStartDate);
				System.out.println("maxDate:"+maxEndDate+"array:"+arrayEndDate);
				
				boolean result2 = allUpdateDAO.taskDateUpdate(taskId, minStartDate, maxEndDate);
				arrayStartDate.clear();
				arrayEndDate.clear();
			}
			
			
		}else if(layer == 3){
			
			TaskMasterBean taskMasterBean = allListDAO.getDetailsOfTask(task_id);
			int parentTask_id = taskMasterBean.getTask_id();
			TaskMasterBean taskMasterBeann = allListDAO.getDetailsOfTask(parentTask_id);
			String parentEndDate = taskMasterBeann.getTask_planned_end_date();
				
					
					
			String minStartDate = null;
			String maxEndDate = null;
			
			List<TaskMasterBean> listOfTaskByTaskId = allListDAO.getTaskByTadskID(parentTask_id);
			
			for(TaskMasterBean t : listOfTaskByTaskId){
				arrayStartDate.add(t.getTask_planned_start_date());
				arrayEndDate.add(t.getTask_planned_end_date());
				
				 
			}
			
			
			minStartDate = Collections.min(arrayStartDate);
			 maxEndDate = Collections.max(arrayEndDate);
			 
			 if(parseOldEndDate.before(pasreEndDate)){
			 	master.setTask_master_id(parentTask_id);
				TaskDateHistoryBean taskDateHistoryBean = new TaskDateHistoryBean(parentEndDate, endDate,master);
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
			TaskDateHistoryBean taskDateHistoryBean1 = new TaskDateHistoryBean(parentOfParentEndDate, endDate,master);
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
			
			
		}
		}
		
		if(request.getParameter("creatorView") != null){
			request.getRequestDispatcher("projectCreatorView.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("addTask.jsp").forward(request, response);
		}
		
		
	}

}
