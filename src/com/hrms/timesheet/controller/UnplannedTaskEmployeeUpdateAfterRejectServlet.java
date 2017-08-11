package com.hrms.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import com.hrms.pms.bean.ProjectMasterBean;
import com.hrms.pms.bean.TaskMasterBean;
import com.hrms.timesheet.bean.DayBean;
import com.hrms.timesheet.bean.TimeSheetBean;
import com.hrms.timesheet.dao.AllInsertDAO;
import com.hrms.timesheet.dao.AllListDAO;
import com.hrms.timesheet.dao.AllUpdateDAO;

/**
 * Servlet implementation class UnplannedTaskEmployeeUpdateAfterRejectServlet
 */
public class UnplannedTaskEmployeeUpdateAfterRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean) session.getAttribute("user");
		
		if (user != null) {

			String filePath = getServletContext().getInitParameter("file-upload");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			String dayOfWeek = null;
			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			String task_desc = "-";
			String date = null;
			int day_id = 0;
			int project_id = 0;
			int client_id = 0;
			int task_id = 0;
			double workedHour = 0;
			double percentage_completed = 0;
			String employee_comment = null;
			String task_time_status = "updated";
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

						if (fieldName.equalsIgnoreCase("day_id")) {
							String value = fieldValue;
							day_id = Integer.parseInt(value);
							System.out.println("day_id:" + day_id);
						}
						if (fieldName.equalsIgnoreCase("dayOfWeek")) {
							dayOfWeek = fieldValue;
							System.out.println("dayOfWeek" + dayOfWeek);
						}
						if (fieldName.equalsIgnoreCase("projectName")) {
							String value = fieldValue;
							project_id = Integer.parseInt(value);
							System.out.println("projectName:" + project_id);
						}
						if (fieldName.equalsIgnoreCase("clientName")) {
							String value = fieldValue;
							client_id = Integer.parseInt(value);
							System.out.println("clientName:" + value);
						}
						if (fieldName.equalsIgnoreCase("taskName")) {
							String value = fieldValue;
							task_id = Integer.parseInt(value);
							System.out.println("taskName:" + value);
						}
						if (fieldName.equalsIgnoreCase("workedHours")) {
							String value = fieldValue;
							workedHour = Double.parseDouble(value);
							System.out.println("workedHours:" + workedHour);
						}
						if (task_time_status.equalsIgnoreCase("updated")) {
							
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							boolean result= allUpdateDAO.timeSheetSubmitStatusUpdate1(employee_id, date);

					}
						if (fieldName.equalsIgnoreCase("employeeComment")) {
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
								session.setAttribute("day_id", day_id);
								session.setAttribute("date", date);
								session.setAttribute("dayOfWeek", dayOfWeek);
								request.getRequestDispatcher("newUnplannedValidationEmployee").forward(request, response);
								return;
								}
							}
									
							
							TimeSheetBean timeSheetBean = new TimeSheetBean(employeeBean, projectMasterBean, taskMasterBean, clientMasterBean, dayBean, date, workedHour, employee_comment, task_time_status, approval_status,percentage_completed,task_desc);
							boolean result = allInsertDAO.timeSheetInsert(timeSheetBean);
								AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
								boolean result1= allUpdateDAO.timeSheetEmployeeCommentUpdate(employee_id, date, employee_comment);
								System.out.println("update comment");
							}
							
						}
					}
						
						if (fieldName.equalsIgnoreCase("redirect")) {
							
							request.getRequestDispatcher("employeeTimeSheetDefault").forward(request, response);
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