package com.hrms.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrms.mailer.Mailer;
import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.timesheet.bean.DayBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.bean.UnplanProjectBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.timesheet.dao.AllDeleteDAO;
import com.hrms.timesheet.dao.AllInsertDAO;
import com.hrms.timesheet.dao.AllListDAO;
import com.hrms.timesheet.dao.AllUpdateDAO;

public class EmployeeTimeSheetUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		if(user!=null){
		
		
		String filePath = 
	             getServletContext().getInitParameter("file-upload"); 
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		
		List<FileItem> items = null;
		String fieldName = null;
		String fieldValue = null;
		String date =null;
		int day_id = 0;
		String day = null;
		int task_id=0;
		int timesheet_id=0;
		double workedHour=0;
		String employee_comment = "-";
		String manager_comment = "-";
		String task_time_status = null;
		String approval_status = "null";
		String project_name = "null";
		String task_name = "null";
		double sumOfHour = 0;
		
		
		int employee_id = user.getEmployee_master_id();
		int undermanager_id =Integer.parseInt(user.getUnder_manager_id());
		
		double percentage_completed = 0;
		TaskMasterBean taskMasterBean = new TaskMasterBean();

		AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
		AllListDAO allListDAO = new AllListDAO();
		
		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					
					
					if (fieldName.equalsIgnoreCase("timesheet_id")) {
						String value = fieldValue;
						timesheet_id = Integer.parseInt(value);
						System.out.println("timesheet_id:"+timesheet_id);
					}
					
					if (fieldName.equalsIgnoreCase("task_master_id")) {
						String value = fieldValue;
						task_id = Integer.parseInt(value);
						System.out.println("task_id:"+task_id);
					}
					
					if (fieldName.equalsIgnoreCase("approval_status")) {
						String value = fieldValue;
						if(value.equalsIgnoreCase("rejected")){
							approval_status = "updated";
						}else{
							approval_status = value;
						}
						System.out.println("approval_status:"+approval_status);
					}
					
					if (fieldName.equalsIgnoreCase("project_name")) {
						project_name = fieldValue;
						System.out.println("project_name:"+project_name);
					}
					
					if (fieldName.equalsIgnoreCase("task_name")) {
						task_name = fieldValue;
						System.out.println("task_name:"+task_name);
					}
					
					if (fieldName.equalsIgnoreCase("workedHours")) {
						String value = fieldValue;
						workedHour = Double.parseDouble(value);
						System.out.println("workedHours:"+workedHour);
					}
					
					if (fieldName.equalsIgnoreCase("date")) {
						date = fieldValue;
						System.out.println("Date:"+date);
					}
					
					if (fieldName.equalsIgnoreCase("data")) {
						task_time_status = fieldValue;
						System.out.println("task_time_status:"+task_time_status);
					}
					
					if (fieldName.equalsIgnoreCase("comment")) {
						employee_comment = fieldValue;
						System.out.println("employee_comment:"+employee_comment);
					}
					
					if (fieldName.equalsIgnoreCase("percentage_completed")) {
						String value = fieldValue;
						percentage_completed = Double.parseDouble(value);
						System.out.println("percentage_completed:"+percentage_completed);
					}
					
					if (fieldName.equalsIgnoreCase("update")) {
						taskMasterBean.setTask_master_id(task_id);
						if(workedHour != 0)
						{
							boolean result = allUpdateDAO.timeSheetUpdate(timesheet_id,workedHour,percentage_completed,task_time_status,employee_comment,task_id);
							request.setAttribute("updatedTimesheet", "Timesheet Updated Successfully");
						}
					}
					
					if (fieldName.equalsIgnoreCase("unplanUpdate")) {
						if(workedHour != 0)
						{
							boolean result = allUpdateDAO.timeSheetUnplanUpdate(timesheet_id,workedHour,percentage_completed,task_time_status,employee_comment,task_name,project_name);
							request.setAttribute("updatedTimesheet", "Timesheet Updated Successfully");
						}
					}
					
					if (fieldName.equalsIgnoreCase("redirect")) {
						
						LoginDAO loginDAO = new LoginDAO(); 
						EmployeeBean employeeBean2 = loginDAO.getEmailId(undermanager_id);
						String EmailId = employeeBean2.getEmail_id();
						int emp_code = employeeBean2.getEmployee_code();
						String manager_name = employeeBean2.getSalutation()+" "+employeeBean2.getFirstname()+" "+employeeBean2.getLastname();
						
						String parsedDate = null;
						String name = user.getFirstname()+" "+user.getLastname();
						
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
						
						String finlaDate = parsedDate;
							
						
						
						
							boolean result1= allUpdateDAO.timeSheetSubmitStatusUpdate(employee_id, date,approval_status,task_time_status);
							boolean result2= allUpdateDAO.timeSheetUnplanSubmitStatusUpdate(employee_id, date,approval_status,task_time_status);
						
							List<Object[]> listOfTimesheet = allListDAO.getSumOfHours(employee_id, date);
							List<UnplanProjectBean> listOfUnplanTimesheet = allListDAO.getdayUnplanTimeSheetList(employee_id, date);
							
							for(Object[] aRow : listOfTimesheet){
								TimeSheetBean t = (TimeSheetBean) aRow[0];
								sumOfHour = sumOfHour + t.getWorked_hours();
							}
							
							for(UnplanProjectBean u : listOfUnplanTimesheet){
								sumOfHour = sumOfHour + u.getWorked_hours();
							}
							
							request.setAttribute("date", date);
							if(task_time_status.equalsIgnoreCase("saved")){
							request.setAttribute("success", "Timesheet Successfully Updated.");
						request.getRequestDispatcher("updateTimesheet.jsp").forward(request, response);
						}else{
							
							double totalHours = sumOfHour;
							 new Thread(new Runnable() {
								    @Override
								    public void run() {
								    	
								    	String to = EmailId;
								    	String sub = name+" Updated timesheet of date "+finlaDate;

								    	Mailer.timeSheetInsertMail(to, sub, finlaDate, name,manager_name,emp_code,totalHours);
								    	
								    }
								}).start();
							
							request.setAttribute("success", "Timesheet Successfully Updated.");
							request.getRequestDispatcher("timesheet.jsp").forward(request, response);
						}
					}
					
				}else {
					
			}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	
		}else{
			request.setAttribute("sessionExpired", "Your session is expired...Please login again...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	

}
