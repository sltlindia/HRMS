package com.hrms.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
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

import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.timesheet.bean.DayBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.dao.AllDeleteDAO;
import com.hrms.timesheet.dao.AllInsertDAO;
import com.hrms.timesheet.dao.AllListDAO;
import com.hrms.timesheet.dao.AllUpdateDAO;
import com.hrms.timesheet.dao.TimeSheetDAO;

public class TimeSheetUpdateServlet extends HttpServlet {
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
		int project_id=0;
		int client_id=0;
		int task_id=0;
		int timesheet_id=0;
		double workedHour=0;
		double percentage_completed = 0;
		String employee_comment = "-";
		String manager_comment = "-";
		String task_time_status = null;
		String approval_status = "pending";
		int employee_id = user.getEmployee_master_id();
		EmployeeBean employeeBean = new EmployeeBean();
		ProjectMasterBean projectMasterBean = new ProjectMasterBean();
		ClientMasterBean clientMasterBean = new ClientMasterBean();
		TaskMasterBean taskMasterBean = new TaskMasterBean();
		DayBean dayBean = new DayBean();


		try {
			items = upload.parseRequest(request);// Parse Request
			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
			
				
				if (item.isFormField()) {
					fieldName = item.getFieldName();
					fieldValue = item.getString();
					if (fieldName.equalsIgnoreCase("date")) {
						date = fieldValue;
						System.out.println("date:" + date);
					}
					if (fieldName.equalsIgnoreCase("day")) {
						day = fieldValue;
						System.out.println("day:" + day);
					}
					if (fieldName.equalsIgnoreCase("day_id")) {
						String value = fieldValue;
						day_id = Integer.parseInt(value);
						System.out.println("day_id:" + day_id);
					}
					
					if (fieldName.equalsIgnoreCase("timesheet_id")) {
						String value = fieldValue;
						timesheet_id = Integer.parseInt(value);
						System.out.println("timesheet_id:"+timesheet_id);
					}
					
					if (fieldName.equalsIgnoreCase("workedHours")) {
						String value = fieldValue;
						workedHour = Double.parseDouble(value);
						System.out.println("workedHours:"+workedHour);
					}
					if (fieldName.equalsIgnoreCase("data")) {
						task_time_status = fieldValue;
						System.out.println("task_time_status:"+task_time_status);
					}
					if (fieldName.equalsIgnoreCase("employeeComment")) {
						employee_comment = fieldValue;
						System.out.println("employeeComment:"+employee_comment);
					}
					
					if (fieldName.equalsIgnoreCase("percentage_completed")) {
						String value = fieldValue;
						percentage_completed = Double.parseDouble(value);
						System.out.println("percentage_completed:"+percentage_completed);
						
						taskMasterBean.setTask_master_id(task_id);
						clientMasterBean.setClient_master_id(client_id);
						if(workedHour != 0)
						{
						AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
						boolean result = allUpdateDAO.timeSheetUpdate(timesheet_id, workedHour, percentage_completed, task_time_status);
						request.setAttribute("updatedTimesheet", "Timesheet Updated Successfully");
						}
						if(workedHour == 0)
						{
						AllDeleteDAO allDeleteDAO = new AllDeleteDAO();
						boolean result = allDeleteDAO.timeSheetDelete1(timesheet_id);
						
						}
						
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							boolean result1= allUpdateDAO.timeSheetEmployeeCommentUpdate(employee_id, date, employee_comment);
							System.out.println("update comment");
					}
					
					if (fieldName.equalsIgnoreCase("redirect")) {
						String value = fieldValue;
						System.out.println("redirect :"+value);
						if(value.equalsIgnoreCase("redirect")){
						request.getRequestDispatcher("managerTimeSheetDefault").forward(request, response);
						}else if(value.equalsIgnoreCase("unplannedRedirect")){
						session.setAttribute("date", date);
						session.setAttribute("day", day);
						session.setAttribute("day_id", day_id);
							request.getRequestDispatcher("newUnplannedTaskManagerInsert").forward(request, response);
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

