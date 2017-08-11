package com.hrms.timesheet.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.dao.AllListDAO;

/**
 * Servlet implementation class TimerForTimesheetServlet
 */
public class TimerForTimesheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		LoginDAO loginDAO = new LoginDAO();
		AllListDAO allListDAO = new AllListDAO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String currDate = sdf.format(date);
		String parseDate = sdf1.format(date);
		
		
List<EmployeeBean> listOfEmployee = loginDAO.getListOfEmployeeByDepartment();
		
		for(EmployeeBean e : listOfEmployee){
			
			int emp_id = e.getEmployee_master_id();
			String email_id = e.getEmail_id();
			String name = e.getFirstname()+" "+ e.getLastname();
			
			List<TimeSheetBean> listOfTimesheet = allListDAO.getSumOfHoursEmployeeWise1(emp_id, currDate);
			
			if(listOfTimesheet.size() == 0){
				 new Thread(new Runnable() {
					    @Override
					    public void run() {
					    	
					    	String to = email_id;
					    	String sub = parseDate +": Fill Timesheet";
					    	
					    		Mailer.timesheetReminder(to, sub, parseDate, name);
					    		System.out.println("Done :"+name);
					    }
					}).start();
				
				 System.out.println("Done :"+name+":"+currDate);
			}else{
				System.out.println(name+":Timesheet Already Submitted...:"+currDate);
			}
		}
	
	}

}
