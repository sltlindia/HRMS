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
import com.hrms.lms.dao.AllUpdateDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class EmployeeODUpdateServlet
 */
public class EmployeeODUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeODUpdateServlet() {
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
			int OD_ID = 0;
			int employee_code = 0; 
			String Startdate = null;
			String Enddate = null;
			String StartTime = null;
			String Endtime = null;
			int totalday = 0;
			int Manager_id = 0;
			String status = null;
			String describ = null;
			EmployeeBean employeeBean = new EmployeeBean();
			LeaveODBean leaveODBean = new LeaveODBean();

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
							System.out.println("OD Id:"+ OD_ID);
						}
						
						
						
						if (fieldName.equalsIgnoreCase("describe")) 
						{
							describ = fieldValue;
						}
						
						
						
						if (fieldName.equalsIgnoreCase("employee_master_id")) 
						{
							String value = fieldValue;
							employee_code = Integer.parseInt(value);
							System.out.println("Employee Code:"+ employee_code);
						}
						
						if (fieldName.equalsIgnoreCase("StartDate")) 
						{
							
							Startdate = fieldValue;
							System.out.println(" Start Date :"+ Startdate);
							
						}
						if (fieldName.equalsIgnoreCase("EndDate")) 
						{
							
							Enddate = fieldValue;
							System.out.println(" End Date :"+ Enddate);
							
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

						if (fieldName.equalsIgnoreCase("status"))
						{
							
							SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
							Date result1 = formater1.parse(Startdate);
							Date result2 = formater1.parse(Enddate);
							SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
							Startdate = formater2.format(result1);
							Enddate = formater2.format(result2);
							
							status = "Pending";
							int mail_view =0;
							AllUpdateDAO allUpdateDAO = new AllUpdateDAO();
							boolean result = allUpdateDAO.ODupdateEmployee(Startdate, Enddate, StartTime, Endtime, totalday, status, OD_ID,describ);
							boolean result3 = allUpdateDAO.ODMailUpdate(OD_ID, mail_view);
							
							if(result == true)
							{
								request.setAttribute("LeaveapprovedSuccessfully", "OD Update Successfully");
								request.getRequestDispatcher("viewODCOStatus.jsp").forward(request, response);
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
