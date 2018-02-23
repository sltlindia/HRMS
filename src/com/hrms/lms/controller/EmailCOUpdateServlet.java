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

import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.bean.LeaveHRBean;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;
import com.hrms.pms.dao.LoginDAO;

/**
 * Servlet implementation class EmailCOUpdateServlet
 */
public class EmailCOUpdateServlet extends HttpServlet {
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
			int CO_ID = 0; 
			double CO = 0, SUMCO = 0;
			double CO1 = 0;
			String date = null;
			String StartTime = null;
			String Endtime = null;
			double totalhours = 0;
			int emp_id = 0;
			String Status  = null;
			String reason = null;
			int LeaveType = 3;
			String Approval_Date = null;
			int Approval_By = 0;
			int code = 0;
			String hrApproval = "null";
			EmployeeBean employeeBean = new EmployeeBean();
			LeaveCOBean leaveCOBean = new LeaveCOBean();
			LeaveHRBean leaveHRBean = new LeaveHRBean();
			LoginDAO loginDAO = new LoginDAO();
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
			AllInsertDAO allInsertDAO = new AllInsertDAO();
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
				
					
					if (item.isFormField())
					{
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						if (fieldName.equalsIgnoreCase("CO_ID")) 
						{
							String value = fieldValue;
							CO_ID = Integer.parseInt(value);
							System.out.println("CO_ID :"+ CO_ID);
						}
						if (fieldName.equalsIgnoreCase("Empid")) 
						{
							String value = fieldValue;
							emp_id = Integer.parseInt(value);
							System.out.println("Emp _id  :"+ emp_id);
						}
						if (fieldName.equalsIgnoreCase("CO")) 
						{
							String value = fieldValue;
							CO = Double.parseDouble(value);
							System.out.println("CO  :"+ CO);
						}
						
						if (fieldName.equalsIgnoreCase("fromDate")) 
						{
							
							date = fieldValue;
							System.out.println(" Date :"+ date);
							
						}
						
						if (fieldName.equalsIgnoreCase("starttime"))
						{
							StartTime = fieldValue;
							System.out.println("Start Time:" + StartTime);
						}
						
						if (fieldName.equalsIgnoreCase("endtime"))
						{
							
							Endtime = fieldValue;
							System.out.println("End Time : "+ Endtime);
							
						}
					
						if (fieldName.equalsIgnoreCase("totalhours"))
						{
							String value = fieldValue;
							totalhours = Double.parseDouble(value);
							System.out.println("Total hours : "+ totalhours);	
						}
						if (fieldName.equalsIgnoreCase("remarks"))
						{
							reason = fieldValue;
							System.out.println("reason: "+ reason);
							
						}
						if (fieldName.equalsIgnoreCase("approval")) 
						{
							String value = fieldValue;
							Approval_By = Integer.parseInt(value);
							System.out.println(" Approval By :"+ Approval_By);
							
							employeeBean = loginDAO.getEmailId(Approval_By);
							code = employeeBean.getEmployee_code();
						}
						
						if (fieldName.equalsIgnoreCase("hrApproval")) 
						{
							hrApproval= fieldValue;
							System.out.println(" Approval By :"+ Approval_By);
						}
						
						
						if (fieldName.equalsIgnoreCase("status"))
						{
							Status = fieldValue;
							System.out.println("Status  : "+ Status);
							employeeBean.setEmployee_master_id(emp_id);
							leaveCOBean.setCO_ID(CO_ID);
							if(Status.equalsIgnoreCase("approved"))
							{
								
								DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
								Date today = Calendar.getInstance().getTime();  
								String date1= dateFormat.format(today);
								
								try 
								{
									SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
									Date result = formater.parse(date1);
									SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
									Date result1 = formater1.parse(date);
									Date result2 = formater1.parse(date);
									SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
									date = formater2.format(result1);
									date = formater2.format(result2);
									Approval_Date = formater2.format(result);
									
									System.out.println(" OD From Date  " + date);
									System.out.println(" OD TO Date    " + date);
									System.out.println(" Approval Date " + Approval_Date);
									System.out.println(" Leave Type ID " +  LeaveType);
								}
								catch (ParseException e1) 
								{
									e1.printStackTrace();
								}	
								
								
								
								if(totalhours <= 2.0)
								{
									CO1  = 0.0;
									SUMCO = CO + CO1;
									System.out.println("Sum CO  : "+ SUMCO);
									boolean result = allUpdateDAO.LeaveCOUpdateStatus(Status, CO_ID);
									boolean result1 = allUpdateDAO.COUpdateManager(SUMCO, emp_id);
									if(result == true)
									{
										request.setAttribute("success", "CO Successfully Approved By You");
										 /*request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);*/
										response.sendRedirect("emailSuccess.jsp");
									}
									
								}
								else if(totalhours > 2.0 && totalhours <= 4.0)
								{
									CO1  = 0.5;
									SUMCO = CO + CO1;
									System.out.println("Sum CO  : "+ SUMCO);
									boolean result = allUpdateDAO.LeaveCOUpdateStatus(Status, CO_ID);
									boolean result1 = allUpdateDAO.COUpdateManager(SUMCO, emp_id);
									
									
									leaveHRBean = new LeaveHRBean(LeaveType, employeeBean, date, date, Approval_Date, code, leaveCOBean);
									allInsertDAO.leaveHRInsert(leaveHRBean);
									if(result == true)
									{
										request.setAttribute("success", "CO Successfully Approved By You");
										/*request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);*/
										response.sendRedirect("emailSuccess.jsp");
									}
								}
								else if(totalhours > 4.0)
								{
									CO1  = 1.0;
									SUMCO = CO + CO1;
									System.out.println("Sum CO  : "+ SUMCO);
									boolean result = allUpdateDAO.LeaveCOUpdateStatus(Status, CO_ID);
									boolean result1 = allUpdateDAO.COUpdateManager(SUMCO, emp_id);
									leaveHRBean = new LeaveHRBean(LeaveType, employeeBean, date, date, Approval_Date, code, leaveCOBean);
									allInsertDAO.leaveHRInsert(leaveHRBean);
									if(result == true)
									{
										
										request.setAttribute("success", "CO Successfully Approved By You");
										 /*request.getRequestDispatcher("emailSuccess.jsp").forward(request, response);*/
										response.sendRedirect("emailSuccess.jsp");
										
										
									}
								}
							
							}
							else if(Status.equalsIgnoreCase("rejected"))
							{
								boolean result = allUpdateDAO.COStatusreject(Status, reason, CO_ID);
								if(result == true)
								{
									
									request.setAttribute("error", "CO Successfully Rejected By You");
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
