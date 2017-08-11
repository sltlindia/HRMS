package com.hrms.lms.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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

import com.hrms.lms.bean.LeaveBean;
import com.hrms.lms.bean.LeaveCOBean;
import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class LeaveCoServlet
 */
public class LeaveCoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveCoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
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
			double totalhours = 0;
			int Manager_id = 0;
			String status = "Pending";
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
							String value = fieldValue;
							totalhours = Double.parseDouble(value);
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
					
							List<LeaveODBean> duplicateODDATE = allListDAO.getCOODDupicate(date, date, employee_code);
							
							Calendar sundayCheck = Calendar.getInstance();    
							sundayCheck.setTime(result1);   
							
							
							
							if(duplicateODDATE.size() == 0 || sunday.equalsIgnoreCase("NO"))
							{
								System.out.println("Between Date Co NOT Already Exit");
							
							if(duplicate.size() == 0)
							{
								
								if(totalhours <= 2.0)
								{
									System.out.println("Leave From Date And To Date Already exit");
									request.setAttribute("LeavefromtodateExist", "You Are Not Eligible For CO");
									request.getRequestDispatcher("leaveCO.jsp").forward(request, response);
								}
								else
								{
						
									employeeBean.setEmployee_master_id(employee_code);
									leaveCOBean = new LeaveCOBean(employeeBean , describe , date , StartTime , Endtime , totalhours , Manager_id , status , sunday,mail_view);
									boolean result = allInsertDAO.leaveCOInsert(leaveCOBean);
									
									
									int ManagerID =  Manager_id;
									String Name = user.getFirstname() + " " + user.getLastname();
									String Leavetype = "Co";
									
									 try {
								            // open a connection to the site
								              URL  url = new URL("http://192.168.182.104/HRMS/send_notification.php?");
								              //  URL url = new URL("http://sltlhrms.16mb.com/HRMS/send_notification.php?");
								            URLConnection con = url.openConnection();
								            // activate the output
								            con.setDoOutput(true);
								            PrintStream ps = new PrintStream(con.getOutputStream());
								            // send your parameters to your site
								          
								            ps.print("&manager_id=" + ManagerID);
								            ps.print("&Name=" + Name);               
								            ps.print("&Leavetype=" + Leavetype);
								           
								            System.out.println("MANAGER " + ManagerID + " NAME " + Name + " TYPE " + Leavetype);
								            

								            // we have to get the input stream in order to actually send the request
								            con.getInputStream();

								            // close the print stream
								            ps.close();
								      }
									 catch (MalformedURLException e1)
									 {    
										 e1.printStackTrace();
								     }
									 catch (IOException e2)
									 {
										 e2.printStackTrace();
									 }
								
									if(result == true)
									{
										System.out.println("CO Insert Successfully");
										request.setAttribute("openStatus", "co");
										request.setAttribute("success", "CO Applied Successfully");
										request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);
									}
								}	
							}
							else
							{
								System.out.println("Leave From Date And To Date Already exit");
								request.setAttribute("LeavefromtodateExist", "CO This Date Already Exists");
								request.getRequestDispatcher("leaveCO.jsp").forward(request, response);
							}
						}
						else
						{
								System.out.println("Between Date Co Already Exit");
								request.setAttribute("LeavefromtodateExist", "OD of Sunday is automatically consider as CO and OD also. So, CO of this date is already exist.");
								request.getRequestDispatcher("leaveCO.jsp").forward(request, response);
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
