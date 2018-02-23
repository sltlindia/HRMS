package com.hrms.lms.controller;

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

import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.pms.bean.EmployeeBean;


public class COInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		EmployeeBean user = (EmployeeBean)session.getAttribute("user");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		if(user!=null)
		{
			List<FileItem> items = null;
			String fieldName = null;
			String fieldValue = null;
			int employee_code = 0; 
			String describe = null;
			String date = null;
			String StartTime = null;
			String Endtime = null;
			double totalhours = 0;
			int Manager_id = 0;
			String hours = null;
			String status = "Pending";
			String sunday = null;
			int mail_view = 0;
			EmployeeBean employeeBean = new EmployeeBean();
			LeaveCOBean leaveCOBean = new LeaveCOBean();
			
			try {
				items = upload.parseRequest(request);// Parse Request
				for (int i = 0; i < items.size(); i++) {
					FileItem item = items.get(i);
				
					
					if (item.isFormField())
					{
						fieldName = item.getFieldName();
						fieldValue = item.getString();
						if (fieldName.equalsIgnoreCase("employee_master_id")) 
						{
							String value = fieldValue;
							employee_code = Integer.parseInt(value);
							System.out.println("Employee Code:"+ employee_code);
						}
						
						if (fieldName.equalsIgnoreCase("describe")) 
						{
							
							describe = fieldValue;
							System.out.println(" Describe :"+ describe);
							
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
							hours = fieldValue;
							System.out.println("Total hours : "+ hours);	
						}
						
						if (fieldName.equalsIgnoreCase("reportingManager"))
						{
							String value = fieldValue;
							Manager_id = Integer.parseInt(value);
							System.out.println("Report Manager Id "+ Manager_id);	
						}
						
						if (fieldName.equalsIgnoreCase("sunday"))
						{
							
							sunday = fieldValue;
							System.out.println("Sunday : "+ sunday);
							
						}

						if (fieldName.equalsIgnoreCase("redirect"))
						{
							
							AllLMSListDAO allListDAO = new  AllLMSListDAO();
							AllInsertDAO allInsertDAO = new  AllInsertDAO();
							List<LeaveCOBean> duplicate = allListDAO.getCODupicate(date, employee_code);
					
							if(duplicate.size() == 0)
							{
								totalhours = Double.parseDouble(hours);
								employeeBean.setEmployee_master_id(employee_code);
								leaveCOBean = new LeaveCOBean(employeeBean , describe , date , StartTime , Endtime , totalhours , Manager_id , status, sunday,mail_view);
								boolean result = allInsertDAO.leaveCOInsert(leaveCOBean);
								if(result == true)
								{
									System.out.println("CO Insert Successfully");
									request.setAttribute("LeaveSuccessfully", "CO Applied Successfully");
									request.getRequestDispatcher("leaveCO.jsp").forward(request, response);
								}
							}
							else
							{
								System.out.println("Leave From Date And To Date Already exit");
								request.setAttribute("LeavefromtodateExist", "CO This Date Already Exists");
								/*request.getRequestDispatcher("leaveCO.jsp").forward(request, response);*/
								response.sendRedirect("leaveCO.jsp");
							}
						}
						
					}
				}
			}
			catch (FileUploadException e) 
			{
				
			}
			
			
		}
	}
	
}



