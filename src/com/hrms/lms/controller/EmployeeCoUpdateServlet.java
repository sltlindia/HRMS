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
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class EmployeeCoUpdateServlet
 */
public class EmployeeCoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeCoUpdateServlet() {
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
			String describ = null;
			EmployeeBean employeeBean = new EmployeeBean();
			LeaveCOBean leaveCOBean = new LeaveCOBean();
			AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
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
							System.out.println("Employee Id :"+ emp_id);
						}
						if (fieldName.equalsIgnoreCase("CO")) 
						{
							String value = fieldValue;
							CO = Double.parseDouble(value);
							System.out.println("CO  :"+ CO);
						}
						
						if (fieldName.equalsIgnoreCase("describe")) 
						{
							
							describ = fieldValue;
							
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
						if (fieldName.equalsIgnoreCase("status"))
						{
							
							
							SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
							Date result1 = formater1.parse(date);
							SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
							date = formater2.format(result1);
							
							Status = fieldValue;
							System.out.println("Status  : "+ Status);
							Status = "Pending";
							int mail_view = 0;
							AllUpdateDAO updateDAO = new AllUpdateDAO();
							boolean result = updateDAO.COupdateEmployee(date, StartTime, Endtime, totalhours, Status, CO_ID,describ);
							boolean result2 = updateDAO.CoMailUpdate(CO_ID, mail_view);
							if(result == true)
							{
								request.setAttribute("LeaveapprovedSuccessfully", "CO Update Successfully");
								//request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);
								response.sendRedirect("leavesuccess.jsp");
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
