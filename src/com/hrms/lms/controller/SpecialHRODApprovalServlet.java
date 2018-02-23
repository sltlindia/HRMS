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

import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class SpecialHRODApprovalServlet
 */
public class SpecialHRODApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpecialHRODApprovalServlet() {
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
			String Startdate = null;
			String Enddate = null;
			String StartTime = null;
			String Endtime = null;
			int OD_ID = 0;
			int totalday = 0;
			int Manager_id = 0;
			String status = "Pending";
			EmployeeBean employeeBean = new EmployeeBean();
			LeaveODBean leaveODBean = new LeaveODBean();
			int mail_view = 1;

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
							System.out.println(" describe :"+ describe);
							
						}
						
						if (fieldName.equalsIgnoreCase("StartDate")) 
						{
							
							Startdate = fieldValue;
							System.out.println(" Date :"+ Startdate);
							
						}
						if (fieldName.equalsIgnoreCase("EndDate")) 
						{
							
							Enddate = fieldValue;
							System.out.println(" Date :"+ Enddate);
							
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
					
						if (fieldName.equalsIgnoreCase("numdays"))
						{
							String value = fieldValue;
							totalday = Integer.parseInt(value);
							System.out.println("Total hours : "+ totalday);	
						}
						
						if (fieldName.equalsIgnoreCase("reportingManager"))
						{
							String value = fieldValue;
							Manager_id = Integer.parseInt(value);
							System.out.println("Report Manager Id "+ Manager_id);	
						}

						if (fieldName.equalsIgnoreCase("redirect"))
						{
							
							
							SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
							Date result1 = formater1.parse(Startdate);
							Date result2 = formater1.parse(Enddate);
							SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
							Startdate = formater2.format(result1);
							Enddate = formater2.format(result2);
							
							AllLMSListDAO allListDAO = new  AllLMSListDAO();
							List<LeaveODBean> duplicate = allListDAO.getODDupicate(Startdate, Enddate, employee_code);
							
							if(duplicate.size() == 0)
							{
								AllInsertDAO allInsertDAO = new AllInsertDAO();
								employeeBean.setEmployee_master_id(employee_code);
								leaveODBean = new LeaveODBean(employeeBean , Startdate , Enddate , StartTime , Endtime , totalday , Manager_id , status, describe,mail_view);
								boolean result = allInsertDAO.leaveODInsert(leaveODBean);
								 OD_ID = leaveODBean.getOD_ID();
								 System.out.println("OD_ID " + OD_ID);
								if(result == true)
								{
									System.out.println("Insert Successfully");
									request.setAttribute("LeaveSuccessfully", "OD Apply Successfully");
									request.setAttribute("OD_ID", OD_ID);
									request.getRequestDispatcher("LeaveODManagerShow").forward(request, response);
								}
							}
							else
							{
								System.out.println("Leave From Date And To Date Already exit");
								request.setAttribute("LeavefromtodateExist", "OD This Date Already Exists");
								/*request.getRequestDispatcher("specialHRLeave.jsp").forward(request, response);*/
								response.sendRedirect("specialHRLeave.jsp");
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
