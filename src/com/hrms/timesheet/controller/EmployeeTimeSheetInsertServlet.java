package com.hrms.timesheet.controller;

import java.io.File;

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

import com.hrms.pms.bean.ClientMasterBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.timesheet.bean.DayBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.dao.AllInsertDAO;
import com.hrms.timesheet.dao.AllListDAO;
import com.hrms.timesheet.dao.AllUpdateDAO;

public class EmployeeTimeSheetInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {

			String filePath = getServletContext().getInitParameter("file-upload");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String date = null;
			int day_id = 0;
			String day = null;
			int project_id = 0;
			String project_master_name = null;
			int client_id = 0;
			String client_master_name = null;
			int task_id = 0;
			double workedHour = 0;
			double leaveHour = 0;
			String employee_comment = "-";
			String task_time_status = "-";
			String approval_status = "pending";
			String external_task = "-";
			double percentage_completed = 0;
			
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

						if (fieldName.equalsIgnoreCase("day_id")) {
							String value = fieldValue;
							day_id = Integer.parseInt(value);
							System.out.println("day_id:" + day_id);
						}
						if (fieldName.equalsIgnoreCase("day")) {
							day = fieldValue;
							System.out.println("day:" + day);
						}
						
						if (fieldName.equalsIgnoreCase("task_Desc")) {
							external_task = fieldValue;
							System.out.println("external_task:" + external_task);
						}

						if (fieldName.equalsIgnoreCase("project_master_id")) {
							String value = fieldValue;
							project_id = Integer.parseInt(value);
							System.out.println("projectName:" + project_id);
						}
						if (fieldName.equalsIgnoreCase("client_master_id")) {
							String value = fieldValue;
							client_id = Integer.parseInt(value);
							System.out.println("clientName:" + client_id);
						}
						if (fieldName.equalsIgnoreCase("task_master_id")) {
							String value = fieldValue;
							task_id = Integer.parseInt(value);
							System.out.println("taskid:" + task_id);
						}
						if (fieldName.equalsIgnoreCase("workedHours")) {
							String value = fieldValue;
							workedHour = Double.parseDouble(value);
							System.out.println("workedHours:" + workedHour);
						}
						if (fieldName.equalsIgnoreCase("data")) {
							task_time_status = fieldValue;
							System.out.println("task_time_status:" + task_time_status);
							
							if(task_time_status.equalsIgnoreCase("submit"))
							{
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result= allUpdateDAO.timeSheetSubmitStatusUpdate1(employee_id, date);
							}

						}if (fieldName.equalsIgnoreCase("employeeComment")) {
							employee_comment = fieldValue;
							System.out.println("employeeComment:"+employee_comment);
							
						}

						if (fieldName.equalsIgnoreCase("percentage_completed")) {
							String value = fieldValue;
							percentage_completed = Double.parseDouble(value);
							employeeBean.setEmployee_master_id(employee_id);
							taskMasterBean.setTask_master_id(task_id);
							clientMasterBean.setClient_master_id(client_id);
							projectMasterBean.setProject_master_id(project_id);
							dayBean.setDay_id(day_id);

							AllInsertDAO allInsertDAO = new AllInsertDAO();
							AllListDAO allListDAO = new AllListDAO();
							
							if(workedHour != 0)
							{
							List<Object[]> listOftimesheet = allListDAO.duplicateTimeSheetList(employee_id, date, project_id, task_id, client_id);
							for(Object[] aRow : listOftimesheet){
								
								TimeSheetBean sheetBean = (TimeSheetBean) aRow[0];
								if(sheetBean.getTimesheet_master_id() != 0){
								System.out.println("Timesheet already exist for this task ");
								session.setAttribute("default", "<font color=red>*Timesheet already exist for this task </font>");
								request.getRequestDispatcher("employeeTimeSheetPopup").forward(request, response);
								return;
								}
							}
							
							if(task_id != 0){
							TimeSheetBean timeSheetBean = new TimeSheetBean(employeeBean, projectMasterBean, taskMasterBean, clientMasterBean, dayBean, date, workedHour, employee_comment, task_time_status, approval_status,percentage_completed,external_task);
							boolean result = allInsertDAO.timeSheetInsert(timeSheetBean);
							request.setAttribute("successTimesheet", "Timesheet Successfully Filled");
							
								
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result1= allUpdateDAO.timeSheetEmployeeCommentUpdate(employee_id, date, employee_comment);
								System.out.println("update comment");
							}else{
								boolean result = allInsertDAO.timeSheetExternalTaskInsert(employeeBean, projectMasterBean, task_id, clientMasterBean, dayBean, date, workedHour, employee_comment, task_time_status, approval_status,percentage_completed,external_task);
								request.setAttribute("successTimesheet", "Timesheet Successfully Filled");
								
									
									AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
									boolean result1= allUpdateDAO.timeSheetEmployeeCommentUpdate(employee_id, date, employee_comment);
									System.out.println("update comment");
							}
							}
							
							
						}
						
						if (fieldName.equalsIgnoreCase("redirect")) {
							String value = fieldValue;
							System.out.println("redirect :"+value);
							if(value.equalsIgnoreCase("redirect")){
							request.getRequestDispatcher("employeeTimeSheetDefault").forward(request, response);
							}else if(value.equalsIgnoreCase("unplannedRedirect")){
							session.setAttribute("date", date);
							session.setAttribute("day", day);
							session.setAttribute("day_id", day_id);
								request.getRequestDispatcher("newUnplannedTaskEmployeeInsert").forward(request, response);
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
