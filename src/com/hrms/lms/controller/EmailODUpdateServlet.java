package com.hrms.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

import com.hrms.lms.bean.LeaveHRBean;
import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class EmailODUpdateServlet
 */
public class EmailODUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			int OD_ID = 0; 
			int emp_id = 0;
			int LeaveType = 0;
			String FromDate = null;
			String ToDate = null;
			String Approval_Date = null;
			int Approval_By = 0;
			String Status  = null;
			String reason = null;
			String hrApproval = "";
			int code = 0;
			
			LoginDAO loginDAO = new LoginDAO();
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
				
					
					if (item.isFormField())
					{
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						if (fieldName.equalsIgnoreCase("OD_Id")) 
						{
							String value = fieldValue;
							OD_ID = Integer.parseInt(value);
							System.out.println("OO_ID :"+ OD_ID);
						}
						
						if (fieldName.equalsIgnoreCase("Empid")) 
						{
							String value = fieldValue;
							emp_id = Integer.parseInt(value);
							System.out.println(" Empid :"+ emp_id);
						}
						if (fieldName.equalsIgnoreCase("StartDate")) 
						{
							
							FromDate = fieldValue;
							System.out.println("From Date :"+ FromDate);
							
						}
						if (fieldName.equalsIgnoreCase("EndDate")) 
						{
							
							ToDate = fieldValue;
							System.out.println(" To Date :"+ ToDate);
							
						}
						
						if (fieldName.equalsIgnoreCase("approval")) 
						{
							String value = fieldValue;
							Approval_By = Integer.parseInt(value);
							System.out.println(" Approval By :"+ Approval_By);
							
							EmployeeBean employeeBean = loginDAO.getEmailId(Approval_By);
							code = employeeBean.getEmployee_code();
						}
						
						if (fieldName.equalsIgnoreCase("remarks"))
						{
							reason = fieldValue;
							System.out.println("reason: "+ reason);
							
						}
						
						if (fieldName.equalsIgnoreCase("hrApproval"))
						{
							hrApproval = fieldValue;
							
						}
						if (fieldName.equalsIgnoreCase("status"))
						{
							Status = fieldValue;
							System.out.println("Status  : "+ Status);
							
							if(Status.equalsIgnoreCase("approved"))
							{
								
								LeaveType = 4;
								DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
								Date today = Calendar.getInstance().getTime();  
								String date1= dateFormat.format(today);
								LeaveHRBean leaveHRBean = new LeaveHRBean();
								EmployeeBean employeeBean = new EmployeeBean();
								LeaveODBean leaveODBean = new LeaveODBean();
								AllInsertDAO allInsertDAO = new AllInsertDAO();
								employeeBean.setEmployee_master_id(emp_id);
								leaveODBean.setOD_ID(OD_ID);
								
								try 
								{
									SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
									Date result = formater.parse(date1);
									SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
									Date result1 = formater1.parse(FromDate);
									Date result2 = formater1.parse(ToDate);
									SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
									FromDate = formater2.format(result1);
									ToDate = formater2.format(result2);
									Approval_Date = formater2.format(result);
									
									System.out.println(" OD From Date  " + FromDate);
									System.out.println(" OD TO Date    " + ToDate);
									System.out.println(" Approval Date " + Approval_Date);
									System.out.println(" Leave Type ID " +  LeaveType);
								}
								catch (ParseException e1) 
								{
									e1.printStackTrace();
								}	
								
								
								boolean result = allUpdateDAO.ODApprovedStatus(status, apdate, OD_ID)(Status, OD_ID);
								leaveHRBean = new LeaveHRBean(LeaveType, employeeBean, FromDate, ToDate, Approval_Date, code, leaveODBean);
								allInsertDAO.leaveHRInsert(leaveHRBean);
								if(result == true)
								{
									request.setAttribute("success", "OD Successfully Approved By You");
									 /*request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);*/
									response.sendRedirect("emailSuccess.jsp");
									
									
								}
							
							}
							else if(Status.equalsIgnoreCase("rejected"))
							{
								boolean result = allUpdateDAO.ODStatusreject(Status, reason, OD_ID);
								if(result == true)
								{
									
									request.setAttribute("error", "OD Successfully Rejected By You");
									/*request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);*/
									response.sendRedirect("emailSuccess.jsp");
								}
								
							}
							
						}
					}
				}
			}
			catch(FileUploadException e)
			{
				
			}
		
		
	}

}

