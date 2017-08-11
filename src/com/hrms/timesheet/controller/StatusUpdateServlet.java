package com.hrms.timesheet.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.timesheet.dao.AllUpdateDAO;

public class StatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {
	String [] ids = request.getParameterValues("check");
	String action = request.getParameter("action");	
	String redirect = "redirect";
	
	LoginDAO loginDAO = new LoginDAO();
	
	if(action.equalsIgnoreCase("approved")){
	for(String id : ids){
		String[] split = id.split(",");
		int employee_id =Integer.parseInt(split[0]);
		String date = split[1];
		System.out.println("id:"+id);
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.timeSheetStatusUpdate(employee_id,action,date);
		boolean result1 = allUpdateDAO.timeSheetUnplanStatusUpdate(employee_id,action,date);
		
	}
	}else if(action.equalsIgnoreCase("rejected")){
		String remarks = request.getParameter("remarks");
		
		
		
		for(String id : ids){
			String[] split = id.split(",");
			int employee_id =Integer.parseInt(split[0]);
			String date = split[1];
			String parsedDate = null;
			
			try 
			{
			  
				SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
				Date result1 = formater1.parse(date);
				SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
				parsedDate = formater2.format(result1);
			
			}
			catch (ParseException e1) 
			{
				e1.printStackTrace();
			}	
			
			String finalDate = parsedDate;
			
			EmployeeBean employeeBean2 = loginDAO.getEmailIdEmployee(employee_id);
			String EmailId = employeeBean2.getEmail_id();
			int emp_code = employeeBean2.getEmployee_code();
			String name = employeeBean2.getFirstname()+" "+employeeBean2.getLastname();
			
			 new Thread(new Runnable() {
				    @Override
				    public void run() {
				    	
				    	String to = EmailId;
				    	String sub = "Your Timesheet Rejected of "+finalDate;

				    	Mailer.timeSheetMail(to, sub, finalDate, remarks, emp_code,name);
				    	
				    }
				}).start();
			
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			boolean result = allUpdateDAO.timeSheetStatusRejectUpdate(employee_id,action,date,remarks);
			boolean result1 = allUpdateDAO.timeSheetUnplanStatusRejectUpdate(employee_id,action,date,remarks);
			
		}
	}else if(action.equalsIgnoreCase("PerDateapproved")){
		
		String action1 ="approved";
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String date = request.getParameter("date");
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.timeSheetStatusUpdate(employee_id,action1,date);
		boolean result1 = allUpdateDAO.timeSheetUnplanStatusUpdate(employee_id,action1,date);
		
	}else if(action.equalsIgnoreCase("PerDaterejected")){
		String action1 ="rejected";
		
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String date = request.getParameter("date");
		String remarks = request.getParameter("remarks");
		
		String parsedDate = null;
		
		try 
		{
		  
			SimpleDateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
			Date result1 = formater1.parse(date);
			SimpleDateFormat formater2 = new SimpleDateFormat("dd-MM-yyyy");
			parsedDate = formater2.format(result1);
		
		}
		catch (ParseException e1) 
		{
			e1.printStackTrace();
		}	
		
		String finalDate = parsedDate;
		
		EmployeeBean employeeBean2 = loginDAO.getEmailIdEmployee(employee_id);
		String EmailId = employeeBean2.getEmail_id();
		int emp_code = employeeBean2.getEmployee_code();
		String name = employeeBean2.getFirstname()+" "+employeeBean2.getLastname();
		
		 new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	
			    	String to = EmailId;
			    	String sub = "Your Timesheet Rejected of "+finalDate;

			    	Mailer.timeSheetMail(to, sub, finalDate, remarks, emp_code,name);
			    	
			    }
			}).start();
		
		
		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		boolean result = allUpdateDAO.timeSheetStatusRejectUpdate(employee_id,action1,date,remarks);
		boolean result1 = allUpdateDAO.timeSheetUnplanStatusRejectUpdate(employee_id,action1,date,remarks);
		
	}
	if(redirect.equalsIgnoreCase("redirect")){
		request.getRequestDispatcher("pendingTimeSheetList").forward(request, response);
	}
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
		

}
