package com.hrms.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class SpecialHRCOApprovalServlet
 */
public class SpecialHRCOApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecialHRCOApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
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
			String sunday = null;
			int CO_ID = 0;
			int totalhours = 0;
			int Manager_id = 0;
			String status = "Pending";
			EmployeeBean employeeBean = new EmployeeBean();
			LeaveCOBean leaveCOBean = new LeaveCOBean();
			int mail_view = 1;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date11 = new Date();
			String date1 = sdf.format(date11);
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
							String value = fieldValue;
							totalhours = (int) Double.parseDouble(value);
							System.out.println("Total hours : "+ totalhours);	
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
							
							SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
							Date result1 = formater1.parse(date);
							SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
							date = formater2.format(result1);
							
							AllLMSListDAO allListDAO = new  AllLMSListDAO();
							AllInsertDAO allInsertDAO = new  AllInsertDAO();
							List<LeaveCOBean> duplicate = allListDAO.getCODupicate(date, employee_code);
					
							if(duplicate.size() == 0)
							{
							
								employeeBean.setEmployee_master_id(employee_code);
								leaveCOBean = new LeaveCOBean(employeeBean , describe , date , StartTime , Endtime , totalhours , Manager_id , status , sunday,mail_view , date1);
							
								boolean result = allInsertDAO.leaveCOInsert(leaveCOBean);
								 CO_ID = leaveCOBean.getCO_ID();
								 System.out.println("CO _ID " + CO_ID);
								if(result == true)
								{
									System.out.println("CO Insert Successfully");
									request.setAttribute("LeaveSuccessfully", "CO Apply Successfully");
									request.setAttribute("CO_ID", CO_ID);
									request.getRequestDispatcher("LeaveCOManagerShow").forward(request, response);
								}
							}
							else
							{
								System.out.println("Leave From Date And To Date Already exit");
								request.setAttribute("LeavefromtodateExist", "CO This Date Already Exists");
								//request.getRequestDispatcher("leaveCO.jsp").forward(request, response);
							}
						}
						
					}
				}
			}
			catch (FileUploadException e) 
			{
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
