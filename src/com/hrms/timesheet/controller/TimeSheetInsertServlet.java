package com.hrms.timesheet.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


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
import com.hrms.timesheet.bean.ProjectAllocationBean;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.bean.ManagerBean;
import com.hrms.pms.bean.MilestoneBean;
import com.hrms.pms.bean.MonthBean;
import com.hrms.pms.bean.PriorityBean;
import com.hrms.pms.bean.ProjectAllocationPercentageBean;
import com.hrms.pms.bean.ProjectManagerListBean;
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.StatusBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.pms.bean.YearBean;
import com.hrms.pms.dao.LoginDAO;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.bean.UnplanProjectBean;
import com.hrms.timesheet.dao.AllInsertDAO;
import com.hrms.timesheet.dao.AllListDAO;
import com.hrms.timesheet.dao.AllUpdateDAO;

public class TimeSheetInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		if (user != null) {

			String filePath = 
		             getServletContext().getInitParameter("timesheet-upload"); 
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String date = null;
			int day_id = 0;
			int project_id = 0;
			int client_id = 0;
			int task_id = 0;
			double workedHour = 0;
			String employee_comment = "-";
			String task_time_status = "-";
			String approval_status = "pending";
			String external_task = "-";
			int unplannedTask = 0;
			double percentage_completed = 0;
			boolean result = false;
			int timesheet_id = 0;
			String task_name = "-";
			String project_name ="-";
			String action ="-";
			String taskName = null;
			double sumOfHour = 0;
			String fileNameWithPath = null;
			
			
			int employee_id = user.getEmployee_master_id();
			int undermanager_id =Integer.parseInt(user.getUnder_manager_id());

			EmployeeBean employeeBean = new EmployeeBean();
			ProjectMasterBean projectMasterBean = new ProjectMasterBean();
			ClientMasterBean clientMasterBean = new ClientMasterBean();
			TaskMasterBean taskMasterBean = new TaskMasterBean();
			DayBean dayBean = new DayBean();
			
			employeeBean.setEmployee_master_id(employee_id);
			
