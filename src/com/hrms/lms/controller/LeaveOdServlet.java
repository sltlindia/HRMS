package com.hrms.lms.controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.hrms.lms.bean.LeaveODBean;
import com.hrms.lms.dao.AllInsertDAO;
import com.hrms.lms.dao.AllLMSListDAO;
import com.hrms.pms.bean.EmployeeBean;

/**
 * Servlet implementation class LeaveOdServlet
 */
public class LeaveOdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveOdServlet() {
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
			String Startdate = null;
			String Enddate = null;
			String StartTime = null;
			String Endtime = null;
			int totalday = 0;
			int Manager_id = 0;
			String status = "Pending";
			EmployeeBean employeeBean = new EmployeeBean();
			LeaveODBean leaveODBean = new LeaveODBean();
			String describe = null;
			int mail_view = 0;
			int sundaycoadd = 0;
			int holidayCOadd = 0;
			String coDates2 = "";
			String coDates = null;
			List<String> listOfArray = new ArrayList<>();
			AllLMSListDAO allLMSListDAO = new AllLMSListDAO();
			

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

						
						if (fieldName.equalsIgnoreCase("SundayCO"))
						{
							String value = fieldValue;
							sundaycoadd = Integer.parseInt(value);
							System.out.println(" SundayCO : "+ sundaycoadd);	
						}
						
						if (fieldName.equalsIgnoreCase("holidayCO"))
						{
							String value = fieldValue;
							holidayCOadd = Integer.parseInt(value);
							System.out.println(" holidayCO : "+ holidayCOadd);	
						}
						
						if (fieldName.equalsIgnoreCase("coDates"))
						{
							coDates = fieldValue;
							System.out.println(" coDates : "+ coDates);	
							
							
							
							String[] split = coDates.split(",");
							for(String co : split)
							{
								try
								{
									//03/12/2017,03/13/2017
									SimpleDateFormat formater = new SimpleDateFormat("MM/dd/yyyy");
									Date d = formater.parse(co);
									SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
									String co1 = formater2.format(d); 
									List<LeaveCOBean> duplicate = allLMSListDAO.getCODupicateWithOD(co1, employee_code);
									
									if(duplicate.size() != 0){
										if(sundaycoadd != 0){
											sundaycoadd--;
										}else if(holidayCOadd != 0){
											holidayCOadd--;
										}
									}else{ 
										listOfArray.add(co);
										System.out.println("no duplicate");
									}
									
								}
								catch (Exception e) {
									// TODO: handle exception
								}
						}
						
						}
						
						if (fieldName.equalsIgnoreCase("redirect"))
						{
							
							SimpleDateFormat formater1 = new SimpleDateFormat("dd/MM/yyyy");
							Date result1 = formater1.parse(Startdate);
							Date result2 = formater1.parse(Enddate);
							SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
							Startdate = formater2.format(result1);
							Enddate = formater2.format(result2);
							
							
							for(String value : listOfArray){
								if(coDates2.equalsIgnoreCase("")){
									coDates2 = value;
								}else{
									coDates2 = coDates2+","+value;
								}
								
							}
							
							System.out.println("coDates2:"+coDates2);
							
							
							
							AllLMSListDAO allListDAO = new  AllLMSListDAO();
							List<LeaveODBean> duplicate = allListDAO.getCOODDupicate(Startdate, Enddate, employee_code);
							
							
							
							
							if(duplicate.size() == 0)
							{
								AllInsertDAO allInsertDAO = new AllInsertDAO();
								employeeBean.setEmployee_master_id(employee_code);
								leaveODBean = new LeaveODBean(employeeBean , Startdate , Enddate , StartTime , Endtime , totalday , Manager_id , status,describe , sundaycoadd , holidayCOadd , coDates2);
								boolean result = allInsertDAO.leaveODInsert(leaveODBean);
								int ManagerID =  Manager_id;
								String Name = user.getFirstname() + " " + user.getLastname();
								String Leavetype = "OD";
								
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
									System.out.println("Insert Successfully");
									request.setAttribute("openStatus", "od");
									request.setAttribute("success", "OD Applied Successfully");
									/*request.getRequestDispatcher("leavesuccess.jsp").forward(request, response);*/
									response.sendRedirect("leavesuccess.jsp");
								}
							}
							else
							{
								System.out.println("Leave From Date And To Date Already exit");
								request.setAttribute("LeavefromtodateExist", "OD This Date Already Exists");
								/*request.getRequestDispatcher("leaveOD.jsp").forward(request, response);*/
								response.sendRedirect("leaveOD.jsp");
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