			AllListDAO allListDAO = new AllListDAO();
			AllInsertDAO allInsertDAO = new AllInsertDAO();

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
							dayBean.setDay_id(day_id);
						}
						
						if (fieldName.equalsIgnoreCase("timesheet_id")) {
							String value = fieldValue;
							timesheet_id = Integer.parseInt(value);
							System.out.println("timesheet_id:" + timesheet_id);
						}
						
						if (fieldName.equalsIgnoreCase("task_name")) {
							task_name = fieldValue;
							System.out.println("task_name:" + task_name);
						}
						
						if (fieldName.equalsIgnoreCase("taskName")) {
							taskName = fieldValue;
							System.out.println("taskName:" + taskName);
						}
						
						
						if (fieldName.equalsIgnoreCase("project_name")) {
							project_name = fieldValue;
							System.out.println("project_name:" + project_name);
						}
						
						if (fieldName.equalsIgnoreCase("project_master_id")) {
							String value = fieldValue;
							project_id = Integer.parseInt(value);
							System.out.println("project_id:" + project_id);
							projectMasterBean.setProject_master_id(project_id);
						}
						if (fieldName.equalsIgnoreCase("client_master_id")) {
							String value = fieldValue;
							client_id = Integer.parseInt(value);
							System.out.println("clientName:" + client_id);
							clientMasterBean.setClient_master_id(client_id);
						}
						if (fieldName.equalsIgnoreCase("task_master_id")) {
							String value = fieldValue;
							task_id = Integer.parseInt(value);
							System.out.println("taskid:" + task_id);
							taskMasterBean.setTask_master_id(task_id);
						}
						if (fieldName.equalsIgnoreCase("workedHours")) {
							String value = fieldValue;
							workedHour = Double.parseDouble(value);
							System.out.println("workedHours:" + workedHour);
						}
						
						if (fieldName.equalsIgnoreCase("percentage_completed")) {
							String value = fieldValue;
							percentage_completed = Double.parseDouble(value);
							System.out.println("percentage_completed:" + workedHour);
						}
						
						if (fieldName.equalsIgnoreCase("unplannedTask")) {
							String value = fieldValue;
							unplannedTask = Integer.parseInt(value);
							System.out.println("unplannedTask:"+unplannedTask);
							
						}
						if (fieldName.equalsIgnoreCase("data")) {
							task_time_status = fieldValue;
							System.out.println("task_time_status:" + task_time_status);
						}
						if (fieldName.equalsIgnoreCase("approval_status")) {
							String value = fieldValue;
							if(approval_status.equalsIgnoreCase("rejected") || approval_status.equalsIgnoreCase("updated")){
								approval_status = "updated";
							}else{
								approval_status = "pending";
							}
							System.out.println("task_time_status:" + task_time_status);
						}
						
						if (fieldName.equalsIgnoreCase("comment")) {
							employee_comment = fieldValue;
							System.out.println("employeeComment:"+employee_comment);
						}
						
						if (fieldName.equalsIgnoreCase("action")) {
							action = fieldValue;
							System.out.println("action:"+action);
						}
						
						if (fieldName.equalsIgnoreCase("update")) {
							
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							if(workedHour != 0){	
							if(action.equalsIgnoreCase("unPlanUpdate")){
								result = allUpdateDAO.timeSheetUnplanUpdate(timesheet_id,workedHour,percentage_completed,task_time_status,employee_comment,task_name,project_name);
							}else if(action.equalsIgnoreCase("planUpdate")){
								result = allUpdateDAO.timeSheetUpdate(timesheet_id,workedHour,percentage_completed,task_time_status,employee_comment,task_id);
							}
							}
						
						}
						
						if (fieldName.equalsIgnoreCase("insert")) {
							if(workedHour != 0)
							{
							
								if(taskName != null && !task_name.equalsIgnoreCase("")){
									
									
									ProjectMasterBean p = allListDAO.getDetailsOfProject(project_id);
									if(p != null){
										
										int project_master_id = p.getProject_master_id();
										String plannedStartDate = p.getPlanned_start_date();
										String plannedEndDate = p.getPlanned_start_date();
										String duration = p.getProj_estimated_duration();
										
										System.out.println("project_id:"+project_master_id);
										double cost = 0;
										int priority_id = 1;
										
										int manager_id = 200;
										int emp_id = 0;
										LoginDAO loginDAO = new LoginDAO();
										int m_id = Integer.parseInt(user.getUnder_manager_id());
										int mm_id = user.getManagerBean().getManager_id();
										/*EmployeeBean bean = loginDAO.getEmailId(m_id);
										int e_id = bean.getEmployee_master_id();*/
										
										List<ProjectManagerListBean> listOfManager = allListDAO.getAllManagerProjectList(project_master_id, m_id);
										List<ProjectManagerListBean> listOfManager1 = allListDAO.getAllManagerProjectList(project_master_id, mm_id);
										if(listOfManager.size() != 0){
											manager_id = m_id;
										}else if(listOfManager1.size() != 0){
											manager_id = mm_id;
										}else{
											emp_id = user.getEmployee_master_id();
										}
										
										int dependent_id = 0;
										String resources = "1";
										int milestone_id = 1;
										int taskId = task_id;
										int master_task_id = 0;
										String task_desc = taskName;
										int clientId = p.getClientMasterBean().getClient_master_id();
										
										ProjectMasterBean projectMasterBeann = new ProjectMasterBean();
										ManagerBean managerBean = new ManagerBean();
										PriorityBean priorityBean = new PriorityBean();
										StatusBean statusBean = new StatusBean();
										MilestoneBean milestoneBean = new MilestoneBean();
										ClientMasterBean clientMasterBeann = new ClientMasterBean();
										
										
										clientMasterBeann.setClient_master_id(clientId);
										milestoneBean.setMilestone_id(1);
										statusBean.setStatus_id(3);
										priorityBean.setPriority_id(1);
										managerBean.setManager_id(manager_id);
										projectMasterBeann.setProject_master_id(project_master_id);
										
										TaskMasterBean taskMasterBean1 = new TaskMasterBean(taskName, task_desc, plannedStartDate, plannedEndDate, null, null, null, 0, "1", duration, null, null, null, taskId, 0, 0, projectMasterBeann, priorityBean, managerBean, statusBean, milestoneBean,emp_id);
										boolean taskInsert = allInsertDAO.taskInsert(taskMasterBean1);
										int taskMasterId = taskMasterBean1.getTask_master_id();
										taskMasterBean1.setTask_master_id(taskMasterId);
										
										double PerAllocation = 100;
										ProjectAllocationPercentageBean allocationPercentageBean = allListDAO.getDetailsOfProjectALlocastion(project_id, employee_id);
										if(allocationPercentageBean != null){
										boolean allocation = allInsertDAO.ProjectAllocationPercentageInsert(project_id, PerAllocation, employee_id,plannedStartDate,plannedEndDate,0);
										}
										
										YearBean yearBean = new YearBean();
										MonthBean monthBean = new MonthBean();
										
										String[] split = plannedStartDate.split("-");
										int year = Integer.parseInt(split[0]);
										int month = Integer.parseInt(split[1]);
										
										YearBean bean2 = allListDAO.detailsOfYear(year);
										int year_id = bean2.getYear_id();
										
										yearBean.setYear_id(year_id);
										monthBean.setMonth_id(month);
										
										
											
											boolean taskAllocation = allInsertDAO.projectAllocationInsert(yearBean, projectMasterBeann, monthBean,
													employeeBean, manager_id, taskMasterBean1);
											
										
										
										
										 if(taskMasterId != 0){
											TimeSheetBean timeSheetBean = new TimeSheetBean(employeeBean, projectMasterBeann, taskMasterBean1, clientMasterBeann, dayBean, date, workedHour, employee_comment, task_time_status, approval_status,percentage_completed,"-",0);
											result = allInsertDAO.timeSheetInsert(timeSheetBean);
										 }
										
									}
									
									
								}else{
								
								
									System.out.println(task_id);
									
									taskMasterBean.setTask_master_id(task_id);
									
								List<Object[]> listOftimesheet = allListDAO.duplicateTimeSheetList(employee_id, date, project_id, task_id, client_id);
							
							for(Object[] aRow : listOftimesheet){
								
								TimeSheetBean sheetBean = (TimeSheetBean) aRow[0];
								if(sheetBean.getTimesheet_master_id() != 0){
								System.out.println("Timesheet already exist for this task ");
								request.setAttribute("error", "<font color=red>*Timesheet already exist for this task </font>");
								request.setAttribute("project_id", project_id);
								request.setAttribute("date", date);
								request.getRequestDispatcher("addTimesheet.jsp").forward(request, response);
								return;
								}
							}
							
							if(task_id != 0){
								
								ProjectMasterBean p = allListDAO.getDetailsOfProject(project_id);
								if(p != null){
								
								String plannedStartDate = p.getPlanned_start_date();
								YearBean yearBean = new YearBean();
								MonthBean monthBean = new MonthBean();
								
								String[] split = plannedStartDate.split("-");
								int year = Integer.parseInt(split[0]);
								int month = Integer.parseInt(split[1]);
								
								YearBean bean2 = allListDAO.detailsOfYear(year);
								int year_id = bean2.getYear_id();
								
								yearBean.setYear_id(year_id);
								monthBean.setMonth_id(month);
								
								int manager_id = 200;
								
								int m_id = Integer.parseInt(user.getUnder_manager_id());
								int mm_id = user.getManagerBean().getManager_id();
								
								List<ProjectManagerListBean> listOfManager = allListDAO.getAllManagerProjectList(project_id, m_id);
								List<ProjectManagerListBean> listOfManager1 = allListDAO.getAllManagerProjectList(project_id, mm_id);
								if(listOfManager.size() != 0){
									manager_id = m_id;
								}else if(listOfManager1.size() != 0){
									manager_id = mm_id;
								}
								
								List<ProjectAllocationBean> listOfAllocationByTaskId = allListDAO.getListOfAllocationByTaskId(employee_id,task_id);
								if(listOfAllocationByTaskId.size() == 0){
								boolean taskAllocation = allInsertDAO.projectAllocationInsert(yearBean, projectMasterBean, monthBean,
										employeeBean, manager_id, taskMasterBean);
								}
								}
								
							TimeSheetBean timeSheetBean = new TimeSheetBean(employeeBean, projectMasterBean, taskMasterBean, clientMasterBean, dayBean, date, workedHour, employee_comment, task_time_status, approval_status,percentage_completed,external_task,unplannedTask);
							result = allInsertDAO.timeSheetInsert(timeSheetBean);
							}
								}
							}
						}
							
						if (fieldName.equalsIgnoreCase("redirect")) {
							
							if(task_time_status.equalsIgnoreCase("submit"))
							{
								
							fileNameWithPath = 	filePath+"\\"+user.getEmployee_code()+"_"+user.getFirstname()+" "+user.getLastname()+"_"+date+".xlsx";
								
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result1= allUpdateDAO.timeSheetSubmitStatusUpdate(employee_id, date,approval_status,task_time_status);
								boolean result2= allUpdateDAO.timeSheetUnplanSubmitStatusUpdate(employee_id, date,approval_status,task_time_status);
								
								List<Object[]> listOfTimesheet = allListDAO.getSumOfHours(employee_id, date);
								List<UnplanProjectBean> listOfUnplanTimesheet = allListDAO.getdayUnplanTimeSheetList(employee_id, date);
								
								
								//Create blank workbook
								 XSSFWorkbook workbook = new XSSFWorkbook();
								 //Create a blank sheet
								 XSSFSheet spreadsheet = workbook.createSheet(
								 " Employee Info ");
								 //Create row object
								 XSSFRow row;
								 //This data needs to be written (Object[])
								 Map < String, Object[] > empinfo =
								 new TreeMap < String, Object[] >();
								 
								 empinfo.put( "1", new Object[] {
										 "Project Name", "Task Name", "Work Hours", "Comment" });
								 int rowCount = 2;
								 
								 for(Object[] aRow : listOfTimesheet){
										TimeSheetBean t = (TimeSheetBean) aRow[0];
								 empinfo.put(Integer.toString(rowCount), new Object[] {
								 t.getProjectMasterBean().getProject_master_name(), t.getTaskMasterBean().getTask_master_name(), String.valueOf(t.getWorked_hours()),t.getEmployee_comment() });
								 rowCount++;
								 }
								 
								 for(UnplanProjectBean u : listOfUnplanTimesheet){
										 empinfo.put( Integer.toString(rowCount), new Object[] {
												u.getProject_name() , u.getTask_name(), String.valueOf(u.getWorked_hours()),u.getEmployee_comment() });
										 rowCount++;
									}
								 
								 //Iterate over data and write to sheet
								 Set < String > keyid = empinfo.keySet();
								 int rowid = 0;
								 for (String key : keyid)
								 {
								 row = spreadsheet.createRow(rowid++);
								 Object [] objectArr = empinfo.get(key);
								 int cellid = 0;
								 for (Object obj : objectArr)
								 {
									 Cell cell = row.createCell(cellid++);
									 cell.setCellValue((String)obj);
									 }
									 }
									 //Write the workbook in file system
									 FileOutputStream out1 = new FileOutputStream(
									 new File(fileNameWithPath));
									 workbook.write(out1);
									 out1.close();
									 System.out.println(
									 "Writesheet.xlsx written successfully" );
									
								
								
								
								for(Object[] aRow : listOfTimesheet){
									TimeSheetBean t = (TimeSheetBean) aRow[0];
									sumOfHour = sumOfHour + t.getWorked_hours();
								}
								
								for(UnplanProjectBean u : listOfUnplanTimesheet){
									sumOfHour = sumOfHour + u.getWorked_hours();
								}
							}
							
							request.setAttribute("project_id", project_id);
							request.setAttribute("date", date);
							if(task_time_status.equalsIgnoreCase("saved")){
								if(result == true){
									request.setAttribute("success", "Timesheet Successfully Saved");
								}
							request.getRequestDispatcher("addTimesheet.jsp").forward(request, response);
							}else{
								
								LoginDAO loginDAO = new LoginDAO(); 
								EmployeeBean employeeBean2 = loginDAO.getEmailId(undermanager_id);
								String EmailId = employeeBean2.getEmail_id();
								int emp_code = user.getEmployee_code();
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
								double totalHours = sumOfHour;
								String file = fileNameWithPath;
								
								 new Thread(new Runnable() {
									    @Override
									    public void run() {
									    	
									    	String to = EmailId;
									    	String sub = name+" Submitted Timesheet of date "+finlaDate;

									    	Mailer.timeSheetInsertMail(to, sub, finlaDate, name,manager_name,emp_code,totalHours,file);
									    	
									    }
									}).start();
								
								request.setAttribute("success", "Timesheet Successfully Submitted");
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
